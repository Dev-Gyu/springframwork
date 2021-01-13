package com.gyus.boardProject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.gyus.boardProject.command.RegisterCommand;
import com.gyus.boardProject.vo.Member;

public class MemberDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String sql;
	
	// 멤버 id 재정렬
	private void idReAlignment() {
		sql = "set @CNT:=0";
		String sql2 = "update MEMBER set ID = @CNT:=@CNT+1";
		String sql3 = "alter table MEMBER auto_increment = 1";
		jdbcTemplate.update(sql);
		jdbcTemplate.update(sql2);
		jdbcTemplate.update(sql3);
	}
	
	// 회원 탈퇴
	public void signOut(String email) {
		sql = "delete from MEMBER where email = ?";
		jdbcTemplate.update(sql, email);
		idReAlignment();
	}
	// 멤버 비밀번호 변경
	public void changePassword(Member member, String newPassword) {
		sql = "update MEMBER set PASSWORD = ? where id = ?";
		jdbcTemplate.update(sql, newPassword, member.getId());
	}
	
	// 이메일로 멤버 하나만 가져오는 메소드
	public Member selectOne(String email) {
		sql = "select * from MEMBER where EMAIL = ?";
		List<Member> ls = jdbcTemplate.query(sql, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member();
				member.setId(rs.getInt("id"));
				member.setEmail(rs.getString("email"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setRegDate(rs.getTimestamp("regdate").toLocalDateTime());
				return member;
			}
		},email);
		if(ls.isEmpty()) {
			return null;
		}else {
			return ls.get(0);
		}
		
	}
	
	// 회원가입
	public void insert(RegisterCommand registerCommand) {
		sql = "insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) values (?, ?, ?, ?)";
		jdbcTemplate.update(sql, registerCommand.getEmail(), registerCommand.getPassword(), registerCommand.getName(), LocalDateTime.now());
	}
}
