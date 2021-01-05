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
import com.mycom.test5.command.LoginCommand;
import com.mycom.test5.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping
	public String form(LoginCommand loginCommand, HttpServletRequest request) {
			HttpSession session = request.getSession();
			if(session.getAttribute("login") == null) {
				return "login/form";
			}else {
				return "login/done";
			}
	}
	
	@PostMapping
	public String submit(LoginCommand loginCommand, Errors errors, HttpSession session) {
		loginService.login(loginCommand, errors);
		if(errors.hasErrors()) {
			return "login/form";
		}
		Member member = memberDao.selectMemberByEmail(loginCommand.getEmail());
		session.setAttribute("login", member);
		return "login/done";
	}
}
