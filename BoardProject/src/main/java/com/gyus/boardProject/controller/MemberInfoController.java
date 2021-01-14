package com.gyus.boardProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyus.boardProject.service.GetMemberServices;
import com.gyus.boardProject.vo.AuthInfo;
import com.gyus.boardProject.vo.Member;

@Controller
@RequestMapping("/member/detail")
public class MemberInfoController {
	@Autowired
	private GetMemberServices getMemberServices;
	@GetMapping
	public String details(Model model,HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		Member member = getMemberServices.getOneMember(authInfo.getEmail());
		model.addAttribute("member", member);
		return "member/detail";
	}
}
