package com.example.comparateur;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/admin/**").authenticated()  // Require authentication for /admin/**
                                .anyRequest().permitAll()  // Allow all other requests without authentication
                )
                .csrf(AbstractHttpConfigurer::disable)  // Disable CSRF if it's not needed
                .formLogin(withDefaults())  // Enable login form for authenticated endpoints
                .httpBasic(withDefaults());  // Enable basic authentication for authenticated endpoints

        return http.build();
    }
}