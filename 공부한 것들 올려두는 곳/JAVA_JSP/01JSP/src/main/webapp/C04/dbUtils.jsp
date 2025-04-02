<%@page import="java.sql.*,C04.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 속성/기능추가 -->
<%!
	
	private String id = "system";
	private String pw = "1234";
	private String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void getConnection() throws Exception{
		if(conn==null){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(db_url, id, pw);	
		}
		
	}
	private int insert(UserDto userdto) throws Exception{
		
		pstmt = conn.prepareStatement("insert into TBL_USER values(?,?,?)");
		pstmt.setString(1, userdto.getUserid());
		pstmt.setString(2, userdto.getPassword());
		pstmt.setString(3, userdto.getRole());
		int result = pstmt.executeUpdate();
		
		conn.commit();
		pstmt.close();
		return result;
	}
	
	private UserDto selectOne(String userid) throws Exception{
		pstmt = conn.prepareStatement("select * from TBL_USER whre userid=?");
		rs = pstmt.executeQuery();
		UserDto userdto=null;
		if(rs!=null){
			if(rs.next()){
				userdto = new UserDto();
				userdto.setUserid(userid);
				userdto.setPassword(rs.getString("password"));
				userdto.setRole(rs.getString("role"));
			}
		}
		rs.close();
		pstmt.close();
		return userdto;
	}

%>



<!-- Service 함수 -->
<% 

	/* 요청 정보 확인 */
	String URL = (String)request.getAttribute("url");
	Integer serviceNo = (Integer)request.getAttribute("serviceNo");
	System.out.println("url : " + URL);
	System.out.println("serviceNo : " + serviceNo);
	
	if(URL.contains("/join")){
		getConnection();
		UserDto userdto = (UserDto)request.getAttribute("userdto");
		if(insert(userdto)>0){
			response.sendRedirect("./login_form.jsp"); // redirect 다수 사용시 return 예약어 사용
			return;
		}
	}
	
	if(URL.contains("/myinfo")){
		request.setAttribute("isConfirm", true);
		getConnection();
		
		String userid= request.getParameter("userid");
		UserDto userdto = selectOne(userid);
		
		if(userdto !=null){
			request.setAttribute("myinfo-result", userdto);
			
			request.getRequestDispatcher("./myinfo.jsp").forward(request, response);
			return;
		}
	}

%>