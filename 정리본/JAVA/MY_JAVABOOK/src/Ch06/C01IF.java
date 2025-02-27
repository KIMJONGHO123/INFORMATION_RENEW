package Ch06;

import java.util.Scanner;

public class C01IF {
	public static void main(String[] args) {
		
		
		// 단순 IF
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("나이 : ");
//		int age = sc.nextInt();
//		
//		if (age >= 8) {
//			System.out.println("학교에 다닙니다.");
//			
//		}
//		System.out.println("첫번쨰 IF 코드 블럭 종료 ...");
//		
//		if (age < 8) {
//			System.out.println("학교에 다니지 않습니다");
//		}
//		System.out.println("두번째 IF 코드 블럭 종료 ..");
//		System.out.println("프로그램을 종료합니다.");
		
		
		
		// IF-ELSE
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("나이 : ");
//		int age = sc.nextInt();
//		
//		if (age >= 8) {
//			System.out.println("학교에 다닙니다.");
//			
//		}else {
//			System.out.println("학교에 다니지 않습니다.");
//		}
//		
//		System.out.println("프로그램을 종료합니다.");
		
		
		// 문제
		// 정수 한개값을 입력받아 3의 배수이면 해당 수를 출력하세요
		// 3의 배수이면서 5의 배수라면 출력
		
		Scanner input = new Scanner(System.in);
		
//		int num = input.nextInt();
//		
//		if (num % 3==0) {
//			System.out.println("3의 배수 : " +num);
//			if(num % 5 ==0) {
//				System.out.println("3의 배수이면서 5의 배수 : "+num);
//			}
//		}
		
		// 문제 
		// 두개의 정수를 입력받아 큰 수 출력
		
//		int num1 = input.nextInt();
//		int num2 = input.nextInt();
//		
//		if (num1> num2) {
//			System.out.println("num1이 num2보다 더 큽니다.");
//		}else {
//			System.out.println("num2가 num1보다 더 큽니다");
//		}
		
		// 문제 
		// 세개의 정수를 입력받아 큰 수 출력
		
//		int integer1  = input.nextInt();
//		int integer2 = input.nextInt();
//		int integer3 = input.nextInt();
//		
//		if (integer1 > integer2) {
//			if (integer1 > integer3) {
//				System.out.printf("%d이 제일 큽니다.",integer1);
//			}else if(integer1 < integer3){
//				System.out.printf("%d이 제일 큽니다.", integer3);
//			}
//			
//		}else if(integer1 < integer2) { 
//			if (integer2 > integer3) {
//				System.out.printf("%d이 제일 큽니다.", integer2);
//			}else if(integer2 < integer3) {
//				System.out.printf("%d이 제일 큽니다.", integer3);
//			}
//		}
//		else {
//			System.out.println("세 개의 수가 동일합니다.");
//		}
		
		// 다른 변수에 담아서 비교하는 방법
		
//		int max = integer1;
//		if (max < integer2) {
//			max = integer2;
//		}
//		if (max < integer3) {
//			max = integer3;
//		}
//		
//		System.out.println(" 큰 수 : " + max);
		
		// 세개의 정수를 입력받아 해당수의 합과 평균을 출력
		
//		int itg1 = input.nextInt();
//		int itg2 = input.nextInt();
//		int itg3 = input.nextInt();
//		
//		int sum = itg1 + itg2 +itg3;
//		int avg = sum/3;
//		
//		System.out.printf("%d %d",sum, avg);
		
		// 문제
		// 입력한 수가 짝수이고, 3의 배수라면 출력
		// 입력한 수가 홀수이고, 5의 배수라면 출력
		
//		int number = input.nextInt();
//
//		
//		if (number % 2 ==0 && number %3 ==0) {
//			System.out.println(number);
//		}else if(number % 2 !=0 && number % 5 ==0) {
//			System.out.println(number);
//		}
		
		
//		IF - ELSE IF - ELSE
		
		// 과목 1,2,3,4 중 하나라도 40점 미만이면 불합격
		// 과목평균이 100점 기준으로 60점 미만이면 불합격
		// 아니면 합격
		
//		Scanner sc = new Scanner(System.in);
//		 int 과목1 = sc.nextInt();
//		 int 과목2 = sc.nextInt();
//		 int 과목3 = sc.nextInt();
//		 int 과목4 = sc.nextInt();
//		 double 평균 = (double)(과목1+과목2+과목3+과목4)/4;
//		 
//		 if (과목1 < 40) {
//			System.out.println("불합격");
//		}else if (과목2 < 40) {
//			System.out.println("불합격");
//		}else if (과목3 < 40) {
//			System.out.println("불합격");
//		}else if (과목4 < 40) {
//			System.out.println("불합격");
//		}else if(평균 <60){
//			System.out.println("불합격");
//		}else {
//			System.out.println("합격");
//		}
		 
		// 문제 
		
		// 시험 점수를 입력받아
		// 90 ~ 100 점은 A,
		// 80 ~ 89 점은 B,
		// 70 ~ 79점은 C,
		// 60 ~ 69점은 D,
		// 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
		
		int score = input.nextInt();
		
		if (score >= 90) {
			System.out.println("A");
		}else if(score >= 80) {
			System.out.println("B");
		}else if(score >=70) {
			System.out.println("C");
		}else if(score >= 60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
		
		
		// 문제
		
		// 나이별로 요금을 부과하는 else if문을 만드세요
		// 8세 미만 : 요금은 1000원
		// 14세 미만 : 요금은 2000원
		// 20세 미만 : 요금은 2500원
		// 20세 이상 : 요금은 3000원
		
		
		int age = input.nextInt();
		
		if (age>=20) {
			System.out.println("요금은 3000원");
		}else if(age >= 14) {
			System.out.println("요금은 2500원");
		}else if(age >= 8) {
			System.out.println("요금은 2000원");
		}else {
			System.out.println("요금은 1000원");
		}
		
	}
}
