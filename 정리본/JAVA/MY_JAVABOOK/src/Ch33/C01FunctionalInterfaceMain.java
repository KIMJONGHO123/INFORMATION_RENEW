package Ch33;

@FunctionalInterface
interface Func1{  // 함수형인터페이스 선언(Compiler에게 전달)
	void say(String message); //추상 메서드
	
	// 함수형인터페이스에서는 메서드는 무조건 하나여야 한다.
	
}
public class C01FunctionalInterfaceMain {

	public static void main(String[] args) {
		
		//01
		Func1 func1 = (message)->{System.out.println(message);};
		func1.say("HelloWorld");
		
		Func1 func1_1 = System.out::println;
		func1_1.say("HELLOWORLD");
	}
	// 함수형 인터페이스 사용하면 같은 함수에 다른 로직을 구현할 수 있다.
}