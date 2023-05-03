package br.com.currencyconverter.adapter.out.api;

import br.com.currencyconverter.adapter.out.api.dto.ExchangeRatesApiResponse;
import br.com.currencyconverter.adapter.out.database.entity.ConversaoHistoricoEntity;
import br.com.currencyconverter.adapter.out.database.entity.MoedaEntity;
import br.com.currencyconverter.adapter.out.database.entity.TaxaCambioEntity;
import br.com.currencyconverter.adapter.out.database.repository.ConversaoHistoricoRepository;
import br.com.currencyconverter.adapter.out.database.repository.MoedaRepository;
import br.com.currencyconverter.adapter.out.database.repository.TaxaCambioRepository;
import br.com.currencyconverter.core.dominio.ConversaoHistoricoFiltro;
import br.com.currencyconverter.core.port.out.ExchangeRatesApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExchangeRatesApiAdapter implements ExchangeRatesApiPort {

    private final RestTemplate restTemplate;
    private final TaxaCambioRepository taxaCambioRepository;
    private final ConversaoHistoricoRepository conversaoHistoricoRepository;

    @Value("${apilayer-exchangerates-api.base-url}")
    private String baseUrl;

    @Value("${apilayer-exchangerates-api.access-key}")
    private String accessKey;

    @Override
    public ExchangeRatesApiResponse getExchangeRates(String baseCurrency) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", accessKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = baseUrl + "/latest?base={base}";
        ResponseEntity<ExchangeRatesApiResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, ExchangeRatesApiResponse.class, baseCurrency);

        return response.getBody();
    }

    @Override
    public List<TaxaCambioEntity> findByMoedaBase(String moedaBase) {
        return taxaCambioRepository.findByMoedaBase(moedaBase);
    }

    @Override
    public Optional<TaxaCambioEntity> findByMoedaBaseAndMoedaDestino(String moedaBase, String moedaDestino) {
        return taxaCambioRepository.findByMoedaBaseAndMoedaDestino(moedaBase, moedaDestino);
    }

    @Override
    public void save(TaxaCambioEntity taxaCambioEntity) {
        taxaCambioRepository.save(taxaCambioEntity);
    }

    public void salvarHistoricoConversao(String moedaOrigem, String moedaDestino, BigDecimal valorOrigem, BigDecimal valorConvertido) {
        ConversaoHistoricoEntity historico = ConversaoHistoricoEntity.builder()
                .moedaOrigem(moedaOrigem)
                .moedaDestino(moedaDestino)
                .valorOrigem(valorOrigem)
                .valorConvertido(valorConvertido)
                .dataConversao(LocalDateTime.now())
                .build();

        conversaoHistoricoRepository.save(historico);
    }

    @Override
    public List<ConversaoHistoricoEntity> consultarHistoricoConversoes(ConversaoHistoricoFiltro filtro) {
        return conversaoHistoricoRepository.findByFiltro(filtro);
    }
}
