package com.wheejuni.jwtdemo.security;

import com.wheejuni.jwtdemo.domain.Account;
import com.wheejuni.jwtdemo.domain.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class AccountContextService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Account account = accountRepository.findByUserId(userId).orElseThrow(() -> new NoSuchElementException("아이디에 맞는 계정이 없습니다."));

        return getAccountContext(account);
    }

    private AccountContext getAccountContext(Account account) {
        return AccountContext.fromAccountModel(account);
    }
}
