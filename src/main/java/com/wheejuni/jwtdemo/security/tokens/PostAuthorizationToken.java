package com.wheejuni.jwtdemo.security.tokens;

import com.wheejuni.jwtdemo.security.AccountContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class PostAuthorizationToken extends UsernamePasswordAuthenticationToken {

    private PostAuthorizationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public AccountContext getAccountContext() {
        return (AccountContext)super.getPrincipal();
    }

    public static PostAuthorizationToken getTokenFromAccountContext(AccountContext context) {
        return new PostAuthorizationToken(context, context.getPassword(), context.getAuthorities());
    }
}
