package com.mycom.chap12.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mycom.chap12.controller.RegisterController;
import com.mycom.chap12.spring.MemberRegisterService;
import com.mycom.chap12.survey.SurveyControllerModel;

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
