package br.com.currencyconverter.core.usecase;

import br.com.currencyconverter.adapter.out.api.dto.ExchangeRatesApiResponse;
import br.com.currencyconverter.adapter.out.database.entity.ConversaoHistoricoEntity;
import br.com.currencyconverter.adapter.out.database.entity.TaxaCambioEntity;
import br.com.currencyconverter.core.dominio.Conversao;
import br.com.currencyconverter.core.dominio.ConversaoHistoricoFiltro;
import br.com.currencyconverter.core.dominio.ConversaoMassa;
import br.com.currencyconverter.core.exception.ResourceNotFoundException;
import br.com.currencyconverter.core.port.in.ExchangeRatesUseCase;
import br.com.currencyconverter.core.port.out.ExchangeRatesApiPort;
import br.com.currencyconverter.core.usecase.service.SpreadService;
import br.com.currencyconverter.core.usecase.service.SystemStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExchangeRatesImpl implements ExchangeRatesUseCase {

    private final ExchangeRatesApiPort exchangeRatesApiClient;

    private final SystemStatusService systemStatusService;

    private final SpreadService spreadService;

    @Override
    public Map<String, BigDecimal> obterTaxasDeCambio(String moedaBase) {
        List<TaxaCambioEntity> taxasCambioEntities = exchangeRatesApiClient.findByMoedaBase(moedaBase);

        if (!taxasCambioEntities.isEmpty()) {
            return taxasCambioEntities.stream().collect(Collectors.toMap(TaxaCambioEntity::getMoedaDestino, TaxaCambioEntity::getTaxaCambio));
        }

        ExchangeRatesApiResponse response = exchangeRatesApiClient.getExchangeRates(moedaBase);
        return response.getRates();
    }

    @Override
    public void atualizarTaxaDeCambio(String moedaBase, String moedaDestino, BigDecimal novaTaxa) {
        TaxaCambioEntity taxaCambioEntity = exchangeRatesApiClient.findByMoedaBaseAndMoedaDestino(moedaBase, moedaDestino)
                .orElseGet(() -> {
                    TaxaCambioEntity novaTaxaCambio = new TaxaCambioEntity();
                    novaTaxaCambio.setMoedaBase(moedaBase);
                    novaTaxaCambio.setMoedaDestino(moedaDestino);
                    return novaTaxaCambio;
                });

        taxaCambioEntity.setTaxaCambio(novaTaxa);
        exchangeRatesApiClient.save(taxaCambioEntity);
    }

    @Override
    public TaxaCambioEntity findByMoedaBaseAndMoedaDestino(String moedaBase, String moedaDestino) {
        return exchangeRatesApiClient.findByMoedaBaseAndMoedaDestino(moedaBase, moedaDestino)
                .orElseThrow(() -> new ResourceNotFoundException("Taxa de câmbio não encontrada"));
    }

    @Override
    public BigDecimal converterMoeda(String moedaBase, String moedaDestino, BigDecimal valor) {
        TaxaCambioEntity taxaCambioEntity = findByMoedaBaseAndMoedaDestino(moedaBase, moedaDestino);
        BigDecimal taxaCambio = taxaCambioEntity.getTaxaCambio();
        BigDecimal spread = spreadService.getSpread();
        BigDecimal taxaCambioComSpread = taxaCambio.add(taxaCambio.multiply(spread));
        BigDecimal valorConvertido = valor.multiply(taxaCambioComSpread).setScale(2, RoundingMode.HALF_UP);

        salvarHistoricoConversao(moedaBase, moedaDestino, valor, valorConvertido);

        systemStatusService.incrementNumberOfConversions();

        return valorConvertido;
    }

    @Override
    public List<ConversaoHistoricoEntity> consultarHistoricoConversoes(ConversaoHistoricoFiltro filtro) {
        return exchangeRatesApiClient.consultarHistoricoConversoes(filtro);
    }

    @Override
    public ConversaoMassa realizarConversoesMassa(ConversaoMassa conversaoMassa) {
        List<Conversao> conversoes = conversaoMassa.getConversoes().stream()
                .map(conversao -> {
                    BigDecimal taxaCambio = findByMoedaBaseAndMoedaDestino(conversao.getMoedaOrigem(), conversao.getMoedaDestino()).getTaxaCambio();
                    BigDecimal valorConvertido = conversao.getValorOrigem().multiply(taxaCambio).setScale(2, RoundingMode.HALF_UP);

                    Conversao resultado = new Conversao();
                    resultado.setMoedaOrigem(conversao.getMoedaOrigem());
                    resultado.setMoedaDestino(conversao.getMoedaDestino());
                    resultado.setValorOrigem(conversao.getValorOrigem());
                    resultado.setValorConvertido(valorConvertido);

                    return resultado;
                })
                .collect(Collectors.toList());

        ConversaoMassa resultado = new ConversaoMassa();
        resultado.setConversoes(conversoes);

        return resultado;
    }

    public void salvarHistoricoConversao(String moedaOrigem, String moedaDestino, BigDecimal valorOrigem, BigDecimal valorConvertido) {
        exchangeRatesApiClient.salvarHistoricoConversao(moedaOrigem, moedaDestino, valorOrigem, valorConvertido);
    }
}
