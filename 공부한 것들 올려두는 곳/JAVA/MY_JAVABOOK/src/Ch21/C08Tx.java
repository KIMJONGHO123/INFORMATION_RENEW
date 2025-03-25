package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.DefPKCS12KeyStoreAES256;

public class C08Tx {
	// DB CONN DATA
	static String id = "root";
	static String pw = "1234";
	static String url = "jdbc:mysql://localhost:3306/testdb";

	// JDBC참조변수
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	
	public static void main(String[] args) {
		
		try {
			// DB 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB CONNECTED...");
			
			//
			System.out.println("INSERT 시작...");
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement("insert into tbl_test values('a',1,'a')");
			pstmt = conn.prepareStatement("insert into tbl_test values('b',1,'a')");
			pstmt = conn.prepareStatement("insert into tbl_test values('c',1,'a')");
			pstmt = conn.prepareStatement("insert into tbl_test values('d',1,'a')");

			
			pstmt.executeUpdate();
			conn.commit();
			System.out.println("INSERT 종료");
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
			}
		}finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
				
			}
			try {
				conn.close();
			} catch (Exception e2) {
				
			}
		}
	}
}
