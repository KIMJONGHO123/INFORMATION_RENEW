<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="C04.*,C09.*,java.util.*" %>
<%
	
	String userid = request.getParameter("userid");
	UserDto userdto = DBUtils.getInstance().selectOneUser(userid);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>


	<!-- dbutils에서 selectOneUser(String userid)를 받아 단건 조회가 되도록 코드 생성
		selectOneUser함수를 이용해서 해당 사용자 정보 받아와서 form>input에 각각 표시
		dbutils에서 int updateUser(UserDto userDto를 생성) -> Update처리코드
		update_form.jsp에서 수정요청 버튼 클릭하면 ./update.jsp에서 업데이트 처리
		처리완료 이후 selectAll.jsp 이동
	
	 --> 



	<h1>USER UPDATE</h1>
		<form action="./update.jsp">
			<input type="text" name="userid" placeholder="userid" value="<%= userdto.getUserid()%>" readonly/> <br />
			<input type="text" name="password" placeholder="password" value="<%= userdto.getPassword()%>"/> <br />
			<input type="text" name="role" placeholder="role" value="<%= userdto.getRole()%>"/> <br />
			<button>수정요청</button>
			<a href="javascript:history.go(-1)">이전으로</a>
		</form>
</body>
</html>