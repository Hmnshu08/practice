package com.practise.socialMediaApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		//authenticate all request
		
		http.httpBasic(withDefaults());
		// pop up for authentication
		
		http.csrf().disable();
		//csrf Post, put
		return http.build();
	}

}
