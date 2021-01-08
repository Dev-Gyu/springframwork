package com.mycom.test5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mycom.test5.controller.ChangePasswordController;
import com.mycom.test5.controller.GetMembersController;
import com.mycom.test5.controller.LoginController;
import com.mycom.test5.controller.LogoutController;
import com.mycom.test5.controller.MemberRegisterController;

@Configuration
public class ControllerConfig {
	@Bean
	public GetMembersController getMembersController(){
		return new GetMembersController();
	}
	@Bean
	public LoginController loginController() {
		return new LoginController();
	}
	@Bean
	public MemberRegisterController memberRegisterController() {
		return new MemberRegisterController();
	}
	@Bean
	public ChangePasswordController changePasswordController() {
		return new ChangePasswordController();
	}
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
}
