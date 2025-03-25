package Ch04;

import java.util.Scanner;

public class C03Scanner2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력 : ");
		
		int num1 = sc.nextInt();
		System.out.println("입력된 정수 값 : "+num1);

//		정수입력받고 엔터 누르면 버퍼 공간에 엔터가 남아있어서 문자열 입력 
//  	받지 못하고 끝난다.
//		nextLine()만 그렇다.
		
		sc.nextLine(); // nextLine을 하나 더 쓰면서 버퍼 문제 해결
		System.out.println("문자열입력(띄어쓰기) : ");
		String str2 = sc.nextLine();
		System.out.println("문자열 : "+ str2);
		

		
		
		
		
//		System.out.println("실수 입력 : ");
//		double num2 = sc.nextDouble();
//		System.out.println("입력된 실수 값 : "+num2);
		
//		System.out.println("문자열 입력 : ");
//		String str1 = sc.next(); // next()는 문자열 입력 받는 Scanner클래스의 메서드이다. 띄어쓰기 하면 띄어쓰기 바로 전까지만 입력받음.
//		System.out.println("입력된 문자열 : "+str1);

//		
//		System.out.printf("문자열 : %s%s%s\n", s1,s2,s3);
		
		
		
		}
}
