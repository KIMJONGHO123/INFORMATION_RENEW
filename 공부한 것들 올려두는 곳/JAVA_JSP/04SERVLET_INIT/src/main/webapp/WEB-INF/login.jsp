<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>login PAGE</h1>
	<form action="${pageContext.request.contextPath}/login.do" method="post">
		<input type="text" name="username"/><br />
		<input type="text" name="password"/><br />
		<button>로그인</button>
	</form>
	<div>
		${username_message}	
	
	</div>
	<div>
		${password_message}
	</div>
</body>
</html>