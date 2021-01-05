package com.mycom.test5.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycom.test5.bean.Member;
import com.mycom.test5.bean.MemberDao;
import com.mycom.test5.command.RegisterCommand;
import com.mycom.test5.exception.DuplicateEmailException;

public class RegisterMemberService {
	@Autowired
	private MemberDao memberDao;
	
	public int registerMember(RegisterCommand registerCommand) {
		try {
		Member member = memberDao.selectMemberByEmail(registerCommand.getEmail());
		if(member == null) {
		member = new Member(registerCommand.getEmail(),registerCommand.getPassword(),registerCommand.getName());
		}else {
			throw new DuplicateEmailException();
		}
		int isSuccess = memberDao.registerMember(member);
		return isSuccess;
	}catch (DuplicateEmailException e) {
		// TODO: handle exception
		return 0;
	}
	}
}
