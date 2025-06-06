package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/session/remove","/session/attr/add","/session/attr/replace","/session/attr/remove"})
public class C03ListenerTest extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[SERVLET] C03ListenerTest service");
		String uri = req.getRequestURI();
		HttpSession session = req.getSession(); // false 안넣으면 session의 기한이 지났을때 자동으로 session을 다시 만든다.
		if(uri.contains("/session/remove")) {
			// 세션제거
			session.invalidate();
		}else if(uri.contains("/session/attr/add")) {
			session.setAttribute("S_KEY", "S_VAL");
		}else if(uri.contains("/session/attr/replace")){
			session.setAttribute("S_KEY", "S_VAL_2");
		}else if(uri.contains("/session/attr/remove")){
			session.removeAttribute("S_KEY");
		}
	}
}
