package br.com.currencyconverter.core.dominio;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ConversaoMassa {

    private List<Conversao> conversoes;
}
