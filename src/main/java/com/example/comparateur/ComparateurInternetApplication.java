package com.example.comparateur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan("com.example.comparateur")
@EnableJpaRepositories("com.example.comparateur")
@EnableMethodSecurity
@EnableTransactionManagement
public class ComparateurInternetApplication {
	public static void main(String[] args) {
		SpringApplication.run(ComparateurInternetApplication.class, args);
	}
}
