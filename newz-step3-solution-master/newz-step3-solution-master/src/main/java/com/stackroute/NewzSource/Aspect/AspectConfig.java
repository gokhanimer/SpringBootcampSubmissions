package com.stackroute.NewzSource.Aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
	
	@Bean
	public AspectLog getaspect() {
		return new AspectLog();
	}
}
