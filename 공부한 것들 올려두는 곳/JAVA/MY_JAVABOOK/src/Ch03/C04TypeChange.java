package Ch03;

public class C04TypeChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 정수 연산식 (int 보다 작은 변수자료형(short, char, byte))
		// int 로 자동 형변환
//		byte x = 10;
//		byte y = 20;
//		byte result1 = (byte)(x+y); // 연산을 처리하면 자동으로 int형으로 형변환이 된다. 
//		//그래서 byte형으로 강제 형변환을 시켜줘야한다.
//		
//		int result2 = x+y;
//		System.out.println(result1);
		
		// 정수 연산식(int 보다 큰 변수 자료형(long))
		// 큰 타입으로 자동 형 변환
		byte var1 = 10;
		int var2 = 100;
		long var3 = 1000L;
		int result = (int)(var1 + var2 + var3);
		
		long result2 = var1 +var2 + var3;
		System.out.println(result2);
		
		
		// 실수 연산식
		// 큰 타입으로 자동 형 변환
		
		int intvar = 10;
		float flvar = 3.15f;
		double dbvar = 5.5;
		int result3 = (int)(intvar + flvar+ dbvar);  // 계산 결과값이 int 저장공간 보다 큰 경우에는 데이터 손실이 발생한다.
		double result4 = intvar+ flvar+ dbvar; // 그래서 애초에 이렇게 해주는게 좋음
		System.out.println(result3);
		System.out.println(result4);
	}

}
