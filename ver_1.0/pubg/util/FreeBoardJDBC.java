package pubg.util;

import java.sql.*;
import java.util.*;

import pubg.util.FreeBoardBeanz;

public class FreeBoardJDBC {

	//---JDBC 연동---
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/pubgdb?useSSL=false&useUnicode=true&characterEncoding=utf8";
	private final String id = "root";
	private final String pw = "1111";
	
	String selQuery = "select regno, user_id, f_title, f_date from free_board"; // 전체 글 검색 쿼리
	String searchQuery = "select regno, user_id, f_title, f_date from free_board where f_title like ?"; // 제목검색
	String textQuery = "select * from free_board where regno = ?"; //제목클릭 글보기 쿼리
	String instQuery = "insert into free_board(user_id, f_title, f_text, f_date) values(?, ?, ?, ?)"; // 글작성
	
	public FreeBoardJDBC() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("드라이버 설치 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 설치 실패");
		} 
	}
	//---JDBC 연동 end---

	//---전체 글 검색---
	public Vector<FreeBoardBeanz> getFBoardList() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Vector<FreeBoardBeanz> vecList = new Vector<FreeBoardBeanz>();
		
		try {
			con = DriverManager.getConnection(JDBC_URL, id, pw);
			st = con.createStatement();
			rs = st.executeQuery(selQuery);
			
			while(rs.next()) {
				FreeBoardBeanz regBean = new FreeBoardBeanz();
				regBean.setRegno(rs.getInt("regno"));
				regBean.setUser_id(rs.getString("user_id"));
				regBean.setF_title(rs.getString("f_title"));
				regBean.setF_date(rs.getString("f_date"));
				vecList.add(regBean);
			}
		} catch (SQLException e) {
			System.out.println("Exception : " + e);
		} finally {
			try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { st.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		return vecList;
	}	
	//---전체 글 검색 end---
	
	
	//---제목검색---
	public Vector<FreeBoardBeanz> getFBoardSearch(String text){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Vector<FreeBoardBeanz> vecList = new Vector<FreeBoardBeanz>();
		
		try {
			con = DriverManager.getConnection(JDBC_URL, id, pw);
			ps = con.prepareStatement(searchQuery);
			ps.setString(1, "%"+text+"%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FreeBoardBeanz regBean = new FreeBoardBeanz();
				regBean.setRegno(rs.getInt("regno"));
				regBean.setUser_id(rs.getString("user_id"));
				regBean.setF_title(rs.getString("f_title"));
				regBean.setF_date(rs.getString("f_date"));
				vecList.add(regBean);
			}
		} catch (SQLException e) {
			System.out.println("Exception : " + e);
		} finally {
			try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
		return vecList;
	}
	//---제목검색 end---
	
	
	//---글보기---
	public Vector<FreeBoardBeanz> getFBoardText(int regno){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Vector<FreeBoardBeanz> vecList = new Vector<FreeBoardBeanz>();
		
		try {
			con = DriverManager.getConnection(JDBC_URL, id, pw);
			ps = con.prepareStatement(textQuery);
			ps.setInt(1, regno);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				FreeBoardBeanz regBean = new FreeBoardBeanz();
				regBean.setRegno(rs.getInt("regno"));
				regBean.setUser_id(rs.getString("user_id"));
				regBean.setF_title(rs.getString("f_title"));
				regBean.setF_text(rs.getString("f_text"));
				regBean.setF_date(rs.getString("f_date"));
				vecList.add(regBean);
			}
		} catch (SQLException e) {
			System.out.println("Exception : " + e);
		} finally {
			try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		
		return vecList;
	}
	//---글보기 end---
	
	
	//---글작성---
	public void insertFBoardText(String user_id, String f_title, String f_text, String f_date) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(JDBC_URL, id, pw);
			ps = con.prepareStatement(instQuery);
			ps.setString(1, user_id);
			ps.setString(2, f_title);
			ps.setString(3, f_text);
			ps.setString(4, f_date);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Exception : " + e);
		} finally {
			try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
	//---글작성 end---
	
}
