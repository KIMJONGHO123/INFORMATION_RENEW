package Ch38Test.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import Ch38Domain.Dto.UserDto;
import Ch38Domain.Service.UserServiceImpl;

class ServiceTests {
	
	
	@Test
	void test() throws ClassNotFoundException, SQLException {
		UserServiceImpl userService = UserServiceImpl.getInstance();
		userService.userJoin(new UserDto("bbb","남길동","1234","ROLE_USER"));
	}

}
