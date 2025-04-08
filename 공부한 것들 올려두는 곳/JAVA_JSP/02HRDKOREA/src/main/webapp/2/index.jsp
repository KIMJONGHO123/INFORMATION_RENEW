<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	:root{}
	*{box-sizing: border-box;}
	body{padding:0;margin:0}
	ul{list-style:none; margin:0; padding:0}
	a{text-decoration:none; color:black}
	.wrapper{}
	.wrapper>header{height:80px;}
	.wrapper>nav{height:50px;}
	.wrapper>main{ height :calc(100vh - 80px - 50px - 80px);}
	.wrapper>main h2{
		text-align:center;
		font-size:1.8rem;
		font-weight:400;
		
	}
	.wrapper>main table{
		border:1px solid;
		border-collapse:collapse;
		min-width:500px;
		min-height:350px;
		margin: 0 auto;
	}
	.wrapper>main table th,
	.wrapper>main table td{
		min-width:80px !important;
		min-height:35px !important;
		border:1px solid;
		text-align:center;
	}
	.wrapper>main table th{
		background-color:lightgray;
	}
	.wrapper>footer{height:80px;}
	
</style>
</head>
<body>
	<div class="wrapper">
		<%@ include file="/layouts/header.jsp" %>
		
		<%@ include file="/layouts/Nav.jsp"  %>
		
		<main>
			<h2>투표하기</h2>
			<form action="./create.jsp" name="vote_form" method="post" onsubmit="return false">
			
				<div>
					<label for="">주민번호</label>
					<input type="text" name="v_jumin"/>
				</div>
				
				<div>
					<label for="">성명</label>
					<input type="text" name="v_name"/>
				</div>
				<div>
					<label for="">투표번호</label>
					<input type="text" name="m_no"/>
				</div>
				<div>
					<label for="">투표시간</label>
					<input type="text" name="v_time"/>
				</div>
				<div>
					<label for="">투표장소</label>
					<input type="text" name="v_area"/>
				</div>
				<div>
					<label for="">유권자확인</label>
					<input type="radio" name="v_confirm" value="Y"/>확인
					<input type="radio" name="v_confirm" value="N"/>미확인
				</div>
				<div>
					<button type="submit" onclick="isValid()">투표하기</button>
					<button type="reset">다시하기</button>
				</div>
			
			</form>
		</main>	
	
		<%@ include file="/layouts/Footer.jsp"  %>
	
	</div>
	<script>
		function isValid(){
			// form 찾기
			var form = document.vote_form;
			// 유효성 검사
			if(form.v_jumin.value ===""){
				alert("주민번호가 입력되지 않았습니다.");
				form.v_jumin.focus();
				return;
			}
			// 그냥 쭉하면 된다.
			if(form.v_confirm.value===""){
				alert("유권자 확인이 입력되지 않았습니다.");
				return;
			}
			// submit처리
			form.submit();
		}
	
	</script>
</body>
</html>