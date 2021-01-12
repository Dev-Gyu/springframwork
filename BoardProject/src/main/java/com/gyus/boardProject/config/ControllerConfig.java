package com.gyus.boardProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gyus.boardProject.controller.RegisterController;

@Configuration
public class ControllerConfig {
	@Bean
	public RegisterController registerController() {
		return new RegisterController();
	}
}
