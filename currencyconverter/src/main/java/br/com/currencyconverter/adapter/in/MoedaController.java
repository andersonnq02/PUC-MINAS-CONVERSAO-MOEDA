package br.com.currencyconverter.adapter.in;

import br.com.currencyconverter.adapter.common.mapper.MoedaMapper;
import br.com.currencyconverter.adapter.in.dto.MoedaDto;
import br.com.currencyconverter.core.dominio.Moeda;
import br.com.currencyconverter.core.port.in.ExchangeRatesUseCase;
import br.com.currencyconverter.core.port.in.MoedaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/moedas")
@RequiredArgsConstructor
public class MoedaController {

    private final MoedaUseCase moedaService;
    private final MoedaMapper moedaMapper;

    @PostMapping
    public ResponseEntity<MoedaDto> adicionarMoeda(@RequestBody MoedaDto moedaDto) {
        Moeda moeda = moedaMapper.dtoToDomain(moedaDto);
        Moeda moedaSalva = moedaService.adicionarMoeda(moeda);
        return ResponseEntity.status(HttpStatus.CREATED).body(moedaMapper.domainToDto(moedaSalva));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<MoedaDto> atualizarMoeda(@PathVariable String codigo, @RequestBody MoedaDto moedaDto) {
        Moeda moeda = moedaMapper.dtoToDomain(moedaDto);
        Moeda moedaAtualizada = moedaService.atualizarMoeda(codigo, moeda);
        return ResponseEntity.ok(moedaMapper.domainToDto(moedaAtualizada));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> removerMoeda(@PathVariable String codigo) {
        moedaService.removerMoeda(codigo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<MoedaDto>> listarMoedas() {
        List<Moeda> moedas = moedaService.listarMoedas();
        List<MoedaDto> moedaDtos = moedas.stream().map(moedaMapper::domainToDto).collect(Collectors.toList());
        return ResponseEntity.ok(moedaDtos);
    }
}

