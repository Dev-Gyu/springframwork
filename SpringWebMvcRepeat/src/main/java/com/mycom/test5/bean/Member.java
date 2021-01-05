package com.mycom.test5.bean;

import java.time.LocalDateTime;

public class Member {
	private int id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime regDate;
	
	public Member(String email, String password, String name) {
		// TODO Auto-generated constructor stub
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}
	public boolean isPasswordMatch(String password) {
		return this.password.equals(password);
	}
	
}
