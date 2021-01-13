package com.gyus.boardProject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyus.boardProject.command.SignOutCommand;
import com.gyus.boardProject.exception.PasswordNotMatchingException;
import com.gyus.boardProject.service.MemberSignOutService;

@Controller
@RequestMapping("/signout")
public class MemberSignOutController {
	@Autowired
	private MemberSignOutService memberSignOutService;
	
	@GetMapping
	public String pwRepeatForm(Model model) {
		return "signout/PwRepeat";
	}
	
	// 유효성체크 뷰페이지로함
	@PostMapping
	public String submit(SignOutCommand signOutCommand ,Errors errors, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String nowPassword = signOutCommand.getNowPassword();
		try {
			memberSignOutService.signOut(session, nowPassword);
			return "signout/done";
		}catch(PasswordNotMatchingException e) {
			errors.reject("password.mismatch");
			return "signout/PwRepeat";
		}
		
	}
}
