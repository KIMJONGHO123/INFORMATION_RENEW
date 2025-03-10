package Ch15;

public class C01NullpointerExceptionMain {
	public static void main(String[] args) {
		try {
			
			String str = null;
			System.out.println(str.toString());
			System.out.println("HelloWorld");
			System.out.println("Helloworld");
			
		} catch (NullPointerException e) {
			System.out.println("예외발생 : "+e);
			System.out.println(e.getCause()); // 반환값 : 원래 발생한 예외 객체 : null
			System.out.println(e.toString());
			System.out.println(e.getStackTrace()); // 예외 발생 위치 정보를 StackTraceElement[] 배열로 반환
		}
		
//		System.out.println("HelloWorld");
//		System.out.println("HelloWorld");
		
	}
}
