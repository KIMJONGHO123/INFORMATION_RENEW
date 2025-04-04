<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="C04.* "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		EL(Expression Language) : 내장객체의 Scope 참조
		pageScope : 현재 JSP 페이지 내에서만 사용가능한 속성/기능 (관련 내장객체 : pageContext)
		requestScope : 하나의 요청 처리동안 (관련 내장객체 : rquest)
		sessionScope : 일정기간 동안(지정된 혹은 기본값) (관련 내장객체 : session)
		applicationScope : 서버 종료시 동안 (관련 내장 객체 application)
	
	
	 -->
	<!-- EL : PARAM -->
	
<%
	pageContext.setAttribute("P_ATTR", "P_ATTR_VALUE");
	pageContext.setAttribute("R_ATTR", "R_ATTR_VALUE");
	session.setAttribute("S_ATTR", "S_ATTR_VALUE");
	application.setAttribute("A_ATTR", "A_ATTR_VALUE");
	
	//pageContext.setAttribute("DUP","PAGECOUNTEXT VALUE"); 
	//request.setAttribute("DUP","REQUEST VALUE");  // key가 중복이 되면 더 좁은 범위를 먼저 출력한다.
	//session.setAttribute("DUP","session VALUE");  
	application.setAttribute("DUP","APPLICATION VALUE");
	
	
	

%>
username : ${param.username} <br />
password : ${param.password} <br />
<hr />
<!-- EL : ATTRIBUTE -->
PAGECONTEXT's ATTR : ${P_ATTR} <br />
PAGECONTEXT's ATTR : ${pageScope.P_ATTR } <br />
<hr />
REQUEST's ATTR : ${R_ATTR} <br />
REQUEST's ATTR : ${pageScope.R_ATTR} <br />
<hr />
SESSION's ATTR : ${S_ATTR } <br />
SESSION's ATTR : ${sessionScope.S_ATTR} <br />
<hr />
SESSION's ATTR : ${A_ATTR } <br />
SESSION's ATTR : ${applicationScope.A_ATTR} <br />

<hr />
<hr />

<!-- EL : ATTRIBUTE(중복값) -->
DUPLICATED VALUE : ${DUP}<br />
<hr />


<!-- EL : OBJECT -->

<%
	UserDto userdto = new UserDto("user1","1234","ROLE_USER");
	request.setAttribute("userdto", userdto);

%>
표현식 : <%= userdto.getUserid() %> <br />
EL : ${userdto.userid } <br />
<hr />
<!-- EL : 연산자 -->
연산 : <%= 1+1 %> <br />
EL : ${1+1} <br />
<hr />

<!-- NULL CHECK -->
NULL : ${null} <br />
empty NULL : ${empty null} <br />

empty null : ${empty TEST } <br />
empty not null : ${!empty TEST } <br />


</body>
</html>