<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
    	nav{
    		background-color : lightgray;
    	}
    	nav>ul{
    		display:flex;
    		justify-content: left;
    	}
    	nav>ul>li{
    		padding:5px 20px;
    		
    	}
    
    </style>
	<nav>
		<ul>
			<li><a href="${pageContext.request.contextPath}/1/index.jsp ">후보조회</a></li>
			<li><a href="${pageContext.request.contextPath }/2/index.jsp">투표하기</a></li>
			<li><a href="${pageContext.request.contextPath }/3/index.jsp">투표검수조회</a></li>
			<li><a href="${pageContext.request.contextPath }/4/index.jsp">후보자등수</a></li>
			<li><a href="${pageContext.request.contextPath}">홈으로</a></li>
		</ul>	
	
	
	</nav>