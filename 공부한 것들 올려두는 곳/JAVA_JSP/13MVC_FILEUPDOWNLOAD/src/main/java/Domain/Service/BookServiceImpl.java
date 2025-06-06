package Domain.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import Domain.Dao.BookDao;
import Domain.Dao.BookDaoImpl;
import Domain.Dao.BookReplyDaoImpl;
import Domain.Dto.BookDto;
import Domain.Dto.BookReplyDto;
import Domain.Dto.Criteria;
import Domain.Dto.PageDto;

public class BookServiceImpl {

	//
	private BookDao bookdao;
	private BookReplyDaoImpl bookReplyDaoImpl;
	
	//싱글톤 패턴
	private static BookServiceImpl instance;
	private BookServiceImpl() throws Exception{	
		bookdao = BookDaoImpl.getInstance();
		bookReplyDaoImpl = BookReplyDaoImpl.getInstance();
	}
	public static BookServiceImpl getInstance() throws Exception{
		if(instance==null)
			instance = new BookServiceImpl();
		return instance;
	}
	
	
	//TX 처리 + 비즈니스 유효성검사(도서 추가)
	public boolean bookRegistration(BookDto bookDto) throws Exception{
		
		int result = bookdao.insert(bookDto);
		
		return result>0;
		
	}
	
	public Map<String,Object> getAllBooks() throws Exception{
		Map<String,Object> response = new LinkedHashMap<String, Object>();
		
		List<BookDto> list = bookdao.selectAll();
		if(list.size()>0) {
			response.put("status", true);
			response.put("list", list);
		}else {
			response.put("status", false);
		}

		return response;
	}
	
	
	public Map<String, Object> getAllBooks(Criteria criteria) throws Exception {
		Map<String,Object> response = new LinkedHashMap<String, Object>();
		
		if(criteria.getType()==null || criteria.getType().isEmpty()) { // 전체검색
			int offset = (criteria.getPageno()-1) * criteria.getAmount();
			
			// 페이지별 건수
			List<BookDto> list = bookdao.selectAll(offset,criteria.getAmount());
			
			// PageDto
			long count = bookdao.count();
			PageDto pagedto = new PageDto(count,criteria);
			
			
			if(list.size()>0) {
				response.put("status", true);
				response.put("list", list);
				response.put("pageDto", pagedto);
			}else {
				response.put("status", false);
			}
		}else {
			// 키워드 검색 시 실행
			int offset = (criteria.getPageno()-1) * criteria.getAmount();
			
			// 페이지별 건수
			int amount = criteria.getAmount();
			String type = criteria.getType();
			String keyword = criteria.getKeyword();
			List<BookDto> list = bookdao.selectAll(offset,amount,type,keyword);
			
			// PageDto
			long totalcount = bookdao.count(criteria);
			PageDto pagedto = new PageDto(totalcount,criteria);

			if(list.size()>0) {
				response.put("status", true);
				response.put("list", list);
				response.put("pageDto", pagedto);
			}else {
				response.put("status", false);
			}
			
			
		}
		
		

		return response;
	}
	public Map<String, Object> getBook(String bookCode) throws Exception {
		Map<String,Object> response = new LinkedHashMap<String, Object>();
		BookDto bookDto = bookdao.select(bookCode);
		
		if(bookDto == null) {
			response.put("status", false);
		}else {
			response.put("status", true);
			response.put("bookDto", bookDto);
		}
		return response;
	}
	public boolean modifyBook(BookDto bookDto) throws Exception{
		int result = bookdao.update(bookDto);
		
		return result>0;
	}
	
	public boolean removeBook(String bookCode) throws Exception{
		int result = bookdao.delete(bookCode);
		return result>0;
	}
	
	public boolean bookReplyAdd(BookReplyDto dto) throws Exception{
		int result = bookReplyDaoImpl.insert(dto);
		
		return result>0;
	}
	public List<BookReplyDto> getAllBookReply(String bookCode) throws Exception {
		List<BookReplyDto> list = bookReplyDaoImpl.selectAll(bookCode);
		return list;
	}
	
	public long bookReplyCount(String bookCode) throws Exception{
		long cnt = bookReplyDaoImpl.count(bookCode);
		return cnt;
	}
	
}
