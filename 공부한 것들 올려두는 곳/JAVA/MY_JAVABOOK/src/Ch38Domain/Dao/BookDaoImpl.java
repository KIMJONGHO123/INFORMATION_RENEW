package Ch38Domain.Dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.IllegalFormatCodePointException;

import Ch38Domain.Dao.ConnectionPool.ConnectionItem;
import Ch38Domain.Dao.ConnectionPool.ConnectionPool;
import Ch38Domain.Dto.BookDto;

public class BookDaoImpl implements BookDao {
	//DB Attr
//	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
//	private String id="root";
//	private String pw="1234";
//	private String url = "jdbc:mysql://localhost:3306/bookdb";
	
	//Connection Pool 연결
	private ConnectionPool connectionpool;
	private ConnectionItem connectionitem;
	
	// 싱클톤 패턴처리
	private static BookDao instance;
	private BookDaoImpl () throws ClassNotFoundException, SQLException	{
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		conn = DriverManager.getConnection(url,id,pw);
		
		connectionpool = ConnectionPool.getInstance();
		System.out.println("BookDaoImpl DB connected");
	}
	public static BookDao getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new BookDaoImpl();
		}
		return instance;
	}
	
	//CRUD
	@Override
	public int insert(BookDto bookdto) throws Exception {
		try {
			// connection get
			connectionitem = connectionpool.getConnection();
			Connection conn = connectionitem.getConn();
			
			pstmt = conn.prepareStatement("insert into tbl_book values(?,?,?,?)");
			pstmt.setString(1, bookdto.getBookCode());
			pstmt.setString(2,bookdto.getBookaNmae());
			pstmt.setString(3,bookdto.getPublisher());
			pstmt.setString(4,"ROLE_USER");
			
			// connection release
			connectionpool.releaseConnection(connectionitem);
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("USERDAO's INSERT SQL EXCEPTION");
		}finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
	}
	
	@Override
	public int update(BookDto bookdto) throws SQLException {
		return 0;
	}
	
	@Override
	public int delete(BookDto bookdto) throws SQLException {
		return 0;
	}
}
