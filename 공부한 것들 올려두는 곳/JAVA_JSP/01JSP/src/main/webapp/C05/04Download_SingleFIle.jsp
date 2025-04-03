<%@page import="org.eclipse.jdt.internal.compiler.ast.WhileStatement"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import ="java.io.*" %>
<%
	//INPUTSTREAM
	String dirPath = pageContext.getServletContext().getRealPath("/")+"C05\\files\\";
	System.out.println("dirPath : " + dirPath);
	
	
	try{
		// INPUTSTREAM
		FileInputStream in = new FileInputStream(dirPath+"TEST.txt");
		
		// OUTPUSTREAM
		out.clear();  // response outStream 을 닫고 버퍼를 비움
		out = pageContext.pushBody(); // 현재페이지의 body에 연결
		
		ServletOutputStream bout = response.getOutputStream();
		
		// Response Header 지정!!!
		response.setHeader("COntext-Type","application/octet-stream;charset-utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=TEXT.txt");
		
		byte buff[] = new byte[4096]; // 다운로드 속도롤 높이기위한 버퍼 공간 지정
		while(true){
			int data = in.read(buff);
			if(data ==-1){
				break;
			}
			bout.write(buff,0,data);
			bout.flush();
		}
		bout.close();
		in.close();
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>