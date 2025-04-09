package com.example.comparateur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan("com.example.comparateur")
@EnableJpaRepositories("com.example.comparateur")
@ComponentScan(basePackages = {
		"com.example.comparateur",
		"com.example.comparateur.forfait.service",
		"com.example.comparateur.forfait.repository",
		"com.example.comparateur.forfait.mapper",
		"com.example.comparateur.forfait.controller"
})
@EnableTransactionManagement
@EnableWebSecurity
public class ComparateurInternetApplication {
	public static void main(String[] args) {
		SpringApplication.run(ComparateurInternetApplication.class, args);
	}
}
