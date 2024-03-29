package pubg.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCon {

	private PreparedStatement stmt;
	private ResultSet rs;

	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/battle";
	private final String ID = "root";
	private final String PASS = "100whdgns";
	
	public String getJDBC_DRIVER() {
		return JDBC_DRIVER;
	}

	public String getJDBC_URL() {
		return JDBC_URL;
	}

	public String getID() {
		return ID;
	}

	public String getPASS() {
		return PASS;
	}

	public DBCon() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("����ġ");
              
		}catch(ClassNotFoundException e) {
			System.out.println("����̹� ����");
		}
	}
	
	
	public void dbClose(ResultSet rs , PreparedStatement stmt , Connection conn) {
		if(rs != null || stmt != null || conn != null) {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(SQLException s) {
				System.out.println("DB ���� ������ error �߻�");
			}
		}
	}
	
}
