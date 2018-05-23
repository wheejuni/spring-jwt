package com.wheejuni.jwtdemo.security.tokens;

import com.wheejuni.jwtdemo.domain.SocialProviders;
import com.wheejuni.jwtdemo.dtos.FormLoginDto;
import com.wheejuni.jwtdemo.dtos.SocialLoginDto;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class PreAuthorizationToken extends UsernamePasswordAuthenticationToken {

    private PreAuthorizationToken(String username, String password) {
        super(username, password);
    }

    private PreAuthorizationToken(SocialProviders providers, SocialLoginDto dto) {
        super(providers, dto);
    }

    public PreAuthorizationToken(FormLoginDto dto) {
        this(dto.getId(), dto.getPassword());
    }

    public PreAuthorizationToken(SocialLoginDto dto) {
        this(dto.getProvider(), dto);
    }

    public String getUsername() {
        return (String)super.getPrincipal();
    }

    public String getUserPassword() {
        return (String)super.getCredentials();
    }

}
