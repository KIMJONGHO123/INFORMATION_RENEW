package Servlet;

import java.io.IOException;
import java.net.ResponseCache;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/join.do")
public class C04Servlet_Test extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Get /join.do...");
		req.getRequestDispatcher("/WEB-INF/join.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터받기
		String username = req.getParameter("username");
		String password = req.getParameter("passsword");
		// 입력값 검증
		// 작업 처리 -> 세션에 담기!
		HttpSession session = req.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		// 뷰로 이동(/login.do redirect)
		
		resp.sendRedirect(req.getContextPath()+"/login.do");
		
		
		
	}
	
	
}
