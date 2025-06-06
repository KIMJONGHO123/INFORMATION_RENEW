package Domain.Dto;

import java.time.LocalDateTime;

public class BookReplyDto {
	private int no; //서버에서 가져온다
	private String bookCode; //프론트에서 가져온다
	private String username; //서버에서 가져온다
	private String contents; //프론트에서 가져온다
	private LocalDateTime createAt; //서버에서 가져온다
	public BookReplyDto() {
		super();
	}
	public BookReplyDto(int no, String bookCode, String username, String contents, LocalDateTime createAt) {
		super();
		this.no = no;
		this.bookCode = bookCode;
		this.username = username;
		this.contents = contents;
		this.createAt = createAt;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public LocalDateTime getCreateAt() {
		return createAt;
	}
	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
	@Override
	public String toString() {
		return "BookReplyDto [no=" + no + ", bookCode=" + bookCode + ", username=" + username + ", contents=" + contents
				+ ", createAt=" + createAt + "]";
	}
	
	
}
