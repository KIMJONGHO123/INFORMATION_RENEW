package Ch01;

public class Ch01SystemOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// System.out.print()
		// \n : 개행 , 줄바꿈
		// \b : 백스페이스
		// \t : 탭길이(기본 8칸) 만큼 커서 이동
//		System.out.print("HelloWorld\n");
//		System.out.print("HelloWorld\n");
//		System.out.print("HelloWorld\n");
//		System.out.print("HelloWorld\n");		
		
		
		// System.out.printf
		// format : 형식, 지정
		// %d : 10진수 정수 서식문자
		// %f : 10진수 실수 서식문자
		// %c : 한문자 서식문자
		// %s : 문자열 서식문자
		System.out.printf("%d %d %d\n", 10,20,30);
		System.out.printf("%f %f %f\n", 10.1,20.2,30.3);
		System.out.printf("%c %c %c\n", 'A','B','C');
		System.out.printf("%s %s %s\n", "THis is","String","Test");
		System.out.printf("%d.%s : %d", 1,"국어",100);
		
		
		// println
		
		System.out.println("HelloWorld\n");
		System.out.println("HelloWorld\n");
		System.out.println("HelloWorld\n");
		System.out.println("HelloWorld\n");		
		
		
	}

}
