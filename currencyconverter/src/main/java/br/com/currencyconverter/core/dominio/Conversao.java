package br.com.currencyconverter.core.dominio;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Conversao {

    private String moedaOrigem;

    private String moedaDestino;

    private BigDecimal valorOrigem;

    private BigDecimal valorConvertido;
}
