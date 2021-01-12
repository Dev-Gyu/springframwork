package com.gyus.boardProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gyus.boardProject.service.RegisterService;

@Configuration
public class ServiceConfig {
	@Bean
	public RegisterService registerService() {
		return new RegisterService();
	}
}
