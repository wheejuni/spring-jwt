package com.wheejuni.jwtdemo.security.providers;

import com.wheejuni.jwtdemo.domain.Account;
import com.wheejuni.jwtdemo.domain.AccountRepository;
import com.wheejuni.jwtdemo.domain.SocialProviders;
import com.wheejuni.jwtdemo.domain.UserRole;
import com.wheejuni.jwtdemo.dtos.SocialLoginDto;
import com.wheejuni.jwtdemo.security.AccountContext;
import com.wheejuni.jwtdemo.security.services.specification.SocialFetchService;
import com.wheejuni.jwtdemo.security.social.SocialUserProperty;
import com.wheejuni.jwtdemo.security.tokens.PostAuthorizationToken;
import com.wheejuni.jwtdemo.security.tokens.SocialPreAuthorizationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SocialLoginAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AccountRepository accountRepository;

    @Qualifier("socialFetchServiceProd")
    @Autowired
    private SocialFetchService service;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SocialPreAuthorizationToken token = (SocialPreAuthorizationToken)authentication;
        SocialLoginDto dto = token.getDto();

        return PostAuthorizationToken.getTokenFromAccountContext(AccountContext.fromAccountModel(getAccount(dto)));
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return SocialPreAuthorizationToken.class.isAssignableFrom(aClass);
    }

    private Account getAccount(SocialLoginDto dto) {
        SocialUserProperty property = service.getSocialUserInfo(dto);

        String userId = property.getUserId();
        SocialProviders provider = dto.getProvider();

        return accountRepository.findBySocialIdAndSocialProvider(Long.valueOf(userId), provider)
                .orElseGet(() -> accountRepository.save(
                        new Account(null, property.getUserNickname(), "SOCIAL_USER", String.valueOf(UUID.randomUUID().getMostSignificantBits()), UserRole.USER, Long.valueOf(property.getUserId()), provider, property.getProfileHref())));

    }

}
