package com.example.comparateur;


import org.junit.jupiter.api.Test;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@EnableAutoConfiguration
//@AutoConfigureMockMvc
@SpringBootTest(classes = ComparateurInternetApplication.class)

class ComparateurInternetApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("test");
	}
}