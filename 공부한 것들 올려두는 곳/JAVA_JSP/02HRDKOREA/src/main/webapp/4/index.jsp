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
		<!-- select m.m_no,m.m_name ,count(*) 총투표건수 from tbl_member_202005 m join tbl_vote_202005 v
				on m.m_no = v.m_no
				group by m.m_no,m.m_name
				order by 총투표건수 desc; -->	
		<%@ page import="Utils.*,java.util.*" %>
		<% List<Vote_Rank> list = DBUtils.getInstance().selectRank(); %>	
		<main>
			<h2>후보자 등수</h2>
			
			<table>
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>총투표건수</th>
				</tr>
				<%
				for(Vote_Rank vr : list){
				%>
					<tr>
						<td><%= vr.getM_no() %></td>
						<td><%= vr.getM_name() %></td>
						<td><%= vr.getCount() %></td>
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