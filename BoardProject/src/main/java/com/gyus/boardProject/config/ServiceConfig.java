package com.gyus.boardProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.gyus.boardProject.service.ChangePwService;
import com.gyus.boardProject.service.GetMemberServices;
import com.gyus.boardProject.service.LoginService;
import com.gyus.boardProject.service.MemberSignOutService;
import com.gyus.boardProject.service.RegisterService;

@Configuration
@EnableTransactionManagement
public class ServiceConfig {
	
	@Bean
	public RegisterService registerService() {
		return new RegisterService();
	}
	@Bean
	public LoginService loginService() {
		return new LoginService();
	}
	@Bean
	public GetMemberServices getMemberServices() {
		return new GetMemberServices();
	}
	@Bean
	public MemberSignOutService memberSignOutService() {
		return new MemberSignOutService();
	}
	@Bean
	public ChangePwService changePwService() {
		return new ChangePwService();
	}
}
