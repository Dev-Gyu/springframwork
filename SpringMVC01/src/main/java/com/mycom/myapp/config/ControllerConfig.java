package com.mycom.myapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mycom.myapp.controller.RegisterController;
import com.mycom.myapp.spring.MemberRegisterService;
import com.mycom.myapp.survey.SurveyControllerModel;

@Configuration
public class ControllerConfig {
	@Autowired
	private MemberRegisterService memberRegisterService;
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
}
