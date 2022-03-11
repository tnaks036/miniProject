package jdbc;


import java.sql.*;


public class JDBCTest {
	
	

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dburl = "jdbc:mysql://192.168.0.7:3306/crawl_data";
			conn = DriverManager.getConnection(dburl, "crawl_user", "1234");
			stmt = conn.createStatement();
			//conn.createStatement: 순방향으로만 데이터를 읽어내려 간다
			String sql = "SELECT no, category, restaurant, menu, price, reviews, polls, specification "
					+ " FROM df_db3 " 
					+" WHERE category = '한식' ORDER BY category DESC";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Long no = rs.getLong("no");
				String category = rs.getString("category");
				String restaurant = rs.getString("restaurant");
				String menu = rs.getString("menu");
				String price = rs.getString("price");
				Long reviews = rs.getLong("reviews");
				Long polls = rs.getLong("polls");
				String specification = rs.getString("specification");
				
				
				
				System.out.println(no + ":" + category + ":" + restaurant + ":" + menu + ":" + 
														 price + ":" + reviews + ":" + polls + ":" + specification);
			}
			} catch (ClassNotFoundException e) {
				System.err.println("드라이버 로딩 실패!");
			} catch (Exception e) {
				System.err.println("쿼리 수행 실패!");
				e.printStackTrace();
				
			} finally {
				try {
					rs.close();
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			
		}
		
	}

}
