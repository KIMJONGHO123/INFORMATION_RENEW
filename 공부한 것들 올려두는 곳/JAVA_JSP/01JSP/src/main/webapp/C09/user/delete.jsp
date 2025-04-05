<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="C04.*,C09.*,java.util.*" %>
<%
	String userid = request.getParameter("userid");
	int result = DBUtils.getInstance().deleteUser(userid);

%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>삭제</h1>
	
		<a href="./selectAll.jsp?userid=${userid }">삭제하기</a>

	

</body>
</html>