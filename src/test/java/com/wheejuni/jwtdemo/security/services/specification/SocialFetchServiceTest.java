package com.wheejuni.jwtdemo.security.services.specification;

import com.wheejuni.jwtdemo.domain.SocialProviders;
import com.wheejuni.jwtdemo.dtos.SocialLoginDto;
import com.wheejuni.jwtdemo.security.services.impl.SocialFetchServiceProd;
import com.wheejuni.jwtdemo.security.social.SocialUserProperty;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@Slf4j
public class SocialFetchServiceTest {

    private SocialFetchServiceProd prod = new SocialFetchServiceProd();
    private SocialLoginDto dto;

    @Before
    public void setUp() {
        this.dto = new SocialLoginDto(SocialProviders.KAKAO, "lxLHHcv9X8Qt2xxpgdgME7n7oxpX9eINQ_3i4wopdtYAAAFjRJ6Fhw");
    }


    @Test
    public void restTemplate_Practice1() {
        log.debug(new RestTemplate().getForObject("http://www.naver.com", String.class));
    }

    @Test
    public void service_fetchSocialInfo() {
        SocialUserProperty property = prod.getSocialUserInfo(this.dto);

        assertThat(property.getEmail(), is("wheejuni@gmail.com"));
    }

}