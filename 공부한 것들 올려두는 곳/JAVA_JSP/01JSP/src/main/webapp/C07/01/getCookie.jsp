<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <h1>쿠키 확인(스크립틀릿 + 표현식)</h1>
	 <%
	 
	 	Cookie cookies[] = request.getCookies();
	 	if(cookies !=null){
	 		for(Cookie cookie : cookies){
	 			System.out.println("cookie : " +cookie.getName()+" : " + cookie.getValue());
	 			%>
	 				<div>
	 					<a href="./deleteCookie.jsp?cookieName=<%=cookie.getName()%>">
	 						<%= cookie.getName() %> : <%=cookie.getValue() %> <br />
	 					</a>
	 					
	 				</div>
	 			
	 			<% 
	 		}
	 	}
	 
	 %>
	 <hr />
<%-- 	 <h1>쿠키확인(값만 확인 : EL)</h1>
	 Cookie's value1 : ${cookie.myCookie1.value } <br />
	 Cookie's value2 : ${cookie.myCookie1.value } <br /> --%>
</body>
</html>