package Ch12;


class C08Super{
	
	void func1() {
		System.out.println("C08.Super.fun1() call");
	}
	void func2() {}; // 이렇게하면 func2는 오버라이드 되기때문에 func2 이용 가능
}


class C08Sub extends C08Super{
	void func2() {
		System.out.println("C08.Sub.fun2() call");
	}
}


public class C08UpDownCastingMain {
	public static void main(String[] args) {
		C08Super ob1 = new C08Super(); // No casting
		ob1.func1();
		
		System.out.println("--------------------------");
		
		C08Sub ob2 = new C08Sub();  // No casting
		ob2.func1();
		ob2.func2();
		
		System.out.println("--------------------------");
		
		C08Super ob3 = new C08Sub(); // Upcasting // Super밖에 접근 못한다.
		ob3.func1(); // C08Super 메서드이니까 접근가능.
		ob3.func2(); // func2()를 Super에다가 선언만 해놓으면 접근가능. 오버라이드 되기 때문에.
		
		
		
		//Upcasting 상태에서
		//확장된(멤버추가) 멤버변수 접근 가능하다?  X => Downcasting 후 접근가능
		// 확장된(멤버추가) 멤버함수 접근 가능하다? X => Downcasting 후 접근가능 
		// 재정의된 메서드 접근 가능? O 
		
	}
}
