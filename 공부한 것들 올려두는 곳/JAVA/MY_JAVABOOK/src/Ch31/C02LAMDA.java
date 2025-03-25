package Ch31;

import java.util.Scanner;

interface Printer{
//	void print(String message); // 추상메서드
//	String print_2(String messaage);  // 추상메서드
	String print();  // 추상메서드
}
public class C02LAMDA {
	public static void main(String[] args) {
		// 01
//		Printer printer = (message)->{System.out.println(message);};
//		printer.print("HElloWORLD");
		
		
		//02
//		Printer printer = (me)->{return me;};
//		String returnVlaue = printer.print_2("Test");
//		System.out.println(returnVlaue); // TEST_HELLOWLORLD가 출력
		
		// 03 (키보드로 입력받아 String 반환)
		
		Printer printer = ()->{
			Scanner input = new Scanner(System.in);
			System.out.println("입력 : ");
			String str = input.nextLine();
			input.close();
			return str;};
			
		String returnValue = printer.print();
		System.out.println(returnValue);
		
		
	}
}
