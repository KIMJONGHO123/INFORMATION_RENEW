package Ch04;

import java.util.Scanner;

public class C01Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 스트림
		// System.in : 표준입력 스트림 생성(요청)
		// System.out : 표준출력 스트림 생성(요청)
		
		// 코드 해석
//		new Scanner(System.in); : 표준 입력 스트림을 연결한 Scanner 객체 생성
//		Scanner sc : 생성된 Scanner 객체의 위치정보(메모리 주소)를 저장한 참조변수 sc
		
		// 표준입력 스트림에 연결된 Scanner 객체를 생성 이후 위치정보를
		// main Stack영역의 Scanner sc 참조변수에 초기화
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("num 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.printf("num2 입력 : ");
		int num2 = sc.nextInt();
		
		System.out.printf("num3 입력 : ");
		int num3 = sc.nextInt();
		
		System.out.printf("num4 입력 : ");
		int num4 = sc.nextInt();
		
		int sum = num1 + num2 +num3+num4;
		System.out.println(sum);
	}

}
