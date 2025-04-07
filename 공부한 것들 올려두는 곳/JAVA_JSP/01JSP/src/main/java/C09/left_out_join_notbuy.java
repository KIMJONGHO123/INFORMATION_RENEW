package C09;

public class left_out_join_notbuy {
	private String userid;
	private Integer password;
	private String role;
	private String addr;
	private Integer product_id;
	private String userid_1;
	private String product_name;
	private String category;
	private Integer price;
	private Integer quantity;
	private String order_date;
	public left_out_join_notbuy() {
		super();
	}
	public left_out_join_notbuy(String userid, Integer password, String role, String addr, Integer product_id,
			String userid_1, String product_name, String category, Integer price, Integer quantity, String order_date) {
		super();
		this.userid = userid;
		this.password = password;
		this.role = role;
		this.addr = addr;
		this.product_id = product_id;
		this.userid_1 = userid_1;
		this.product_name = product_name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.order_date = order_date;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Integer getPassword() {
		return password;
	}
	public void setPassword(Integer password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getUserid_1() {
		return userid_1;
	}
	public void setUserid_1(String userid_1) {
		this.userid_1 = userid_1;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	@Override
	public String toString() {
		return "left_out_join_notbuy [userid=" + userid + ", password=" + password + ", role=" + role + ", addr=" + addr
				+ ", product_id=" + product_id + ", userid_1=" + userid_1 + ", product_name=" + product_name
				+ ", category=" + category + ", price=" + price + ", quantity=" + quantity + ", order_date="
				+ order_date + "]";
	}
	
	
	
}
