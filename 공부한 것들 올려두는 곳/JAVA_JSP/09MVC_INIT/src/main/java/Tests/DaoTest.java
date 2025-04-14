package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Domain.DAO.UserDao;
import Domain.DAO.UserDaoImpl;
import Domain.DTO.UserDto;

class DaoTest {

	
	@Test
	@Disabled
	void test() throws Exception {
		UserDao userdao = UserDaoImpl.getInstance();
		
		userdao.insert(new UserDto("user1235","1234","ROLE_USER"));
	}

}
