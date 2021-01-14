package com.gyus.boardProject.vo;

import java.time.LocalDateTime;

public class Member {
	private int id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime regDate;
	private String cellphone;
	private String sex;
	
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellPhone) {
		this.cellphone = cellPhone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	
	public boolean isPasswordMatch(String password) {
		return this.password.equals(password);
	}
}
