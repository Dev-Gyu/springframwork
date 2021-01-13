package com.gyus.boardProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyus.boardProject.command.RegisterCommand;
import com.gyus.boardProject.exception.DuplicateException;
import com.gyus.boardProject.service.RegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	RegisterService registerService;
	
	// /register url요청시 대응하는 메소드
	@GetMapping
	public String form(RegisterCommand registerCommand) {
		return "register/form";
	}
	
	// form페이지에서 submit시 대응하는 메소드, 유효성검사는 페이지 자체에서 JS를 이용해 처리함
	// Command객체 데이터 주고받을때 한글데이터 깨지면 web.xml에 encoding filter utf8로 적용하면됨
	@PostMapping
	public String submit(RegisterCommand registerCommand, Errors errors, Model model) {
		try {
		registerService.insertMember(registerCommand);
		model.addAttribute("registerCommand", registerCommand);
		return "register/done";
		}catch(DuplicateException e) {
			errors.rejectValue("email","email.duplicate");
			return "register/form";
		}
	}
}
