package com.gyus.boardProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gyus.boardProject.command.RegisterCommand;
import com.gyus.boardProject.service.RegisterService;

@Configuration
public class CommandConfig {
	@Bean
	public RegisterCommand registerCommand() {
		return new RegisterCommand();
	}
}
