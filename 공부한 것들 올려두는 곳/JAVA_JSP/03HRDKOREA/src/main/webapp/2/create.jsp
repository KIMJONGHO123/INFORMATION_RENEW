<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Utils.*,java.util.*" %>
    <!--  파라미터 받기-->    


<!-- 파라미턴 받기(액션 태그) :userBean + :setProperty-->
<jsp:useBean id="classDto" class="Utils.ClassDto" scope="request" />
<jsp:setProperty name="classDto" property="*"/>

<%
	System.out.println(classDto);
	int result = DBUtils.getInstance().insertClass(classDto);
	if(result>0){
		out.println("<script>alert('수강신청이 정상적으로 완료되었습니다.!');location.href='../index.jsp'</script>");
	}
%>