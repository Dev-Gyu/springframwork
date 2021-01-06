package com.mycom.test5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

import com.mycom.test5.bean.Member;
import com.mycom.test5.bean.MemberDao;
import com.mycom.test5.command.AuthInfo;
import com.mycom.test5.command.LoginCommand;
import com.mycom.test5.exception.MemberNotFoundedException;
import com.mycom.test5.exception.NotMatchingException;

public class LoginService {
	@Autowired
	private MemberDao memberDao;
	private Member member;
	
	public AuthInfo login(LoginCommand loginCommand, Errors errors) {
		try {
			if(errors.hasErrors())
				return null;
			member = memberDao.selectMemberByEmail(loginCommand.getEmail());
			if(member == null) {
				throw new MemberNotFoundedException();
			}else {
				if(member.isPasswordMatch(loginCommand.getPassword())) {
					AuthInfo authInfo = new AuthInfo();
					authInfo.setEmail(member.getEmail());
					authInfo.setName(member.getName());
					return authInfo;
				}else {
					throw new NotMatchingException();
				}
			}
		}catch(MemberNotFoundedException e) {
			errors.reject("notFound");
			return null;
		}catch(NotMatchingException e) {
			errors.reject("pwMissMatch");
			return null;
		}
	}
}
