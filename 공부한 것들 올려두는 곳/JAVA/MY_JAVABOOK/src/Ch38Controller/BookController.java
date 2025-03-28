package Ch38Controller;

import java.net.ResponseCache;
import java.util.HashMap;
import java.util.Map;

import Ch38Domain.Dto.BookDto;
import Ch38Domain.Service.BookServiceImpl;

public class BookController implements SubController{
	private BookServiceImpl bookService;
	public BookController(){
		try {
			bookService = BookServiceImpl.getInstance();
		} catch (Exception e) {
			exceptionalHandler(e);
		}
		
	}
	Map<String,Object> response = new HashMap<>();
	@Override
	public Map<String, Object> execute(Map<String, Object> params) {
		System.out.println("[SC] BookController execute invoke..!");
		//00
		
		Integer serviceNo = (Integer)params.get("serviceNo");
		if (serviceNo == null) {
			response.put("status", false);
			response.put("message", "유효하지 않은 서비스 요청입니다.");
			return response;
		}
		
		switch (serviceNo) {
		case 1: {
			System.out.println("[SC] 도서 등록 요청 확인");
			String bookCode = params.get("bookCode") !=null? (String)params.get("bookCode"):null;
			String bookaName = params.get("bookName") !=null? (String)params.get("bookName"):null;
			String publisher = params.get("publisher") !=null? (String)params.get("publisher"):null;
			String isbn = params.get("isbn") !=null? (String) params.get("isbn"):null;
			BookDto bookdto = new BookDto(bookCode,bookaName,publisher,isbn);
			
			boolean isokay = isValid(bookdto);
			System.out.println("[No-1 도서 등록 요청] : 유효성 검사 확인 : "+ isokay);
			if (!isokay) {
				response.put("status", false);
				response.put("message", "유효성 체크 오류발생!");
				return response;
			}
			break;
		}
		case 2: {
			System.out.println("[SC]도서 조회 요청 확인");
			break;
		}
		case 3:{
			System.out.println("[SC]도서 수정 요청 확인");
			break;
		}
		case 4 : {
			System.out.println("[SC] 도서삭제 요청 확인");
			break;
		}
		
		default:
			System.out.println("[SC] 잘못된 서비스번호 요쳥 확인");
			response.put("status", false);
			response.put("message", "잘못된 서비스번호 요청입니다.");
		}
		return response;
	}
	private boolean isValid(BookDto bookdto) {
		if (bookdto.getBookCode() == null || bookdto.getBookCode().length()!=8) {
			response.put("error", "bookCode의 길이는 8글자 이어야 합니다.");
			System.out.println("[INVALID] bookCode의 길이는 최소 8자여야 합니다.");
			return false;
		}
		if (bookdto.getBookaNmae().length() >255) {
			response.put("error", "bookName의 길이는 255자를 넘기면 안됩니다.");
			System.out.println("[INVALID] bookName의 길이는 255자를 넘기면 안됩니다.");
			return false;
		}
		System.out.println();
		return true;
	}
	
	public Map<String,Object> exceptionalHandler(Exception e){
		
		if (response == null) {
			response = new HashMap<>();
		}
		response.put("status", false);
		response.put("message", e.getMessage());
		response.put("message", e);
		return response;
	}

}
