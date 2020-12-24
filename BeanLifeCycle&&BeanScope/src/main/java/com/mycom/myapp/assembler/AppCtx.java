package com.mycom.myapp.assembler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mycom.myapp.spring.ChangePasswordService;
import com.mycom.myapp.spring.Client;
import com.mycom.myapp.spring.MemberDao;
import com.mycom.myapp.spring.MemberRegisterService;

// @Configuration = 스프링 설정 클래스를 의미
@Configuration
public class AppCtx {
	// @Bean = getBean()의 대상이 될 Bean메소드를 정의함. 탐색시 메소드의 이름으로 탐색한다
	// 즉, getBean("memberDao")로 탐색하면 memberDao()메소드를 가져오는것인데, 반환값이 있으므로 해당 반환값이 대입됨
	@Bean
	public Client client() {
		Client client = new Client();
		client.setHost("host");
		return client;
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
}
