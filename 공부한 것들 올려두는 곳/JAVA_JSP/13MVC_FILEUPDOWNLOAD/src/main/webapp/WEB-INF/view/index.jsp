<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- link -->
	<%@include file="/resources/layouts/link.jsp" %>
	
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="wrapper">
		<header>
			<!-- topHeader -->
			<%@include file="/resources/layouts/topHeader.jsp" %>
			<!-- nav -->
			<%@include file="/resources/layouts/nav.jsp" %>
		</header>
		<main  class="layout">
				<h1>HOME</h1>
				
				${message }
				<%
					session.removeAttribute("message"); // 화면에 한번 표시하고 나면 session에서 제거하는 방식이다.
				%>
		</main>

		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp" %>
	</div>

</body>
</html>