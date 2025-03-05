package Ch09;

import javax.swing.LayoutStyle;

public class C05StringClass {
	public static void main(String[] args) {
		
		String str1 = "Java Powerful";
		String str2 = new String("Java Programming");
		String str3 = str1+str2;
		String str4 = str1.concat(str2); // concat는 공간을 새롭게 만든다.
//		
//		System.out.printf("%x\n",System.identityHashCode(str1));
//		System.out.printf("%x\n",System.identityHashCode(str2));
//		System.out.printf("%x\n",System.identityHashCode(str3));
//		System.out.printf("%x\n",System.identityHashCode(str4));
//		
//		System.out.println(str3);
//		System.out.println(str4);
//		
//		int i =0;
//		String str = "";
//		
//		while (i<10) {
//			str+=i;
//			System.out.print("str : "+ str+" ");
//			System.out.printf("위치 : %x\n",System.identityHashCode(str));
//			i++;
//		}
//		String은 불변 객체이므로 += 연산을 반복하면 매번 새로운 객체가 생성됨 (성능 비효율)
//		concat도 같음. => StringBuilder or StringBuffer 사용
		
		
		
		// 문자열 덧붙이기(메모리 누수 방지 클래스 : StringBuffer, StringBuilder)
		
//		int i=0;
//		StringBuilder str = new StringBuilder();
//		
//		while (i<10) {
//			
//			str.append(i);
//			System.out.print("str : " + str+" ");
//			System.out.printf("위치 : %x\n",System.identityHashCode(str));
//			i++;
//		}
		
		
		System.out.println("문자열 길이 : " + str1.length());
		System.out.println("한문자 찾기 : " + str1.charAt(2));
		System.out.println("인덱스 찾기 : " + str1.indexOf('a'));
		System.out.println("인덱스 찾기 : " + str1.lastIndexOf('a'));
		System.out.println("문자열 포함 여부 : " + str1.contains("va"));
		System.out.println("문자열 포함 여부 : " + str1.contains("abs"));
		System.out.println("문자열 자르기 : " + str1.substring(2,6));
		
		String str6 = "등산,탁구,축구,골프,독서,영화감상";
		String result[] = str6.split(",");
		
		for (String hobby : result) {
			System.out.println(hobby);
		}
	}
}
