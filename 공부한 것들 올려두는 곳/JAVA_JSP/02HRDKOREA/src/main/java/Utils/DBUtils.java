package Utils;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<MemberDto> selectAllMember() throws SQLException {
		String sql = "select m.m_no,m.m_name,p.p_name,m.p_school,m.m_jumin,m.m_city,p.p_tel1,p.p_tel2,p.p_tel3\r\n"
				+ "	from tbl_member_202005 m \r\n"
				+ "	join tbl_party_202005 p\r\n"
				+ "	on m.p_code = p.p_code";
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<MemberDto> list = new ArrayList<>();
		MemberDto memberdto=null;
		if(rs!=null) {
			while(rs.next()) {
				memberdto = new MemberDto();
				memberdto.setM_no(rs.getString(1));
				memberdto.setM_name(rs.getString(2));
				memberdto.setP_name(rs.getString(3));
				memberdto.setP_school(rs.getString(4));
				memberdto.setM_jomin(rs.getString(5));
				memberdto.setM_city(rs.getString(6));
				memberdto.setP_tel1(rs.getString(7));
				memberdto.setP_tel2(rs.getString(8));
				memberdto.setP_tel3(rs.getString(9));
				list.add(memberdto);
			}
			
		}
		pstmt.close();
		rs.close();
		return list;
		
	}
	
}
