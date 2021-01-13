package com.gyus.boardProject.vo;

import java.time.LocalDateTime;

public class AuthInfo {
	private int id;
	private String email;
	private String name;
	private LocalDateTime regDate;
	
	public AuthInfo(int id, String email, String name, LocalDateTime regDate) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.regDate = regDate;
	}
	
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	
	
}
