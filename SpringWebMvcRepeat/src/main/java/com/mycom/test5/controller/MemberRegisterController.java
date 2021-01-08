package com.mycom.test5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycom.test5.command.RegisterCommand;
import com.mycom.test5.service.RegisterMemberService;
import com.mycom.test5.validator.RegisterMemberValidator;

@Controller
@RequestMapping("/register")
public class MemberRegisterController {
	// view페이지의 form:form의 경우 modelAttribute속성으로 커맨드객체명을 정의해야하는데, 기본값이 command이므로
	// view페이지에서 modelAttribute속성 정의 안해뒀으므로 해당 객체명을 @ModelAttribute를 이용해 command로 정의한 것
	// 만약 @ModelAttribute속성 안쓰면 뷰페이지의 form:form태그의 modelAttribute="registerCommand"로 지정해줘야됨
	// 커맨드객체타입의 맨 첫글자 소문자로 변환한걸로 자동 매칭해줌
	
	@Autowired
	private RegisterMemberService registerService;
	@Autowired
	private RegisterMemberValidator registerValidator;
	@GetMapping
	public String form(@ModelAttribute("command")RegisterCommand registerCommand) {
		return "register/form";
	}

	@PostMapping
	public String submit(@ModelAttribute("command")RegisterCommand registerCommand, Errors errors,Model model) {
		registerValidator.validate(registerCommand, errors);
		if(errors.hasErrors()) {
			return "register/form";
		}
		int isSuccess = registerService.registerMember(registerCommand);
		
		if(isSuccess == 0) {
			errors.rejectValue("email", "duplicate");
			return "register/form";
		}
		model.addAttribute("isSuccess",	isSuccess);
		return "register/result";
	}
}
