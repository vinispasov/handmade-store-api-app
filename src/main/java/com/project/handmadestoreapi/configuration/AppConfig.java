package com.project.handmadestoreapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

	@Bean
	public PasswordEncoder providePasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
