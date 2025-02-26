package Ch03;

public class C01TypeChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// (자료) 형변환
		// 연산시 일치하지 않는 자료형을 일치시키는 작업
		
		// 자동형변환(암시적 형변환) : 컴파일러에 의해 자동 형변환  (작은곳 -> 큰 곳) 
		// 강제형변환(명시적 형변환) : 프로그래머에 의해 강제 형변환
		
		// 자동형변환(=)
		// '변수 연산처리'시 범위가 넓은 공간에 작은값이 대입되는 경우
		// '리터럴 상수 연산처리'시 리터럴 값에 따른 형변환 여부 결정
		// ex
		
//		byte a = 10;
//		int b = a;
		
		// byte > short,char > int >long > float > double
		
		byte byteValue = 10; // 10이라는 int 형 숫자가 byte 자료형에 맞춰서 자동형변환 형변환 1번
		int intValue = byteValue;  // byte 형이 int 형에 자동으로 형변환  형변환 2번
		System.out.println("intValue : " + intValue);
		
		char charValue = '가'; 
		intValue = charValue; // char 형이 int형으로 형변환 된다.
		System.out.println("가 의 유니코드 :" + intValue); // '가'의 유니코드가 출력된다.
		
		 intValue = 50; // 50이라는 숫자가 intValue에 재할당
		 long longValue = intValue; // intValue가 long형의 변수에 자동으로 형변환
		 System.out.println("longValue : "+ longValue);
		 
		 longValue = 100; // 100이라는 숫자가 long 형인 longValue 변수에 재할당
		 float floatValue = longValue; // long 형이 float 형으로 자동으로 형변환
		 System.out.println("floatValue : " + floatValue);
		 
		 floatValue = 100.5f;  // float형인 floatValue 변수에 100.5f로 재할당
		 double doubleValue = floatValue; // double 형으로 형변환
		 System.out.println("doubleValue : " + doubleValue);
		

	}

}
