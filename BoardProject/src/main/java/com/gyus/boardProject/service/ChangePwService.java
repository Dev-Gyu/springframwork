package com.gyus.boardProject.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gyus.boardProject.command.ChangePwCommand;
import com.gyus.boardProject.dao.MemberDAO;
import com.gyus.boardProject.exception.PasswordNotMatchingException;
import com.gyus.boardProject.vo.AuthInfo;
import com.gyus.boardProject.vo.Member;

public class ChangePwService {
	@Autowired
	private GetMemberServices getMemberServices;
	@Autowired
	private MemberDAO memberDAO;
	
	public void changePw(AuthInfo authInfo, ChangePwCommand changePwCommand) {
		String inputPassword = changePwCommand.getOldPassword(); // 입력한 현재비밀번호
		String newPassword = changePwCommand.getNewPassword(); // 새로 변경할 비밀번호
		
		Member member = getMemberServices.getOneMember(authInfo.getEmail());
		
		if(member.isPasswordMatch(inputPassword)) {
			member.setPassword(newPassword);
			memberDAO.memberUpdate(member);
		}else {
			throw new PasswordNotMatchingException();
		}
	}
}
