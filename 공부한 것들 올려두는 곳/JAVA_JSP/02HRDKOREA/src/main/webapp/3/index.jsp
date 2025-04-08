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
	.wrapper>main{ height :calc(100vh - 80px - 50px - 80px); overflow:auto;}
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
		
		<%@ page import="Utils.*,java.util.*,java.time.LocalDate,java.time.format.DateTimeFormatter,java.time.Period" %>
		<%
			List<VoteDto> list = DBUtils.getInstance().selectAllVote();
		 
		%>
		<main>
			<h2>투표검수조회</h2>
			<table>
				<tr>
					<th>성명</th>
					<th>생년월일</th>
					<th>나이</th>
					<th>성별</th>
					<th>후보번호</th>
					<th>투표시간</th>
					<th>유권자확인</th>
				</tr>
				
				<%
					for(VoteDto vd : list){
				%>
						
					<tr>
						<td><%= vd.getV_name() %></td>
						<%
							String birth = vd.getV_jumin().substring(0,6);
							System.out.println(birth);
							
							int yy = Integer.parseInt(birth.substring(0,2));
							int now = LocalDate.now().getYear()%100;
							if(yy>0 && yy<=now){ //01 ~ 24년생
								birth = "20"+birth;
							}else{
								birth = "19"+birth;
							}
							
							
							//입력포맷(yyyyMMdd)
							DateTimeFormatter in = DateTimeFormatter.ofPattern("yyyyMMdd");
							LocalDate mybirth = LocalDate.parse(birth,in);
							
							//출력포맷(yyyy년MM월dd일)
							DateTimeFormatter outfmt = DateTimeFormatter.ofPattern("yyyy년생MM월dd일");
							out.println("<td>" + mybirth.format(outfmt)+"</td>");
						%>
						<td><%= vd.getV_jumin() %></td>
						<td><%= vd.getV_jumin() %></td>
						<td><%= vd.getM_no() %></td>
						<td><%= vd.getV_time() %></td>						
						<td><%= vd.getV_confirm() %></td>
				
					</tr>
				<%
					}
				%>
				
			
			</table>
			
		</main>	
	
		<%@ include file="/layouts/Footer.jsp"  %>
	
	</div>
</body>
</html>