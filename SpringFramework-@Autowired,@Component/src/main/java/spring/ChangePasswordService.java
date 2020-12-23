package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {
	//Autowired사용하면 setter, 메소드내에서 의존 선언 안해줘도 설정파일에서 자동으로 의존객체 주입해줌
	@Autowired
	private MemberDao memberDao;
	
	public void changePassword(String email, String oldPassword, String newPassword) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPassword, newPassword);
		memberDao.update(member);
	}
}
