package Controller.user;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.startup.SetAllPropertiesRule;

import com.mysql.cj.Session;

import Controller.SubController;
import Domain.Dto.UserDto;
import Domain.Service.UserServiceImpl;

public class UserLogoutController implements SubController{
	// FrontController -> UserLogoutController 등록 (URI : /user/logout)
	// UserLogoutController
	//  - 1 파라미터받기 생략 
	//	- 2 session 안 속성 정보(isAuth , role , username) 꺼내오고 유효성 체크
	//  - isAuth == false 라면 포워딩 /WEB-INF/login.jsp   session에 message 속성 추가 "로그인상태가 아닙니다"
	// UserService
	//  - logout함수 내 처리
	//		- session invalid 처리 하기
	//		- Map<String,Object> 로 return "isLogout",true , "message","로그아웃성공"

	// UserLogoutController
	//	- isLogout 정보를 확인하여 로그아웃 성공/실패 둘다  /login.do
	//  - message는 session 에 저장
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	private UserServiceImpl userService;
	
	public UserLogoutController() throws Exception{
		userService = UserServiceImpl.getInstance();	
//		throw new Exception("TESTTSTST");
	}


	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] UserLogoutController execute..");
		
		UserServiceImpl userimpl;
		HttpSession session = req.getSession();
		Boolean isAuth = session.getAttribute("isAuth")!=null? (boolean)session.getAttribute("isAuth"):null;
		String username = (String) session.getAttribute("username");
		String role = (String) session.getAttribute("role");
		
		try {
			if(isAuth == null || isAuth ==false) { //로그인된 상태가 아니라면
				req.setAttribute("message", "로그인된 상태가 아닙니다.");
				try {
					req.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(req, resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			
			boolean isokay = isValid(isAuth,username,role);
			
			// 서비스
			
			Map<String, Object> serviceResponse =userService.logout(req.getSession());
			Boolean isLogout = (Boolean) serviceResponse.get("isLogout");
			
			HttpSession reSession = req.getSession(true); //logout에서 세션을 지워서 새로 만들었다.
			if(isLogout !=null && isLogout == true) {
				reSession.setAttribute("message", "로그아웃 성공");
			}else {
				reSession.setAttribute("message", "로그아웃 실패!");
			}
			resp.sendRedirect(req.getContextPath()+"/user/login");
		} catch (Exception e) {
			try {
				req.getRequestDispatcher("/WEB-INF/view/user/error.jsp").forward(req, resp);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	
	
	private boolean isValid(Boolean isAuth, String username, String role) {
		if(isAuth == null || isAuth == false) {
			req.setAttribute("message", "로그인된 상태가 아닙니다.");
			return false;
		}

		return true;
	}
	// 예외처리함수
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
}
