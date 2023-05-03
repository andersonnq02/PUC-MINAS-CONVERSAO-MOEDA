package br.com.currencyconverter.core.usecase.service;

import br.com.currencyconverter.core.port.in.SystemStatusUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class SystemStatusService implements SystemStatusUseCase {

    private final Instant systemStartTime = Instant.now();
    private final AtomicLong numberOfConversions = new AtomicLong(0);

    @Override
    public Instant getSystemStartTime() {
        return systemStartTime;
    }

    public long incrementNumberOfConversions() {
        return numberOfConversions.incrementAndGet();
    }

    @Override
    public long getNumberOfConversions() {
        return numberOfConversions.get();
    }
}
