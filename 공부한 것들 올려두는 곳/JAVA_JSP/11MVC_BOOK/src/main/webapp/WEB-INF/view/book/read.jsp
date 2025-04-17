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
			<h1>/BOOK/READ</h1>
			<form action="${pageContext.request.contextPath}/book/update" method="post">
				<div>
					<label for="">bookCode : </label><span>${bookcode}</span><br/>
					<input type="text" name="bookCode"  placeHolder="bookCode" value="${bookDto.bookcode}" readonly/> <!-- bookDto.bookcode는 bookDto의 getter메서드임. 프로퍼티 이름이 bookcode -> Bookcode로 바뀐다. -> getBookcode()를 호출한다. -->
				</div>
				<div>
					<label for="">bookName : </label><span>${bookname}</span><br/>
					<input type="text" name="bookName"  placeHolder="bookName"  value="${bookDto.bookname}"/>
				</div>
				<div>
					<label for="">publisher : </label><span>${publisher}</span><br/>
					<input type="text" name="publisher"  placeHolder="publisher" value="${bookDto.publisher}" />
				</div>
				<div>
					<label for="">isbn : </label><span>${isbn}</span><br/>
					<input type="text" name="isbn" placeHolder="isbn"  value="${bookDto.isbn}"/>
				</div>
				<input type="hidden" name="pageno" value="${pageno}">
				<div>
					<button>도서수정</button>
					<a href="${pageContext.request.contextPath}/book/delete?bookCode=${bookDto.bookcode}&pageno=${pageno}">도서삭제</a>
				</div>
			</form>
		</main>
		
		
		
		<!-- footer -->
		<%@include file="/resources/layouts/footer.jsp" %>
	</div>

	
</body>
</html>







