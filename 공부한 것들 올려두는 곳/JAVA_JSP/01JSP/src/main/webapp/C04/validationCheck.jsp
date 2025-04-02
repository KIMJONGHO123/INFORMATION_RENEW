<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="./error.jsp"%>
<%@ page import ="C04.*" %>
<%

	//request로부터 전달받은 파라미터 꺼내서 System.out 확인
	//받은 username,password 값이 null인지여부를 체크(String API trim()  + isEmpty() 이용)
	// 에러 발생시 처리되는 페이지로 전달.(error.jsp)
	
	
	String url = (String) request.getAttribute("url");
	Integer serviceNo = (Integer) request.getAttribute("serviceNo");
	
	
	// url선별 serviceNo 선별 -> 유효성체크
		
	/* request.getAttribute(String name) 메서드는 어떤 객체든 저장하고 꺼낼 수 있게 Object 타입으로 리턴해준다. 
		그래서 (UserDto) 이렇게 형변환을 해줘야하는거다(Object -> UserDto).
	*/
	UserDto userdto;
	
	if(url.contains("/join")){
		userdto = (UserDto)request.getAttribute("userdto");
		isValid(userdto);
	}else if(url.contains("/myinfo")){
		// myinfo
		String userid = request.getParameter("userid");
		isValid(userid);
		
	}

	request.getRequestDispatcher("./dbUtils.jsp").forward(request, response);
%>


<%!
	void isValid(UserDto userdto) throws Exception{
	
		String password = userdto.getUserid();
		if(userdto == null){
			throw new Exception("userDto가 Null 입니다..");
		}
		
		if(password.trim().isEmpty()){
			throw new Exception("password를 입력하세요..");
		}
		if(userdto.getRole().trim().isEmpty()){
			throw new Exception("기본 역할(ROLE_USER)이 입력되지 않았습니다.");
		}
	}
	
	void isValid(String userid) throws Exception{
		
		if(userid.trim().isEmpty()){
			/* isEmpty()는 String 타입에만 사용 가능한 메서드 */
			throw new Exception("userid를 입력하세요..");
		}
	}

%>
