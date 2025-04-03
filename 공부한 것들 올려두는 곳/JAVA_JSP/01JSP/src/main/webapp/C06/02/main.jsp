<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	if(session.getAttribute("isAuth")==null){
		//request.getRequestDispatcher("./login_form.jsp");
		response.sendRedirect("./login_form.jsp?message=Session_Expired");
		return;
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="./logout.jsp">로그아웃</a>
<hr />
<h1>MAIN PAGE</h1>
ISAUTH : <%= session.getAttribute("isAuth")%> <br />
ISAUTH(EL) :${isAuth} <br/> 
ROLD : <%= session.getAttribute("role")%> <br />
ROLE(EL) : ${role} <br />
</body>
</html>