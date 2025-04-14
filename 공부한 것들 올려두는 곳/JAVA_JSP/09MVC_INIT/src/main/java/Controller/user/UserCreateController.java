package Controller.user;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.DTO.UserDto;
import Domain.Service.UserServiceImpl;

// 얘는 서블릿이 아니다.
public class UserCreateController implements SubController {

	private HttpServletRequest req;
	private HttpServletResponse resp;
	private UserServiceImpl userServie;
	
	public UserCreateController() throws Exception{
		
		userServie = UserServiceImpl.getInstance();
//		throw new Exception("TESTTSTT");
		
	}
	@Override
	public void execute(HttpServletRequest req,HttpServletResponse resp) {
		// void인 이유 : req,resp로 다 작업을 하기 때문에
		this.req = req;
		this.resp = resp;
		System.out.println("[sc] UserCreateController execute..");
		// 파라미터
		
		try {
			
			String uri = req.getMethod();
			if(uri.equals("GET")) { //URL로 직접 전달하면 GET방식
				req.getRequestDispatcher("/WEB-INF/view/user/create.jsp").forward(req, resp);
				return; // 화면 이동하고 끝난다.
			}
			// 회원가입 버튼 누르면 POST 방식이기 때문에 밑에꺼 실행된다.
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String role = "ROLE_USER";
			// 입력값 검증
			UserDto dto = new UserDto(username,password,role);
			boolean isokay = isValid(dto);
			if(!isokay)	{
				// 로그인 유효성 검사에 막히면 다시 회원가입창  띄우는 로직
				req.getRequestDispatcher("/WEB-INF/view/user/create.jsp").forward(req, resp);
				return;
			}
			// 서비스
			boolean isJoin = userServie.userJoin(dto);
			
			// 뷰
			if(isJoin) {
				resp.sendRedirect(req.getContextPath()+"/index.do");
			}else {
				req.getRequestDispatcher("WEB-INF/view/user/join.jsp").forward(req, resp);
			}
			
		} catch (Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/user/error.jsp").forward(req, resp);
			}catch(Exception e2){
				
			}
		}
		
		
	}

	private boolean isValid(UserDto userdto) {
		if (userdto.getUsername() == null || userdto.getUsername().length() <= 4) {
			req.setAttribute("username_err", "userid의 길이는 최소 5자이상이어야합니다");
			System.out.println("[INVALID] userid의 길이는 최소 5자이상이어야합니다");
			return false;
		}
		if (userdto.getUsername().matches("^[0-9].*")) {
			System.out.println("[INVALID] userid의 첫문자로 숫자가 들어올수 없습니다");
			req.setAttribute("username_err", "userid의 userid의 첫문자로 숫자가 들어올수 없습니다");
			return false;
		}
		// NULL 체크 / 데이터(자료)수준에서의 의미있는데이터가 포함되어져있는지 여부
		// userid 은 첫문자가 숫자인지 여부 - /or 길이가 1글자인지 등등..
		// username 은 첫문자가 숫자인지 여부 -
		// password 복잡도체크는 Business Layer 체크(Policy 에 의한 처리)

		return true;
	}
	
	public void exceptionHandler(Exception e) {

		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}

}
