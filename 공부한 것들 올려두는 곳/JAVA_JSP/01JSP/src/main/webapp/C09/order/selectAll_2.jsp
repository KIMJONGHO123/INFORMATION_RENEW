<%@page import="oracle.jdbc.oracore.Util"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="C04.*, C09.*, java.util.*,java.time.format.DateTimeFormatter" %>
<!-- INNER JOIN 

	select u.addr, o.order_date ,sum(o.price*o.quantity) 총합 from tbl_user u join tbl_order o  -- 구매한 고객
	on u.userid = o.userid
	group by u.addr, o.order_date
	order by u.addr asc, 총합 desc;
	
	select * from tbl_user left outer join tbl_order   --구매하지 않은 고객
	on tbl_user.userid = tbl_order.userid
	where tbl_order.userid is null;

-->

<% 
	List<OrderDto3> join_addr_sum_list = DBUtils.getInstance().SelectAllOrder3();
	List<left_out_join_notbuy> loj_list = DBUtils.getInstance().notbuy();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>지역 + 날짜별 구매 총액</h1>
	<table>
	
		<tr>
			<th>지역</th>
			<th>날짜</th>
			<th>총액</th>
		
		</tr>
		

			<%
			
				for(OrderDto3 list : join_addr_sum_list){
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy*MM*dd");
			%>
				<tr>
					<td><%= list.getAddr() %></td>
					<td><%= list.getOrder_date().format(formatter) %></td>
					<td><%=list.getSum() %></td>
				</tr>
				
			
			<%
				}
			%>
			
	
	</table>
	
	<h1>구매안한 사람</h1>
	<table>
	
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>역할</th>
			<th>주소</th>
			<th>제품 아이디</th>
			<th>아이디_1</th>
			<th>제품 이름</th>
			<th>카테고리</th>
			<th>가격</th>
			<th>수량</th>
			<th>날짜</th>
		
		</tr>
		
		<%
			for(left_out_join_notbuy el : loj_list){
				
			
		%>
			<tr>
				<th><%=el.getUserid() %></th>
				<th><%= el.getPassword() %></th>
				<th><%= el.getRole() %></th>
				<th><%=el.getAddr() %></th>
				<th><%=el.getProduct_id() %></th>
				<th><%=el.getUserid_1() %></th>
				<th><%=el.getProduct_name() %></th>
				<th><%=el.getCategory() %></th>
				<th><%=el.getPrice() %></th>
				<th><%=el.getQuantity() %></th>
				<th><%=el.getOrder_date() %></th>

				
			
			</tr>
	
	
		<%
			}
		%>
	
	</table>
</body>
</html>