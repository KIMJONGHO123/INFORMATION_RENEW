<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String idSave= request.getParameter("idSave");
	String pwSave= request.getParameter("pwSave");
	
	System.out.println("idSave : " + idSave);
	System.out.println("pwSave : " +  pwSave);
	
	// 파라미터 유효성 체크(반드시 지켜햐 하는 것만)
	
	if(username.isEmpty()){
		//out.println("<script>alert('username을 입력하세요');location.href='./login_form.jsp'</script>");
		request.setAttribute("username_msg", "username을 입력하세요");
		
	}
	if(password.isEmpty()){
		
		request.setAttribute("password_msg", "password을 입력하세요");
	}
	if(username.isEmpty() || password.isEmpty()){
		request.getRequestDispatcher("./login_form.jsp").forward(request, response);
		return ;
	}
	//01 ID 확인(DB 조회 - 생략)
	
	if(!username.equals("admin")){
		request.setAttribute("username_msg", "해당ID는 존재하지 않습니다.");
		//request.setAttribute("password_msg", "");
		request.getRequestDispatcher("./login_form.jsp").forward(request, response);
	}
	// 02 PW 확인(일치여부 확인)
	
	if(!password.equals("1234")){
		request.setAttribute("password_msg", "패스워드가 일치하지 않습니다.");
		request.getRequestDispatcher("./login_form.jsp").forward(request, response);
	}
	// 03 사용자 상태정보(인증됨)를 Session 저장
	
	session.setAttribute("isAuth", true);
	session.setAttribute("role","ROLE_ADMIN");
	session.setMaxInactiveInterval(30); // 30초 (기본 1800초 : 30분)
	
	if(idSave!=null && pwSave!=null){
		Cookie cookie = new Cookie("ididid",username); // cookie의 이름 "ididid"
		cookie.setMaxAge(60*5);
		cookie.setPath("/01JSP/C07/03/login_form.jsp"); /* 저 경로로 갔을때 쿠키가 보인다. */
		response.addCookie(cookie);
		
		Cookie cookie_password = new Cookie("password", password);
		cookie_password.setMaxAge(60*5);
		cookie.setPath("/01JSP/C07/03/login_form.jsp");
		response.addCookie(cookie_password);
		
		
		Cookie idchk = new Cookie("idchk","checked");
		idchk.setMaxAge(60*5);
		idchk.setPath("/01JSP/C07/03/login_form.jsp");
		response.addCookie(idchk);
		
		Cookie ckiPassword = new Cookie("pwchk","checked");
		ckiPassword.setMaxAge(60*5);
		ckiPassword.setPath("/01JSP/C07/03/login_form.jsp");
		response.addCookie(ckiPassword);
		
	}else if(idSave != null ){
		// ID저장하기 체크 안했을때 쿠키 지우기
		Cookie cookie = new Cookie("username",username);
		cookie.setMaxAge(60*5);
		cookie.setPath("/01JSP/C07/03/login_form.jsp");
		response.addCookie(cookie);
		
		Cookie idchk = new Cookie("idchk","checked");
		idchk.setMaxAge(60*5);
		idchk.setPath("/01JSP/C07/03/login_form.jsp");
		response.addCookie(idchk);
		
		
	}else if(pwSave !=null){
		Cookie cookie_password = new Cookie("password",password);
		cookie_password.setMaxAge(60*5);
		cookie_password.setPath("/01JSP/C07/03/login_form.jsp");
		response.addCookie(cookie_password);
		
		Cookie ckiPassword = new Cookie("pwchk","checked");
		ckiPassword.setMaxAge(60*5);
		ckiPassword.setPath("/01JSP/C07/03/login_form.jsp");
		response.addCookie(ckiPassword);
	}
	
	
	// 04로그인 처리후 MAIN PAGE REDIRECT
	out.println("<script>alert('로그인 성공! MAIN page로 이동합니다.');location.href='main.jsp'</script>");


%>