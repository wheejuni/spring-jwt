package com.wheejuni.jwtdemo.security.services.impl;

import com.wheejuni.jwtdemo.dtos.SocialLoginDto;
import com.wheejuni.jwtdemo.security.services.specification.SocialFetchService;
import com.wheejuni.jwtdemo.security.social.SocialUserProperty;
import org.springframework.stereotype.Service;

@Service
public class SocialFetchServiceTest implements SocialFetchService {

    @Override
    public SocialUserProperty getSocialUserInfo(SocialLoginDto dto) {
        return null;
    }
}
