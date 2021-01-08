package com.mycom.test5.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.google.protobuf.Timestamp;

public class MemberDao {
	JdbcTemplate jdbcTemplate;
	
	// RowMapper 반복하는거 대신하도록 변수설정
	RowMapper<Member> rowMapper = new RowMapper<Member>() {
		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
			Member member = new Member(rs.getString("email"), rs.getString("password"), rs.getString("name"));
			member.setId(rs.getInt("id"));
			member.setRegDate(rs.getTimestamp("REGDATE").toLocalDateTime());
			return member;
	}
	};

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Member selectById(int id) {
		List<Member> member = (List<Member>)jdbcTemplate.query("select * from MEMBER where ID = ?", rowMapper, id);
		return member.get(0);
	}
	
	public int changePassword(Member member) {
		int isSuccess = jdbcTemplate.update("update MEMBER set PASSWORD=? where EMAIL=?", member.getPassword(), member.getEmail());
		return isSuccess;
	}
	
	public int registerMember(Member member) {
		int isSuccess = jdbcTemplate.update("insert into MEMBER (NAME, EMAIL, PASSWORD, REGDATE) values (?,?,?,now())", member.getName(), member.getEmail()
				, member.getPassword());
		return isSuccess;
	}
	
	public Member selectMemberByEmail(String email) {
		List<Member> member = jdbcTemplate.query("select * from MEMBER where EMAIL = ?", rowMapper, email);
			return member.isEmpty() ? null : member.get(0);
	}
	
	public List<Member> selectAllMembers(){
		List<Member> results = new ArrayList<Member>();
		results = jdbcTemplate.query("select * from MEMBER", rowMapper);
		return results;
	}
}
