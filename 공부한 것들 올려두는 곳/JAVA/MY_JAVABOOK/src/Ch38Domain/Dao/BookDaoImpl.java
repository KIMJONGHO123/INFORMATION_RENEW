package Ch38Domain.Dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.IllegalFormatCodePointException;

import Ch38Domain.Dto.BookDto;

public class BookDaoImpl {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	private String id="root";
	private String pw="1234";
	private String url = "jdbc:mysql://localhost:3306/bookdb";
	
	// 싱클톤 패턴처리
	private static BookDaoImpl instance;
	private BookDaoImpl () throws ClassNotFoundException, SQLException	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("BookDaoImpl DB connected");
	}
	public static BookDaoImpl getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new BookDaoImpl();
		}
		return instance;
	}
	
	//CRUD
	public int insert(BookDto bookdto) throws SQLException {
		try {
			pstmt = conn.prepareStatement("insert into tbl_book values(?,?,?,?)");
			pstmt.setString(1, bookdto.getBookCode());
			pstmt.setString(2,bookdto.getBookaNmae());
			pstmt.setString(3,bookdto.getPublisher());
			pstmt.setString(4,"ROLE_USER");
			
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
	
	public int update(BookDto bookdto) throws SQLException {
		try {
			pstmt = conn.prepareStatement("update into tbl_book values(?,?,?,?)");
			pstmt.setString(1, bookdto.getBookCode());
			pstmt.setString(2,bookdto.getBookaNmae());
			pstmt.setString(3,bookdto.getPublisher());
			pstmt.setString(4,"ROLE_USER");
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("USERDAO's update SQL EXCEPTION");
		}finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
	}
	
	public int delete(BookDto bookdto) throws SQLException {
		try {
			pstmt = conn.prepareStatement("delete into tbl_book values(?,?,?,?)");
			pstmt.setString(1, bookdto.getBookCode());
			pstmt.setString(2,bookdto.getBookaNmae());
			pstmt.setString(3,bookdto.getPublisher());
			pstmt.setString(4,"ROLE_USER");
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("USERDAO's delete SQL EXCEPTION");
		}finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
	}
}
