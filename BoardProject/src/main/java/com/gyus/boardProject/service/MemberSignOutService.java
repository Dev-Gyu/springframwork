package com.gyus.boardProject.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gyus.boardProject.dao.MemberDAO;
import com.gyus.boardProject.exception.PasswordNotMatchingException;
import com.gyus.boardProject.vo.AuthInfo;
import com.gyus.boardProject.vo.Member;

@Transactional
public class MemberSignOutService {
	
	@Autowired
	private GetMemberServices getMemberServices;
	@Autowired
	private MemberDAO memberDAO;
	
	public void signOut(HttpSession session, String nowPassword) {
		// 로그인한 정보를 토대로 멤버객체 가져옴
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		Member member = getMemberServices.getOneMember(authInfo.getEmail());
		
		// 가져온 멤버객체의 비밀번호와 입력한 비밀번호 맞으면 탈퇴, 아니면 불일치예외 컨트롤러에 전가
		if(member.isPasswordMatch(nowPassword)) {
			memberDAO.signOut(authInfo.getEmail());
		}else {
			throw new PasswordNotMatchingException();
		}
}
}
