package Ch14;

public class C04WrapperMain {
	public static void main(String[] args) {
		
		// Boxing (기본자료형 -> Wrapper Class)
		Integer ob1 = new Integer(100);
		Integer ob2 = new Integer("100");
		Integer ob3 = Integer.valueOf("300");
		System.out.println(ob1+ob2+ob3);
		
		// unBoxing
		int n1 = ob1.intValue();
		int n2 = ob2.intValue(); // Wrapper class에서 기본 타입으로 값을 변환하는 메서드이다.
		int n3 = ob3.intValue(); 
		System.out.println(n1+n2+n3);
		
		// Auto Boxing
		Integer ob4 = 100; // Wrapper class에서 기본 타입으로 값이 자동으로 변환된다.
		int n4 = ob1 + ob2 + ob3;
		
	}
}
