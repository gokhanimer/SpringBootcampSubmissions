package com.stackroute.TokenIssuerApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TokenIssuerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TokenIssuerAppApplication.class, args);
	}

}
