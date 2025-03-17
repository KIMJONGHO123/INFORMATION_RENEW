package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C02Insert {
	public static void main(String[] args) {
		//DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/testdb";
		
		//JDBC 참조변수 (클래스 형태)
		Connection conn = null; // 데이터베이스 연결
		PreparedStatement pstmt = null; // SQL 실행. // 보안성 때문에 PreparedStatement를 사용
		ResultSet rs = null; // select결과
		
		//
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			
			//CONNECTION
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB CONNECTED");
			
			//SQL 쿼리 준비
			String name = args[0];
			int age = Integer.parseInt(args[1]);
			String addr = args[2];
			//pstmt = conn.prepareStatement("insert into tbl_std values(?,?,?)");  // insert문을 실행하여 데이터베이스에 값을 입력.
//			pstmt.setString(1, name);
//			pstmt.setInt(2, age);
//			pstmt.setString(3, addr);
			
			pstmt = conn.prepareStatement("insert into tbl_std values('"+name+"',"+age+",'"+addr+"')");  // ? 가 지원안 할시에 하는 방법 문자열은 ''으로 한번더 덮어씌어야 한다.
			
			// SQL 실행
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("INSERT 성공");
			}else {
				System.out.println("INSERT 실패");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {  // 종료되는 상황에서도 예외발생할 수 있어서 finally에서도 try catch 한것
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();  //printStackTrace(); → 예외 발생 시 오류 위치 & 원인을 콘솔에 출력
			}
		}
	}
}
