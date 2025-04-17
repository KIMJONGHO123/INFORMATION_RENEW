package Controller.book;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain.Dto.BookDto;
import Domain.Service.BookServiceImpl;

public class BookReadeController implements SubController{

	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	private BookServiceImpl bookservice;
	
	public BookReadeController() throws Exception{
		this.bookservice = BookServiceImpl.getInstance();
	}
	
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] BookReadController execute..");
		

		try {
			//파라미터받기
			
			String bookCode = req.getParameter("bookCode"); // 책이름 누르면 넘어갈때 받는거 // URL에서 bookCode를 받는다.
			String pageno = req.getParameter("pageno");  // 책이름 누르면 넘어갈때 받는거 // URL에서 pageno를 받는다.
			// 유효성 검사
			if(!isValid(bookCode)) {
				//req.setAttribute("message", "유효성 체크 오류!");
				resp.sendRedirect(req.getContextPath()+"/book/list");
				return;
			}
			
			// 서비스
			Map<String,Object> serviceResponse = bookservice.getBook(bookCode);
			Boolean status = (Boolean) serviceResponse.get("status");
			if(status) {
				req.setAttribute("bookDto", serviceResponse.get("bookDto"));
			}
			req.setAttribute("pageno", pageno);
			// 뷰
			req.getRequestDispatcher("/WEB-INF/view/book/read.jsp").forward(req, resp);
		}catch(Exception e) {
			exceptionHandler(e);
			try {
				req.getRequestDispatcher("/WEB-INF/view/book/error.jsp").forward(req, resp);
			}catch(Exception e2) {}
		}

	}

	private boolean isValid(String bookCode) {
		if(bookCode.isEmpty()) {
			req.setAttribute("bookCode", "BookCode 유효성 오류");
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
