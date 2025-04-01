<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jsp에서 js로 보내는 방법 -->    

<!-- BackEnd 처리 코드 -->
<%
	String msg1 = "HELLO 1";
	String msg2 = "HELLO 2";
	String msg3 = "HELLO 3";
	String msg4 = "HELLO 4";
	request.setAttribute("message", "TEST!!");
	request.setAttribute("message2", "TEST!!_2");	
	/* setAttribute 쓰면 param안써도 된다. */

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script>
<%-- 	const message1 = '<%= msg1%>';  /* 문자열임을 표시하는 ''무조건 붙여야한다. 안붙이면 Syntax Error가 생긴다. */
		const message2 = '<%= msg2%>';
		const message3 = '<%= msg3%>';
		const message4 = '<%= msg4%>'; --%>
		
		const message1 = '${message}';  /* 문자열임을 표시하는 ''무조건 붙여야한다. 안붙이면 Syntax Error가 생긴다. */
		const message2 = '${message2}'; //jsp에 껄 쓰는거다. // EL 표현식 
		const message3 = `${message}`;  // js에 껄 쓰는거다. // 보간법(JSP의 message값을 리터럴 형태로 변환)

		
		console.log(message1);  
		console.log(message2);  
		console.log(message3);
/* 		console.log(message3);
		console.log(message4); */
	</script>
</body>
</html>