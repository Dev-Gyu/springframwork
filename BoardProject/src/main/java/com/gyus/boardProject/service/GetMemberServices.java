package com.gyus.boardProject.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gyus.boardProject.dao.MemberDAO;
import com.gyus.boardProject.vo.Member;

public class GetMemberServices {
	@Autowired
	private MemberDAO memberDAO;
	
	public Member getOneMember(String email) {
		Member member = memberDAO.selectOne(email);
		return member;
	}
}
