package Controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.BookDto;
import Domain.Dto.UserDto;
import Domain.Service.BookServiceImpl;
import Domain.Service.UserServiceImpl;

public class BookCreateController implements SubController{
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	private BookServiceImpl bookservice;
	
	public BookCreateController() throws Exception{
		this.bookservice = BookServiceImpl.getInstance();
	}
	
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] BookCreateController execute..");
		

		try {
			String uri = req.getMethod();
			if(uri.equals("GET")) { // URL로 직접 치는 것도 GET 방식이다.
				req.getRequestDispatcher("/WEB-INF/view/book/create.jsp").forward(req, resp);
				return ;
			}
			
			
			// 파라미터
			String bookcode = req.getParameter("bookcode");
			String bookname = req.getParameter("bookname");
			String publisher = req.getParameter("publisher");
			String isbn = req.getParameter("isbn");
			
			BookDto bookdto = new BookDto(bookcode,bookname,publisher,isbn);
			
			// 유효성
			
			if(!isValid(bookdto)) {
				req.getRequestDispatcher("/WEB-INF/view/book/create.jsp").forward(req, resp);
				return;
			}
			
			// 서비스
			boolean isadded = bookservice.bookRegistration(bookdto); //book insert 작업
			
			// 뷰
			if(isadded) {
				resp.sendRedirect(req.getContextPath()+"/book/list");
			}else {
				req.getRequestDispatcher("/WEB-INF/view/book/create.jsp").forward(req, resp);
			}
			
			
		}catch(Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/book/error.jsp").forward(req, resp);
			}catch(Exception e2) {}
		}

	}

	private boolean isValid(BookDto bookdto) {
		if(bookdto.getBookcode().isEmpty()) {
			req.setAttribute("bookcode", "BookCode를 입력하세요");
			
		}
		if(bookdto.getBookname().isEmpty()) {
			req.setAttribute("bookname", "BookName을 입력하세요");
			
		}
		if(bookdto.getPublisher().isEmpty()) {
			req.setAttribute("publisher", "출판사명을 입력하세요");
			
		}
		if(bookdto.getIsbn().isEmpty()) {
			req.setAttribute("isbn", "isbn을 입력하세요");
			
		}
		if(bookdto.getBookcode().isEmpty()||bookdto.getBookname().isEmpty()
				||bookdto.getPublisher().isEmpty()||bookdto.getIsbn().isEmpty()
		  ) {
			return false;
		}
		return true;
	}
	
	// 예외처리함수
	public void exceptionHandler(Exception e) {
		req.setAttribute("status", false);
		req.setAttribute("message", e.getMessage());
		req.setAttribute("exception", e);
	}	
		
	
}
