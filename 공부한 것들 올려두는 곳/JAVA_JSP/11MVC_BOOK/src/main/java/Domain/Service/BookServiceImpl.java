package Domain.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import Domain.Dao.BookDao;
import Domain.Dao.BookDaoImpl;
import Domain.Dto.BookDto;
import Domain.Dto.Criteria;
import Domain.Dto.PageDto;

public class BookServiceImpl {

	//
	private BookDao bookdao;
	
	//싱글톤 패턴
	private static BookServiceImpl instance;
	private BookServiceImpl() throws Exception{	
		bookdao = BookDaoImpl.getInstance();
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

		return response;
	}
	
	
}
