package com.libti.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.libti.dtos.AcessDto;
import com.libti.dtos.AuthDto;
import com.libti.security.jwt.JwtUtils;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUitls;

    public AcessDto login(AuthDto authDto) {

        try {
            // Cria mecanismo de credenciais para o spring
            UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(authDto.getEmail(),
                    authDto.getPassword());

            // Autentica o usuário
            Authentication authentication = authenticationManager.authenticate(userAuth);

            // Pega o usuário autenticado
            UserDetailsImpls userAuthenticate = (UserDetailsImpls) authentication.getPrincipal();

            String token = jwtUitls.generateTokenFromUserDetailsImpl(userAuthenticate);

            AcessDto acessDto = new AcessDto(token);

            return acessDto;

        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Acesso negado");
        }
    }
}
