package Ch05;

import java.util.Scanner;

public class C02Ex {

	public static void main(String[] args) {
		
		//1.문제(삼항연산자)
		// 키보드로 국어/영어/수학 점수를 입력받아 각각의부분점수가 40점이상이고
		// 총점수 평균이 70점이상이면 '합격'
		// 미만이면 '불합격'을 출력합니다
		
		Scanner input = new Scanner(System.in);
		
		int Korean = input.nextInt();
		int English = input.nextInt();
		int Math = input.nextInt();
		
		String sentence = (Korean + English + Math)/3 > 70 ? "합격" : "불합격";
		System.out.println(sentence);
		
		
		//2.미니문제(%연산자)
		//키보드로 부터 정수값 2 를 입력받아
		//두수의 합이 짝수이면 "짝수입니다"
		//홀수이면 "홀수입니다" 를 출력하세요~
		
		int n1 =input.nextInt();
		int n2 = input.nextInt();
		
		if ((n1+n2)%2 ==0) {
			System.out.println("짝수입니다.");
		}else {
			System.out.println("홀수입니다.");
		}
		
		//3.문제
		//국어 / 영어 / 수학 점수를 입력받아서
		//국어 점수가 40점이상
		//영어 점수가 40점이상
		//수학 점수가 40점이상이면서 전체평균이 60점이상이면 합격을 출력
		//아니면 불합격을 출력하세요
		//삼항연산자와 논리연산자를 이용합니다.
		
		int Korea_score = input.nextInt();
		int English_score = input.nextInt();
		int Math_score = input.nextInt();
		
		int avg =( Korea_score+English_score+Math_score)/3;
		if (Korea_score>=40 && English_score >=40 && Math_score>=40 && avg>=60 ) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
		
		// 삼항 연산자 사용
		String result = (Korea_score>=40 && English_score >=40 && Math_score>=40 && avg>=60) ? "합격" : "불합격";
		System.out.println(result);
		
		input.close();
	}

}
