package br.com.med.voll.api.controller;

import br.com.med.voll.api.config.security.TokenDTO;
import br.com.med.voll.api.config.security.TokenService;
import br.com.med.voll.api.domain.usuario.AuthDTO;
import br.com.med.voll.api.domain.usuario.Usuario;
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
    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDTO> auth(@RequestBody @Valid AuthDTO authDTO) {
        var authToken = new UsernamePasswordAuthenticationToken(authDTO.login(), authDTO.senha());
        var auth = authManager.authenticate(authToken);


        String token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new TokenDTO(token));

    }
}