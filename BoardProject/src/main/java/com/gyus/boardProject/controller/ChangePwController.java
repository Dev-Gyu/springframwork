package com.gyus.boardProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyus.boardProject.command.ChangePwCommand;
import com.gyus.boardProject.exception.PasswordNotMatchingException;
import com.gyus.boardProject.service.ChangePwService;
import com.gyus.boardProject.vo.AuthInfo;

@Controller
@RequestMapping("/member/changePw")
public class ChangePwController {
	@Autowired
	private ChangePwService changePwService;
	
	@GetMapping
	public String form(ChangePwCommand changePwCommand) {
		return "member/changePw/form";
	}
	
	@PostMapping
	public String submit(ChangePwCommand changePwCommand, Errors errors, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		try {
			changePwService.changePw(authInfo, changePwCommand);
			return "member/changePw/done";
		}catch(PasswordNotMatchingException e) {
			errors.reject("password.mismatch");
			return "member/changePw/form";
		}
	}
}
