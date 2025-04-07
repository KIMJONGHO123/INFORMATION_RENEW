<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="C04.*,C09.*,java.util.*" %>
<%
	String userid = request.getParameter("userid");
	int result = DBUtils.getInstance().deleteUser(userid);
	
	// Re + FR
	response.sendRedirect("./selectAll.jsp");
%>
