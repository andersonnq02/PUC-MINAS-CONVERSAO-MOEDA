package br.com.currencyconverter.core.port.in;

import br.com.currencyconverter.adapter.out.database.entity.ConversaoHistoricoEntity;
import br.com.currencyconverter.adapter.out.database.entity.TaxaCambioEntity;
import br.com.currencyconverter.core.dominio.ConversaoHistoricoFiltro;
import br.com.currencyconverter.core.dominio.ConversaoMassa;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ExchangeRatesUseCase {
    Map<String, BigDecimal> obterTaxasDeCambio(String moedaBase);
    void atualizarTaxaDeCambio(String moedaBase, String moedaDestino, BigDecimal novaTaxa);

    TaxaCambioEntity findByMoedaBaseAndMoedaDestino(String moedaBase, String moedaDestino);

    BigDecimal converterMoeda(String moedaBase, String moedaDestino, BigDecimal valor);

    List<ConversaoHistoricoEntity> consultarHistoricoConversoes(ConversaoHistoricoFiltro filtro);

    ConversaoMassa realizarConversoesMassa(ConversaoMassa conversaoMassa);
}
