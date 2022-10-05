package com.cgi.insurance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Config {
	@Bean
	public Docket getdocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.cgi.insurance"))
				.build()
				.apiInfo(getDetails());
	}
	public ApiInfo getDetails()
	{
		ApiInfoBuilder apibuild=new ApiInfoBuilder();
		apibuild.title("Insurance Application").version("1.0.0").description("Welcome to this microservice where we can track all the details of our cab drivers <br />"
				+ "This microservice is built on Spring Boot and JPA Persistence with MySQL, the UI is provided by Swagger").license("Made by Gökhan Imer");
		return apibuild.build();
		
	}

}
