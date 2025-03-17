package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C05SELECT {
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
			
			// SQL 준비
			pstmt = conn.prepareStatement("select * from tbl_std");
			
			
			// SQL 실행
			rs = pstmt.executeQuery(); //executeQuery()은 반환값이 ResultSet object이다.
			
			if (rs != null) {
				while (rs.next()) { // 기본적으로 rs는 행의 타이틀에 가리킨다. 그래서 next하면 커서의 위치가 밑에 행으로 이동한다. 계속 밑으로 내려가다가 값이 없으면 false를 반환하고 while을 멈춘다.
					System.out.print(rs.getString("name")+" ");
					System.out.print(rs.getInt("age")+" ");
					System.out.print(rs.getString("addr")+"\n");
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {  // 종료되는 상황에서도 예외발생할 수 있어서 finally에서도 try catch 한것
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
//			try {
//				if (!rs.isClosed()) {
//					rs.close();
//				}
//				if (!pstmt.isClosed()) {
//					pstmt.close();
//				}
//				if (!conn.isClosed()) {
//					conn.close();
//				}
//			} catch (SQLException e2) {
//				e2.printStackTrace();
//			}
		}
	}
}
