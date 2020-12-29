package com.mycom.myapp.config;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mycom.myapp.spring.ChangePasswordService;
import com.mycom.myapp.spring.MemberDao;
import com.mycom.myapp.spring.MemberRegisterService;

@Configuration
@EnableTransactionManagement
public class MemberConfig {
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/spring5fs?serverTimezone=UTC&&characterEncoding=utf8");
		ds.setUsername("spring5");
		ds.setPassword("spring5");
		ds.setInitialSize(10);
		ds.setMaxActive(20);
		ds.setMaxIdle(10);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return ds;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}
	
	@Bean
	public MemberDao memberDao() {
		MemberDao dao = new MemberDao(dataSource());
		return dao;
	}
	
	@Bean
	public ChangePasswordService changePasswordService() {
		ChangePasswordService cSvc = new ChangePasswordService();
		cSvc.setMemberDao(memberDao());
		return cSvc;
	}
	@Bean
	public MemberRegisterService memberRegisterService() {
		MemberRegisterService rSvc = new MemberRegisterService(memberDao());
		return rSvc;
	}
}
