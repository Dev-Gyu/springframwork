package com.gyus.boardProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

import com.gyus.boardProject.command.LoginCommand;
import com.gyus.boardProject.exception.MemberNotFoundException;
import com.gyus.boardProject.exception.PasswordNotMatchingException;
import com.gyus.boardProject.vo.AuthInfo;
import com.gyus.boardProject.vo.Member;

public class LoginService {
	@Autowired
	private GetMemberServices getMemberServices;
	
	// 로그인입력에 대한 Validation은 뷰페이지에서하고 비밀번호불일치, 멤버없음등의 DB접근후에 발생하는 에러는 서비스단에서 추가
	public AuthInfo login(LoginCommand loginCommand, Errors errors) throws MemberNotFoundException{
		Member member = getMemberServices.getOneMember(loginCommand.getEmail());
		if(member != null && member.isPasswordMatch(loginCommand.getPassword())) {
			AuthInfo authInfo = new AuthInfo(member.getId(),member.getEmail(),member.getName(),member.getRegDate());
			return authInfo;
		}else {
			throw new PasswordNotMatchingException();
		}
	}
}
