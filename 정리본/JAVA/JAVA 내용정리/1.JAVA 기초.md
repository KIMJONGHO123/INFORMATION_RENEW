# JAVA 기초

## JAVA 시작전 배경

- COMPUTE : 계산하다
- COMPUTER : 계산기

가장 중요한거

- 데이터를 어떻게 저장할지
- 저장한 데이터를 어떻게 사용할지

### JAVA란?

- 절차지향 문법(C) + 객체지향 문법(C++)

이클립스에서 System.out.println 단축키 : 

sysout

인텔리제이에서 System.out.println 단축키 : 

sout

### 서식문자가 왜 생겼냐?

한번에 여러 자료형들을 표시하기 위해서 

# 자바 기본 문법

## Ch00

### Ch00Helloworld

```java
package Ch00;
// package : 폴더 개념
public class Ch00Helloworld { // 클래스 영역 (객체지향 개념이 적용되는 범위)

	public static void main(String[] args) { // 메서드 영역 (절차지향 개념이 적용되는 범위)
		System.out.println("Hellow world");
		
		// 메서드 종류
		// 라이브러리 메서드 : 미리 만들어져 제공되는 메서드
		// 사용자 정의 메서드 : 개발자에 의해 만들어지는 메서드
		// main 메서드 : 최초 실행 메서드
		
	}

}

```

## Ch01

### Ch01SystemOut

```java
package Ch01;

public class Ch01SystemOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// System.out.print()
		// \n : 개행 , 줄바꿈
		// \b : 백스페이스
		// \t : 탭길이(기본 8칸) 만큼 커서 이동
//		System.out.print("HelloWorld\n");
//		System.out.print("HelloWorld\n");
//		System.out.print("HelloWorld\n");
//		System.out.print("HelloWorld\n");		
		
		
		// System.out.printf
		// format : 형식, 지정
		// %d : 10진수 정수 서식문자
		// %f : 10진수 실수 서식문자
		// %c : 한문자 서식문자
		// %s : 문자열 서식문자
		System.out.printf("%d %d %d\n", 10,20,30);
		System.out.printf("%f %f %f\n", 10.1,20.2,30.3);
		System.out.printf("%c %c %c\n", 'A','B','C');
		System.out.printf("%s %s %s\n", "THis is","String","Test");
		System.out.printf("%d.%s : %d", 1,"국어",100);
		
		
		// println
		
		System.out.println("HelloWorld\n");
		System.out.println("HelloWorld\n");
		System.out.println("HelloWorld\n");
		System.out.println("HelloWorld\n");		
		
		
	}

}

```

## Ch02

### C01 진수

```java
package Ch02;

public class C01진수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		10진수			2진수
//		0			   0
//		1			   1
//		2			  10
//		3			  11
//		4			 100
//		5			 101
//		6			 110
//		7			 111
//		8			1000
//		9			1001
//		------------------------------
//		1bit : 2^1 = 2(0~1)
//		2bit : 2^2 = 4(0~3)
//		3bit : 2^3 = 8(0~7)
//		4bit : 2^4 = 16(0~15)
//		5bit : 2^5 = 32(0~31)
//		6bit : 2^6 = 64(0~63)
//		7bit : 2^7 = 128(0~127)
//		8bit : 2^8 = 256(0~255)
//		9bit : 2^9 = 512(0~511)
//		10bit: 2^19 =1024(0~1023)
//		--------------------------------
//		1	1	1	1	1	1	1	1
//		*	*	*	*	*	*	*	*
//		2^7	2^6	2^5	2^4	2^3	2^2	2^1	2^0
//
//		128	64	32	16	8	4	2	1

		// 2진수 - > 10진수
		// 10101100 = 128 + 32 + 8 + 4
		// 10011010 = 128 + 16 + 8 + 2
		// 01101001 = 64 + 32 + 8 + 1
		// 10010010 = 128 + 16 + 2

		// 10진수 -> 2진수
		// 192 -> 11000000
		// 224 -> 11100000
		// 252 -> 11111100
		// 12 -> 00001100
		// 15 -> 00001111

		// %d : 10진 서식문자
		// %o : 8진 서식문자
		// %x : 16진수 서식문자

		// 코드 예쁘게 정렬하기 ctrl + shift +f
		System.out.printf("10진수 : %d\n", 0b00001111);
		System.out.printf("10진수 : %d\n", 173); // 10진수
		System.out.printf("10진수 : %d\n", 0255); // 8진수 (0 : 8진수를 의미하는 접두사)
		System.out.printf("10진수 : %d\n", 0b00001111); // 16진수 (0x:16진수를 의미하는 접두사)

		System.out.printf("8진수 : %o\n", 173); // 10진수
		System.out.printf("8진수 : %o\n", 0255); // 8진수 (0x:8진수를 의미하는 접두사)
		System.out.printf("8진수 : %o\n", 0xAD); // 16진수 (0x:16진수를 의미하는 접두사)

		System.out.printf("16진수 : %x\n", 173); // 10진수
		System.out.printf("16진수 : %X\n", 0255); // 8진수 (0 :8진수를 의미하는 접두사)
		System.out.printf("16진수 : %X\n", 0xAD); // 16진수 (0x:16진수를 의미하는 접두사)

	}

}

```

### 기본 자료형

<aside>
💡

primitive == 원시타입 == 기본자료형 (선 공간 형성)

- byte(1 byte)  / 음수 양수
- short(2 byte) / 음수 양수
- char(2 byte)  / 양수값만 지원
- int (4 byte) - 기본 / 음수 양수
- long (8 byte) / 음수 양수

실수

- float(4 byte)
- double(8 byte) - 기본

단일 문자

- char(2 byte)
</aside>

<aside>
💡

문자열

- String 클래스 (동적공간 할당)
</aside>

### C02 음수

```java
package Ch02;

//컴퓨터 (CPU)는 구조상 덧셈처리를 할 수 있다.(O)
//컴퓨터 (CPU)는 구조상 뺄셈연산을 할 수 없다.(X)
//컴퓨터 (CPU)는 뺄셈요청시 뺄셈처리는 할 수 있다.(O)
//보수개념을 도입해서 뺄셈처리를 수행하기 때문에 가능
//
//7 -4 = 3
//
//7 + 6 = 3
//
//77 - 32 = 45
//77 + 68 = 45 (보수 145에서 1 뺴면 됨)
//
//   00000101 = 5
//   11111010 = -6(1의 보수)
//+  00000001 = 
//+           = -5 (2의 보수)
//-----------------
//   00000000 = 0 

//문제
//음수값임을 고려하여 풉니다
//10 진수 	-> 2진수
//111 		-> 
//-111 		-> 
//96		-> 
//-96		-> 
//31 		-> 
//-31		-> 

//2진수		-> 10진수
//10101111 	-> 81
//00110101	-> 52
//11001100	-> 
//10101010	-> 

public class C02음수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}

```

### c03 변수_자료형

```java
package Ch02;

public class C03변수_자료형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Data(수,자료) : 선 저장 / 후 처리
		// 변수 : 개발자의 유지보수 측면에서 바뀔 예정이 큰 수
		// 변수명 : 저장되어져 있는 변수 공간에 접근하기 위한 문자 형태의 주소
		
		// lv(공간) = rv(값)    rv를 먼저 처리(저장 or 연산) 한 다음 lv에 대입
		
		int num1;  // 4 byte 정수 공간 형성 + num1 이름 부여 (변수 정의)
		num1 = 10;  // 10 리터럴 상수값 상수 Pool 저장, num1 공간에 값 대입(복사)
		int num2 = 4;  // 4 리터럴 상수값 상수 Pool 저장, 4 byte 정수 공간 num2 에 초기값으로 대입
					   // num2에 4로 초기화
		int num3 = num1 +num2;  // num1 안의 값과 num2안의 값의 + 연산결과 값을 4byte 정수 공간 num3에 초기화
		System.out.println(num3); // num3 안의 값을 println
	}

}

```

