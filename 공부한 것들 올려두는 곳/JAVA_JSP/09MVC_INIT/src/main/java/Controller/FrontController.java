package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.user.UserCreateController;

// 서블릿
@WebServlet("/") // 모든 경로
public class FrontController extends HttpServlet{
	
	//서브컨트롤러 저장 자료구조("/endPoint":서브컨트롤러객체)
	private Map<String,SubController> map = new HashMap();
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 인증(/uesr/*) -회원CRUD, 로그인, 로그아웃
		
		try {
			// 기본
			map.put("/", new homeController());
			map.put("/index.do", new homeController());
			
			//인증
			map.put("/user/create", new UserCreateController());
			System.out.println("INIT SIZE : "+ map.size());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException("서브컨트롤러 등록오류");
		}
		
		
		// 도서(/book/*) - 도서CRUD
		
	}
	
	
	@Override // service는 모든걸 다 받는다. 요청할때마다 실행된다. execute함수 대체 부분
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		try {
			System.out.println("[FC] service...");
			String endpoint = req.getServletPath();
			System.out.println("[FC] endpoint "+endpoint);
			SubController controller =  map.get(endpoint);	//userCreateController이 controller객체에 담김
			controller.execute(req,resp);	// 해당 컨트롤러 실행 // SubController에 execute 하면 인터페이스이기때문에 UserCreateController의 execute가 실행됨
		} catch (Exception e) {
			e.printStackTrace();
			exceptionHandler(e,req);
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
		}
		
		
	}

	public void exceptionHandler(Exception e, HttpServletRequest req) {

		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}
	
	
}
