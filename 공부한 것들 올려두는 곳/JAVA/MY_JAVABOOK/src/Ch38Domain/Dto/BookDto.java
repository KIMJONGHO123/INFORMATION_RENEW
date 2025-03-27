package Ch38Domain.Dto;

public class BookDto {
	private String bookCode;
	private String bookaName;
	private String publisher;
	private String isbn;
	
	public BookDto() {
		super();
	}
	public BookDto(String bookCode, String bookaNmae, String publisher, String isbn) {
		super();
		this.bookCode = bookCode;
		this.bookaName = bookaNmae;
		this.publisher = publisher;
		this.isbn = isbn;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getBookaNmae() {
		return bookaName;
	}
	public void setBookaNmae(String bookaNmae) {
		this.bookaName = bookaNmae;
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
		return "BookDto [bookCode=" + bookCode + ", bookaName=" + bookaName + ", publisher=" + publisher + ", isbn="
				+ isbn + "]";
	}
	
	
	
}
