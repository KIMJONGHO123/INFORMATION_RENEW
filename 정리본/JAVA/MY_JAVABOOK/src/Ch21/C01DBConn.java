package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C01DBConn {
	public static void main(String[] args) {
		//DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/testdb";
		
		//JDBC 참조변수 (클래스 형태)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select결과
		
		//
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB CONNECTED");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {  // 종료되는 상황에서도 예외발생할 수 있어서 finally에서도 try catch 한것
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
