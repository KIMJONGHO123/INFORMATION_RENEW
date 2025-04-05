<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<%!
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id_db = "system";
	private String pw_db = "1234";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private int insert(String id,String pw) throws Exception{


		pstmt = conn.prepareStatement("insert into user_tbl values(?,?)");
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		int result = pstmt.executeUpdate();
		
		conn.commit();
	
		pstmt.close();
	
		return result;

}

%>
<%
	String id = request.getParameter("userid");
	String pw = request.getParameter("password");
	
		// 아이디 비밀번호 유효성 검사
		if(id.isEmpty()){
			request.setAttribute("userid_input", "id를 입력하세요");
		}
		if(pw.isEmpty()){
			request.setAttribute("password_input", "password를 입력하세요");
			
		}
		if(id.isEmpty() || pw.isEmpty()){
			request.getRequestDispatcher("./join_form.jsp").forward(request, response);
			return;
		}

	try{	
		// DB 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id_db, pw_db);
		
		if(insert(id,pw)>=1){
			out.print("<script>alert('회원가입 성공');location.href='./login.jsp'</script>");
			//request.getRequestDispatcher("./login.jsp"); // login.jsp로 forward 이동
		}
		
	}catch(Exception e){
		out.print("<script>alert('회원가입 실패(이미 id가 존재합니다.)');location.href='./join_form.jsp'</script>");
	}
	
		
%>
