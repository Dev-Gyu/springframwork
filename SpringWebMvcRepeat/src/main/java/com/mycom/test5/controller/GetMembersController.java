package com.mycom.test5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycom.test5.bean.Member;
import com.mycom.test5.service.GetMembersService;

@Controller
@RequestMapping("/select")
public class GetMembersController {
	@Autowired
	GetMembersService getMembersService = new GetMembersService();
	
	@GetMapping("/all")
	public String getAllMembers(Model model) {
		List<Member> members = getMembersService.getAllMembers();
		model.addAttribute("members", members);
		return "select/all";
	}
	
	@GetMapping("/{id}")
	public String detailInfo(@PathVariable("id") int id, Model model) {
		Member member = getMembersService.selectMemberById(id);
		model.addAttribute("member", member);
		return "select/detail";
	}
}
