package Domain.Dto;

public class BookDto {
	private String bookcode;
	private String bookname;
	private String publisher;
	private String isbn;
	public BookDto() {
		super();
	}
	public BookDto(String bookcode, String bookname, String publisher, String isbn) {
		super();
		this.bookcode = bookcode;
		this.bookname = bookname;
		this.publisher = publisher;
		this.isbn = isbn;
	}
	public String getBookcode() {
		return bookcode;
	}
	public void setBookcode(String bookcode) {
		this.bookcode = bookcode;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "BookDto [bookcode=" + bookcode + ", bookname=" + bookname + ", publisher=" + publisher + ", isbn="
				+ isbn + "]";
	}
	
	
	
	
}
