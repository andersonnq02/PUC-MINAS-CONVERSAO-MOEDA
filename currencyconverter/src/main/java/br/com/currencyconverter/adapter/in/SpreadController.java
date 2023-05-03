package br.com.currencyconverter.adapter.in;

import br.com.currencyconverter.core.port.in.SpreadUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/spread")
@RequiredArgsConstructor
public class SpreadController {

    private final SpreadUseCase spreadUseCase;

    @GetMapping
    public BigDecimal getSpread() {
        return spreadUseCase.getSpread();
    }

    @PutMapping
    public void setSpread(@RequestBody BigDecimal newSpread) {
        spreadUseCase.setSpread(newSpread);
    }
}
