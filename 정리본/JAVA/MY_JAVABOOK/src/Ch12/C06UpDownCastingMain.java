package Ch12;


class Super{
	int n1;

	@Override
	public String toString() {
		return "Super [n1=" + n1 + "]";
	}
	
	
}

class Sub extends Super{
	int n2;

	@Override
	public String toString() {
		return "Sub [n2=" + n2 + ", n1=" + n1 + "]";
	}
	
	
}

public class C06UpDownCastingMain {
	public static void main(String[] args) {
		// NOCasting (자료형의 일치)
		Super ob1 = new Super();
		ob1.n1 = 10;
		Sub ob2 = new Sub();
		ob2.n2 = 10;
		ob2.n1 = 20;
		
		System.out.println(ob1);
		System.out.println(ob2);
		
		// Upcasting(상위클래스 참조변수 = 하위클래스형 객체)(자동형변환)
		// Upcasting 쓰는 이유 : 상속관계에 있는 많은 클래스의 만들어진 하위객체들을 연결하는게 주목적이다
		// DownCasting : Upcasting 으로 연결된부분에서 하위객체의 접근 하기 위해서 쓴다.
		
		Super ob3 = new Sub(); // Sub 가 Super로 자동 형변환 (오른쪽에서 왼쪽으로)
		ob3.n1 = 100;
//		ob3.n2 = 200; // 접근 불가능
		Super ob4 = ob2;
		ob4.n1 = 100;
//		ob4.n2 = 200; // 접근 불가능   상위 객체가 이해할수 있는 영역까지만 접근 가능
		
		
		//Downcasting(하위클래스 참조변수 = 상위클래스형 객체) (강제형변환)
		// UPcasting된 상태에서 확장된 멤버에 접근하기 위한 용도
		// Sub ob5 = (Sub)new Super();
		//Sub ob5 = (Sub) ob1; // 강제로 형 변환 에러난다. 부모객체를 자식객체로 변환할 수 없다.
		Sub ob6 = (Sub)ob3;
		
		
		
		
		
	}
}
