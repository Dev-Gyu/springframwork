package com.mycom.test5.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycom.test5.bean.Member;
import com.mycom.test5.bean.MemberDao;

public class GetMembersService {
	@Autowired
	MemberDao memberDao;
	
	public List<Member> getAllMembers(){
		List<Member> ls = memberDao.selectAllMembers();
		if(ls != null) {
			return ls;
		}else {
			return Collections.emptyList();
		}
	}
}
