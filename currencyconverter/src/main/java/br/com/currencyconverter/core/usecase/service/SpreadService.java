package br.com.currencyconverter.core.usecase.service;

import br.com.currencyconverter.core.port.in.SpreadUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class SpreadService implements SpreadUseCase {

    private final AtomicReference<BigDecimal> spread = new AtomicReference<>(BigDecimal.ZERO);

    @Override
    public BigDecimal getSpread() {
        return spread.get();
    }

    @Override
    public void setSpread(BigDecimal newSpread) {
        spread.set(newSpread);
    }
}
