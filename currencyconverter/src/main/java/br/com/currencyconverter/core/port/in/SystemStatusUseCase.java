package br.com.currencyconverter.core.port.in;

import java.time.Instant;

public interface SystemStatusUseCase {
    Instant getSystemStartTime();

    long getNumberOfConversions();
}
