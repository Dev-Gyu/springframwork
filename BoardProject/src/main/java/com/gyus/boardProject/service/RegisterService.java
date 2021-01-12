package com.gyus.boardProject.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gyus.boardProject.command.RegisterCommand;
import com.gyus.boardProject.dao.MemberDAO;

public class RegisterService {
	@Autowired
	MemberDAO memberDAO;
	
	public void insertMember(RegisterCommand registerCommand) {
		memberDAO.insert(registerCommand);
	}
}
