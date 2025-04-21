package Tests;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Domain.Dao.BookDao;
import Domain.Dao.BookDaoImpl;
import Domain.Dao.BookReplyDaoImpl;
import Domain.Dao.UserDao;
import Domain.Dao.UserDaoImpl;
import Domain.Dto.BookDto;
import Domain.Dto.BookReplyDto;
import Domain.Dto.UserDto;

class DaoTests {
	
	@Disabled
	@Test
	void test() throws Exception {
		UserDao userDao = UserDaoImpl.getInstance();
		
		userDao.insert(new UserDto("user123511","1234","ROLE_USER"));
	}

	@Disabled
	@Test
	void test2() throws Exception{
		UserDao userDao = UserDaoImpl.getInstance();
		
		System.out.println(userDao.select(null));
	}
	
	@Disabled
	@Test
	void test3() throws Exception{
		BookDao dao = BookDaoImpl.getInstance();
		
		dao.insert(new BookDto("1111","C++","한빛미디어","111-111"));
	}
	@Disabled
	@Test
	void test4() throws Exception{
		BookDao dao = BookDaoImpl.getInstance();
		
		dao.selectAll().forEach(System.out::println);
	}
	@Disabled
	@Test
	void test5() throws Exception{
		BookDao dao = BookDaoImpl.getInstance();
		
		System.out.println(dao.count());
	}
	
	@Test
	void test6() throws Exception{
		BookReplyDaoImpl.getInstance().insert(new BookReplyDto(-1,"CDG000000020", "bbbbb", "테스트용", LocalDateTime.now()));
	}
	@Disabled
	@Test
	void test7() throws Exception{
		BookReplyDaoImpl.getInstance().selectAll("CDJ000025511").forEach(System.out::println);
	}
}
