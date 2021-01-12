package com.gyus.boardProject.config;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gyus.boardProject.dao.MemberDAO;

@Configuration
public class BeansConfig {
	// tomcat-jdbc 이용한 connectionPool생성 및 DB연동
	
	@Bean
	public DataSource dataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/boardproject?serverTimezone=UTC&&characterEncoding=utf8");
		dataSource.setUsername("boardManager");
		dataSource.setPassword("vmffkd495");
		dataSource.setTestWhileIdle(true);
		dataSource.setMaxActive(20);
		dataSource.setMaxIdle(5);
		dataSource.setMinIdle(3);
		dataSource.setTimeBetweenEvictionRunsMillis(1000*60*3);
		dataSource.setMinEvictableIdleTimeMillis(1000*60*5);
		return dataSource;
	}
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
	@Bean
	public MemberDAO memberDAO() {
		return new MemberDAO();
	}
}
