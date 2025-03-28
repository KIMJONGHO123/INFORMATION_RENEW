package Ch38TestDao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Ch38Domain.Dao.BookDao;
import Ch38Domain.Dao.BookDaoImpl;
import Ch38Domain.Dao.UserDaoImpl;
import Ch38Domain.Dao.userDao;
import Ch38Domain.Dto.BookDto;
import Ch38Domain.Dto.UserDto;

class DaoTest {
	// 이 파일은 오른쪽 마우스 눌러서 other에 Junit 으로 만든다.
	// test1()누른다음에 runas에 Junit Test클릭하면 DB랑 연결된다.
	@Test
	@Disabled
	void test1() throws Exception {
		userDao userDaoImpl = UserDaoImpl.getInstance();
	
	}
	
	@Test
	void test2() throws Exception {
		userDao userDaoImpl = UserDaoImpl.getInstance();
		userDaoImpl.insert(new UserDto("abbbccok","홍길동","1234",""));
	}
	
	@Test
	@Disabled
	void test3() {
		
	}
	
	@Test
	void test4() throws Exception {
		BookDao bookdatoimpl = BookDaoImpl.getInstance();
		bookdatoimpl.insert(new BookDto("bbb","감감감","9999",""));
	}

}
