<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String col = request.getParameter("col1");
	String col2 = request.getParameter("col2");
	String col3 = request.getParameter("col3");
	String col4 = request.getParameter("col4");
	String style = request.getParameter("style");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul style="list-style:none display: <%= style%>">
		<li><%= col %></li>
		<li><%= col2 %></li>
		<li><%= col3 %></li>
		<li><%= col4 %></li>
	
	</ul>
</body>
</html>