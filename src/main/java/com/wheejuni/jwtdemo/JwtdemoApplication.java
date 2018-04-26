package com.wheejuni.jwtdemo;

import com.wheejuni.jwtdemo.domain.Account;
import com.wheejuni.jwtdemo.domain.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JwtdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtdemoApplication.class, args);
	}


	@Bean
	CommandLineRunner bootstrapTestAccount(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			Account account = new Account();
			account.setPassword(passwordEncoder.encode("1234"));

			accountRepository.save(account);
		};
	}
}
