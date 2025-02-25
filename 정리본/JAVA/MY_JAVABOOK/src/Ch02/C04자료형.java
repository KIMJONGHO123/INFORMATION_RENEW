package Ch02;

public class C04자료형 {

	public static void main(String[] args) {
		
//		정수 int - 4 byte 정수 부호 ㅇ
		
//		int n1 = 0b10101101; // 2진수값
//		int n2 = 173;
//		int n3 = 0255;
//		int n4 = 0xad;
//		System.out.printf("%d %d %d %d \n", n1,n2,n3,n4);
		
		
//		정수 byte - 1byte 정수 부호 ㅇ
		
//		byte n5 = (byte)-129;
//		byte n6 = -30;
//		byte n7 = 30;
//		byte n8 = 127;
////		byte n9 = 129;  127초과 해서 에러
//		
////		System.out.printf("%d\n",n9);
//		System.out.println(0b10101101);
//		System.out.println(Integer.toBinaryString(-129));
//		
//		// 정수 short -2byte 정수 부호 ㅇ | char -2byte 정수 부호 x(양수만)
//		
//		char n1 = 65535;  // (0~2^16-1)  (0~65535)
//		short n2 = 32767; // (-2^15 ~ 2^15-1) (-32768 ~ + 32767)
//		
//		char n3 = 60000;
//		short n4 = n3;
//		
//		System.out.printf("%d\n",n4);
		
		// 정수 long -8byte 정수 부호 ㅇ
		
//		long n1 = 10000000000L;
//		long n2 = 20;  // L,l (리터럴접미사) : long 자료형 사용하여 값 저장
//		
//		long n3 = 100000000000;
//		long n4 = 100000000000L;
		
		// 실수 
		
		// 유리수와 무리수의 통칭
//		소숫점 이하값을 가지는 수 123.456
//		float : 4byte 실수 (6-9자리)
//		double : 8 byte 실수 (15 ~ 18 자리), 기본 자료형
		
		// 정밀도 확인
		float n1 = 0.123456789123456789F;
		double n2 = 0.123456789123456789;
		
		System.out.println(n1);
		System.out.println(n2);
		
		// 오차 확인
		float num = 0.1F;
		for (int i = 0; i <= 1E5; i++) {
			num = num+0.1F;
			System.out.println(i);
		}
		System.out.println("num"+ num);
	}

}
