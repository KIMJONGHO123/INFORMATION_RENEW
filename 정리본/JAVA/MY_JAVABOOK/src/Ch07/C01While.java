package Ch07;

import java.util.Iterator;
import java.util.Scanner;

public class C01While {
	public static void main(String[] args) {
		
		// 10번 박복 - "EHWLLO WORLD"
		// 탈출용 변수 : i=9;
		// 탈춫용 조건식 : i < 10;
		// 탈출용 연산 : i++;
//		Scanner sc= new Scanner(System.in);
//		int n = sc.nextInt();
//		int i =9;
//		while (i <n) {
//			System.out.println("HELLO WORLD");
//			i++;
//			
//			
//		}
		
		// 03 기본 1부터 - 10까지의 합
		
//		int i = 1;
//		int sum=0;
//		while (i<=10) {
//			System.out.println("i : "+i);
//			sum+=i;
//			i++;
//			
//		}
//		System.out.println("SUM : " + sum);
		
		// 04 기본 - 1부터 N까지 합
		Scanner input = new Scanner(System.in);
//		int n = input.nextInt();
//		int i = 1;
//		int sum=0;
//		while (i<=n) {
//			sum+=i;
//			i++;
//			
//		}
//		System.out.println(sum);
		
		// 05 기본 - N부터 M까지 합(N<N) - N>=M인경우 N과 M을 Swap하고 진행합니다.
//		int n = input.nextInt();
//		int m = input.nextInt();
//		int sum=0;
//		if (n>=m) {
//			int tmp;
//			tmp = n;
//			n =m;
//			m = tmp;
//		}
//		int i =n;
//		
//		while (i<=m) {
//			sum+=i;
//			i++;
//		}
//		System.out.println(sum);
		
		
		// 06 n - m 까지 수중(N < M) 짝수의 합, 홀수의 합을 각각 구해서 출력하세요
		// 예시)
		// n =3(키보드로 입력된 값)
		// m = 7 (키보드로 입력된 값)
		// 짝수의 합 : 10
		// 홀수의 합 : 15
		
//		int n = input.nextInt();
//		int m = input.nextInt();
//		
//	  	if (n>=m) {
//				int tmp;
//				tmp = n;
//				n =m;
//				m = tmp;
//			}
//
//		int i = n;
//		int EvenSum = 0; //짝수의 합
//		int OddSum = 0; // 홀수의 합
//		
//		while(i <= m) {
//			if (i % 2 ==0) {
//				EvenSum+=i;
//			}else {
//				OddSum+=i;
//			}
//			i++;
//		}
//		System.out.println("짝수의 합 : " + EvenSum);
//		System.out.println("홀수의 합 : " + OddSum);
		
		// 07 1 - N 까지 수 중에 4의 배수를 출력하고 4의 배수가 아닌 나머지의 합을 구하세요
		
//		int n = input.nextInt();
//		int start =1;
//		int sum = 0;
//		
//		while (start <= n) {
//			if (start % 4 ==0) {
//				System.out.println(start);
//			}
//			else {
//				sum += start;
//				
//			}
//			start++;
//		}
//		System.out.println("4의 배수가 아닌 값들의 합은 : " +sum);
		
		// 08 구구단 N단을 출력하세요 (2<=N<=9)
		
		// while문 사용
		
		// 구구단 전체 출력
//		int start=	2;
//		int end =9;
//		while (start <= end) {
//			
//			int i = 1;
//			while (i <= 9) {
//				System.out.printf("%d * %d = %d\n", start,i, start*i);
//				i++;
//				System.out.println("");
//			}
//			start++;
//			
//		}
		
		
		int start=	input.nextInt();
		int end =9;
		
		while(start <2 || start >9) {
			System.out.println("범위가 잘못됬습니다");
			start = input.nextInt();
			
		}
		int i = 1;
		while (i <= end) {
			System.out.printf("%d * %d = %d\n", start,i, start*i);
			i++;
			System.out.println("");
		}
			
		
//		
//		// for문 사용
//		for (int i = 2; i <= 9; i++) {
//			for (int j = 1; j <= 9; j++) {
//				System.out.printf("%d * %d = %d\n", i,j,i*j);
//				
//			}
//		}
	}
}
