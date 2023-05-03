package br.com.currencyconverter.config;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import io.github.resilience4j.retry.RetryConfig;

@Component
public class RetryConfiguration {
 /*
    @Bean
    public Retry retry() {
      RetryConfig config = io.github.resilience4j.retry.RetryConfig.custom().maxAttempts(7).build();
        RetryRegistry registry = RetryRegistry.of(config);
        Retry retry = registry.retry("consultarTestProjeto");
        return retry;
    }
    */
}


