package br.com.currencyconverter.core.dominio;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ConversaoHistoricoFiltro {

    private String moedaOrigem;

    private String moedaDestino;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private BigDecimal valorMinimo;

    private BigDecimal valorMaximo;
}