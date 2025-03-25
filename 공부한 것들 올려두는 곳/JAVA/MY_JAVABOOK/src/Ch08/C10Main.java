package Ch08;


// 홍길동이 사과장수에게 사과를 구매한다
// 구매자              판매자
// 보유금액(속성)       보유금액(속성)
// 보유 사과개수        사과개수(속성)
//					 개당가격(속성)
// 구매하기(기능)       판매하기(기능)

// 1) 특정사과장수에게 돈을 건넨다 ->
// 2) 돈을 내 보유금액에 누적
// 3) 사과갯수 개산. -> 나의 보유 사과개수에서 차감 -> 사과개수 전달
// 4) 나의 보유 사과개수에 누적


class Buyer{ //구매자 (사는사람)
	private int myMoney;
	private int appleCnt;
	
	// 모든 인자 생성자
	// toString
	public Buyer(int myMoney, int appleCnt) {
		super();
		this.myMoney = myMoney;
		this.appleCnt = appleCnt;
	}

	public void payment(Seller seller, int money) {
		// 내 보유금액에서 차감
		// seller에 money를 전달하고 return 되는 사과 개수를 누적
		this.myMoney-=money;
		this.appleCnt += seller.receive(money);
	}
	
	@Override
	public String toString() {
		return "Buyer [myMoney=" + myMoney + ", appleCnt=" + appleCnt + "]";
	}
	
	
}
class Seller{ // 판매자 (파는사람)
	private int myMoney;
	private int appleCnt;
	private int price;
	
	//모든 인자 생성자
	// toString
	public Seller(int myMoney, int appleCnt, int price) {
		super();
		this.myMoney = myMoney;
		this.appleCnt = appleCnt;
		this.price = price;
	}



	public int receive(int money) {
		// 구매자로부터 전달받은 money를 내보유금액에 누적
		// 전달받은금액/사과개수를 리턴
		this.myMoney += money;
		this.appleCnt-=(money/this.price);
		return money/this.price;
	}
	
	@Override
	public String toString() {
		return "Seller [myMoney=" + myMoney + ", appleCnt=" + appleCnt + ", price=" + price + "]";
	}
	
}
public class C10Main {
	public static void main(String[] args) {
		
		Seller seller = new Seller(10000,100,1000);
		
		Buyer 홍길동 = new Buyer(10000,0);
		Buyer 노홍철 = new Buyer(5000,0);
		
		홍길동.payment(seller, 5000);
		노홍철.payment(seller, 2000);
		
		System.out.println(홍길동);
		System.out.println("----------------------------");
		System.out.println(노홍철);
		System.out.println("-----------------------------");
		System.out.println(seller);
	}
}
