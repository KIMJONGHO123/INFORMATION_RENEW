package C09;

import java.time.LocalDate;

public class OrderDto2 {
	private LocalDate date;
	private Double avg;
	public OrderDto2() {
		super();
	}
	public OrderDto2(LocalDate date, Double avg) {
		super();
		this.date = date;
		this.avg = avg;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Double getAvg() {
		return avg;
	}
	public void setAvg(Double avg) {
		this.avg = avg;
	}
	@Override
	public String toString() {
		return "Date_Avg [date=" + date + ", avg=" + avg + "]";
	}

	
}
