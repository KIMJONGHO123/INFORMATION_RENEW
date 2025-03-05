package Ch10;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class C01ArrayMain {
	public static void main(String[] args) {
//		Scanner sc  = new Scanner(System.in);
//		
//		int arr1 [] = new int [5];
//		System.out.println("배열 길이" + arr1.length);
//		System.out.println("5개의 값을 입력하세요");
//		arr1[0] = sc.nextInt();
//		arr1[1] = sc.nextInt();
//		arr1[2] = sc.nextInt();
//		arr1[3] = sc.nextInt();
//		arr1[4] = sc.nextInt();
//		
//		
//		for (int i = 0; i < arr1.length; i++) {
//			System.out.println(i+"+arr1[i]");
//			
//		}
//		for (int el : arr1) {
//			System.out.println(el);
//		}
//		System.out.println("-----------------------------------------");
//		Arrays.stream(arr1).forEach(el->System.out.println(el));
		
		
		// 배열에 입력된 정수중에 최대값과 최소값을 출력
		
		Scanner input = new Scanner(System.in);
		int arr[] = new int[7];
		
//		// 값 입력
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}
//		
//		// 최대값 구하기
//		int max = arr[0];
//		for (int i = 0; i < arr.length; i++) {
//			if (max < arr[i]) {
//				max = arr[i];
//			}
//		}
//		
//		
//		// 최소값 구하기
//		int min = arr[0];
//		for (int i = 0; i < arr.length; i++) {
//			if (min> arr[i]) {
//				min =arr[i];
//			}
//			
//		}
//		
//		
//		System.out.printf("최대값 : %d 최소값 : %d",max,min);
		
//		Arrays.sort(arr);
//
//		System.out.println(Arrays.toString(arr));
//
//		System.out.printf("최솟값 : %d 최대값 : %d",arr[0], arr[arr.length-1]);
		
		// 새로운 방법
//		System.out.println("MAX : " + Arrays.stream(arr).max().getAsInt() );
//		System.out.println("MIN : " + Arrays.stream(arr).min().getAsInt() );
		
	}
	
}