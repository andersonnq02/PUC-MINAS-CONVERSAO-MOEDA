package br.com.currencyconverter.adapter.in;

import br.com.currencyconverter.adapter.in.dto.JwtResponse;
import br.com.currencyconverter.adapter.in.dto.UserLoginRequest;
import br.com.currencyconverter.core.usecase.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody UserLoginRequest userLoginRequest) {
        String jwtToken = authenticationService.authenticate(userLoginRequest.getUsername(), userLoginRequest.getPassword());
        return ResponseEntity.ok(new JwtResponse(jwtToken));
    }
}

