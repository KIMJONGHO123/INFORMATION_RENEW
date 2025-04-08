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
	
	public int insertVote(VoteDto dto) throws Exception{
		pstmt = conn.prepareStatement("insert into TBL_VOTE_202005 values(?,?,?,?,?,?)");
		pstmt.setString(1, dto.getV_jumin());
		pstmt.setString(2, dto.getV_name());
		pstmt.setString(3, dto.getM_no());
		pstmt.setString(4, dto.getV_time());
		pstmt.setString(5, dto.getV_area());
		pstmt.setString(6, dto.getV_confirm());
		
		int result = pstmt.executeUpdate();
		
		
		pstmt.close();
		return result;
	}
	
	
	public List<VoteDto> selectAllVote() throws SQLException {
		pstmt = conn.prepareStatement("select *from TBL_VOTE_202005");
		rs = pstmt.executeQuery();
		List<VoteDto> list = new ArrayList<>();
		VoteDto votedto=null;
		if(rs!=null) {
			while(rs.next()) {
				votedto = new VoteDto();
				votedto.setV_jumin(rs.getString(1));
				votedto.setV_name(rs.getString(2));
				votedto.setM_no(rs.getString(3));
				votedto.setV_time(rs.getString(4));
				votedto.setV_area(rs.getString(5));
				votedto.setV_confirm(rs.getString(6));
				list.add(votedto);
			}
			
		}
		pstmt.close();
		rs.close();
		return list;
		
	}
	
	public List<Vote_Rank> selectRank() throws SQLException {
		String sql = "select m.m_no,m.m_name ,count(*) 총투표건수 from tbl_member_202005 m join tbl_vote_202005 v\r\n"
				+ "on m.m_no = v.m_no\r\n"
				+ "group by m.m_no,m.m_name\r\n"
				+ "order by 총투표건수 desc";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Vote_Rank> list = new ArrayList<>();
		Vote_Rank voterank=null;
		if(rs!=null) {
			while(rs.next()) {
				voterank = new Vote_Rank();
				voterank.setM_no(rs.getString(1));
				voterank.setM_name(rs.getString(2));;
				voterank.setCount(rs.getString(3));
				list.add(voterank);
			}
			
		}
		pstmt.close();
		rs.close();
		return list;
		
	}
}
