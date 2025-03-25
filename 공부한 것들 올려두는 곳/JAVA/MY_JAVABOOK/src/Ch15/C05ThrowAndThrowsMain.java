package Ch15;
 
class A{ 
	public void Ex1() throws NullPointerException{

		System.out.println("Ex1 process..1");
		throw new NullPointerException("Ex1 Null Exception");
		
	}
}
class B{
	public void Ex2() throws NullPointerException{
		System.out.println("Ex2 process...1");
		throw new NullPointerException("Ex2 Null Exception");
	}
	
}
public class C05ThrowAndThrowsMain {
	public static void main(String[] args) {
		
		
		System.out.println("실행코드1");
		System.out.println("실행코드2");
		A a = new A();
		B b = new B();
		
		try {
			a.Ex1();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("실행코드3");
	}
}

// thorw는 예외를 만들때 생성
// thorws 예외를 던질때 생성
