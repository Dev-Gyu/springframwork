package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;



public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Member selectByEmail(String email) {
		List<Member> result = jdbcTemplate.query("select * from MEMBER where EMAIL=?",new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs,int rowNum) throws SQLException{
				Member member = new Member(rs.getString("email"), rs.getString("password"), 
						rs.getString("name"), rs.getTimestamp("regdate").toLocalDateTime());
				member.setId(rs.getLong("id"));
				return member;
			}
		}, email);
	
		return result.isEmpty() ? null : result.get(0);
	}
	public void insert(Member member) {
		int isSuccess = jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pstmt = con.prepareStatement("insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE)"
						+ " values (?, ?, ?, ?)");
				pstmt.setString(1,member.getEmail());
				pstmt.setString(2,member.getPassword());
				pstmt.setString(3,member.getName());
				pstmt.setTimestamp(4,Timestamp.valueOf(member.getRegisterDateTime()));
				return pstmt;
			}
		});
		System.out.println("insert결과 ="+isSuccess);
	}
	
	public void update(Member member) {
		int isSuccess = jdbcTemplate.update("update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?",member.getName(), member.getPassword(),
				member.getEmail());
		System.out.println("update결과 ="+isSuccess);
	}
	
	public List<Member> selectAll(){
		String sql = "select * from MEMBER";
		List<Member> resultsList = jdbcTemplate.query(sql,new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
				Member member = new Member(rs.getString("email"), rs.getString("password"), 
						rs.getString("name"), rs.getTimestamp("regdate").toLocalDateTime());
				return member;
			}
		
		});
		return resultsList;
	}
	
}
