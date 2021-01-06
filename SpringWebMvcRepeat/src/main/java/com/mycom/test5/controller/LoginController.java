package com.mycom.test5.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycom.test5.bean.Member;
import com.mycom.test5.bean.MemberDao;
import com.mycom.test5.command.AuthInfo;
import com.mycom.test5.command.LoginCommand;
import com.mycom.test5.service.LoginService;
import com.mycom.test5.validator.LoginValidator;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private LoginValidator loginValidationService;
	
	@GetMapping
	public String form(LoginCommand loginCommand, HttpServletRequest request) {
			HttpSession session = request.getSession();
			if(session.getAttribute("authInfo") == null) {
				return "login/form";
			}else {
				return "login/done";
			}
	}
	
	@PostMapping
	public String submit(LoginCommand loginCommand, Errors errors, HttpSession session) {
		loginValidationService.validate(loginCommand, errors);
		AuthInfo authInfo = loginService.login(loginCommand, errors);
		if(errors.hasErrors()) {
			return "login/form";
		}
		if(authInfo != null) {
		session.setAttribute("authInfo", authInfo);
		return "login/done";
		}
		return "login/form";
	}
}
