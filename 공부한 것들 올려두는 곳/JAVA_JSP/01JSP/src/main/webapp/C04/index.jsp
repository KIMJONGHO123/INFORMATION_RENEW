<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	:root{
	}
	*{box-sizing: border-box;padding:10px; border: 1px solid;}
	a{}
	ul{}
	body{
		padding:0;
		margin: 0;
	}
	.wrapper{
	}
	.wrapper>header{min-height: 100px}
	.wrapper>header>.top-header{min-height: 25px}
	.wrapper>header>.nav{min-height: 75px}
	.wrapper>main{min-height: 500px}
	.wrapper>main>section{}
	.wrapper>footer{min-height: 250px}
</style>
</head>
<body>
	<div class="wrapper">
		<header>
			<!-- top-header insert 지시자 이용해서 가져오기 -->
			<!-- nav Insert 지시자 이용해서 가져오기 -->
			<%@ include file="../C03/02Include/layouts/TopHeader.jsp" %>
			<%@ include file="../C03/02Include/layouts/Nav.jsp" %>
		</header>
		<main>
			<section>
				<!--  
						form태그로 
						
						userid
						password
						join.jsp 로 회원가입 요청 처리
					
					-->
				<form action="join.jsp" method="post">
					<input type="text" name="userid" /><br> 
					<input type="text"name="password" /><br> 
					<input type="submit" value="회원가입" />
				</form>
			</section>

		</main>

		<footer>
			<!-- footer insert 지시자 이용해서 가져오기 -->
			<%@ include file = "../C03/02Include/layouts/Footer.jsp" %>
		</footer>
	</div>

</body>
</html>