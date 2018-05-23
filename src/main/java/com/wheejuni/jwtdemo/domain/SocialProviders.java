package com.wheejuni.jwtdemo.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import com.wheejuni.jwtdemo.security.social.KakaoUserProperty;
import com.wheejuni.jwtdemo.security.social.NaverUserProperty;
import com.wheejuni.jwtdemo.security.social.SocialUserProperty;
import lombok.Getter;

@Getter
public enum SocialProviders {

    KAKAO("https://kapi.kakao.com/v1/user/me", KakaoUserProperty.class),
    NAVER("https://openapi.naver.com/v1/nid/me", NaverUserProperty.class);

    private String userinfoEndpoint;
    private Class<? extends SocialUserProperty> propertyMetaclass;

    SocialProviders(String userinfoEndpoint, Class<? extends SocialUserProperty> propertyMetaclass) {
        this.userinfoEndpoint = userinfoEndpoint;
        this.propertyMetaclass = propertyMetaclass;
    }

    @JsonValue
    public String getProviderName() {
        return this.name();
    }

}
