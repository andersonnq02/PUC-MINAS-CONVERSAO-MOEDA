package br.com.currencyconverter.adapter.in;

import br.com.currencyconverter.adapter.common.mapper.ConversaoMapper;
import br.com.currencyconverter.adapter.in.dto.ConversaoMassaDTO;
import br.com.currencyconverter.adapter.out.database.entity.ConversaoHistoricoEntity;
import br.com.currencyconverter.core.dominio.ConversaoHistoricoFiltro;
import br.com.currencyconverter.core.dominio.ConversaoMassa;
import br.com.currencyconverter.core.port.in.ExchangeRatesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conversao")
@RequiredArgsConstructor
public class CurrencyConverterController {

    private final ExchangeRatesUseCase exchangeRatesUseCase;

    private final ConversaoMapper conversaoMapper;

    @GetMapping("/historico")
    public ResponseEntity<List<ConversaoHistoricoEntity>> consultarHistoricoConversoes(ConversaoHistoricoFiltro filtro) {
        List<ConversaoHistoricoEntity> historico = exchangeRatesUseCase.consultarHistoricoConversoes(filtro);
        return ResponseEntity.ok(historico);
    }

    @PostMapping("/massa")
    public ResponseEntity<ConversaoMassaDTO> realizarConversoesMassa(@RequestBody ConversaoMassaDTO conversaoMassaDTO) {
        ConversaoMassa conversaoMassa = conversaoMapper.dtoToDomain(conversaoMassaDTO);
        ConversaoMassa resultadoConversaoMassa = exchangeRatesUseCase.realizarConversoesMassa(conversaoMassa);
        ConversaoMassaDTO resultadoConversaoMassaDTO = conversaoMapper.domainToDto(resultadoConversaoMassa);
        return ResponseEntity.ok(resultadoConversaoMassaDTO);
    }
}
