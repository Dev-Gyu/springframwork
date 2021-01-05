package com.mycom.test5.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberDao {
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int registerMember(Member member) {
		int isSuccess = jdbcTemplate.update("insert into MEMBER (NAME, EMAIL, PASSWORD, REGDATE) values (?,?,?,now())", member.getName(), member.getEmail()
				, member.getPassword());
		return isSuccess;
	}
	
	public Member selectMemberByEmail(String email) {
		List<Member> member = jdbcTemplate.query("select * from MEMBER where EMAIL = ?", new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
						Member member = new Member(rs.getString("email"), rs.getString("password"), rs.getString("name"));
						member.setId(rs.getInt("id"));
						return member;
			}
		}, email);
			return member.isEmpty() ? null : member.get(0);
	}
	
	public List<Member> selectAllMembers(){
		List<Member> results = new ArrayList<Member>();
		results = jdbcTemplate.query("select * from MEMBER", new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
			Member member = new Member(rs.getString("email"), rs.getString("password"), rs.getString("name"));
			member.setId(rs.getInt("id"));
			return member;
			}
		});
		return results;
	}
}
