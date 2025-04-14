package Domain.DTO;

// DTO : 데이터 담는 객체를 정의한다.(Data Transfer Object)

public class UserDto {
	private String username;
	private String password;
	private String role;
	public UserDto() {
		super();
	}
	public UserDto(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserDto [username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
