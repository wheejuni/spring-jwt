package com.wheejuni.jwtdemo.domain;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.NoSuchElementException;

@Getter
public enum UserRole {

    USER("ROLE_USER"), ADMIN("ROLE_ADMIN") ;

    private String roleName;

    UserRole(String roleName) {
        this.roleName = roleName;
    }

    public boolean isCorrectName(String name) {
        return name.equalsIgnoreCase(this.roleName);
    }

    public static UserRole getRoleByName(String roleName) {
        return Arrays.stream(UserRole.values()).filter(r -> r.isCorrectName(roleName)).findFirst().orElseThrow(() -> new NoSuchElementException("검색된 권한이 없습니다."));
    }

}
