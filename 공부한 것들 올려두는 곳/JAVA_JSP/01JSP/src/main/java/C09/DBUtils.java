package C09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import C04.UserDto;

public class DBUtils {
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String pw = "1234";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	private static DBUtils instance;
	public DBUtils() throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pw);
	}
	public static DBUtils getInstance() throws Exception{
		if(instance==null) {
			instance = new DBUtils();
		}
		return instance;
	}
	
	
	//3-4
	
	public int insertUser(UserDto userdto) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_test values(?,?,?)");
		pstmt.setString(1, userdto.getUserid());
		pstmt.setString(2, userdto.getPassword());
		pstmt.setString(3, userdto.getRole());
		
		int reulst = pstmt.executeUpdate();
		conn.commit();
		pstmt.close();
		return reulst;
	}
	
	public List<UserDto> selectAllUser() throws SQLException{
		
		pstmt = conn.prepareStatement("select * from tbl_test");
		rs = pstmt.executeQuery();
		UserDto userdto = null;
		List <UserDto> li = new ArrayList<>();
		if(rs !=null) {
			while(rs.next()) {
				userdto = new UserDto();
				userdto.setUserid(rs.getString("userid"));
				userdto.setPassword(rs.getString("password"));
				userdto.setRole(rs.getString("role"));
				li.add(userdto);
			}
		}
		return li;
	}
	
	public UserDto selectOneUser(String userid) throws SQLException {
		pstmt = conn.prepareStatement("select * from tbl_test where USERID=?");
		pstmt.setString(1, userid);
		rs = pstmt.executeQuery();
		UserDto userdto = null;
		if(rs.next()) {
			userdto = new UserDto();
			userdto.setUserid(rs.getString("userid"));
			userdto.setPassword(rs.getString("password"));
			userdto.setRole(rs.getString("role"));
				
			
		}
		rs.close();
		pstmt.close();
		return userdto;
	}
	
	public int updateUser(UserDto userdto) throws Exception {
		pstmt = conn.prepareStatement("update tbl_test set password=?,role=? where userid=?");
		pstmt.setString(1, userdto.getPassword());
		pstmt.setString(2, userdto.getRole());
		pstmt.setString(3, userdto.getUserid());
		
		int reulst = pstmt.executeUpdate();
		conn.commit();
		pstmt.close();
		return reulst;
	}
	
	public int deleteUser(String userid) throws SQLException {
		pstmt = conn.prepareStatement("delete from tbl_test where userid=?");
		pstmt.setString(1, userid);
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result;
		
	}
}
