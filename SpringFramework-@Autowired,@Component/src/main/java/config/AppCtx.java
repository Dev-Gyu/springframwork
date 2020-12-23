package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.VersionPrinter;

// MemberDao, MemberListPrinter, MemberInfoPrinter, MemberSummaryPrinter @Component설정함
// @Configuration = 스프링 설정 클래스를 의미
@Configuration
@ComponentScan(basePackages = {"spring"})
//memberDao 중복돼서 예외발생예측
public class AppCtx {
	// @Bean = getBean()의 대상이 될 Bean메소드를 정의함. 탐색시 메소드의 이름으로 탐색한다
	// 즉, getBean("memberDao")로 탐색하면 memberDao()메소드를 가져오는것인데, 반환값이 있으므로 해당 반환값이 대입됨
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService();
	}
	
	// changePassword class에 dao객체 Autowired로 자동주입함 => setter써서 의존주입 안해줘도 되는것
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		return pwdSvc;
	}
	/*
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		return infoPrinter;
	}
	*/
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter vPrinter = new VersionPrinter();
		vPrinter.setMajorVersion(5);
		vPrinter.setMinorVersion(0);
		return vPrinter;
	}
}
