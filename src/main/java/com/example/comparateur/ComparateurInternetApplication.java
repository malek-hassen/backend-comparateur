package com.example.comparateur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan("com.example.comparateur")
@EnableJpaRepositories("com.example.comparateur")
@EnableTransactionManagement
@EnableWebSecurity
public class ComparateurInternetApplication {
	public static void main(String[] args) {
		SpringApplication.run(ComparateurInternetApplication.class, args);
	}
}
