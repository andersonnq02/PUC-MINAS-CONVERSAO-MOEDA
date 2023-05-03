package br.com.currencyconverter.core.port.out;

import br.com.currencyconverter.adapter.out.api.dto.ExchangeRatesApiResponse;
import br.com.currencyconverter.adapter.out.database.entity.ConversaoHistoricoEntity;
import br.com.currencyconverter.adapter.out.database.entity.MoedaEntity;
import br.com.currencyconverter.adapter.out.database.entity.TaxaCambioEntity;
import br.com.currencyconverter.core.dominio.ConversaoHistoricoFiltro;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ExchangeRatesApiPort {
    ExchangeRatesApiResponse getExchangeRates(String baseCurrency);

    List<TaxaCambioEntity> findByMoedaBase(String moedaBase);

    Optional<TaxaCambioEntity> findByMoedaBaseAndMoedaDestino(String moedaBase, String moedaDestino);

    void save(TaxaCambioEntity taxaCambioEntity);

    void salvarHistoricoConversao(String moedaOrigem, String moedaDestino, BigDecimal valorOrigem, BigDecimal valorConvertido);

    List<ConversaoHistoricoEntity> consultarHistoricoConversoes(ConversaoHistoricoFiltro filtro);
}
