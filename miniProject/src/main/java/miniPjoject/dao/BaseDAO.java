package miniPjoject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	
	protected Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dburl = "jdbc:mysql://192.168.0.7:3306/crawl_data";
			conn = DriverManager.getConnection(dburl, "crawl_user", "1234");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패!");
		}
		return conn ; 
	}

}
