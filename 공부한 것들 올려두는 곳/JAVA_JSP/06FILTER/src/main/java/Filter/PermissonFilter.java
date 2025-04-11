package Filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Type.Role;
import Utils.OracleDBUtils;

public class PermissonFilter implements Filter{
	
	// URL : Permisson Value
	private Map<String,Role> pageGradeMap = new HashMap<>();
	// URI와 필요한 권한값을 값으로 입력
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String projectPath = filterConfig.getServletContext().getContextPath();
		// admin_main 필요한 권한값(3) - ROLE_ADMIN
		// manager_main 필요한 권한값(2) - ROLE_MANAGER
		// /user_main 필요한 권한값(1) - ROLE_USER
		
		pageGradeMap.put(projectPath+"/admin_main",Role.ROLE_ADMIN);
		pageGradeMap.put(projectPath+"/manager_main",Role.ROLE_MANAGER);
		pageGradeMap.put(projectPath+"/user_main",Role.ROLE_USER);
		
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		// 프레임워크 가면 안씀 자동으로 해준다.
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		HttpSession session = request.getSession();
		String myRole = (String)session.getAttribute("role");
		
		//로그인 안했을때 여기로 이동
		if(myRole == null) {
			response.sendRedirect(request.getContextPath()+"/login.do?msg=not authenticated...");
			return;
		}
		
		
		// 문자열 권한을 Role enum으로 변환
		Role my =null;
		switch (myRole) {
		case "ROLE_USER":  //1
			my = Role.ROLE_USER;
			break;
		case "ROLE_MANAGER": //2
			my = Role.ROLE_MANAGER;
			break;
		
		case "ROLE_ADMIN": //3
			my = Role.ROLE_ADMIN;
			break;
		
		default :  //0
			my = Role.Role_ANONYMOUS;
			break;
		}
		
		String requestUri = request.getRequestURI(); // Project/admin_main //클라이언트가 요청한 실제 URI를 가져온다.
		Role pageRole = pageGradeMap.get(requestUri); //해당 URI의 필요한권한을 확인한다.
		
		if(my.ordinal()<pageRole.ordinal()) {
			throw new ServletException("해당 권한으로는 접근이 불가능한 페이지입니다.");
			
			
		}
		System.out.printf("URL : %s,myRole : %d, PageRole : %d\n",requestUri,my.ordinal(),pageRole.ordinal());
		System.out.println("[Filter] perm Filter start...");
		chain.doFilter(req, resp);
		System.out.println("[Filter] perm Filter end...");
	}

	

}
