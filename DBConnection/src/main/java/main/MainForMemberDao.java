package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.Member;
import spring.MemberDao;

public class MainForMemberDao {
	private static MemberDao memberDao;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppCtx.class);
		memberDao = context.getBean("memberDao",MemberDao.class);
		
		selectAll();
		updateMember();
		insertMember();
		context.close();

	}
	
	private static void selectAll() {
		System.out.println("selectAll 실행");
		List<Member> members = memberDao.selectAll();
		for(Member member : members) {
			System.out.println("Email="+member.getEmail()+", Name="+member.getName()+", id="+member.getId());
		}
	}
	
	private static void updateMember() {
		System.out.println("update실행");
		Member member = new Member("asdf@naver.com", "asdf", "규스", LocalDateTime.now());
		memberDao.update(member);
		Member result = memberDao.selectByEmail("asdf@naver.com");
		System.out.println(result.getEmail()+","+result.getPassword()+","+result.getName()+","+result.getRegisterDateTime().toLocalDate());
	}
	
	// 인서트메소드는 그냥 시간형식메소드 실행결과 어떻게 나오는지 확인하려고 일부러 이렇게 작성해둠.
	private static void insertMember() {
		String formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(LocalDateTime.now());
		System.out.println(formatter);
	}

}
