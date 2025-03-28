package Ch38Domain.Service;

import java.awt.print.Book;
import java.sql.SQLException;

import Ch38Domain.Dao.BookDao;
import Ch38Domain.Dao.BookDaoImpl;
import Ch38Domain.Dto.BookDto;

public class BookServiceImpl {
	private BookDao bookDao;
	// 싱글톤
	private static BookServiceImpl instance;
	private BookServiceImpl() throws ClassNotFoundException, SQLException {
		bookDao = BookDaoImpl.getInstance();
	};
	public static BookServiceImpl getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new BookServiceImpl();
		}
		return instance;
	}
	
	// TX(트랜잭션)처리 + 비즈니스 유효성검사
	public boolean bookRegistration(BookDto bookdto) throws Exception {
		return bookDao.insert(bookdto)>0;
	}
	
}
