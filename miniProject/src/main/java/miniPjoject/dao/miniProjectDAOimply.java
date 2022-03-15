package miniPjoject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class miniProjectDAOimply extends BaseDAO implements miniProjectDAO {


	
	
	
	
	@Override
	public List<miniProjectlist> restaurant(String category) {
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<miniProjectlist> list = new ArrayList<>();
		
		try {
//			stmt = conn.createStatement();
			// conn.createStatement: 순방향으로만 데이터를 읽어내려 간다
			conn = getConnection();
			String sql = "SELECT DISTINCT restaurant "
					+ " FROM df_db3 " + " WHERE category = ? ORDER BY reviews DESC";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				miniProjectlist item = new miniProjectlist();
				item.setRestaurant(rs.getString(1));
				
				list.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
//				stmt.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
			}
			;
		}
		return list;

	}			
	
	
	



	@Override
	public List<miniProjectlist> menu(String restaurant) {
	
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<miniProjectlist> list = new ArrayList<>();
		
		try {
//			stmt = conn.createStatement();
			// conn.createStatement: 순방향으로만 데이터를 읽어내려 간다
			conn = getConnection();
			String sql = "SELECT menu "
					+ " FROM df_db3 " + "WHERE restaurant = ? ORDER BY reviews DESC";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, restaurant);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				miniProjectlist item = new miniProjectlist();
				item.setMenu(rs.getString(1));
				
				list.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
//				stmt.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
			}
			;
		}
		return list;

	}				
	

	
	






	@Override
	public List<miniProjectlist> getList(String restaurant) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<miniProjectlist> list = new ArrayList<>();

		try {
//			stmt = conn.createStatement();
			// conn.createStatement: 순방향으로만 데이터를 읽어내려 간다
			conn = getConnection();
			String sql = "SELECT no, category, restaurant, menu, price, reviews, polls, specification "
					+ " FROM df_db3 " + " WHERE restaurant = ? ORDER BY polls DESC ";
			

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, restaurant);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				miniProjectlist item = new miniProjectlist();
				item.setNo(rs.getLong(1));
				item.setCategory(rs.getString(2));
				item.setRestaurant(rs.getString(3));
				item.setMenu(rs.getString(4));
				item.setPrice(rs.getLong(5));
				item.setReviews(rs.getLong(6));
				item.setPolls(rs.getLong(7));
				item.setSpecification(rs.getString(8));
				
				list.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
			}
			;
		}
		return list;

			
	}
	
	
	
	@Override
	public miniProjectlist getPollsCount(String category, String restaurant, String menu) {
	// 개별 객체 가져올 때는 그냥 이대로, 복합적으로 가져올 때는 list로 가져옴	
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		miniProjectlist vo = null;
		
		Long count = null;
		String address = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT polls, specification "
					+ " FROM df_db3 " + " WHERE (category = ? AND restaurant = ? AND menu = ?) ";			

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setString(2, restaurant);
			pstmt.setString(3, menu);
		 
			rs = pstmt.executeQuery();
			
			
			rs.next();
			count = rs.getLong(1);
			address = rs.getString(2);
			
			vo = new miniProjectlist();
			vo.setCount(count);
			vo.setAddress(address);
			
			
			
			// 받아오는 컬럼을 명시함
		} catch (Exception e) {
			
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				
			}
		}
		
		return vo ;
		
	}
	
	
	@Override
	public List<miniProjectlist> getPolls(String category, String restaurant, String menu) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<miniProjectlist> CountOfPolls = new ArrayList<>();

		try {
//			stmt = conn.createStatement();
			// conn.createStatement: 순방향으로만 데이터를 읽어내려 간다
			conn = getConnection();
			String sql = "SELECT polls "
					+ " FROM df_db3 " + " WHERE (category = ? AND restaurant = ? AND menu = ?) ";
			

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, category);
			pstmt.setString(2, restaurant);
			pstmt.setString(3, menu);
	
			rs = pstmt.executeQuery();
			System.out.println(rs);
			
			
			while(rs.next()) {
				miniProjectlist item = new miniProjectlist();
				item.setPolls(rs.getLong(1));
				
				CountOfPolls.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
			}
			;
		}
		return CountOfPolls;

	}
	
	@Override
	public List<miniProjectlist> getspecification(String category, String restaurant, String menu) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<miniProjectlist> list = new ArrayList<>();

		try {
//			stmt = conn.createStatement();
			// conn.createStatement: 순방향으로만 데이터를 읽어내려 간다
			conn = getConnection();
			String sql = "SELECT specification "
					+ " FROM df_db3 " + " WHERE (category = ? AND restaurant = ? AND menu = ?) ";
			

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, category);
			pstmt.setString(2, restaurant);
			pstmt.setString(3, menu);
	
			rs = pstmt.executeQuery();
			System.out.println(rs);
			
			
			while(rs.next()) {
				miniProjectlist item = new miniProjectlist();
				item.setSpecification(rs.getString(1));
				
				list.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
			}
			;
		}
		return list;

	}

	@Override
	public int update(String category, String restaurant, String menu) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
				
		System.out.println(category);
		System.out.println(restaurant);
		System.out.println(menu);
		
		try {
				conn = getConnection();
				String sql = "UPDATE  df_db3 "
					+ "SET polls = polls + 1 "
					+ "WHERE (category = ? and restaurant = ? and menu = ?) ";
					
				
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setString(2, restaurant);
			pstmt.setString(3, menu);
			
			count =pstmt.executeUpdate();
			System.out.println(count);
			System.out.println("해결");

			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (Exception e) {
				}

			}
			return count;
		
	}
	
	
	
	
	
	
	
	
	public List<miniProjectlist> getSelectedList() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<miniProjectlist> list = new ArrayList<>();

		try {
//			stmt = conn.createStatement();
			// conn.createStatement: 순방향으로만 데이터를 읽어내려 간다
			conn = getConnection();
			String sql = "SELECT no, category, restaurant, menu, price, reviews, polls, specification "
					+ " FROM df_db3 " + " WHERE polls > 0 ORDER BY polls DESC";
			

			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				miniProjectlist item = new miniProjectlist();
				item.setNo(rs.getLong(1));
				item.setCategory(rs.getString(2));
				item.setRestaurant(rs.getString(3));
				item.setMenu(rs.getString(4));
				item.setPrice(rs.getLong(5));
				item.setReviews(rs.getLong(6));
				item.setPolls(rs.getLong(7));
				item.setSpecification(rs.getString(8));
				
				list.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
			}
			;
		}
		return list;

	}

	
	
	


	
//	@Override
//	public List<miniProjectlist> getList(String category) {
//		Connection conn = null;
//		ResultSet rs = null;
//		PreparedStatement pstmt = null;
//		List<miniProjectlist> list = new ArrayList<>();
//
//		try {
////			stmt = conn.createStatement();
//			// conn.createStatement: 순방향으로만 데이터를 읽어내려 간다
//			conn = getConnection();
//			String sql = "SELECT no, category, restaurant, menu, price, reviews, polls, specification "
//					+ " FROM df_db3 " + " WHERE category = ? ORDER BY reviews DESC";
//			
//
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, category);
//			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				miniProjectlist item = new miniProjectlist();
//				item.setNo(rs.getLong(1));
//				item.setCategory(rs.getString(2));
//				item.setRestaurant(rs.getString(3));
//				item.setMenu(rs.getString(4));
//				item.setPrice(rs.getLong(5));
//				item.setReviews(rs.getLong(6));
//				item.setPolls(rs.getLong(7));
//				item.setSpecification(rs.getString(8));
//				
//				list.add(item);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				rs.close();
//				pstmt.close();
//				conn.close();
//			} catch (SQLException e) {
//			}
//			;
//		}
//		return list;
//
//	}
	
	
	
	
}

