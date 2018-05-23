package com.wheejuni.jwtdemo.security.services.specification;

import com.wheejuni.jwtdemo.dtos.SocialLoginDto;
import com.wheejuni.jwtdemo.security.social.SocialUserProperty;

public interface SocialFetchService {

    SocialUserProperty getSocialUserInfo(SocialLoginDto dto);

}
