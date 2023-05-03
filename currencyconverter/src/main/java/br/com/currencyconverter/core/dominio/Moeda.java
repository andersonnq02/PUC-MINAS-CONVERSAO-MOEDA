package br.com.currencyconverter.core.dominio;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Moeda {

    private String codigo;

    private String nome;

    private String simbolo;
}
