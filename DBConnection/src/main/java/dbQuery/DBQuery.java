package dbQuery;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;

public class DBQuery {
	public DataSource ds;
	
	public DBQuery(DataSource dataSource) {
		ds = dataSource;
	}
		// TODO Auto-generated method stub
	public void select() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from MEMBER");
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("email"));
			System.out.println(rs.getString("password"));
			System.out.println(rs.getString("regdate"));
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					// TODO: handle exception
				}
			}
		}
	}

}
