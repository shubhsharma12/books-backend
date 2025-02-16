package com.chitkara.bootcamp.books.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.chitkara.bootcamp.books.filters.JwtRequestFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfiguration {

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		return security
				.csrf(csrf -> csrf.disable()) // Disable CSRF for stateless API
				.authorizeHttpRequests(requests -> requests.requestMatchers("/signup", "/login").permitAll()) // Allow public access to signup and login endpoints	
                .authorizeHttpRequests(requests -> requests.requestMatchers("/api/**").authenticated()) // Require authentication for /api/**
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless session (no session saved on server)
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class).build(); // Add JWT filter before the UsernamePasswordAuthenticationFilter
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

}
