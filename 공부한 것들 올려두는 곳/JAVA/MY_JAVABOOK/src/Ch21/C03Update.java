package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C03Update {

	public static void main(String[] args) {
		//DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/testdb";
		
		//JDBC참조변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		//
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB CONNECTED...");
			
			String name = "티모";
			int age = 30;
			String addr = "서울";
			String sql = "update tbl_std set age=?, addr = ? where name=?"; // PK가 name
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, age);
			pstmt.setString(2, addr);
			pstmt.setString(3, name);
			
			int result = pstmt.executeUpdate();
			
			if (result>0) {
				System.out.println("update 정상 실행");
			}else {
				System.out.println("update 실패");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {	
			try { conn.close();} catch (SQLException e) {e.printStackTrace(); }
		}
	}

}