### C04 자료형

```java
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
//		float n1 = 0.123456789123456789F;
//		double n2 = 0.123456789123456789;
//
//		System.out.println(n1);
//		System.out.println(n2);

		// 오차 확인
//		float num = 0.1F; // 자바에서는 기본적으로 소수는 double로 인식 그래서 float으로 표현할려면 f 붙여야한다. 그래야 타입 불일치가 일어나지 않는다.
//		for (int i = 0; i <= 1E5; i++) { // 1E5 는 1 * 10^5 이다.
//			num = num + 0.1F;
//			System.out.println("나는 num : " + num);
//			System.out.println(i);
//		}
//		System.out.println("num" + num);

		// 단일 문자 char 2byte 정수

//		char ch1 = 'a';
//		System.out.println(ch1);
//		System.out.println((int) ch1); // 011000001
//
//		char ch2 = 98;
//		System.out.println(ch2);
//		System.out.println((int) ch2); // 011000010
//
//		char ch3 = 'b' + 1;
//		System.out.println(ch3);
//		System.out.println((int) ch3); // 011000011
//
//		byte ch4 = 'c' + 2;
//		System.out.println((char) ch4);
//		System.out.println(ch4); // 011000011
//
//		char ch5 = 0xac00;
//		char ch6 = 44032;
//
//		System.out.println(ch5);
//		System.out.println(ch6);
//		System.out.println((char) (0b1010110000000000 + 1));
//
//		char ch6 = 0xac00 + 1;
//		System.out.printf("%c %c\n", ch5, ch6);
		
		
		// \\u :유니코드값 이스케이프문자
//		System.out.printf("%c\n", '\uACa1');
//		
//		System.out.printf("TEST : %c\n", '\uabcd');
//		
//		
//		char n = 10;
//		System.out.printf("HELLO %c WORLD", n);
		
		//--------------------
		//문자열 : String (클래스자료형)
		//--------------------
				
				//기본자료형(원시타입)
//				byte n1;
//				short n2;
//				double n3;
//				long n4;
				
				//클래스자료형
				//클래스자료형으로 만든변수는 '참조변수'라고 하고
				//참조변수는 데이터가 저장된 위치정보(메모리주소값)이 저장된다.
//				int n1 = 10;
//				byte n2 = 20;
//				char n3 = 40;
//				String name = "홍길동";
//				String job = "프로그래머";
//				System.out.println(name);
//				System.out.println(job);

				//--------------------
				//boolean : 논리형(true/false 저장)
				//--------------------
				
//				boolean flag = (10>11); 	// 참(긍정)
//				if(flag) 
//				{
//					System.out.println("참인경우 실행");				}
//				else 
//				{
//					System.out.println("거짓인경우 실행");
//				}
	}

}

```

### C05 상수

```java
package Ch02;

public class C05상수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 리터럴 상수 : 이름부여 x , 상수 Pool에 저장, 단순한 수치, 값
		// 심볼릭 상수 : 이름부여 O, final 예약어 사용
		
		// 리터럴 접미사 : 리터럴 상수가 저장되는 자료형을 지정
		// l,L : long 자료형
		// f,F : float 자료형
		
		int a ='a';
		System.out.println((int)a);
		System.out.println((char)a);
		
		// int n1= 100;   // 100은 리터럴 상수
//		final int n2 = 200; // n2는 심볼릭 상수
//		
//		final double PI = 3.14;
//		
//		double result = PI*4*4;
	}

}

```

### C06 정리문제

```java
	정수 타입 		: byte,short,int ,long
	char 타입 	: ' ' 
	String 타입 	: " "
	실수 타입 		: double , float
	논리 타입 		: boolean

	확인 문제1

	정수타입 
	1byte : byte  (숫자 127까지 가능)
	2byte : char / short
	4byte : int 
	8byte : long 

	실수타입
	4byte : float
	8byte : double

	논리타입
	1byte : boolean

	확인문제2
	
	
	맞는 코드인지 틀린 코드인지 확인 
	byte var = 200;							( x	)
	char var='AB';							( x )
	char var=65;							( o )
	long var=50000000000;					( x ) // int 범위 벗어난다.	
	float var = 3.14						( x	) // 3.14는 double 리터널이다. 3.14f 하면 맞다.
	double var = 100.0						( o )
	String var = "나의직업은 "개발자" 입니다.";	( x ) // 문자열 안에 "" 사용할려면 이스케이프 사용해야 한다.
	boolean var = 0;						( x )
	int v2 = 1e2;							( ㅇ	) // 100.0 이고 기본적으로 double로 인식된다. 자바에서는 지수표기법은 기본적으로 double 형이다.
	float v3 =1e2f;							( ㅇ )
	
```

## Ch03

### C01 TypeChange

```java
package Ch03;

public class C01TypeChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// (자료) 형변환
		// 연산시 일치하지 않는 자료형을 일치시키는 작업
		
		// 자동형변환(암시적 형변환) : 컴파일러에 의해 자동 형변환
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

```

<aside>
💡

float : 4byte 

long : 8byte

float이 long 보다 더 큰 수를 저장 할 수 있는 이유 : 

float은 소숫점을 저장할 수 있는 공간을 가지고 있다.

그래서 지수부 덕분에 아주 큰 값부터 아주 작은값까지 넓은 범위를 저장할 수 있습니다.

byte a = 10;  // 10이 int 형으로 먼저 저장이 되고 이 값이  크기 않기 때문에 byte에 자동 형변환이 된다.

int b = a; // a는 byte형이기 때문에 int가 long 보다 커서 아무 문제 없이 형 변환이 된다.

long a = 100;

int b = a;

// 자동 형변환이 되지 않는다. long이 int  보다 저장공간이 크기 때문이다. 

명시적 형변환으로 int b = (int) a ; 하면 가능하긴 하다 

BUT 데이터 손실이 발생할 수 있다. (큰 곳에서 작은 곳으로 들어가니까)

</aside>

### C02 TypeChange

```java
package Ch03;

public class Ch02TypeChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// 강제 형변환 // (큰 곳 -> 작은 곳)
		// 좁은 범위공간에 큰값을 넣을려고 하는 경우
		// 기본적으로 부락능하기 때문에 강제로 자료형을 바꾸어 전달한다.
		// 데이터 손실의 염려가 있다.
		 
		int intValue = 44032;
		char charValue = (char)intValue; // 44032가 char형으로 강제형변환된다.
		System.out.println((int)charValue); // 출력할때는 다시 int형으로 형변환해서 원래대로 출력
		
		long longValue =  500;
		intValue = (int)longValue; // long 을 int로 강제 형변환을 하면 데이터 손실이 생길 수도 있다. 근데 여기서는 숫자가 500이기때문에 데이터 손실이 생기지 않는다. 
		System.out.println(intValue);
		
		// 데이터 손실
		double doubleValue = 3.14;
		intValue  = (int)doubleValue; // double 형을 int형으로 강제 형변환을 하면 뒤에 소수점은 다 날라간다.
		System.out.println(intValue);
	}

}

```

### C03 TypeChange

```java
package Ch03;

public class C03TypeChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1 = 129;
		int num2 = 130;
		byte ch1 = (byte)num1;
		byte ch2 = (byte)num2;
		
		System.out.printf("%d\n", ch1);
		System.out.printf("%d\n",ch2);
		
		int a = (int) 100F;
		
	}

}

```

### C04 TypeChange

```java
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

```

### C05 TypeChange

