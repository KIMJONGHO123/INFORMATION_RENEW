package Ch38Domain.Service;

import java.sql.SQLException;

import Ch38Domain.Dao.UserDaoImpl;
import Ch38Domain.Dto.UserDto;

public class UserServiceImpl {
	
	//
	private UserDaoImpl userDao;
	
	// 싱글톤 패턴
	private static UserServiceImpl instance;
	private UserServiceImpl () throws ClassNotFoundException,SQLException{
		userDao = UserDaoImpl.getInstance();
		System.out.println("[SERVICE] UserServiceImpl init...");
	}
	public static UserServiceImpl getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new UserServiceImpl();	
		}
		return instance;
	}
	
	// 회원가입 (+TX처리필요)
	public boolean userJoin(UserDto userdto) throws SQLException{
		return userDao.insert(userdto)>0;
	};
	
	// 회원정보수정
	
	// 회원탈퇴
	
	// 로그인
	
	// 로그아웃
}
