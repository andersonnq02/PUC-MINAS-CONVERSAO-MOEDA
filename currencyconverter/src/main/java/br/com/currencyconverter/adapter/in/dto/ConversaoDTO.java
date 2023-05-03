package br.com.currencyconverter.adapter.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConversaoDTO {

    @JsonProperty("moedaOrigem")
    private String moedaOrigem;

    @JsonProperty("moedaDestino")
    private String moedaDestino;

    @JsonProperty("valor")
    private BigDecimal valor;
}
