package com.mycom.chap13.spring;

public class AuthService {
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public AuthInfo authenticate(String email, String password) {
		Member member = memberDao.selectByEmail(email);
		if(member==null) {
			throw new MemberNotFoundException();
		}
		if(member.matchPassword(password)) {
			return new AuthInfo(member.getId(), member.getEmail(), member.getName());
		}else {
			throw new WrongIdPasswordException();
		}
	}
}
