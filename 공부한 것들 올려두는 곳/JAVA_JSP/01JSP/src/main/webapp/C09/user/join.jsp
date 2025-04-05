<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="C09.*, C04.*,java.util.*" %>

<%
	//파라미터
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	String role = "ROLE_USER";
	
	
	
	// 입력값 검증(생략)
	
	
	// 서비스 실행(db insert)
	
	
	// 서비스 실행(db insert)
	DBUtils dbutils = DBUtils.getInstance(); // 싱글톤 패턴에서 리턴받은 객체가 dbutils에 들어간다.
	int result = dbutils.insertUser(new UserDto(userid,password,role));
	
	// 이동(redirect or forwarding or script코드 처리(location.href=))
	if(result>0){
		out.println("<script>alert('insert 성공');location.href='./selectAll.jsp'</script>");

	}else{
		out.println("<script>alert('insert 실패');location.href='./join_form.jsp'</script>");
	}
	
	
	
	

%>