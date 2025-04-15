package Domain.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Domain.Dao.ConnectionPool.ConnectionItem;
import Domain.Dto.UserDto;



public class UserDaoImpl extends Dao implements UserDao{
	//DB Attr
//	private Connection conn;
//	private PreparedStatement pstmt;
//	private ResultSet rs;
//	
//	private String id="root";
//	private String pw="1234";
//	private String url="jdbc:mysql://localhost:3306/bookDB";
	
	
	//CONNECTION POOL 
//	private ConnectionPool connectionPool;
//	private ConnectionItem connectionItem;
	
	
	//싱글톤 패턴처리
	private static UserDao instance;
	private UserDaoImpl() throws Exception {
		System.out.println("[DAO] UserDaoImpl init...");
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		conn = DriverManager.getConnection(url,id,pw);
//		System.out.println("UserDaoImpl DB Connection Success");
//		connectionPool =ConnectionPool.getInstance();
		
		
	};
	public static UserDao getInstance() throws Exception {
		if(instance==null)
			instance = new UserDaoImpl();
		return instance;
	}
	
	//CRUD 
 
	@Override
	public int insert(UserDto userDto) throws Exception {
	    int result = 0;
	    ConnectionItem connectionItem = null; // 지역 변수로 사용
	    try {
	        // 1. Connection 획득
	        connectionItem = connectionPool.getConnection();
	        Connection conn = connectionItem.getConn();

	        // 2. PreparedStatement 준비 및 파라미터 설정
	        pstmt = conn.prepareStatement("insert into user_table values(?,?,?)");
	        pstmt.setString(1, userDto.getUsername());
	        pstmt.setString(2, userDto.getPassword());
	        pstmt.setString(3, "ROLE_USER");

	        // 3. 쿼리 실행 (executeUpdate 실행 후 결과 저장)
	        result = pstmt.executeUpdate();

	    } catch(SQLException e) {
	        e.printStackTrace();
	        throw new SQLException("USERDAO's INSERT SQL EXCEPTION!!");
	    } finally {
	        try { 
	            if (pstmt != null) {
	                pstmt.close();
	            }
	        } catch(Exception e2) {
	            e2.printStackTrace();
	        }
	        // 4. Connection 반납 (쿼리 실행 후에 반환)
	        if(connectionItem != null) {
	            connectionPool.releaseConnection(connectionItem);
	        }
	    }
	    return result;
	}
	
 
	@Override
	public int update(UserDto userDto) throws SQLException {
//		try {
//			pstmt = conn.prepareStatement("");
//			
//			return pstmt.executeUpdate();
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//			throw new SQLException("USERDAO's UPDATE SQL EXCEPTION!!");
//		}finally {
//			try {pstmt.close();}catch(Exception e2) {}
//		}
		return 0;
	}
 
	@Override
	public int delete(UserDto userDto) throws SQLException {
//		try {
//			pstmt = conn.prepareStatement("");
//			
//			return pstmt.executeUpdate();
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//			throw new SQLException("USERDAO's DELETE SQL EXCEPTION!!");
//		}finally {
//			try {pstmt.close();}catch(Exception e2) {}
//		}
		return 0;
	}
	//단건조회
 
	@Override
	public UserDto select(String username) throws Exception {
		connectionItem = connectionPool.getConnection();
		Connection conn = connectionItem.getConn();
		pstmt = conn.prepareStatement("select * from user_table where username=?");
		pstmt.setString(1, username);
		rs = pstmt.executeQuery();
		UserDto dto = null;
		if(rs!=null) {
			while(rs.next()) {
				dto = new UserDto(rs.getString(1),rs.getString(2),rs.getString(3));
				
			}
		}
		
		connectionPool.releaseConnection(connectionItem);
		return dto;
	}
	//다건조회
 
	@Override
	public List<UserDto> selectAll() {	
		return null;
	}	
	
}



