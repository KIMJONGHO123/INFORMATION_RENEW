<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "C04.*" %>
<!--  
		UserDto객체에 전달받은 파라미터(username,password)를 저장
		request에  setAttribute로 userDto 저장("userDto",userDto);
		02ValidationCheck.jsp 로 forwarding
-->
<%

	// userDto 객체 생성
	// request 내장객체 userDto 추가
	// forwarding
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	request.setAttribute("userdto", new UserDto(userid,password,"ROLE_USER"));
	
	
	// 에러 미발생시 dbUtils.jsp 로 해당내용 Forwarding
	request.setAttribute("url", "/join"); // DB 요청 처리 insert
	request.setAttribute("serviceNo", 1); // ServiceNo C: 1, R : 2, U : 3, D:4
	/* FORWARD */
	request.getRequestDispatcher("./validationCheck.jsp").forward(request, response);
%>
