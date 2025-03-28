package Ch38Domain.Dao;

import java.sql.SQLException;

import Ch38Domain.Dto.BookDto;

public interface BookDao {

	//CRUD
	int insert(BookDto bookdto) throws Exception;

	int update(BookDto bookdto) throws SQLException;

	int delete(BookDto bookdto) throws SQLException;

}