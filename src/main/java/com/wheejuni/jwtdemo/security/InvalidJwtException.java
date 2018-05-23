package com.wheejuni.jwtdemo.security;

public class InvalidJwtException extends RuntimeException {

    public InvalidJwtException(String msg) {
        super(msg);
    }
}
