package com.gyus.boardProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyus.boardProject.command.LoginCommand;
import com.gyus.boardProject.exception.MemberNotFoundException;
import com.gyus.boardProject.exception.PasswordNotMatchingException;
import com.gyus.boardProject.service.LoginService;
import com.gyus.boardProject.vo.AuthInfo;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@GetMapping
	public String form(LoginCommand loginCommand, HttpSession session) {
		if(session.getAttribute("authInfo") != null) {
			return "login/done";
		}else {
		return "login/form";
		}
	}
	
	@PostMapping
	public String submit(LoginCommand loginCommand, Model model, Errors errors, HttpSession session) {
		try {
			AuthInfo authInfo = loginService.login(loginCommand, errors);
			model.addAttribute("authInfo", authInfo);
			session.setAttribute("authInfo", authInfo);
			return "login/done";
		}catch(MemberNotFoundException e) {
			errors.reject("login.fail");
			return "login/form";
		}catch(PasswordNotMatchingException a) {
			errors.reject("login.fail");
			return "login/form";
		}
	}
}
