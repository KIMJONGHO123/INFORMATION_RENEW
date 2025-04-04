<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="C04.*, C09.*, java.util.*" %>
<%

	DBUtils dbutils = DBUtils.getInstance();
	
	List<UserDto> list = dbutils.selectAllUser();
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--  -->
	총인원 = <%= list.size() %> <br />
	
	<table>
		<tr>
			<th>계정</th>
			<th>패스워드</th>
			<th>역할</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		
		<%
			for(UserDto dto : list){
		%>
			<tr>
				<td><%=dto.getUserid() %></td>
				<td><%= dto.getPassword() %></td>
				<td><%= dto.getRole() %></td>
				<td>
					<a href="./update_form.jsp?userid=<%=dto.getUserid()%>">수정하기</a>
				</td>
				<td>
					<a href="./delete.jsp?userid=<%= dto.getUserid()%>">삭제하기</a>
				</td>
			</tr>
				
		<%
			}
		%>
		
		
	
	
	</table>
</body>
</html>