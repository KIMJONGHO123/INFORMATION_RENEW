package Ch07;

import java.util.Iterator;
import java.util.Scanner;

public class C02While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 2단 - 9단 출력
		
//		int dan = 2;
//		while (dan<10) {
//			
//			int i=1;
//			
//			while (i<10) {
//				
//				System.out.printf("%d * %d = %d\n", dan, i , dan*i);
//				i++;
//			}
//			System.out.println();
//			dan++;
//		}
		
		// 2단 - 9단 출력 (2x9, 2x8, ......... , 9x9, ..... 9x1)
		
//		int dan =2;
//		while (dan<10) {
//			int i = 9;
//			while (i>0) {
//				System.out.printf("%d * %d = %d\n", dan,i,dan*i);
//				i--;
//			}
//			System.out.println();
//			dan++;
//		}
		
		
		// 9단 - 2단 (9x9 9x8 - 2x1)
		
//		int dan = 9;
//		while (dan >1) {
//			int i = 9;
//			while (i>0) {
//				System.out.printf("%d * %d = %d\n", dan ,i, dan*i);
//				i--;
//			}
//			System.out.println();
//			dan--;
//		}
		
		// 2단 - N단(N<9)
		
		Scanner input = new Scanner(System.in);
		
//		int dan = input.nextInt();
//		
//		while (dan>1&&dan<10) {
//			int i = 1;
//			while (i<10) {
//				System.out.printf("%d * %d = %d\n", dan,i, dan*i);
//				i++;
//			}
//			System.out.println();
//			dan++;
//		}
		
		//N단 - M단 (N<M , N<9, M<9)
		
//		int startDan = input.nextInt();
//		int endDan = input.nextInt();
//		
//		int sd = startDan;
//		int ed = endDan;
//		
//		while (sd<=ed) {
//			
//			int i = 1;
//			while (i<10) {
//				System.out.printf("%d * %d = %d\n",sd, i,sd*i);
//				i++;
//			}
//			System.out.println();
//			sd++;
//		}
		
		
		//별찍기(기본높이:4)
		

//		*****
//		*****
//		*****
//		*****
		
//		int height = input.nextInt();
//		while (height >0) {
//			int width =1;
//			while (width<=5) {
//				
//				System.out.printf("*");
//				width++;
//			}
//			System.out.println();
//			height--;
//		}
	
	
		
		//*
		//**
		//***
		//****

//		int value = input.nextInt();
//		int height=1;
//		while (height<=value) {
//			
//			int count = height;
//			while (count >0) {
//				System.out.printf("*");
//				count--;
//			}
//			
//			int blank = value;
//			while (blank-1 >=0) {
//				System.out.printf(" ");
//				blank--;
//			}
//			System.out.println();
//			
//			height++;
//		}
		
		
		
		//****
		//***
		//**
		//*
		
//		int value = input.nextInt();
//		int height=1;
//		int end= value; // 입력값을 할당한다.
//		int count = value;  // 입력값을 할당한다.
//		
//		while (height<=end) { // 입력받은 회수만큼 반복
//
//			while (count >0) {
//				System.out.printf("*");
//				count--;
//			}
//			value--; // 기준값을 하나 줄인다.
//			count = value; // 별찍는 조건을 하나 줄인 기준값으로 재할당한다.
//			
//			int blank = 1; // 공백 기준을 1로 잡는다.
//			while (blank < end - value) {
//				System.out.printf(" ");
//				blank++;
//			}
//			System.out.println();
//			
//			height++;
//		}
		
		
		//   *
		//  ***
		// *****
		//*******  7개
	
		
//		int height = input.nextInt();
//
//		
//		for (int i = 1; i <= height; i++) {
//			for (int j = 1; j <= height-i; j++) { // 왼쪽 빈칸
//				System.out.printf(" ");
//			}
//			
//			for (int j2 = 1; j2 <= i ; j2++) { // 왼쪽 별
//				System.out.printf("*");
//			}
//			
//			for (int j3 = 1; j3 <= i-1; j3++) { // 오른쪽 별
//				System.out.printf("*");
//			}
//			
//			for (int j4 = 1; j4 <= height-i; j4++) {
//				System.out.printf(" ");
//			}
//			System.out.println();
//		}
			
		
		//*******
		// *****
		//  ***
		//   *

