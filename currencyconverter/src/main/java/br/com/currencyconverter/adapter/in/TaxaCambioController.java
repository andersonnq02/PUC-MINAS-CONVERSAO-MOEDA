package br.com.currencyconverter.adapter.in;

import br.com.currencyconverter.adapter.out.database.entity.TaxaCambioEntity;
import br.com.currencyconverter.core.port.in.ExchangeRatesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/taxa")
@RequiredArgsConstructor
public class TaxaCambioController {

    private final ExchangeRatesUseCase exchangeRatesUseCase;

    @GetMapping("/taxas-cambio")
    public ResponseEntity<Map<String, BigDecimal>> obterTaxasCambio(@RequestParam(value = "moedaBase", defaultValue = "USD") String moedaBase) {

        Map<String, BigDecimal> taxasCambio = exchangeRatesUseCase.obterTaxasDeCambio(moedaBase);
        return ResponseEntity.ok(taxasCambio);
    }

    @PutMapping("/taxas-cambio/atualizar")
    public ResponseEntity<Void> atualizarTaxaCambio(@RequestParam("moedaBase") String moedaBase,
                                                    @RequestParam("moedaDestino") String moedaDestino,
                                                    @RequestParam("novaTaxa") BigDecimal novaTaxa) {
        exchangeRatesUseCase.atualizarTaxaDeCambio(moedaBase, moedaDestino, novaTaxa);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/consulta")
    public ResponseEntity<TaxaCambioEntity> consultarTaxaCambio(
            @RequestParam String moedaBase,
            @RequestParam String moedaDestino) {
        TaxaCambioEntity taxaCambio = exchangeRatesUseCase.findByMoedaBaseAndMoedaDestino(moedaBase, moedaDestino);
        return ResponseEntity.ok(taxaCambio);
    }

    @GetMapping("/converter")
    public ResponseEntity<BigDecimal> converterMoeda(
            @RequestParam String moedaBase,
            @RequestParam String moedaDestino,
            @RequestParam BigDecimal valor) {
        BigDecimal valorConvertido = exchangeRatesUseCase.converterMoeda(moedaBase, moedaDestino, valor);
        return ResponseEntity.ok(valorConvertido);
    }

}
