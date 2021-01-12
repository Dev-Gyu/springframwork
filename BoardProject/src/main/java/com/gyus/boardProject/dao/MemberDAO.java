package com.gyus.boardProject.dao;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gyus.boardProject.command.RegisterCommand;

public class MemberDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(RegisterCommand registerCommand) {
		String sql = "insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) values (?, ?, ?, ?)";
		jdbcTemplate.update(sql, registerCommand.getEmail(), registerCommand.getPassword(), registerCommand.getName(), LocalDateTime.now());
	}
}
