package com.mycom.test5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mycom.test5.command.ChangePasswordCommand;
import com.mycom.test5.command.LoginCommand;
import com.mycom.test5.command.RegisterCommand;

@Configuration
public class CommandConfig {
	@Bean
	public RegisterCommand registerCommand() {
		return new RegisterCommand();
	}
	@Bean
	public LoginCommand loginCommand() {
		return new LoginCommand();
	}
	@Bean
	public ChangePasswordCommand changePasswordCommand() {
		return new ChangePasswordCommand();
	}
}
