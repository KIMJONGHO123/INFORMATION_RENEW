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
		pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?)");
		pstmt.setString(1, userdto.getUserid());
		pstmt.setString(2, userdto.getPassword());
		pstmt.setString(3, userdto.getRole());
		
		int reulst = pstmt.executeUpdate();
		conn.commit();
		pstmt.close();
		return reulst;
	}
	
	public List<UserDto> selectAllUser() throws SQLException{
		
		pstmt = conn.prepareStatement("select * from tbl_user");
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
		pstmt = conn.prepareStatement("select * from tbl_user where USERID=?");
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
		pstmt = conn.prepareStatement("update tbl_user set password=?,role=? where userid=?");
		pstmt.setString(1, userdto.getPassword());
		pstmt.setString(2, userdto.getRole());
		pstmt.setString(3, userdto.getUserid());
		
		int reulst = pstmt.executeUpdate();
		conn.commit();
		pstmt.close();
		return reulst;
	}
	 
	public int deleteUser(String userid) throws SQLException {
		pstmt = conn.prepareStatement("delete from tbl_user where userid=?"); // tbl_test
		pstmt.setString(1, userid);
		int result = pstmt.executeUpdate();
		conn.commit();
		pstmt.close();
		return result;
		
	}
	
public List<OrderDto> selectAllOrder() throws SQLException{
		
		//SQL
		
		String sql = "select category,sum(price*quantity) 총합 from tbl_order"
				+ " group by category"
				+ " having sum(price*quantity) >= 50000"
				+ " order by 총합 desc";
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List <OrderDto> li = new ArrayList<>();
		OrderDto orderdto = null;
		if(rs !=null) {
			while(rs.next()) {
				orderdto = new OrderDto();
				orderdto.setCategory(rs.getString(1)); // 나오는 컬럼을 넣을 수도 있다(첫번째 컬럼).
				orderdto.setSum(rs.getInt(2)); // 두 번째 컬럼
				li.add(orderdto);
			}
		}
		return li;
	}


public List<OrderDto2> Date_Selector() throws SQLException{
	
	//SQL
	
	String sql = "select order_date, round(avg(price*quantity),2) 총평균 from tbl_order"
			+ " group by order_Date";
	
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	List <OrderDto2> li = new ArrayList<>();
	OrderDto2 date_avg = null;
	if(rs !=null) {
		while(rs.next()) {
			date_avg = new OrderDto2();
			date_avg.setDate(rs.getDate(1).toLocalDate()); // 나오는 컬럼을 넣을 수도 있다(첫번째 컬럼).
			date_avg.setAvg(rs.getDouble(2)); // 두 번째 컬럼
			li.add(date_avg);
		}
	}
	return li;
}

public List<OrderDto3> SelectAllOrder3() throws SQLException{
	
	//SQL
	
	String sql = "select u.addr, o.order_date ,sum(o.price*o.quantity) 총합 from tbl_user u join tbl_order o"
			+ "	on u.userid = o.userid"
			+ "	group by u.addr, o.order_date"
			+ "	order by u.addr asc, 총합 desc";
	
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	List <OrderDto3> li = new ArrayList<>();
	OrderDto3 jas = null;
	if(rs !=null) {
		while(rs.next()) {
			jas = new OrderDto3();
			jas.setAddr(rs.getString(1)); // 나오는 컬럼을 넣을 수도 있다(첫번째 컬럼).
			jas.setOrder_date(rs.getDate(2).toLocalDate()); // 두 번째 컬럼
			jas.setSum(rs.getInt(3));
			li.add(jas);
			
		}
	}
	return li;
}


public List<left_out_join_notbuy> notbuy() throws SQLException{
	
	//SQL
	
	String sql = "select * from tbl_user left outer join tbl_order   --구매하지 않은 고객\r\n"
			+ "	on tbl_user.userid = tbl_order.userid\r\n"
			+ "	where tbl_order.userid is null";
	
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	List <left_out_join_notbuy> li = new ArrayList<>();
	left_out_join_notbuy loj = null;
	if(rs !=null) {
		while(rs.next()) {
			loj = new left_out_join_notbuy();
			loj.setUserid(rs.getString(1)); // 나오는 컬럼을 넣을 수도 있다(첫번째 컬럼).
			loj.setPassword(rs.getInt(2)); // 두 번째 컬럼
			loj.setRole(rs.getString(3));
			loj.setAddr(rs.getString(4));
			loj.setProduct_id(rs.getInt(5));
			loj.setUserid_1(rs.getString(6));
			loj.setProduct_name(rs.getString(7));
			loj.setCategory(rs.getString(8));
			loj.setPrice(rs.getInt(9));
			loj.setQuantity(rs.getInt(10));
			loj.setOrder_date(rs.getString(11));
			
			li.add(loj);
			
		}
	}
	return li;
}
}
