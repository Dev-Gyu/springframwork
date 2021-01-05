package com.mycom.test5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycom.test5.bean.Member;
import com.mycom.test5.service.GetMembersService;

@Controller
@RequestMapping("/select/all")
public class GetMembersController {
	@Autowired
	GetMembersService getMembersService = new GetMembersService();
	
	@GetMapping
	public String getAllMembers(Model model) {
		List<Member> members = getMembersService.getAllMembers();
		model.addAttribute("members", members);
		return "select/all";
	}
}
