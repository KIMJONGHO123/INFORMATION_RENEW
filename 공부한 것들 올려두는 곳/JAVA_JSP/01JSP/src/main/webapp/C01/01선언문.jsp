<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		선언문 (서블릿으로 변환되는 자바파일의 속성/기능을 추가)
	 -->
	 
<!-- 선언식 -->
<%!
 	String name = "HONG GIL DONG";
 	public String testFunc(){
 		System.out.println("선언문 TEST");
 		return "name : "+ name;
 	}
%>


<!-- 표현식(SERVLET 파일(JAVA파일) 안의 값을 FRONTEND로 전달 표현할때 사용) -->

Name: <%= name %> <br/>
testFunc() : <%= testFunc() %></br>

<!-- 
서블릿 파일 생성위치
workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\01JSP\org\apache\jsp\C01
 -->
	 
	 
	 
	 
	 
	 
	 
</body>
</html>