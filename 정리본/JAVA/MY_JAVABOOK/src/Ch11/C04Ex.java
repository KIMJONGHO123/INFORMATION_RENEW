package Ch11;

import java.util.Arrays;

//다음 2개의 static 가진 ArrayUtils 클래스를 만들어보자. 다음 코드의 실행 결과를 참고하여 concat()와 print()를 작성하여 ArrayUtil 클래스를 완성하라.

class ArrayUtils {
	public static int[] concat(int[] a, int[] b) {
		/* 배열 a와 b를 연결한 새로운 배열 리턴 */
		int newArr[] = new int[a.length+b.length];
		
		int i =0;
		for ( i= 0; i < a.length; i++) {
			newArr[i] = a[i];
		}
		for (int j = i; j < b.length+i; j++) {
			newArr[j] = b[j-i];
			
		}
		return newArr;
	}

	public static void print(int[] array3) {
		// TODO Auto-generated method stub
		
		System.out.println(Arrays.toString(array3));
	}


}

public class C04Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = { 1, 5, 7, 9 };
		int[] array2 = { 3, 6, -1, 100, 77 };
		int[] array3 = ArrayUtils.concat(array1, array2);
		ArrayUtils.print(array3);
	}
}