//		int height = input.nextInt();
//
//		
//		for (int i = 1; i <= height; i++) {
//			
//			
//			for (int j = 1; j <= i-1 ; j++) { // 왼쪽 빈칸
//				System.out.printf(" ");
//			}
//			
//			for (int j2 = 0; j2 <= height-i ; j2++) { // 왼쪽 별
//				System.out.printf("*");
//			}
//			
//
//			for (int j3 = 1; j3 <= height-i; j3++) { // 오른쪽 별
//				System.out.printf("*");
//			}
//			
//			for (int j4 = 1; j4 < i; j4++) {  // 뒤에 빈칸은 찍어도 되고 안해도 되고
//				System.out.printf(" ");
//			}
//			System.out.println();
//		}
		
		//   *
		//  ***
		// *****		
		//*******
		// *****
		//  ***
		//   *

		
//		int height = input.nextInt();
//		
//				
//		for (int i = 1; i <= height; i++) {
//			for (int j = 1; j <= height-i; j++) { // 왼쪽 빈칸
//				System.out.printf(" ");
//			}
//			
//			for (int j2 = 1; j2 <= i ; j2++) { // 왼쪽 별
//				System.out.printf("*");
//			}
//			
//			for (int j3 = 1; j3 <= i-1; j3++) { // 오른쪽 별
//				System.out.printf("*");
//			}
//			
//			for (int j4 = 1; j4 <= height-i; j4++) {  //  오른쪽 빈칸
//				System.out.printf(" ");
//			}
//			System.out.println();
//		}
//
////			밑에서 부터는 도형 밑에 부분
//		
//		for (int i = 2; i <= height; i++) {
//			
//			
//			for (int j = 1; j <= i-1 ; j++) { // 왼쪽 빈칸
//				System.out.printf(" ");
//			}
//			
//			for (int j2 = 0; j2 <= height-i ; j2++) { // 왼쪽 별
//				System.out.printf("*");
//			}
//			
//
//			for (int j3 = 1; j3 <= height-i; j3++) { // 오른쪽 별
//				System.out.printf("*");
//			}
//			
//			for (int j4 = 1; j4 < i; j4++) {  // 뒤에 빈칸은 찍어도 되고 안해도 되고
//				System.out.printf(" ");
//			}
//			System.out.println();
//		}
			
		
		
		//*******
		// *****
		//  ***
		//   *		
		//   *
		//  ***
		// *****		
		//*******
		
		
//		int height = input.nextInt();
//		
//		for (int i = 1; i <= height; i++) {
//			for (int j = 1; j <= i-1 ; j++) { // 왼쪽 빈칸
//				System.out.printf(" ");
//			}
//			
//			for (int j2 = 0; j2 <= height-i ; j2++) { // 왼쪽 별
//				System.out.printf("*");
//			}
//			
//
//			for (int j3 = 1; j3 <= height-i; j3++) { // 오른쪽 별
//				System.out.printf("*");
//			}
//			
//			for (int j4 = 1; j4 < i; j4++) {  // 뒤에 빈칸은 찍어도 되고 안해도 되고
//				System.out.printf(" ");
//			}
//			System.out.println();
//		}
//		
//	밑에서부터는 도형 아랫부분
//		for (int i = 1; i <= height; i++) {
//			for (int j = 1; j <= height-i; j++) { // 왼쪽 빈칸
//				System.out.printf(" ");
//			}
//			
//			for (int j2 = 1; j2 <= i ; j2++) { // 왼쪽 별
//				System.out.printf("*");
//			}
//			
//			for (int j3 = 1; j3 <= i-1; j3++) { // 오른쪽 별
//				System.out.printf("*");
//			}
//			
//			for (int j4 = 1; j4 <= height-i; j4++) {
//				System.out.printf(" ");
//			}
//			System.out.println();
//		}
		
		
		
		
	}

}
