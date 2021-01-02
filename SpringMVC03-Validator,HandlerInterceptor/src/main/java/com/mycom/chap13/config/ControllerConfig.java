package com.mycom.chap13.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mycom.chap13.controller.ChangePwdController;
import com.mycom.chap13.controller.LoginController;
import com.mycom.chap13.controller.LogoutController;
import com.mycom.chap13.controller.RegisterController;
import com.mycom.chap13.spring.AuthService;
import com.mycom.chap13.spring.ChangePasswordService;
import com.mycom.chap13.spring.MemberRegisterService;
import com.mycom.chap13.survey.SurveyControllerModel;

@Configuration
public class ControllerConfig {
	@Autowired
	private MemberRegisterService memberRegisterService;
	@Autowired
	private AuthService authService;
	@Autowired
	private ChangePasswordService changePasswordService;
	@Bean
	public RegisterController registerController() {
		RegisterController rgsCtr = new RegisterController();
		rgsCtr.setMemberRegisterService(memberRegisterService);
		return rgsCtr;
	}
	@Bean
	public SurveyControllerModel surveyControllerModel() {
		return new SurveyControllerModel();
	}
	@Bean
	public LoginController loginController() {
		LoginController loginController = new LoginController();
		loginController.setAuthService(authService);
		return loginController;
	}
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
	@Bean
	public ChangePwdController changePwdController() {
		ChangePwdController changePwdController = new ChangePwdController();
		changePwdController.setChangePwdService(changePasswordService);
		return changePwdController;
	}
}
