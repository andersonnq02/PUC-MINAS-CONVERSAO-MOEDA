package br.com.currencyconverter.adapter.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConversaoMassaDTO {

    @JsonProperty("conversoes")
    private List<ConversaoDTO> conversoes;
}
