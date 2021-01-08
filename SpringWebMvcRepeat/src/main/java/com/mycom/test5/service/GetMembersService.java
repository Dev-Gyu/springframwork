package com.mycom.test5.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycom.test5.bean.Member;
import com.mycom.test5.bean.MemberDao;

public class GetMembersService {
	@Autowired
	MemberDao memberDao;
	
	// 전체 멤버 조회
	public List<Member> getAllMembers(){
		List<Member> ls = memberDao.selectAllMembers();
		if(ls != null) {
			return ls;
		}else {
			return Collections.emptyList();
		}
	}
	
	// id로 멤버 조회
	public Member selectMemberById(int id) {
		Member member = memberDao.selectById(id);
		return member;
	}
}
