package com.gyus.boardProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gyus.boardProject.controller.ChangePwController;
import com.gyus.boardProject.controller.LoginController;
import com.gyus.boardProject.controller.MemberSignOutController;
import com.gyus.boardProject.controller.RegisterController;

@Configuration
public class ControllerConfig {
	@Bean
	public RegisterController registerController() {
		return new RegisterController();
	}
	@Bean
	public LoginController loginController() {
		return new LoginController();
	}
	@Bean
	public MemberSignOutController memberSignOutController() {
		return new MemberSignOutController();
	}
	@Bean
	public ChangePwController changePwController() {
		return new ChangePwController();
	}
}
