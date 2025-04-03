<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cookieName=  request.getParameter("cookieName");
	if(cookieName!=null){
		Cookie cookie = new Cookie(cookieName,"");
		cookie.setMaxAge(0); // 쿠키유지시간0초(만료 설정)
		cookie.setPath("/");  // 쿠키적용 URI 전달(/ : 모든 영역)
		response.addCookie(cookie); // 만료처리 전달
	}

	// 만료쿠키 전달 후 다음이동 위치 전달
	out.println("<script>alert('쿠키삭제완료!');location.href='getCookie.jsp'; </script>");

%>