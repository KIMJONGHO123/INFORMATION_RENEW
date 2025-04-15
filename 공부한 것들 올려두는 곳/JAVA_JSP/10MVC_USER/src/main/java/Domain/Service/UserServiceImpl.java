package Domain.Service;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import Domain.Dao.UserDao;
import Domain.Dao.UserDaoImpl;
import Domain.Dao.ConnectionPool.ConnectionPool;
import Domain.Dto.UserDto;


public class UserServiceImpl {
	
	//
	private UserDao userDao ;
	private ConnectionPool connectionPool ;	//TX
	
	//싱글톤 패턴
	private static UserServiceImpl instance;
	private UserServiceImpl() throws Exception {
		userDao = UserDaoImpl.getInstance();
		connectionPool = ConnectionPool.getInstance();
		System.out.println("[SERVICE] UserServiceImpl init...");
	};
	public static UserServiceImpl getInstance() throws Exception {
		if(instance==null)
			instance = new UserServiceImpl();
		return instance ;
	}
	
	//회원가입(+TX처리필요)
	public boolean userJoin(UserDto userDto) throws Exception{
		boolean isJoin = false;
		try {
		
			connectionPool.beginTransaction();
			
			isJoin  = userDao.insert(userDto)>0; //sql 질의 다수
//			userDao.insert(new UserDto("aaaaa","","",""));
//			userDao.insert(new UserDto("aaaab","","",""));
//			userDao.insert(new UserDto("aaaaa","","",""));	//PK 중복 오류!
			
			connectionPool.commitTransaction();
			
		}catch(SQLException e) {
			connectionPool.rollbackTransaction();
		}
	
		return  isJoin;
		
	};
	
	public Map<String,Object> login(UserDto userdto, HttpSession session) throws Exception{
		Map<String,Object> response = new LinkedHashMap<>();
		boolean isLogin = false;
		try {
			
			connectionPool.beginTransaction();
			
			UserDto userdb  = userDao.select(userdto.getUsername()); // username으로 찾았다.
			if(userdb ==null) {
				response.put("isLogin", false);
				response.put("message", "동일한 계정이 존재하지 않습니다.");
				
			}else {
				// 패스워드 일치여부 확인
				if(!userdto.getPassword().equals(userdb.getPassword())){
					response.put("isLogin", false);
					response.put("message", "패스워드가 일치하지 않습니다.");
				}else {
					// ID/패스워드 일치 -> 로그인 처리
					session.setAttribute("isAuth", true);					
					session.setAttribute("username", userdb.getUsername());
					session.setAttribute("role", userdb.getRole());
					session.setMaxInactiveInterval(60*10);
					
					response.put("isLogin", true);
					response.put("message", "로그인 성공");
					
				}
			}
			connectionPool.commitTransaction();
			
		}catch(SQLException e) {
			connectionPool.rollbackTransaction();
		}
		return response;
	}
	
	//회원조회
	
	//회원정보수정
	
	//회원탈퇴
	
	//로그인
	
	//로그아웃
	public Map<String,Object> logout(HttpSession session) throws Exception{
		session.invalidate();
		Map<String,Object> response = new LinkedHashMap<>();
		response.put("isLogout", true);
		return response;
	}

}
