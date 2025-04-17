<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="layout navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/book/list">도서</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
        </li>
      </ul>
      
      <%@page import="Domain.Dto.*" %>
      <%
      	PageDto pageDto_nav = request.getAttribute("pageDto") !=null ? (PageDto) request.getAttribute("pageDto"):null;
      	System.out.println("Nav : " + pageDto_nav);
      	Integer pageno_nav = null;
      	if(pageDto_nav !=null){
      		pageno_nav = pageDto_nav.getCriteria().getPageno();
      	}
      %>
      
      <form class="d-flex" action="${pageContext.request.contextPath }/book/list">
      	<select name="type"> <!-- type=booCode랑 같은거다. 서버 -> String type = req.getParameter("type"); -->
      		<option selected>--</option>
      		<option value="bookCode">도서코드</option>
      		<option value="bookName">도서명</option>
      		<option value="publisher">출판사</option>
      		<option value="isbn">ISBN</option>
      	
      	</select>
        <input name= "keyword" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <%
        	if(pageno_nav!=null){
        %>
        		<!-- 화면에서는 보이지 않는다. -->
        		<!-- 검색 후에도 해당 페이지가 보이게 하는 코드 -->
        		<input type="hidden" name="pageno" value="<%=pageno_nav %>"/>
        <%		
        	}
        
        %>
        
        <button class="btn btn-outline-success" type="submit">Search</button>
        <!-- 버튼 누르면 /book/list?type=bookCode&keyword=10&pageno=2 가 전달된다. -->
        <!-- Get방식에서는 action 링크 뒤에 ?type=...&keyword=... 이렇게 직접 안 붙여도 된다. 입력 필드에 name 속성이 붙어 있으면 자동으로 URL 뒤에 붙여서 전달해준다. -->
      </form>
    </div>
  </div>
</nav>