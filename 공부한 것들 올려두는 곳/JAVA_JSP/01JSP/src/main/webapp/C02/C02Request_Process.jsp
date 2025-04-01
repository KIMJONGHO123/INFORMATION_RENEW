<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--  <%
 	/* request 내장객체 - 요청정보값 저장(HTTP Request Protocol의 구조형태) - 나중에 따로 정리*/
 	
 	/* 문자셋 설정 */
 	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
	
 	String username = request.getParameter("username");
 	String password = request.getParameter("password");
 	String bgcolor = request.getParameter("bgcolor");
 	System.out.printf("%s , %s, %s \n", username,password,bgcolor);
 	
 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<!-- 표현식으로 처리 -->
<body style="background-color:<%=bgcolor.equals("")?"gray":bgcolor %>">
username : <%= username%>
<hr/>
passworld : <%=password %>
<hr/>
bgcolor : <%= bgcolor %>
<hr/>
</body>

</html> --%>


<!-- EL 표현식(내장형이라서 강의장에서도 사용가능) -->
<%

	/* 문자셋 설정 */
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<!-- 표현식으로 처리 -->
<body style="background-color:${param.bgcolor}">
	EL_USERNAME : ${param.username} <br/>
	EL_PASSWORD : ${param.password} <br/>
<hr/>
</body>

</html>
