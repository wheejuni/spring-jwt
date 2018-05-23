package com.wheejuni.jwtdemo.security.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wheejuni.jwtdemo.dtos.TokenDto;
import com.wheejuni.jwtdemo.security.AccountContext;
import com.wheejuni.jwtdemo.security.jwt.JwtFactory;
import com.wheejuni.jwtdemo.security.tokens.PostAuthorizationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FormLoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private JwtFactory factory;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth) throws IOException, ServletException {
        AccountContext context = ((PostAuthorizationToken) auth).getAccountContext();

        String tokenString = factory.generateToken(context);

        processResponse(res, writeDto(tokenString));
    }

    private TokenDto writeDto(String token) {
        return new TokenDto(token);
    }

    private void processResponse(HttpServletResponse res, TokenDto dto) throws JsonProcessingException, IOException {
        res.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        res.setStatus(HttpStatus.OK.value());
        res.getWriter().write(objectMapper.writeValueAsString(dto));
    }
}
