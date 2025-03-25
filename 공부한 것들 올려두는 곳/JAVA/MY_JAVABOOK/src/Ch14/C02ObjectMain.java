package Ch14;

class C02Simple{
	int n;
	
	
	C02Simple(int n){
		this.n = n;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		if(obj instanceof C02Simple) {
			C02Simple down = (C02Simple) obj;
			return this.n == down.n;
			
		}
		return false;
	}
	
	
}

public class C02ObjectMain {
	public static void main(String[] args) {
		C02Simple ob1 = new C02Simple(10);
		C02Simple ob2 = new C02Simple(10);
		C02Simple ob3 = new C02Simple(20);
		
		
		ob1.equals(ob2);
		System.out.println(ob1.equals(ob2)); 
		System.out.println(ob1.equals(ob3)); 
		
		String str1 = new String("JAVA");
		String str2 = new String("JAVA");
		System.out.println(str1.equals(str2));
		
		
		// Object클래스의 equals 메소드는 == 연산자로 두 객체를 비교한다. 
		// 즉 두 객체의 주소가 같으면 true, 두 객체의 주소가 다르면 false를 반환한다.
		// 오버라이드 하면 값을 비교할 수도 있다.
		
		// String 클래스의 equals 메서드는 두 문자열의 내용을 비교한다. (오버라이딩되어 있기 때문에.)
		// String 클래스의 == 연산자는 두 문자열의 주소를 비교한다.
	}
}
