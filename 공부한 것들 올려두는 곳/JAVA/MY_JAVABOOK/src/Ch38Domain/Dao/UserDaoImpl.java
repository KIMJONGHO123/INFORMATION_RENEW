package Ch38Domain.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Ch38Domain.Dao.ConnectionPool.ConnectionItem;
import Ch38Domain.Dao.ConnectionPool.ConnectionPool;
import Ch38Domain.Dto.UserDto;

public class UserDaoImpl extends Dao implements userDao {
//	private Connection conn;
//	private PreparedStatement pstmt;
//	private ResultSet rs;
//	
//	
//	private String id="root";
//	private String pw="1234";
//	private String url = "jdbc:mysql://localhost:3306/bookdb";
	
	//Connection Pool 연결
//	private ConnectionPool connectionpool;
//	private ConnectionItem connectionitem;
	
	
	// 싱글톤 패턴처리
	private static userDao instance;
	private UserDaoImpl() throws Exception, SQLException {
		// 여기서는 예외처리 웬만하면 하지 않는다 Controller로 넘긴다.
//		System.out.println("[DAO] UserDaoImpl init...");
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		conn = DriverManager.getConnection(url,id,pw);
//		System.out.println("BookDaoImpl DB Connection Success");
		
		connectionpool = connectionpool.getInstance();
		
		
	};
	public static userDao getInstance() throws Exception {
		if (instance == null) {
			instance =new UserDaoImpl();
			
		}
		return instance;
	}
	
	//CRUD
	@Override
	public int insert(UserDto userdto) throws Exception {
		try {
			connectionitem = connectionpool.getConnection();
			Connection conn = connectionitem.getConn();
			
			pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?,?)");
			pstmt.setString(1, userdto.getUserid());
			pstmt.setString(2,userdto.getUsername());
			pstmt.setString(3,userdto.getPassword());
			pstmt.setString(4,"ROLE_USER");
			
			
			// Connection release
			connectionpool.releaseConnection(connectionitem);
			
			return pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("USERDAO's INSERT SQL EXCEPTION!");
		}finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
				
			}
		}
	}
	
	@Override
	public int update(UserDto userdto) throws SQLException {
//		try {
//			pstmt = conn.prepareStatement("");
//			return pstmt.executeUpdate();
//		}catch(SQLException e){
//			e.printStackTrace();
//			throw new SQLException("USERDAO's UPDATE SQL EXCEPTION!");
//		}finally {
//			try {
//				pstmt.close();
//			} catch (Exception e2) {
//				
//			}
//		}
		return 0;
	}
	@Override
	public int delete(UserDto userdto) throws SQLException {
//		try {
//			pstmt = conn.prepareStatement("");
//			return pstmt.executeUpdate();
//		}catch(SQLException e){
//			e.printStackTrace();
//			throw new SQLException("USERDAO's DELETE SQL EXCEPTION!");
//		}finally {
//			try {
//				pstmt.close();
//			} catch (Exception e2) {
//				
//			}
//		}
		return 0;
	}
	@Override
	public UserDto select(UserDto userdto){
		return null;
	}
	@Override
	public List<UserDto> selectAll(){
		return null;
	}
	
	
	
}
