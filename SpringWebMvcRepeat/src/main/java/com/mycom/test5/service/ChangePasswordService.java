package com.mycom.test5.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import com.mycom.test5.bean.Member;
import com.mycom.test5.bean.MemberDao;
import com.mycom.test5.command.AuthInfo;
import com.mycom.test5.command.ChangePasswordCommand;
import com.mycom.test5.exception.NotMatchingException;
import com.mycom.test5.exception.NotValidateException;
import com.mycom.test5.validator.ChangePasswordValidator;


public class ChangePasswordService {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private ChangePasswordValidator changePasswordValidator;
	
	//@Transactional
	public void changePassword(ChangePasswordCommand changePasswordCommand, Errors errors, HttpSession session) {
		changePasswordValidator.validate(changePasswordCommand, errors);
		if(errors.hasErrors()) {
			throw new NotValidateException();
		}
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		Member member = memberDao.selectMemberByEmail(authInfo.getEmail());
		if(changePasswordCommand.getCurrentPassword().equals(member.getPassword())) {
		memberDao.changePassword(member);
		return;
		}else {
		errors.rejectValue("currentPassword", "changePwd.missMatch");
		throw new NotMatchingException();
		}
	}
}
