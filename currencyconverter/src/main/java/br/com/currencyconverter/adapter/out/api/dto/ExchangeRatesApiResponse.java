package br.com.currencyconverter.adapter.out.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRatesApiResponse {

    private String base;
    private String date;
    private Map<String, BigDecimal> rates;
}
