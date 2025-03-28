package Ch38Test.Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Ch38Domain.Dto.BookDto;
import Ch38Domain.Dto.UserDto;
import Ch38Domain.Service.BookServiceImpl;
import Ch38Domain.Service.UserServiceImpl;

class ServiceTests {
	
	
	@Test
	void test() throws Exception {
		UserServiceImpl userService = UserServiceImpl.getInstance();
		userService.userJoin(null);
//		userService.userJoin(new UserDto("bbb","남길동","1234","ROLE_USER"));
	}
	
	@Test
	@Disabled
	void test2() throws Exception {
		BookServiceImpl bookservice = BookServiceImpl.getInstance();
		bookservice.bookRegistration(new BookDto("1010101","C언어 기본","코리아 미디어","1010-1010"));
	}

}
