package com.mycom.test5.config;



import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mycom.test5.bean.Member;
import com.mycom.test5.bean.MemberDao;
import com.mycom.test5.service.GetMembersService;
import com.mycom.test5.service.LoginService;
import com.mycom.test5.service.RegisterMemberService;

@Configuration
public class BeanConfig {
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/spring5fs?serverTimezone=UTC&&characterEncoding=utf8");
		dataSource.setUsername("spring5");
		dataSource.setPassword("spring5");
		dataSource.setTestWhileIdle(true);
		dataSource.setMinIdle(10);
		dataSource.setMaxActive(30);
		dataSource.setMaxIdle(20);
		dataSource.setInitialSize(10);
		dataSource.setTimeBetweenEvictionRunsMillis(1000 * 60 * 3);
		dataSource.setMinEvictableIdleTimeMillis(60000 * 3);
		return dataSource;
	}
	@Bean
	public MemberDao memberDao() {
		MemberDao memberDao = new MemberDao();
		memberDao.setJdbcTemplate(new JdbcTemplate(dataSource()));
		return memberDao;
	}
	@Bean
	public GetMembersService getMembersService() {
		return new GetMembersService();
	}
	@Bean
	public RegisterMemberService registerMemberService() {
		return new RegisterMemberService();
	}
	@Bean
	public LoginService loginService() {
		return new LoginService();
	}
}
