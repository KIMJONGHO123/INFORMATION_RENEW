<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	java.util.Scanner sc = new java.util.Scanner(System.in);
 	
 	System.out.println("단을 입력하세요");
 	int dan = sc.nextInt();
 	
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	
		<tbody>
			
			<%
				for(int i =1; i<10;i++){
					%>
					<tr>
						<td>
							<%=dan +"*"+ i + "=" + (dan *i) %>
						</td>
					</tr>
					<%
				}
			
			
			%>
			
		</tbody>
	</table>
</body>
</html>