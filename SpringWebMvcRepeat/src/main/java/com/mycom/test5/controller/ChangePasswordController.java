package com.mycom.test5.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycom.test5.command.ChangePasswordCommand;
import com.mycom.test5.exception.NotMatchingException;
import com.mycom.test5.exception.NotValidateException;
import com.mycom.test5.service.ChangePasswordService;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePasswordController {
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@GetMapping
	public String form(ChangePasswordCommand changePasswordCommand) {
		return "edit/changePwdForm";
	}
	
	@PostMapping
	public String submit(ChangePasswordCommand changePasswordCommand, Errors errors, HttpSession session) {
		try {
		changePasswordService.changePassword(changePasswordCommand, errors, session);
		if(errors.hasErrors()) {
		return "edit/changePwdForm";
		}
		return "edit/pwdChanged";
	}catch(NotValidateException e) {
		return "edit/changePwdForm";
	}catch(NotMatchingException e) {
		return "edit/changePwdForm";
	}
	}
}
