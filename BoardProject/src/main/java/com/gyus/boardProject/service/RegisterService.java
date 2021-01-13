package com.gyus.boardProject.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gyus.boardProject.command.RegisterCommand;
import com.gyus.boardProject.dao.MemberDAO;
import com.gyus.boardProject.exception.DuplicateException;

public class RegisterService {
	@Autowired
	MemberDAO memberDAO;
	@Autowired
	GetMemberServices getMemberServices;
	
	public void insertMember(RegisterCommand registerCommand) {
		if(getMemberServices.getOneMember(registerCommand.getEmail()) != null) {
			throw new DuplicateException();
		}
		memberDAO.insert(registerCommand);
	}
}
