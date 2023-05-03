package br.com.currencyconverter.adapter.in.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest {

    private String username = "anderson";

    private String password = "1234";
}
