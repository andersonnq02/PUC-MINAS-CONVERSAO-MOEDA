package br.com.currencyconverter.adapter.in;

import br.com.currencyconverter.adapter.in.dto.SystemStatusDTO;
import br.com.currencyconverter.core.port.in.SystemStatusUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
@RequiredArgsConstructor
public class SystemStatusController {
    private final SystemStatusUseCase systemStatusUseCase;

    @GetMapping
    public SystemStatusDTO getSystemStatus() {
        SystemStatusDTO status = new SystemStatusDTO();
        status.setSystemStartTime(systemStatusUseCase.getSystemStartTime());
        status.setNumberOfConversions(systemStatusUseCase.getNumberOfConversions());
        return status;
    }
}