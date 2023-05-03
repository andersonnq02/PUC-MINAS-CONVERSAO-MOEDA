package br.com.currencyconverter.adapter.in.dto;

import lombok.*;

import java.time.Instant;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SystemStatusDTO {

    private Instant systemStartTime;

    private long numberOfConversions;
}
