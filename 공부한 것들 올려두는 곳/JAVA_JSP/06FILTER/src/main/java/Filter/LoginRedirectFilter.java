package Filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Type.Role;
import Utils.OracleDBUtils;

public class LoginRedirectFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		chain.doFilter(req, resp); // 서블릿의 doPost가 실행된다. 끝나고 나면 아래의 코드를 실행한다.
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		String method = request.getMethod(); //전달방식 method="POST"
		
		HttpSession session = request.getSession();
		String role = (String)session.getAttribute("role");
		if(method.contains("POST") && role!=null) {
			System.out.println("로그인된 상태 확인! role : "+role);
			switch (role) {
			case "ROLE_USER":  //1
				response.sendRedirect(request.getContextPath()+"/user_main");
				return;
			case "ROLE_MANAGER": //2
				response.sendRedirect(request.getContextPath()+"/manager_main");
				return;
			
			case "ROLE_ADMIN": //3
				response.sendRedirect(request.getContextPath()+"/admin_main");
				return;
			default :  //0
				response.sendRedirect(request.getContextPath()+"main.do");
				return;
			}
		}
		
		
	
	// Filter URL : login.do
	// 로그인 성공시 redirect 경로를 role별로 해준다
	// ROLE_ADMIN -> /admin_main 으로 리다이렉트
	// ROLE_MANAGER -> /manager_main 으로 리다이렉트
	// ROLE_USER -> /user_main 으로 리다이렉트
	
	
	
	
	}
	
}
