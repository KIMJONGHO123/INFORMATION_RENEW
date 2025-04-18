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
				<h1>Book create</h1>
				<form action="${pageContext.request.contextPath }/book/create" method="post">
					<div>
						<label for="">BookCode : </label><span>${ bookcode}</span><br>
						<input type="text" name="bookcode" placeHolder="bookCode">
					
					</div>
					<div>
						<label for="">BookName : </label><span>${ bookname}</span><br>
						<input type="text" name="bookname" placeHolder="bookName">
					
					</div>
					<div>
						<label for="">Publisher : </label><span>${ publisher}</span><br>
						<input type="text" name="publisher" placeHolder="publisher">
					
					</div>
					<div>
						<label for="">Isbn : </label><span>${ isbn}</span><br>
						<input type="text" name="isbn" placeHolder="isbn">
					
					</div>
					<div>
						<button>도서등록</button>
					</div>
					
				
				</form>
		</main>
		
		
		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp" %>
	</div>

	
</body>
</html>