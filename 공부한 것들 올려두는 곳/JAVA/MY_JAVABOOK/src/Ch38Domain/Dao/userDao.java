package Ch38Domain.Dao;

import java.sql.SQLException;
import java.util.List;

import Ch38Domain.Dto.UserDto;

public interface userDao {

	//CRUD
	int insert(UserDto userdto) throws Exception;

	int update(UserDto userdto) throws SQLException;

	int delete(UserDto userdto) throws SQLException;

	UserDto select(UserDto userdto);

	List<UserDto> selectAll();

}