```java
package Ch03;

public class C05TypeChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 10, num2 = 4;
		double dnum1 = (double)num1/num2;
		double dnum2 = (num1 * 1.0)/num2;
		double dnum3 = num1/num2;
		int dnum4 = num1/num2;
		
		System.out.println("dnum1 : " + dnum1);
		System.out.println("dnum2 : " + dnum2);
		System.out.println("dnum3 : " + dnum3);
		System.out.println("dnum3 : " + dnum4);
		
	}

}

```

![image](https://github.com/user-attachments/assets/e8ed43c1-1689-48f4-9753-ca81cd7d2d78)

### C06 TypeChange

```java
package Ch03;

public class C06TypeChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// short vs char
		// char 외 short는 같은 size(2byte)를 가지나
		// short는 양,음수를 지원 / char는 양수만 지원
		//short  char간의 데이터교환시 동일한 값을 저장하더라도
		// 표현하는 범위가 다르기 때문에 각각 다른값이 나올수도 있다.
		
		char n1 = 60000;
		short n2 = (short)n1;
		System.out.println(n2);
		
		int n3 = (char)n2;
		System.out.println(n3);
	}

}

```

### C07 TypeChange

```java
package Ch03;

import Ch01.Ch01SystemOut;

public class C07StringTypeChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 문자열 + 문자열
		
//		System.out.println("문자열 1" + "문자열 2");
//		System.out.println("문자열 1" + "문자열 2");
//		System.out.println("문자열 1" + ',' +"문자열 2");
//		System.out.println("문자열 1" + 2);
//		System.out.println("문자열 1" + ',' +"문자열 2");
//		System.out.println(',' + '!' +"문자열"); // 단일 문자는 숫자로 바뀌게 되고 계산되서 77이 나오고 뒤에 문자열때문에 문자열로 형 변환 되어서 이어서 나온다.
//		System.out.println("문자열 1" + "문자열 2");
		
		
		// 문자형 -> 숫자형 변환
		//-----------------------------
		// 문자열 -> 숫자형으로 변환 (정수)
		 
//		System.out.println("10"+"20");
//		int n1 = Integer.parseInt("10");
//		int n2 = Integer.parseInt("20");
//		System.out.println(n1+n2);
//		
//		
//		// 문자열 -> 숫자형으로 변환 (실수)
//		double n3 = Double.parseDouble("10.5");
//		double n4 = Double.parseDouble("20.4");
//		System.out.println(n3+n4);
//		
//		short n5 = Short.parseShort("5");
//		short n6 = Short.parseShort("6");
//		
//		System.out.println(n5+n6);
		

		
	}

}

```

### C08 정리 문제

```java
--------------------------------------------------------
정리
--------------------------------------------------------
자동 타입 변환
- 컴파일에 의한 자동 형변환
- 큰 공간에 작은자료형의 값을 넣을때 발생
- 데이터 손실이 최소화 되는 방향으로 자료형이 결정된다

강제 타입 변환
- 프로그래머에 의한 강제 형변환
- 작은 공간에 큰 자료형의 값을 저장(데이터 손실발생)

문자열 결합 연산
- 문자열과  + 연산을 하면 다른 피연산자도 문자열로 변환되어 문자열 결합이 일어난다

Integer.parseInt() : 문자열을 정수 int 타입으로 변환
Double.parseDouble() : 문자열을 실수 double로 변환

--------------------------------------------------------
문제
--------------------------------------------------------
1. 자동 타입 변환에 대한 내용입니다 컴파일 에러가 발생하는 것은 무엇입니까  3번

[예시]
----------------------------
byte byteValue = 10;
char charValue = 'A';
----------------------------
1) int intValue = byteValue;
2) int intValue = charValue;
3) short shortValue = charValue;
4) double doubleValue = byteValue;

2. 강제 타입 변환에 대한 내용입니다. 컴파일 에러가 발생하는 것은 무엇입니까  4번

[예시]   char var = (Char)strValue;을 
        char var = strValue.charAt(0); 이렇게 하면 된다.
----------------------------
int intValue = 10;
char charValue = 'A';
double doubleValue = 5.7;
String strValue = "A";
----------------------------
1) double var = (double)intValue;
2) byte var = (byte) intValue;
3) int var = (int)doubleVale;
4) char var = (Char)strValue;

3. 연산식에서의 타입 변환에 대한 내용입니다. 컴파일 에러가 발생하는 것은 무엇입니까?  1번
[예시]
----------------------------
byte byteValue = 10;
float floatValue = 2.5;
double doubleValue = 2.5;
----------------------------
1) byte result = byteValue + byteValue;
2) int result = 5 + byteValue;
3) float result = 5 + floatValue;
4) double result = 5 + doubleValue;

4. 다음 코드에서 컴파일 에러가 발생하는 위치와 이유를 설명해 보세요  
[예시]
----------------------------
short s1 = 1;
short s2 = 2;
int i1 = 3;
int i2 = 4;
short result = s1 + s2;  // 컴파일 에러 발생 이유 : s1 + s2 를 하면 자료형이 int로 바뀌면서 값이 3이 나온다. 따라서 int에서 short로 형변환을 할려면 강제 형변환이 필요하다. short result = (short)(s1 + s2);
int result = i1 + i2;
----------------------------

5. 알파벳 a의 아스키코드는 97이고 b의 아스키코드는 98입니다.
따라서 a의 아스키코드에 1을 더하면 b의 아스키코드가 되므로
다음과 같이 코드를 작성했습니다. 실행결과는 b가 출력되어야 하는데 
컴파일 에러가 발생하였습니다. 무엇이 문제이고, 어떻게 수정하면 좋을지
적어보세요
[예시]    char c2 = (int)c1 + 1; 연산의 결과는 int 인데 char타입에 저장해서
----------------------------
char c1 = 'a';
char c2 = c1 + 1;
System.out.println(c2);
----------------------------

6. 자바에서 / 는 나눗셈 연산자 입니다 x/y 는 x 를 y 로 나누는 연산을 수행합니다
빈칸에 들어갈 타입은 무엇이며 출력되는 결과와 그 이유를 설명해 보세요
[예시]   빈칸 : int 출력 결과 : 2 이유 : x와 y에 소수점이 존재하지 않기때문에 나눗셈연산을 하면 몫만 반환한다.
----------------------------
int x = 5;
int y = 2;
____ result = x/y;
System.out.println(result);
----------------------------

7. 6번 문제에서 출력되는 결과로 2.5가 나오게 하고 싶습니다 빈칸에 들어갈 코드를
작성하세요
[예시]
----------------------------
int x = 5;
int y = 2;
double result = (double)x + y; or double result = (x*1.0) + y;
System.out.println(result);
----------------------------

8. 두 실수를 덧셈 연산하고 소수점 이하 자리를 버리고 싶습니다
빈칸에 들어갈 코드를 작성해 보세요

[예시]  
----------------------------
double var1 = 3.5;
double var2 = 2.7;
int result = (int)(var1 + var2);   // int result = var1 + var2; C언어에서는 가능
----------------------------

9. var1 부터 var4까지 + 연산을 수행해서 int 타입 result변수에 9가 저장되도록
빈칸에 들어갈 코드를 작성해보세요
[예시]  
----------------------------
long var1 = 2L;
float var2 = 1.8f;        3.8   6.3   10.2
double var3 = 2.5;
String var4 = "3.9";
int result = (int)(var1 + var2 + var3) + (int)Double.parseDouble(var4); // Double.parseDouble로 문자열을 숫자로 바꿔주고 int로 형변환해서 3만 반환
System.out.println(result);
----------------------------

10. 다음코드를 실행했을 때 출력 결과를 적어보세요
[예시]  
----------------------------
String str1 = 2 + 3 + ""; 
String str2 = 2 + "" + 3; 
String str3 = "" + 2 + 3; 
System.out.println(str1); // 5
System.out.println(str2); // 23
System.out.println(str3); // 23
----------------------------

11. 문자열을 기본 타입으로 변환하려고 합니다
빈칸에 알맞은 코드를 작성해 보세요
[예시]
----------------------------
 byte value =	Byte.parseByte("10");
 int value = 	Integer.parseInteger("100);
 float value =	Float.parseFloat("20.5");
 double value =	Double.parseDouble("3.14159");
----------------------------

[답]
1. 3 char 타입의 양의 허용 범위가 short 타입보다 더 큼

2. 4 문자열을 char 타입으로 강제 타입 변환(캐스팅)할 수 없음

3. 1 연산의 결과는 int 타입임

4. 5 연산의 결과는 int 타입임

5. 연산의 결과는 int 타입인데 , char 타입 변수 c2 에 저장했기 때문

char c2 = (char) (c1 + 1);

6. int 2, 연산의 결과는 int 타입임

7. double, (double)x / y 또는 x / (double)y 또는 (double)x / (double)y

8. (int) (var1 + var2)

9. 
(int)var1 + (int)(var2 + var3) + (int)Double.parseDouble(var4) 또는
(int)(var1 + (int)var2 + var3 + Double.parseDouble(var4)) 또는
(int)(var1 + var2 + (int)var3 + Double.parseDouble(var4)) 또는
(int)(var1 + var2 + var3 + (int)Double.parseDouble(var4))

10.실행결과
5
23
23

11. 
 Byte.parseByte
 Integer.parseInt
 Float.parseFloat
 Double.parseDouble

```

## Ch04

### C01 Scanner

```java
package Ch04;

import java.util.Scanner;

public class C01Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 스트림
		// System.in : 표준입력 스트림 생성(요청)
		// System.out : 표준출력 스트림 생성(요청)
		
		// 코드 해석
//		new Scanner(System.in); : 표준 입력 스트림을 연결한 Scanner 객체 생성
//		Scanner sc : 생성된 Scanner 객체의 위치정보(메모리 주소)를 저장한 참조변수 sc
		
		// 표준입력 스트림에 연결된 Scanner 객체를 생성 이후 위치정보를
		// main Stack영역의 Scanner sc 참조변수에 초기화
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("num 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.printf("num2 입력 : ");
		int num2 = sc.nextInt();
		
		System.out.printf("num3 입력 : ");
		int num3 = sc.nextInt();
		
		System.out.printf("num4 입력 : ");
		int num4 = sc.nextInt();
		
		int sum = num1 + num2 +num3+num4;
		System.out.println(sum);
	}

}

```

<aside>
💡

Stream : 데이터의 이동 통로

</aside>

### C02 Scanner

```java
package Ch04;

import java.util.Scanner;

public class C02Scanner {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // sc는 객체 Scanner클래스의 인스턴스
//		System.out.println("정수 입력 : ");
//		
//		int num1 = sc.nextInt();
//		System.out.println("입력된 정수 값 : "+num1);
//		
//		System.out.println("실수 입력 : ");
//		double num2 = sc.nextDouble();
//		System.out.println("입력된 실수 값 : "+num2);
		
//		System.out.println("문자열 입력 : ");
//		String str1 = sc.next(); // next()는 문자열 입력 받는 Scanner클래스의 메서드이다. 띄어쓰기 하면 띄어쓰기 바로 전까지만 입력받음.
//		System.out.println("입력된 문자열 : "+str1);
//		System.out.println("입력");
//		String s1 = sc.next();
//		String s2 = sc.next();
//		String s3 = sc.next();
//		
//		System.out.printf("문자열 : %s%s%s\n", s1,s2,s3);
		
//		System.out.println("문자열입력(띄어쓰기) : ");
//		String str2 = sc.nextLine(); // nextLine()는 띄어쓰기까지 입력받는다.
//		System.out.println("문자열 : "+ str2);
		
		}
}

```

### C03 Scanner

```java
package Ch04;

import java.util.Scanner;

public class C03Scanner2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력 : ");
		
		int num1 = sc.nextInt();
		System.out.println("입력된 정수 값 : "+num1);

//		정수입력받고 엔터 누르면 버퍼 공간에 엔터가 남아있어서 문자열 입력 
//  	받지 못하고 끝난다.
//		nextLine()만 그렇다.
		
		sc.nextLine(); // nextLine을 하나 더 쓰면서 버퍼 문제 해결
		System.out.println("문자열입력(띄어쓰기) : ");
		String str2 = sc.nextLine();
		System.out.println("문자열 : "+ str2);
		

//		System.out.println("실수 입력 : ");
//		double num2 = sc.nextDouble();
//		System.out.println("입력된 실수 값 : "+num2);
		
//		System.out.println("문자열 입력 : ");
//		String str1 = sc.next(); // next()는 문자열 입력 받는 Scanner클래스의 메서드이다. 띄어쓰기 하면 띄어쓰기 바로 전까지만 입력받음.
//		System.out.println("입력된 문자열 : "+str1);

//		
//		System.out.printf("문자열 : %s%s%s\n", s1,s2,s3);
		
		}
}

```

### C04 Scanner

```java
package Ch04;

import java.util.Scanner;

public class C04Scanner {

	public static void main(String[] args) {
		// 이름을 입력하세요? 홍길동
		// 홍길동 님의 나이를 입력하세요? 35
		// 홍길동 님의 주소를 입력하세요? 대구광역시 달서구 000
		// 홍길동 님의 나이는 35세 주소는 대구광역시 ~~ 입니다
		
		Scanner input = new Scanner(System.in);
		
		System.out.printf("이름을 입력하세요 : ");
		String name = input.next();
		
		System.out.printf("%s 님의 나이를 입력하세요 : ",name);
		int age = input.nextInt();
		
		input.nextLine(); // 버퍼 제거
		
		System.out.printf("%s 님의 주소를 입력하세요 : ", name);
		String address = input.nextLine();
		System.out.println(name +"님의 나이는 " + age + "세 주소는 "+address+"입니다." );
		

	}

}

```

### C05 정리문제

```java
--------------------------------------------------------
정리
--------------------------------------------------------
System.out.print	: 기본 출력 메서드
System.out.printf	: 서식문자 사용가능한 출력 메서드
System.out.println	: 개행 기본 출력 메서드 
Scanner : 키보드로부터 입력받는 장치 생성에 필요한 클래스 자료형

--------------------------------------------------------
문제
--------------------------------------------------------
1 Scanner 를 이용해서 키보드로 입력한 두수를 덧셈하여 결과를 출력해보세요

[예시]
----------------------------
Scanner scanner = new Scanner(System.in);

System.out.print("첫번째 수 : ");
String strNum1=scanner.nextLine();

System.out.print("두번째 수 : ");
String strNum2=scanner.nextLine();

int num1 = Integer.parseInt(strNum1);
int num2 = Integer.parseInt(strNum2);

int result = num1 + num2;
System.out.println("덧셈 결과 : " + result);
----------------------------

2 Scanner를 이용해서 이름, 주미번호 앞 6자리 , 전화번호를 키보드에서
입력받고 출력하는 코드를 작성해보세요

Scanner sc = new Scanner(System.in);
String name = sc.next();
String id = sc.next();
String phone = sc.next();

System.out.printf("%s %s %s\n",name,id,phone);

[예시]
----------------------------
[필수 정보 입력]
1. 이름 : ______________ENTER
2. 주민번호 6자리 : ______________ENTER
3. 전화번호 : ____________ENTER

[입력한 내용]
이름 : 홍길동
주민번호 : 123456
PH : 010-222-3333
----------------------------

[답]
1.
 Scanner scanner = new Scanner(System.in);
 System.out.print("첫번째 수:");
 String strNum1 = scanner.nextLine();
 System.out.print("두번째 수:");
 String strNum2 = scanner.nextLine();
 int num1 = Integer.parseInt(strNum1);
 int num2 = Integer.parseInt(strNum2);
 int result = num1 + num2;
 System.out.println("덧셈 결과:" + result);

2.
 Scanner scanner = new Scanner(System.in);

 System.out.println("[필수 정보 입력]");

 System.out.print("1. 이름: ");
 String name = scanner.nextLine();

 System.out.print("2. 주민번호 앞 6자리: ");
 String ssn = scanner.nextLine();

 System.out.print("3. 전화번호: ");
 String tel = scanner.nextLine();

 System.out.println();

 System.out.println("[입력된 내용]");
 System.out.println("1. 이름: " + name);
 System.out.println("2. 주민번호 앞 6자리: " + ssn);
 System.out.println("3. 전화번호: " + tel);

```

## Ch05

### C01 BASIC

```java
package Ch05;

public class C01BASIC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// -------------------------
		// 기본 산술 연산자
		// -------------------------
//		int a = 10, b = 20, c;
//		System.out.println("a+b="+ (a + b));
//		System.out.println("a-b="+ (a - b));
//		System.out.println("a*b="+ (a * b));
//		System.out.println("b/a="+ (b / a)); //나누기 - 몫
//		System.out.println("a%b="+ (a % b));//나누기 - 나머지(1.짝홀수구분,2.배수구분,3.자리수제한,4.끝자리구하기)
//		System.out.println("-a="+ -a);
			

		// 문제
//		두수를 입력 받아 두수의 합/차/곱을 출력하는 프로그램을 만들어보세요
//		Scanner 를 사용합니다

		// -------------------------
		// 대입 연산자
		// -------------------------
		// LV = RV;
		// 공간 = 값(우선 처리);

		// -------------------------
		// 복합 대입 연산자
		// -------------------------
//		int a = 10;
//		a += 10; //a = a + 10;
//		a -= 5; // a = a-5;
//		a *= 3; // a = a*3;
//		System.out.println("a="+a);

		// -------------------------
		// 비교 연산자
		// -------------------------
//		int a =10;
//		int b=20;
//		System.out.println("A == B : "+ (a == b)); // a=b
//		System.out.println("A  > B : "+ (a > b));
//		System.out.println("A  < B : "+ (a < b));
//		System.out.println("A >= B : "+ (a >= b));
//		System.out.println("A <= B : "+ (a <= b));
//		System.out.println("A != B : "+ (a != b));

		// -------------------------
		// 논리 연산자
		// -------------------------
		// AND 연산자 && : (true)&&(true) = true , 그외는 거짓
		// - &&기호를 기준으로 왼/오른쪽 둘다 true 이면 true
		// OR 연산자 || : t||t = t, t||f =t, f||t=t, f||f=f
		// - ||기호를 기준으로 왼/오른쪽 중 하나만 true 이면 true
		// ! 연산자
		// - true이면 false, false 이면 true

//		int a=10;int b=20;
//		System.out.println((a>=b)&&(a>5));
//		System.out.println((a!=b)&&(b>15));
//		
//		System.out.println((a>=b)||(a>5));
//		System.out.println((a!=b)||(b>15));
//		System.out.println((a==b)||(a<=5));
//		
//		System.out.println("false AND false = " + (true && true));
//		System.out.println("false AND true = " + (false && true));
//		System.out.println("true AND false = " + (true && false));
//		System.out.println("true AND true =  " + (false && false));

		// -------------------------
		// 논리 부정 연산자
		// -------------------------
//		boolean play = true;
//		System.out.println(play);
		//
//		play = !play;
//		System.out.println(play);
		//
//		play = !play;
//		System.out.println(play);

		// -------------------------
		// 증감연산자
		// -------------------------
		// ++a(--a) : 전치 연산자 : 먼저 값 1증가(1감소) 이후 다른 연산자 처리
		// a++(a--) : 후치 연산자 : 다른 연산자 처리 먼저 한 후 1증가(1감소)
//		int a = 10, b = 10, c, d=0;

//		c = --a + b++;
//		d = a-- + ++b;
//		System.out.printf("a=%d , b=%d , c=%d, d=%d", a, b, c, d);	

		// -------------------------
		// 삼항 연산자
		// -------------------------
		// (조건식)? 참인경우 실행코드 : 거짓인경우 실행코드;
//		int score = 85;
//		char grade = (score > 90) ? 'A' : ((score > 80) ? 'B' : 'C');
//		System.out.println(score + "점은 " + gr
	}

}

```

### C02 Ex

```java
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

```

### C03 Percent

```java
package Ch05;

import java.util.Random;

public class C03Percent {

	public static void main(String[] args) throws InterruptedException {
		// %연산자

		// 01 홀수/짝수

		// Scanner 객체 생성 후
		// 정수를 num1 에 저장 다음
		// 짝홀수 확인하세요

//		Scanner sc = new Scanner(System.in);
//		int num1 = sc.nextInt();
		
		//String result =  (num1%2==0)?"짝수입니다":"홀수입니다";
		//System.out.println("결과 : " + result);

		// 02 배수 구하기

		// 세 정수를 받아서 세 수의 합이 5의 배수인 경우
		// 5의배수입니다 를 출력
		// 아닌 경우 5의배수가 아닙니다 를 출력

//		Scanner sc = new Scanner(System.in);
//		int n1,n2,n3,sum;
//		n1=sc.nextInt();
//		n2=sc.nextInt();
//		n3=sc.nextInt();
//		sum=n1+n2+n3;
//		String result = (sum%5==0)?"5의배수입니다":"5의 배수가 아닙니다";
//		System.out.println("RESULT : " +result);

		// 03 수의범위
		/*
		 * N%2 = 0,1 N%3 = 0,1,2 N%4 = 0-3 N%9 = 0-8 N%10 = 0-9 수%100 = 0 ~99
		 */

		// 난수생성
//		Random rnd = new Random();

//		Random rnd = new Random();
//		while (true) {
//			System.out.println(rnd.nextInt(45)+1); //N%5 과 동일 (0~4)
//			Thread.sleep(500);
//		}

//		 02 Math.random();
//		while (true) {
//			System.out.println((int)(Math.random()*100)%45+1);  // (int)(Math.random()*100) 정수형만 보겠다.
////			System.out.println((int)(Math.random()*100)%16);
//			Thread.sleep(500);
//		}

		// 04 끝자리수

//		int num = 56789;
//
//		System.out.println("오른쪽 끝 1자리 : " + (num % 10));
//		System.out.println("오른쪽 끝 2자리 : " + (num % 100));
//		System.out.println("오른쪽 끝 3자리 : " + (num % 1000));
//		System.out.println("오른쪽 끝 4자리 : " + (num % 10000));
//		System.out.println();
//		System.out.println("왼쪽 끝 1자리 : " + (num / 10000));
//		System.out.println("왼쪽 끝 2자리 : " + (num / 1000));
//		System.out.println("왼쪽 끝 3자리 : " + (num / 100));
//		System.out.println("왼쪽 끝 4자리 : " + (num / 10));
		
		//정수 하나를 입력받아 거꾸로 저장해보세요(반복문법 이후 풀어보기)%,/연산 동시이용할 것
		//예
		
//		입력: 1234
//		저장
//		int reverse = 4321;
//		출력 : 4321
		
		

	}

}

```

### C04 BitArith

```java
package Ch05;

public class C04BitArith {
	public static void main(String[] args) {
		int num1 = 15;			//00000000 00000000 0000000 00001111
		int num2 = 20;			//00000000 00000000 0000000 00010100
		int num3 = num1&num2;	//00000000 00000000 0000000 00000100 = 4
		int num4 = num1|num2;	//00000000 00000000 0000000 00011111 = 31
		int num5 = num1^num2;	//00000000 00000000 0000000 00011011 = 27
		int num6 = ~num1;		//11111111 11111111 1111111 11110000 =
		
		System.out.println("AND 비트 연산 결과 : " + num3);
		System.out.println("OR 비트 연산 결과 : " + num4);
		System.out.println("XOR 비트 연산 결과 : " + num5);
		System.out.println("NOT 비트 연산 결과 : " + num6);
	}
}	

```

### C05 ShiftArch

```java
package Ch05;

public class C05ShiftArch {
	public static void main(String[] args) {
		int num1 = 15;		//00000000 00000000 00000000 00001111
		int num2 = 20;		//00000000 00000000 00000000 00010100
		int num3 = num2<<3; //00000000 00000000 00000000 10100000
		int num4 = num2>>3; //00000000 00000000 00000000 00000010
		
		System.out.println("<<Shift 연산결과 :" + num3);
		System.out.println(">>Shift 연산결과 :" + num4);
	}
}	

```

### C06 LogicArith

```java
package Ch05;

public class C06LogicArith {
	public static void main(String[] args) {
		int a=0,b=0;
		boolean c;
		a = 1;
		b = 1;
		c =(++a>0)||(++b>0) ;
		System.out.printf("a = %d , b = %d c = %s\n", a, b, c);

		a = 1;
		b = 1;
		c = (++a>0)||(--b>0) ;
		System.out.printf("a = %d , b = %d c = %s\n", a, b, c);

		a = 1;
		b = 1;
		c = (--a>0)||(++b>0) ;
		System.out.printf("a = %d , b = %d c = %s\n", a, b, c);

		a = 1;
		b = 1;
		c = (--a>0)||(b-->0) ;
		System.out.printf("a = %d , b = %d c = %s\n", a, b, c);
	}
}	

```

### C07 IncDesArith

```java
package Ch05;

public class C07IncDesArith {
	public static void main(String[] args) {
//		int a=5, b=6, c=10, d;
//		boolean e;
//		d=++a*b--;
//		 System.out.printf("a = %d, b = %d, d = %d\n", a, b, d);
//		d=a++ + ++c - b--;
//		System.out.printf("a = %d, b = %d, c = %d, d = %d\n", a, b, c, d);
//		a=1;
//		b=0;
//		e=(a++>0)||((b*d/c)>0);
//		System.out.printf("a = %d, b = %d, c = %d, d = %d ,e = %b\n", a, b, c, d , e);
		
	}
}	

```

### C08 정리_문제

```java
--------------------------------------------------------
정리
--------------------------------------------------------
기본 연산자 : + , - , * , / , %
증감 연산자 :  ++ , --  변수의 값을 1증가 or 1감소
비교 연산자 : == , > ,>= , < , <= != 두 피연산자를 비교한뒤 참거짓에따라 boolean값을 전달
논리 연산자 : && , || , !  , 논리곱 , 논리합 , 논리 부정 계산후 boolean값을 전달
복합 대입 연산자 : = , += , -= , *= , /= , %= , 오른쪽값을 왼쪽 공간에 대입
삼항 연산자 : (조건식) ? A : B ; 조건식이 true이면 A를 실행 false 이면 B를 실행

--------------------------------------------------------
문제
--------------------------------------------------------
1. 다음 코드에서 컴파일 에러가 발생하는 위치와 이유를 설명해보세요
// 2번 -를 붙이면서 int형으로 바뀐다. 그래서 강제 형변환을 해줘야한다. (byte)-b;
[예시]
----------------------------
byte b = 5;						//1
b = -b;							//2
int result = 10 / b;			//3
System.out.println(result);		//4 
----------------------------

2. 다음 코드를 실행했을 때 출력 결과는 무엇입니까?
// 11 + 20 = 31;

[예시]
----------------------------
int x = 10;
int y = 20;
int z = (++x) + (y--);
System.out.println(z);
 
----------------------------

3. 다음 코드 실행시 출력 결과로 5를 기대했는데 4가 나왔습니다
어디서 잘못됬는지 확인하고 고쳐보세요

//

[예시]
----------------------------
int var1 = 5;
int var2 = 2;
double var3 = (1.0*var1) / var2;  // 2.5
int var4=(int)(var3 * var2);  // 6.5 -> 6
System.out.println(var4);
----------------------------

4 다음 코드는 비교 연산자와 논리 연산자의 복합 연산식입니다
연산식의 출력 결과를 빈칸에 넣으세요

[예시]
----------------------------
 int x = 10;
 int y = 5;
 System.out.println( (x>7) && (y<=5) );
 -> (	TRUE	)
 System.out.println( x%3 ==2) || (y%2 !=1) );
 -> (	 FALSE		)
----------------------------

5 대입 연산자와 산술연산자로 구성된 실행문을
복합대입연산자로 바꿔서 작성해보세요
[예시]
----------------------------
 int value = 0;
 value = value + 10; ->( value += 10  );
 value = value - 10; ->( value -= 10  );
 value = value * 10; ->( value *= 10  );
 value = value / 10; ->( value /= 10  );
----------------------------

6. 다음 코드를 실행했을 때 출력 결과는 무엇인지 적어보세요 
// 가

[예시]
----------------------------
 int score = 85;
 String result = (!(score>90)) ? "가" : "나";
 System.out.println(result);
----------------------------

[답]

1. b = -b;, 부호 연산을 하므로 결과는 int 타입이 됨
확인 문제 정답 649 정답편
2. 31 
3. var1/var2는 정수 연산이므로 결과는 정수 2, 그래서 변수 var3에는 2.0이 저장
(int)(var3 * var2)는 (int)(2.0 * 2)이므로 결과는 4, 그래서 변수 var4는 4가 저장

4. true, false

5. 
value += 10;
value -= 10;
value *= 10;
value /= 10;
6. 가

```

## Ch06

### C01 IF

```java
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

```

### C02 SWITCH

```java
package Ch06;

import java.util.Scanner;

public class C02SWITCH {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int ranking =sc.nextInt();
		char medalColor;
		switch (ranking) {
		case 1: 
			
			medalColor = 'G';
			System.out.println("매달색상 : G");
			break;
		
		case 2:
			medalColor = 'S';
			System.out.println("매달색상 : S");
			break;
			
		case 3:
			medalColor = 'B';
			System.out.println("매달색상 : B");
			break;
		default:
			medalColor = 'C';
			System.out.println("매달색상 : C");
		
		}
		System.out.println(ranking + "등 매달의 색은 "+medalColor+"입니다.");

	}
}

```

### C03 SWITCH

```java
package Ch06;

import java.util.Scanner;

import Ch01.Ch01SystemOut;

public class C03SWITCH {
	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			int num = 0;
			
			System.out.println("--------------------JOIN MENU --------------------");
			System.out.println("1 이메일 인증");
			System.out.println("2 개인정보 입력");
			System.out.println("3 회원가입 요청");
			System.out.println("4 종료");
			
			System.out.println("--------------------JOIN MENU --------------------");
			System.out.println("번호 입력 : ");
			
			num = sc.nextInt();
			
			switch (num) {
			case 1: {
				
				System.out.println("이메일 인증처리 작업 - ");
				break;
			}
			case 2:{
				System.out.println("이메일 개인정보 입력 저장");
				break;
			}
			case 3:{
				System.out.println("회원가입 처리 작업 - ");
				break;
			}
			case 4:{
				System.out.println("JOIN 메뉴 종료 - ");
				System.exit(-1);
				break;
			}
			default:
				System.out.println("잘못된 메뉴번호를 입력하셨습니다.");
				break;
			}
		}
	}
}

```

## Ch07

### C01 While

```java
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

```

### C02While (내가 한거)

```jsx
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

```

### C02While (강사님이 한거)

```jsx
package Ch07;

import java.util.Scanner;

public class C02While {
	
	public static void main(String[] args) {
		
		
		//2단 - 9단 출력
//		dan	i
//		2	1-9
//		3	1-9
//		...
//		9	1-9
//		---------------------------
//		dan=2	i=1
//		dan++	i++
//		dan<10   i<10
		
//		int dan = 2;
//		while(dan<10) {
//			
//			int i=1;
//			while(i<10) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				i++;
//			}
//			System.out.println();
//			
//			dan++;
//		}
 	
		
		//2단 - 9단 출력 (2x9,2x8 ,.... 9x9 ,...9x1)
//		--------------------------
//		dan	i
//		2	9-1
//		3	9-1
//		...
//		9	9-1
//		---------------------------
//		dan=2	i=9
//		dan++	i--
//		dan<10   i>0

//		int dan = 2;
//		while(dan<10) {
//			
//			int i=9;
//			while(i>0) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				i--;
//			}
//			System.out.println();
//			
//			dan++;
//		}
		
		
		//9단 - 2단( 9x9 9x8 - 2x1)
//		--------------------------
//		dan	i
//		9	9-1
//		8	9-1
//		...
//		2	9-1
//		---------------------------
//		dan=9	i=9
//		dan--	i--
//		dan>1   i>0

//		int dan = 9;
//		while(dan>1) {
//			
//			int i=9;
//			while(i>0) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				i--;
//			}
//			System.out.println();
//			
//			dan--;
//		}		

		
		//2단 - N단(N<9)
		
		
//		입력 : n
//		dan	i
//		2	1-9
//		3	1-9
//		...
//		n	1-9
//		---------------------------
//		dan=2	i=1
//		dan++	i++
//		dan<n+1   i<10

//		Scanner sc = new Scanner(System.in);
//		System.out.print("단 수 입력 : " );
//		int n = sc.nextInt();
//		
//		//(N<9)
//		while(n>9 || n<2) {
//			System.out.println("2  - 9 사이의 값을 입력하세요" );
//			System.out.print("단 수 입력 : " );
//			n = sc.nextInt();	
//		}
//		
//		int dan = 2;
//		while(dan<n+1) {
//			
//			int i=1;
//			while(i<10) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				i++;
//			}
//			System.out.println();
//			
//			dan++;
//		}
		
		
		//N단 - M단(N<M , N<9 , M<9)
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("단 수 입력(시작단수 끝단수) : " );
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		
//		//(N<9) (M<9)
//		while(n>9 || n<2 || m>9 || m<2) {
//			System.out.println("[!] 값범위[2-9]를 초과하였습니다" );
//			System.out.print("단 수 입력(시작단수 끝단수) : " );
//			n = sc.nextInt();	
//			m = sc.nextInt();
//		}
//		
//		//N>M
//		while(n>m) {
//			int tmp = n;
//			n = m;
//			m = tmp;	
//		}
//		
//		int dan = n;
//		while(dan<m+1) {
//			
//			int i=1;
//			while(i<10) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				i++;
//			}
//			System.out.println();
//			
//			dan++;
//		}
		
		
		
		// 
//		System.out.println();	//줄바꿈(개행)
//		System.out.print("*");	//별찍기

		
		//별찍기(기본높이:4)
				
		//*****
		//*****
		//*****
		//*****
	
//		i(개행)		j(별)
//		0		0-4
//		1		0-4
//		2		0-4
//		3		0-4
//		-----------------------------
//		i=0		j=0	
//		i++		j++
//		i<4		j<5	
		
			
//		int i=0;
//		while(i<4) {
//			
//			int j=0;
//			while(j<5) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}
		
		
		//높이 : h
		//*****
		//*****
		//*****
		//*****
		
//		높이 : h
//		i(개행)		j(별)
//		0		0-4
//		1		0-4
//		2		0-4
//		3		0-4
//		h
//		-----------------------------
//		i=0		j=0	
//		i++		j++
//		i<h+1		j<5
		
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		
//		int i=0;
//		while(i<h+1) {
//			
//			int j=0;
//			while(j<5) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}
		
//		i(개행)		j(별)
//		0		0-0
//		1		0-1
//		2		0-2
//		3		0-3	
//		--------------------------------
//		i=0		j=0
//		i++		j++
//		i<4		j<i+1
	
		
		//*
		//**
		//***
		//****
		
//		int i=0;
//		while(i<4) {
//			int j=0;
//			while(j<i+1) {	
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}
		
		
//		높이 : h
//		*
//		**
//		***
//		****
//
//		i(개행)		j(별)
//		0		0-0
//		1		0-1
//		2		0-2
//		3		0-3
//		..
//		h-1		0-(h-1)
//		-------------------------------
//		i=0		j=0
//		i++		j++
//		i<h		j<i+1

//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		
//		int i=0;
//		while(i<h) {
//			int j=0;
//			while(j<i+1) {	
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}	

		
		//****
		//***
		//**
		//*
//		i(개행)	j(별)
//		0		0-3
//		1		0-2
//		2		0-1
//		3		0-0
//		-----------------------------
//		i=0		j=0
//		i++		j++
//		i<4		j<4-i

		
//		int i=0;
//		while(i<4) {
//			
//			int j=0;
//			while(j<4-i) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}
		

//		i(개행)		j(별)
//		0		0-(h-1) -0
//		1		0-(h-1) -1
//		2		0-(h-1) -2
//		3		0-(h-1) -3
//		...
//		h-1		0-0
//		-----------------------------
//		i=0		j=0
//		i++		j++
//		i<h		j<h-i
		
		
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		
//		int i=0;
//		while(i<h) {
//			
//			int j=0;
//			while(j<h-i) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}
		
		
		
		
		//   *
		//  ***
		// *****
		//*******

//		i(행)		j(공백)		k(별)
//		0		0-2		0-0		
//		1		0-1		0-2
//		2		0-0		0-4
//		3		x		0-6
//		---------------------------------------
//		i=0		j=0		k=0
//		i++		j++		k++
//		i<4		j<3-i		k<=2*i
		
//		int i=0;
//		while(i<4) {
//			//공백
//			int j=0;
//			while(j<3-i) {
//				System.out.print(" ");
//				j++;
//			}
//			//별
//			int k=0;
//			while(k<=2*i) {
//				System.out.print("*");
//				k++;
//			}
//			System.out.println();
//			i++;
//		}
		
		
		// 높이: h
		//   *
		//  ***
		// *****
		//*******
		
//		i(행)		j(공백)		k(별)
//		0		0-(h-2)-0	0-0		
//		1		0-(h-2)-1	0-2
//		2		0-(h-2)-2	0-4
//		3		x		0-6
//		..
//		(h-1)
//		---------------------------------------
//		i=0		j=0		k=0
//		i++		j++		k++
//		i<h		j<(h-1)-i	k<=2*i
		
//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		int i=0;
//		while(i<h) {
//			//공백
//			int j=0;
//			while(j<(h-1)-i) {
//				System.out.print(" ");
//				j++;
//			}
//			//별
//			int k=0;
//			while(k<=2*i) {
//				System.out.print("*");
//				k++;
//			}
//			System.out.println();
//			i++;
//		}
		
		
		
		
//		i(행)		j(공백)		k(별)
//		0		x		0-6
//		1		0-0		0-4
//		2		0-1		0-2
//		3		0-2		0-0
//		-----------------------------------------
//		i=0		j=0		k=0
//		i++		j++		k++
//		i<4		j<i		k<=6 - 2*i
	
		
		//*******
		// *****
		//  ***
		//   *

		
//		int i=0;
//		while(i<4) {		
//			
//			//공백
//			int j=0;
//			while(j<i) {
//				System.out.print(" ");
//				j++;
//			}
//			//별
//			int k=0;
//			while(k<=6-2*i) {
//				System.out.print("*");
//				k++;
//			}		
//			System.out.println();
//			i++;
//		}

		
		
		//높이 : h
		//*******
		// *****
		//  ***
		//   *

//		높이 :h
//		i(행)		j(공백)		k(별)
//		0		x		0-6
//		1		0-0		0-4
//		2		0-1		0-2
//		3		0-2		0-0
//		..
//		h-1
//		-----------------------------------------
//		i=0		j=0		k=0
//		i++		j++		k++
//		i<h		j<i		k<=((h-1)*2) - 2*i

//		Scanner sc = new Scanner(System.in);
//		int h = sc.nextInt();
//		
//		int i=0;
//		while(i<h) {		
//			
//			//공백
//			int j=0;
//			while(j<i) {
//				System.out.print(" ");
//				j++;
//			}
//			//별
//			int k=0;
//			while(k<=((h-1)*2) - 2*i) {
//				System.out.print("*");
//				k++;
//			}		
//			System.out.println();
//			i++;
//		}
		
		
		
		
		
		//   *
		//  ***
		// *****		
		//*******
		// *****
		//  ***
		//   *
//		i(행)		j(공백)		k(별)
//		0		0-2		0-0
//		1		0-1		0-2
//		2		0-0		0-4
//		3		x		0-6
//		-----------------------------------------
//		i<4		j=0		k=0
//				j++		k++
//				j<3-i		k<=2*i
//
//		4		0-0		0-4
//		5		0-1		0-2
//		6		0-2		0-0
//		-----------------------------------------
//		i>=4		j=0		k=0
//				j++		k++
//				j<=i-4		k<= 12-2*i
//
//		i=0
//		i++
//		i<7
		
//		int i=0;
//		while(i<7) {
//			
//			if(i<4) {
//				//공백(↓)
//				int j=0;
//				while(j<3-i) {
//					System.out.print(" ");
//					j++;
//				}
//				//별(↑)
//				int k=0;
//				while(k<=2*i) {
//					System.out.print("*");
//					k++;
//				}
//				
//			}else {
//				
//				//공백(↑)
//				int j=0;
//				while(j<=i-4) {
//					System.out.print(" ");
//					j++;
//				}	
//				//별(↓)
//				int k=0;
//				while(k<= 12-2*i) {
//					System.out.print("*");
//					k++;
//				}
//			}
//			
//			System.out.println();
//			i++;
//		}
		
		
		
		
		
		
		
//		i(행)		j(공백)		k(별)
//		0		0-2				0-0
//		1		0-1				0-2
//		2		0-0				0-4
//		3		x				0-6
//		-----------------------------------------
//		i<=(h/2)	j=0			k=0
//					j++			k++
//					j<(h/2)-i	k<=2*i
//
//		4			0-0				0-4
//		5			0-1				0-2
//		6			0-2				0-0
//		-----------------------------------------
//					j=0				k=0
//					j++				k++
//					j<=i-(h/2+1)	k<=((h-1)*2)-2*i
				
			
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		
		
		int i=0;
		while(i<h) {
			
			if(i<=(h/2)) {
				//공백(↓)
				int j=0;
				while(j<(h/2)-i) {
					System.out.print(" ");
					j++;
				}
				//별(↑)
				int k=0;
				while(k<=2*i) {
					System.out.print("*");
					k++;
				}
				
			}else {
				
				//공백(↑)
				int j=0;
				while(j<=i-(h/2+1)) {
					System.out.print(" ");
					j++;
				}	
				//별(↓)
				
				int k=0;
				while(k<=((h-1)*2)-2*i) {
					System.out.print("*");
					k++;
				}
				
			}
			
			System.out.println();
			i++;
		}
		
		//*******
		// *****
		//  ***
		//   *		
		//   *
		//  ***
		// *****		
		//*******

	}
	
}

```

### C03Continue_Break

```java
package Ch07;

import java.util.Scanner;

public class C03Continue_Break {
	public static void main(String[] args) {
		
//		1 break
//		-1을 입력하기 전까지 정수값을 누적하여 합을 구하고 출력
		
//		Scanner sc = new Scanner(System.in);
//		int n;
//		int sum=0;
//		while (true) {
//			n = sc.nextInt();
//			if (n ==-1) {
//				break;
//			}
//			sum+=n;
//		}
//		System.out.println("sum : " + sum);
//		sc.close();
		
//		모든 반복문 탈출 : flag
//		7 x 7 = 49 출력 이후 모든 반복문 탈출
//		boolean flag = false;
//		int dan=2;
//		while (dan<10) {
//			int i =1;
//			while (i < 10) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				
//				// 7 x 7 = 49 이후 모든 반복문 탈출
//				if (dan==7 && i ==7) {
//					flag = true;
//					break;
//					
//				}
//				i++;
//			}
//			
//			System.out.println();
//			if (flag) {
//				break;
//			}
//		}
		
		// EXIT
		
			
//		int dan=2;
//		Exit:  // break Exit가 실행되면 Exit 레이블이 붙어 있는 바깥 반복문까지 즉시 탈출
//		while (dan<10) {
//			int i =1;
//			while (i < 10) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				
//				// 7 x 7 = 49 이후 모든 반복문 탈출
//				if (dan==7 && i ==7) {
//
//					break Exit;
//					
//				}
//				i++;
//			}
//			
//			System.out.println();
//			dan++;
//		}
		
		// Continue
		
		// 1부터 10까지의 수중에 3의 배수를 제외한 합 출력
		
		int i=1;
		int sum=0;
		while (i<=10) {
			System.out.println("i : " + i);
			sum+=i;
			i++;
		}
		System.out.println("sum : " + sum);
	}
}

```

### C04For

```java
package Ch07;

import java.util.Scanner;

public class C04For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int i =0;
//		while (i <10) {
//			System.out.println("HELLO WORLD");
//			i++;
//
//		}
		
		
//		for( 타출용 변수 선언; 탈출용 조건식; 탈출용 연산식){
//		}

//		for(int i=0;i<10;i++){
//		System.out.println("HELLO WORLD");
//	}
	
		//1-10까지합
		//1-N까지합
		//N-M까지합(N<M)
		//2단 구구간
		//N단 구구단(2<=N<=9)
		//2-9 구구단
		//2-N 구구단
		//N-M 구구단
		//별찍기
	
	
	//	int i=0;
	//	while(i<4) {
	//		int j=0;
	//		while(j<i+1) {	
	//			System.out.print("*");
	//			j++;
	//		}
	//		System.out.println();
	//		i++;
	//	}
		
	//	for(int i=0;i<4;i++) {	
	//		for(int j=0;j<i+1;j++) 
	//			System.out.print("*");
	//		System.out.println();
	//	}
		
		int i=0;
		while(i<4) {
			//공백
			int j=0;
			while(j<3-i) {
				System.out.print(" ");
				j++;
			}
			//별
			int k=0;
			while(k<=2*i) {
				System.out.print("*");
				k++;
			}
			System.out.println();
			i++;
		}
		
		
		
	}

}

```

### C05 기타반복처리

```java
package Ch07;

import java.util.ArrayList;
import java.util.List;

public class C05기타반복처리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Collection 객첼들 이용 - 저장
		
		List<String> lists = new ArrayList<>();
		lists.add("JAVA");
		lists.add("JSP/SERVLET");
		lists.add("SPRING STS");
		lists.add("SPRINGBOOT");
		lists.add("REACT");
		lists.add("ORACLE");
		
		
		
		for (int i = 0; i < lists.size(); i++) {
			System.out.println(lists.get(i));
		}
		
		System.out.println("----------------------------");
		// 계량 for
		
		for (String subject : lists) {
			System.out.println(subject);
		}
		
		
		// Stream forEach
		
		lists.stream().forEach((item)->{
			System.out.println(item);
		});
	}

}

```
