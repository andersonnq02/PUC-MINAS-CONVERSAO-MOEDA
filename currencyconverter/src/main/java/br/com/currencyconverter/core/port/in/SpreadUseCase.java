package br.com.currencyconverter.core.port.in;

import java.math.BigDecimal;

public interface SpreadUseCase {
    BigDecimal getSpread();

    void setSpread(BigDecimal newSpread);
}
