package Ch04;

import java.util.Scanner;

public class C04Scanner {

	public static void main(String[] args) {
		// 이름을 입력하세요? 홍길동
		// 홍길동 님의 나이를 입력하세요? 35
		// 홍길동 님의 주소를 입력하세요? 대구광역시 달서구 000
		// 홍길동 님의 나이는 35세 주소는 대구광역시 ~~ 입니다
		
		Scanner input = new Scanner(System.in);
		
		System.out.printf("이름을 입력하세요 : ");
		String name = input.next();
		
		System.out.printf("%s 님의 나이를 입력하세요 : ",name);
		int age = input.nextInt();
		
		input.nextLine(); // 버퍼 제거
		
		System.out.printf("%s 님의 주소를 입력하세요 : ", name);
		String address = input.nextLine();
		System.out.println(name +"님의 나이는 " + age + "세 주소는 "+address+"입니다." );
		

	}

}
