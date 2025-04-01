<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	/* request 내장객체 - 요청정보값 저장(HTTP Request Protocol의 구조형태) - 나중에 따로 정리*/
 	
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
<body style="background-color:<%=bgcolor.equals("")?"gray":bgcolor %>">
username : <%= username%>
<hr/>
passworld : <%=password %>
<hr/>
bgcolor : <%= bgcolor %>
<hr/>
</body>
</html>