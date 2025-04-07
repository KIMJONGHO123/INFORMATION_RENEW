<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 품목별 총합(총합별 내림차순)

	select category,sum(price*quantity) 총합 from tbl_order 
	group by category
	having sum(price*quantity) >= 50000
	order by 총합 desc;
 -->
<%@ page import="C04.*, C09.*, java.util.*,java.time.*" %>
<%
	List<OrderDto> order_list= DBUtils.getInstance().selectAllOrder();
	
	List<OrderDto2> date_list = DBUtils.getInstance().Date_Selector();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>품목별 총액 (50000만원 이상)</h1>
	
	<table>
	
		<tr>
			<th>품목</th>
			<th>총합</th>
		
		</tr>
		<%
		for(OrderDto orderdto: order_list){
		%>
				<tr>
					<th><%=orderdto.getCategory()%></th>
					<th><%=orderdto.getSum()%></th>
				</tr>
		<%
		}
		%>
		
	</table>
	
	<h1>날짜별 구매 총평균</h1>
	<!-- select order_date, round(avg(price*quantity),2) 총평균 from tbl_order 
group by order_Date; -->
	
	<table>
		<tr>		
			<th>날짜</th>
			<th>날짜별 총평균</th>
		</tr>
		<%
		for(OrderDto2 date_Avg : date_list){
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		%>
				<tr>
					<td><%= date_Avg.getDate().format(formatter) %></td>
					<td><%= date_Avg.getAvg() %></td>
				
				</tr>
				
		<% 
			}
		%>
	
	</table>
	
	
</body>
</html>