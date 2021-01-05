package com.mycom.test5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

import com.mycom.test5.bean.Member;
import com.mycom.test5.bean.MemberDao;
import com.mycom.test5.command.LoginCommand;
import com.mycom.test5.exception.MemberNotFoundedException;
import com.mycom.test5.exception.NotMatchingException;

public class LoginService {
	@Autowired
	private MemberDao memberDao;
	
	public void login(LoginCommand loginCommand, Errors errors) {
		try {
			Member member = memberDao.selectMemberByEmail(loginCommand.getEmail());
			if(member == null) {
				throw new MemberNotFoundedException();
			}else {
				if(member.isPasswordMatch(loginCommand.getPassword())) {
					return;
				}else {
					throw new NotMatchingException();
				}
			}
		}catch(MemberNotFoundedException e) {
			errors.reject("notFound");
		}catch(NotMatchingException e) {
			errors.reject("pwMissMatch");
		}
	}
}
