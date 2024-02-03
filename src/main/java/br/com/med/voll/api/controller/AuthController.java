package br.com.med.voll.api.controller;

import br.com.med.voll.api.domain.usuario.AuthDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping
    public ResponseEntity<AuthDTO> auth(@RequestBody @Valid AuthDTO authDTO) {
        var token = new UsernamePasswordAuthenticationToken(authDTO.login(),authDTO.senha());
        var auth =authManager.authenticate(token);


        return ResponseEntity.ok().build();

    }
}
