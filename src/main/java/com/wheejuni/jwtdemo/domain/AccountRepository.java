package com.wheejuni.jwtdemo.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Optional<Account> findByUserId(String userId);

    Optional<Account> findBySocialId(long socialId);

    Optional<Account> findBySocialIdAndSocialProvider(long socialId, SocialProviders socialProvider);

}
