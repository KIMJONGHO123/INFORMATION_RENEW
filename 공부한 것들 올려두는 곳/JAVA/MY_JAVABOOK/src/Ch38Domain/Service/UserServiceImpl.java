package Ch38Domain.Service;

import java.sql.SQLException;

import Ch38Domain.Dao.UserDaoImpl;
import Ch38Domain.Dao.ConnectionPool.ConnectionPool;
import Ch38Domain.Dto.UserDto;

public class UserServiceImpl {
	
	//
	private Ch38Domain.Dao.userDao userDao;
	private ConnectionPool connectinopool;
	
	// 싱글톤 패턴
	private static UserServiceImpl instance;
	private UserServiceImpl () throws Exception{
		userDao = UserDaoImpl.getInstance();
		connectinopool = ConnectionPool.getInstance();
		System.out.println("[SERVICE] UserServiceImpl init...");
	}
	public static UserServiceImpl getInstance() throws Exception {
		if (instance == null) {
			instance = new UserServiceImpl();	
		}
		return instance;
	}
	
	// 회원가입 (+TX처리필요)
	public boolean userJoin(UserDto userdto) throws Exception{
		boolean isJoin = false;
		try {
			isJoin = userDao.insert(userdto)>0;
			connectinopool.beginTransaction();
//			userDao.insert(userdto); // sql 질의 다수
			userDao.insert(new UserDto("aaaaa","","",""));
			userDao.insert(new UserDto("aaaab","","",""));
			userDao.insert(new UserDto("aaaaa","","","")); // PK 중복 오류
			
			connectinopool.commitTransaction();
			
		} catch (SQLException e) {
			//rollback
			connectinopool.rollbackTransaction();
		}
		
		return isJoin;
		
//		return userDao.insert(userdto)>0; //return pstmt.executeUpdate();는 INSERT가 정상적으로 1개의 데이터를 추가하면 → 1을 반환한다.
	};
	
	// 회원정보수정
	
	// 회원탈퇴
	
	// 로그인
	
	// 로그아웃
}
