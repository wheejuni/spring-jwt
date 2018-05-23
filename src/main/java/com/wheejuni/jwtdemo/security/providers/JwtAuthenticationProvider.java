package com.wheejuni.jwtdemo.security.providers;

import com.wheejuni.jwtdemo.security.AccountContext;
import com.wheejuni.jwtdemo.security.jwt.JwtDecoder;
import com.wheejuni.jwtdemo.security.tokens.JwtPreProcessingToken;
import com.wheejuni.jwtdemo.security.tokens.PostAuthorizationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private JwtDecoder jwtDecoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String token = (String)authentication.getPrincipal();
        AccountContext context = jwtDecoder.decodeJwt(token);

        return PostAuthorizationToken.getTokenFromAccountContext(context);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return JwtPreProcessingToken.class.isAssignableFrom(aClass);
    }
}
