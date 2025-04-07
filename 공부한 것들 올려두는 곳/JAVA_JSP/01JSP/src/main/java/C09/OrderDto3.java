package C09;

import java.time.LocalDate;


public class OrderDto3 {
	private String addr;
	private LocalDate order_date;
	private Integer sum;
	public OrderDto3() {
		super();
	}
	public OrderDto3(String addr, LocalDate order_date, Integer sum) {
		super();
		this.addr = addr;
		this.order_date = order_date;
		this.sum = sum;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public LocalDate getOrder_date() {
		return order_date;
	}
	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "OrderDto3 [addr=" + addr + ", order_date=" + order_date + ", sum=" + sum + "]";
	}

	
	
}
