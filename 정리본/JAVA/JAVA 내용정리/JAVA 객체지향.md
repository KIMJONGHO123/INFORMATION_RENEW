# JAVA 객체지향

## Ch08

### C00INFO

```java
package Ch08;

public class C00INFO {
	public static void main(String[] args) {
		
		
		// 1. 객체 - Object
		// 존재(독점적이고 베타적인 공간을 차지)하는 사물(Object)
		
		// 2 객체
		// 속성(Attribute) : 객체마다 구별되는 데이터(저장 - 변수처리)
		// 기능(Function) : 객체가 수행할 수 있는 공통 Action(기능 - 메서드 처리)
		
		// 3 객체 지향
		// 현실 세계의 여러 객체의 정보(속성/기능) 중에 필요한 일부만 추출(추상화) 하여
		// 문제 해결을 하기 위한 요소단위로 적재하기 위해 고안된 문법.
		
		// 4 클래스?
		// 동일한 종류의 객체에 필요한 메모리공간을 제공하기 위해 선언된 자료형
		// 클래스로 객체를 생성하기 전에는 기본적으로 메모리공간을 차지하지 않는다.
		// (Document화)
		// 클래스 자료형에 의해 객체가 정의되는 순간 클래스에서 선언한 속성과 기능대로
		// 공간형성이 이루어진다.
		
		// 5 자바의 메모리 영역
		
		// 1. 스택영역 : {} 내에서 생성되고 소멸되는 영역(int,double..)
		// 2. 클래스(==메서드)영역 : 공유메모리 영역(생성자,일반메서드,static메서드,static변수)
		// 3. 힙영역 : 객체 저장 영역(new 예약어 사용시 할당)
		
		
		// 6 코드 해석
		// Scanner sc = new Scanner(System.in);
		
		// new : 힙(Heap) 영역에 객체 저장
		// Scanner() : 객체에 필요한 초기값을 부여하기 위한 생성자 메서드
		// Scanner sc : Scanner라는 클래스 자료형으로 정의된 참조변수 sc
		
		// 힙메모리 영역에 Scanner에 필요한 초기값이 담긴 객체를 생성하고
		// 현위치(main stack)에 Scanner 자료형으로 만든 sc 참조변수에 생성된 Scanner 객체의
		// '시작 메모리주소'를 저장
	}
}

```

### C01Main

```java
package Ch08;

public class C01Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		C01Person hong = new C01Person();
		
		hong.name = "홍길동";
		hong.age = 15;
		hong.height = 177.5f;
		hong.weight = 70.5;
		
		System.out.printf("%s %d %f %f\n",hong.name,hong.age,hong.height,hong.weight);
		
	}

}

```

### C01Person

```java
package Ch08;

public class C01Person {
	// 속성
	String name;
	int age;
	float height;
	double weight;
	
}

```

### C02PersonMain

```java
package Ch08;

class C02Person{
	// 속성
	String name;
	int age;
	float height;
	double weight;
		
}

public class C02PersonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C02Person hong = new C02Person();
		
		hong.name = "홍길동";
		hong.age = 15;
		hong.height = 177.5f;
		hong.weight = 70.5;
		
		System.out.printf("%s %d %f %f\n",hong.name,hong.age,hong.height,hong.weight);
		
	}

}

```

### C03PersonMain

```java
package Ch08;

class C03Person{
	// 속성
	String name;
	int age;
	float height;
	double weight;
	
	// 기능
	void talk() {
		System.out.printf("%s 님이 말합니다.\n",this.name);
	}
	
	void walk() {
		System.out.printf("%s 님이 걷습니다.\n", this.name);
	}
	
	// 속성정보 확인
	void showInfo() {
		System.out.printf("%s %d %f %f\n",this.name,this.age,this.height,this.weight);
	}

	@Override // 마우스 오른쪽 클릭 -> source -> Generate toString() 클릭
	public String toString() {
		return "C03Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}
		
}

public class C03PersonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C03Person hong = new C03Person();
		
		hong.name = "홍길동";
		hong.age = 15;
		hong.height = 177.5f;
		hong.weight = 70.5;
		
		System.out.printf("%s %d %f %f\n",hong.name,hong.age,hong.height,hong.weight);
		
		
		hong.talk();
		hong.walk();
		hong.showInfo();
		
		System.out.println(hong.toString());
		
		
	}

	@Override
	public String toString() {
		return "C03PersonMain [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}

```

### C04MethodMain

```java
package Ch08;

import java.util.Scanner;

class MethodTest{
	// 속성
			Scanner sc = new Scanner(System.in);
			
			// 기능
			public int sum1(int n1, int n2) {
				return n1+n2;
			}
			
			public int sum2() {
				return sc.nextInt() + sc.nextInt();
				
			}
			
			public void sum3(int n1, int n2) {
				System.out.println(n1+n2);
			}
			
			public void sum4() {
				System.out.println(sc.nextInt()+sc.nextInt());
			}
}

public class C04MethodMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MethodTest sumCalc = new MethodTest();
		System.out.println(sumCalc.sum1(10,20));
		System.out.println(sumCalc.sum2());
		sumCalc.sum3(10,20);
		sumCalc.sum4();
		
		
	}

}

```

### C05LocalVarMain

```java
package Ch08;

// 멤버변수 : 클래스 내부 - 메서드 영영 바깥에서 생성

//          생성된 객체의 개별 정보 저장

// static 변수 : 동일 클래스로부터 만든 여러객체간 공유하는 멤버 변수

//지역변수 : 메서드 영역내에서 
//         (or 메서드 영역내의 {}범위에서 포함) 
//		   생성되는 변수
//         (파라미터, 일반변수 포함)

// 하나의 .java 파일에는 public class가 하나만 가능
// 만약 두 개의 public class가 필요하면, 따로 .java 파일을 만들어야 함

class C05Simple{
	int num=10;  // 멤버변수
	
	void Fun1() {
		System.out.println("멤버변수 num : "+num);
		int num=10; // 지역변수
		System.out.println("지역변수 num : "+num);
		num++;
		this.num++;
	}
	void Fun2() {
		System.out.println("멤버변수 num : "+num);
		if (true) {
			int num=10;
			System.out.println("FUnc2's if안 지역변수 num : "+num);
		}
		System.out.println("num : "+num);
		
		while (num<15) {
			int num=7;
			System.out.println(num);
			num++;
			
		}
	}
	
	void Func3(int num) {
		this.num = num;
	}
}
public class C05LocalVarMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C05Simple obj = new C05Simple();
		
		obj.Fun1();
		obj.Fun2();
	}

}

```

### C06MethodOverloadingMain

```java
package Ch08;

class C06Simple {
	int sum(int x, int y) {
		System.out.println("int num(int x , int y)");
		return x + y;
	}
	
	int sum (int x, int y, int z) {
		System.out.println("int sum(int x, int y, int z)");
		return x + y + z;
	}
	
	int sum(double x, double y, double z) {
		System.out.println("int sum(double x, double y, double z)");
		return (int)(x+y+z);
	}
}

public class C06MethodOverloadingMain {
	public static void main(String[] args) {
		C06Simple obj = new C06Simple();
		
		obj.sum(10, 20);
		obj.sum(10, 20,30);
		obj.sum(10.5, 20.5,30.5);
		C06Simple obj2 = new C06Simple();
	}
}

```

<aside>
💡

### 오버로딩 조건

- **반환 타입은 관계없음!**
- **메서드 이름이 동일해야 함.**
- **매개변수의 개수 또는 타입이 달라야 함.**
- **매개변수의 순서가 다르면 오버로딩 가능!**
</aside>

### C07가변인자

```java
package Ch08;

class C07Simple{
	
	int sum(int ...arg) {
		System.out.println(arg);
		
		int sum=0;
//		for(int item : arg) {
//			System.out.println(item); // 숫자 출력
//			sum+=item;
//		}
		
		for (int i = 0; i < arg.length; i++) {
			System.out.println(arg[i]);
			sum+=arg[i];
			
		}
		return sum;
	}
}

public class C07가변인자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C07Simple ob= new C07Simple();
		System.out.println("최종 합계 : "+ob.sum(10,20,30,40,50,60,70));

		System.out.println();
		int bigSum = ob.sum(10,20,30,40,50,60,70,80,90,100);
		System.out.println("최종 합계 : "+bigSum);
	}

}

```

### C08ConstructorMain

```java
package Ch08;

// 생성자 메서드
// 객체 생성시 한번만 호출되는 메서드
// 생성된 객체 내애서는 사용이 불가능
// 객체 생성시에 필요한 메모리공간 형성과 "초기값 부여"에 사용
// 생성자 메서드 이름은 클래스 이름과 동일하며 반환자료형은 가지지 않는다.

// 생성자 함수를 클래스 내에 명시하지 않으면(코드 삽입 x) 컴파일러에 의해 주입되는
// 생성자가 있는데 이를 디폴트 생성자라고 한다.
class C08Simple{
	// 속성
	int n1;
	double n2;
	boolean n3;
	String n4;
	
	C08Simple(){
		System.out.println("C08Simple() 생성자 호출 - 디폴트 생성자");
	}
	C08Simple(int n1){
		this.n1 = n1;
		System.out.println("C08Simple(int n1)생성자 호출!");
	}
	C08Simple(int n1, double n2){
		this.n1 = n1;
		this.n2 = n2;
		System.out.println("C08Simple(int n1, double n2)생성자 호출!");
	}
	C08Simple(int n1, double n2,boolean n3){
		this.n1 = n1;
		this.n2= n2;
		this.n3= n3;
		System.out.println("C08Simple(int n1, double n2,boolean n3)생성자 호출!");
	}
//	C08Simple(int n1, double n2, boolean n3, String n4){
//		this.n1 = n1;
//		this.n2 = n2;
//		this.n3 = n3;
//		this.n4 = n4;
//		System.out.println("C08Simple(int n1, double n2, boolean n3, String n4)생성자 호출!");
//	}
	
	// source -> Generate Constructor Using Fields 클릭
	public C08Simple(int n1, double n2, boolean n3, String n4) {
		super();
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		this.n4 = n4;
	}
	
	//to String 재정의
	@Override
	public String toString() {
		return "C08Simple [n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", n4=" + n4 + "]";
	}

}

public class C08ConstructorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		C08Simple ob0 = new C08Simple();
		
		C08Simple ob1 = new C08Simple(10);
		C08Simple ob2 = new C08Simple(10,10.5);
		C08Simple ob3 = new C08Simple(10,10.5,true);
//		C08Simple ob4 = new C08Simple(10,10.5,true,"홍길동");
		
		System.out.println(ob1);
		System.out.println(ob2);
		System.out.println(ob3);
//		System.out.println(ob4);
	}

}

```

<aside>
💡

`System.out.println(ob1);` 같은 코드를 실행했을 때, `toString()` 메서드가 호출되는 이유는 **Java에서 `System.out.println(object)`를 호출하면 자동으로 `object.toString()`을 호출하도록 설계**되어 있기 때문입니다.

기본적으로 `toString()`을 오버라이딩하지 않으면 객체의 클래스 이름과 해시 코드가 출력됩니다.

toString 오버라이딩 하지 않으면 밑에 처럼 나온다.

Ch08.C08Simple@2ff4acd0
Ch08.C08Simple@54bedef2
Ch08.C08Simple@5caf905d
Ch08.C08Simple@27716f4

</aside>

<aside>
💡

생성자를 아무것도 만들지 않았으면 컴파일러가 자동으로 default 생성자를 만들어준다.

그러나 생성자가 하나라도 만들어져 있으면 디폴트 생성자를 자동으로 만들어주지 않는다.

내가 직접 디폴트 생성자도 만들어야 한다.

</aside>

<aside>
💡

하나의 .java 파일에는 public class가 하나만 가능

만약 두 개의 public class가 필요하면, 따로 .java 파일을 만들어야 함

문제는 클래스에 `public`이 두 개 이상 있느냐이지, 생성자나 메서드에서 `public`이 여러 번 사용되는 것은 문제되지 않습니다.

</aside>

### C09Ex

```java
package Ch08;

import java.util.Scanner;

import javax.security.sasl.RealmCallback;

//class TV{
//	String brand;
//	int leaseYear;
//	int size;
//	
//	TV(String Brand, int makeYear, int size){
//		this.brand = Brand;
//		this.leaseYear = makeYear;
//		this.size = size;
//		
//	}
//	
//	public void show() {
//		System.out.printf("%s에서 만든 %d년 %d인치 TV",this.brand,this.leaseYear,this.size);
//	}
//}

//class Grade{
//	int mathScore;
//	int scienceScore;
//	int englishScore;
//	
//	Grade(int math, int science, int english){
//		mathScore=math;  // 멤버변수와 생성자의 매개변수의 이름이 달라서 this 안써도 된다.
//		scienceScore= science;
//		englishScore=english;
//	}
//	
//	public double average(){
//		double avg = (mathScore + scienceScore + englishScore)/3.0;
//		return avg;
//	}
//}

class Song{
	String title;
	String artist;
	int year;
	String country;
	
	Song(){
		this("title","artist",0000,"country");
	}
	Song(String SongTitle, String SongArtist, int releaseYear, String CountryName){
		title = SongTitle;
		artist = SongArtist;
		year = releaseYear;
		country = CountryName;
	}
	
	public void show() {
		System.out.printf("%d년 %s국적의 %s가 부른 %s\n",year,country,artist,title);
	}
}

public class C09Ex {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		//package Ch08Ex;
		//
		//public class C00문제 {
//			--------------------------------------------
//			문제 - 이것이자바다
//			--------------------------------------------
//			https://scksk.tistory.com/6
		//

//     1번
//	   TV myTV = new TV("LG", 2017, 32); //LG에서 만든 2017년 32인치
//	   myTV.show();
	   
//	   2번
//	   Scanner sc = new Scanner(System.in);
//	   
//	   System.out.print("수학, 과학, 영어 순으로 3개의 정수 입력 >> ");
//	   int math = sc.nextInt();
//	   int science = sc.nextInt();
//	   int english = sc.nextInt();
//	   Grade me = new Grade(math, science, english);
//	   System.out.println("평균은 "+me.average()); // average()는 평균을 계산하여 리턴
//	   
//	   sc.close();
	   
//	   3번
	   Song song1 = new Song();
	   song1.show();
		
	   Song song2 = new Song("Dancing Queen","ABBA",1978,"스웨덴");
       song2.show();
	   
//     LG에서 만든 2017년형 32인치 TV

//			12번-16번 확인하기
		//
//			--------------------------------------------
//			--추가(명품자바)
//			--------------------------------------------
//			https://security-nanglam.tistory.com/213
		//
		//
//			--------------------------------------------
//			--추가
//			--------------------------------------------
//			https://iu-corner.tistory.com/entry/JAVA-%EC%9E%90%EB%B0%94-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%97%B0%EC%8A%B5-%EB%AC%B8%EC%A0%9C-%EB%AA%A8%EC%9D%8C-1
		//
	}
}
	

```

<aside>
💡

현재 클래스의 다른 생성자를 호출하려면 `this(...)`를 사용해야 함

기본 생성자 `Song()`이 `this("title", "artist", 0000, "country")`를 호출하면, `Song(String, String, int, String)` 생성자가 실행된다.

**`this(...)`는 반드시 생성자의 첫 번째 줄에서만 사용 가능.**

**첫 번째 줄이 아니면 컴파일 오류 발생!**

**객체 초기화 순서를 유지하기 위해 첫 번째 줄에서 실행해야 함.**

Example() {
this(10, 20); // ✅ 첫 번째 줄에서 다른 생성자 호출
System.out.println("Default Constructor");
}

Example() {
System.out.println("Default Constructor"); // ⚠️ 첫 번째 줄이 아님!
this(10, 20); // ❌ 오류! this(...)는 첫 번째 줄에서만 호출해야 함
}

</aside>

### C10Main

```java
package Ch08;

// 홍길동이 사과장수에게 사과를 구매한다
// 구매자              판매자
// 보유금액(속성)       보유금액(속성)
// 보유 사과개수        사과개수(속성)
//					 개당가격(속성)
// 구매하기(기능)       판매하기(기능)

// 1) 특정사과장수에게 돈을 건넨다 ->
// 2) 돈을 내 보유금액에 누적
// 3) 사과갯수 개산. -> 나의 보유 사과개수에서 차감 -> 사과개수 전달
// 4) 나의 보유 사과개수에 누적

class Buyer{ //구매자 (사는사람)
	private int myMoney;
	private int appleCnt;
	
	// 모든 인자 생성자
	// toString
	public Buyer(int myMoney, int appleCnt) {
		super();
		this.myMoney = myMoney;
		this.appleCnt = appleCnt;
	}

	@Override
	public String toString() {
		return "Buyer [myMoney=" + myMoney + ", appleCnt=" + appleCnt + "]";
	}
	
	public void payment(Seller seller, int money) {
		// 내 보유금액에서 차감
		// seller에 money를 전달하고 return 되는 사과 개수를 누적
		this.myMoney-=money;
		this.appleCnt += seller.receive(money);
	}
	
	
}
class Seller{ // 판매자 (파는사람)
	private int myMoney;
	private int appleCnt;
	private int price;
	
	//모든 인자 생성자
	// toString
	public Seller(int myMoney, int appleCnt, int price) {
		super();
		this.myMoney = myMoney;
		this.appleCnt = appleCnt;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Seller [myMoney=" + myMoney + ", appleCnt=" + appleCnt + ", price=" + price + "]";
	}

	public int receive(int money) {
		// 구매자로부터 전달받은 money를 내보유금액에 누적
		// 전달받은금액/사과개수를 리턴
		this.myMoney += money;
		this.appleCnt-=(money/this.price);
		return money/this.price;
	}
	
}
public class C10Main {
	public static void main(String[] args) {
		
		Seller seller = new Seller(10000,100,1000);
		
		Buyer 홍길동 = new Buyer(10000,0);
		Buyer 노홍철 = new Buyer(5000,0);
		
		홍길동.payment(seller, 5000);
		노홍철.payment(seller, 2000);
		
		System.out.println(홍길동);
		System.out.println("----------------------------");
		System.out.println(노홍철);
		System.out.println("-----------------------------");
		System.out.println(seller);
	}
}

```

## Ch09

### C01정보은닉

```java
package Ch09;

// 접근 제어자
// 멤버 클래스의 접근범위를 제한을 위한 예약어
// public : 모든 클래스에서 접근가능
// private : 해당 클래스에서만 접근가능
// protected : 상속 관계를 가지는 경우에 접근가능
// default(기본) : 동일 패키지에 속한 클래스에서 접근가능.

class C01Person{
	private String name; // private는 처음 생성자에서 초기화한다.
	int age;
	private String addr;
	
	public C01Person(String name, int age, String addr) {
		this.name= name;
		this.age= age;
		this.addr = addr;
		
	}
	
//	//getter 함수(데이터를 외부로 반환)
//	public String getName() {
//		return this.name;
//		
//	}
//	
//	public int getAge1() {
//		return this.age;
//	}
//	
//	//setter 함수(기존데이터를 수정)
//	public void setAge(int age) {
//		this.age = age;
//	}

	
	// source에서 Generate Getters and Setters 클릭해서 자동 완성
	
	
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}
	
	public int setAge(int age) {
		return this.age =age;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}

public class C01정보은닉 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C01Person person1 = new C01Person("홍길동",55,"대구");
		System.out.println(person1.getName());
		person1.setAge(56);
		System.out.println(person1.getAge());
		
	}

}

```

### C02캡슐화

```java
package Ch09;

// 캡슐화란
// 특정 목적을 가지는 기능을 구현하는데 필요한 세부 기능들을 묶어서 처리하는 방법
// 특정 목적을 가지는 기능 구현에 있어서 각 과정의 전부가 외부로 노출되는 문제 막기 위해
// 정보은닉을 수반한다(필수는 아님)
// 캡슐화 작업은 각 공정과정에 대한 정확한 이해가 수반되어야 한다.

class Engine{
	private void 흡입() {
		System.out.println("외부로부터 공기를 빨아들인다.");
		
	}
	private void 압축() {
		System.out.println("가둔 공기를 압축시킨다");
	}
	private void 폭발() {
		System.out.println("일정 수준압축되면 폭발!");
	}
	private void 배기() {
		System.out.println("가스를 외부로 보낸다.");
	}
	
	// 캡슐화
	public void EngineStart() {
		흡입();
		압축();
		폭발();
		배기();
	}
}

class Car{
	Engine engine;
	
	Car(){
		engine= new Engine();
	}
	void run() {
		engine.EngineStart();
	}
}

public class C02캡슐화 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car car = new Car();
		car.run();
	}

}

```

### C03This

```java
package Ch09;

// this
// 클래스 내에서 사용되는 예약어
// 생성되는 객체의 위치정보(메모리주소-해시코드값)을 확인하는데 사용

// this : 멤버변수와 지역변수 구별에 사용
// this : 다른 생성자 호출 사용

class C03Simple{
	int x;
	int y;
	
	C03Simple(){
		this(0,0);
		System.out.println("C03Simple()...");
	}
	C03Simple(int x){
		this(x,0);
		System.out.println("C03Simple(int x)... 생성자 호출");
		this.x = x;
	}
	C03Simple(int x,int y){
		System.out.println("C03Simple(int x, int y)... 생성자 호출");
		this.x=x;
		this.y=y;
	}
	
	
	C03Simple getThis() {
		return this;
	}
}

public class C03This {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C03Simple ob = new C03Simple();
		System.out.println(ob);
		System.out.println(ob.getThis());
	}

}

```

### C04StringClass

```java
package Ch08;

import javax.sound.sampled.AudioSystem;

public class C04StringClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		String str4 = new String("java");
		
		System.out.println("str1==str2 ?" +(str1==str2));
		System.out.println("str3==str4 ?" +(str3==str4));
		System.out.println("str1==str3 ?" +(str1==str3));
		System.out.println("str2==str4 ?" +(str2==str4));
		
		
		System.out.println("----------------------------------------");
		System.out.printf("%x\n",System.identityHashCode(str1));
		System.out.printf("%x\n",System.identityHashCode(str2));
		System.out.printf("%x\n",System.identityHashCode(str3));
		System.out.printf("%x\n",System.identityHashCode(str4));
		
		System.out.println("----------------------------------------");
		System.out.println("str1==str2 ? " + (str1.equals(str2)));
		System.out.println("str3==str4 ? " + (str3.equals(str4)));
		System.out.println("str1==str3 ? " + (str1.equals(str3)));		
		System.out.println("str2==str4 ? " + (str2.equals(str4)));	
		
		System.out.println("----------------------------------------");
		
		System.out.println("str1==str2 ? " + (str1==str2));
		System.out.println("str3==str4 ? " + (str3==str4));
		System.out.println("str1==str3 ? " + (str1==str3));
		
	
	}
}

--------------------------------------------------------------------------
출력값

str1==str2 ?true
str3==str4 ?false
str1==str3 ?false
str2==str4 ?false
----------------------------------------
13221655
13221655
e9e54c2
65ab7765
----------------------------------------
str1==str2 ? true
str3==str4 ? true
str1==str3 ? true
str2==str4 ? true
----------------------------------------
str1==str2 ? true
str3==str4 ? false
str1==str3 ? false
```

<aside>
💡

String str1 = "java";
String str3 = new String("java");

System.out.println(str1.equals(str3)); // true

`str1`은 리터럴 풀(String Pool)에 저장된 문자열입니다.

`str3`은 `new String("java")`로 힙(Heap) 메모리에 새롭게 생성된 객체입니다.

따라서 `Eequals()` 메서드는 **문자열의 내용**을 비교하기 때문에 `true`를 반환합니다.

---

System.out.println(str1 == str3); // false

`str1`은 **String Pool**에 저장된 `"java"`를 가리킵니다.

`str3`은 `new` 키워드를 사용하여 **Heap 메모리**에 새로운 객체를 생성했습니다.

따라서 `==`는 서로 다른 메모리 주소를 가리킨다고 판단하여 `false`를 반환합니다

---

`equals()` → **문자열 값**을 비교

`==` → 주소(참조값)을 비교

</aside>

### C05StringClass

```java
package Ch09;

public class C05StringClass {
	public static void main(String[] args) {
		
//		String str1 = "Java Powerful";
//		String str2 = new String("Java Programming");
//		String str3 = str1+str2;
//		String str4 = str1.concat(str2); // concat는 공간을 새롭게 만든다.
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
		
		int i=0;
		StringBuilder str = new StringBuilder();
		
		while (i<10) {
			
			str.append(i);
			System.out.print("str : " + str+" ");
			System.out.printf("위치 : %x\n",System.identityHashCode(str));
			i++;
		}
		
		
	}
}

------------------------------------------------------------------------------------
일반 String 에다가 += 연산 반복
(concat()함수도 똑같이 값이 계속 바뀐다.)

str : 0 위치 : 7229724f
str : 01 위치 : 7cca494b
str : 012 위치 : 7ba4f24f
str : 0123 위치 : 3b9a45b3
str : 01234 위치 : 7699a589
str : 012345 위치 : 58372a00
str : 0123456 위치 : 4dd8dc3
str : 01234567 위치 : 6d03e736
str : 012345678 위치 : 568db2f2
str : 0123456789 위치 : 378bf509

-------------------------------------------------------------------------------------
StringBuilder 사용했을 때 출력값
(메모리 누수 방지 클래스 : StringBuilder, StringBuffer)

str : 01234 위치 : 31befd9f
str : 012345 위치 : 31befd9f
str : 0123456 위치 : 31befd9f
str : 01234567 위치 : 31befd9f
str : 012345678 위치 : 31befd9f
str : 0123456789 위치 : 31befd9f

```

### C06Ex

```java
package Ch09;

import java.util.Arrays;

class Profile{
	//속성
	String name;
	String addr;
	String job;
	String major;
	//생성자
	//1)디폴트생성자 삽입
	//2)모든 인자 받는 생성자 삽입 -> 각멤버에 대입
	//3)모든 인자 받는 생성자 삽입(가변인자사용할것) -> , 를기준으로 잘라내어 각속성에 저장
	//ex, "홍길동,대구,프로그래머,컴퓨터공학" ->[홍길동,대구,프로그래머,컴퓨터공학]
	
	public Profile() {
	}
	public Profile(String name, String addr, String job, String major) {
		this.name = name;
		this.addr = addr;
		this.job = job;
		this.major = major;
		
	}
	
	public Profile(String ...dumy) { // 가변인자 사용
		
		this.name = dumy[0];
		this.addr = dumy[1];
		this.job = dumy[2];
		this.major = dumy[3];
	}
	
	public Profile(String all) {  // 문자열로 받아와서 split으로 잘라 배열에 저장
		String [] arr = all.split(",");
		this.name = arr[0];
		this.addr = arr[1];
		this.job = arr[2];
		this.major = arr[3];
	}
	//기능
	//1) getter and setter 삽입
	//2) toString  재정의 
	//3) boolean isContain(String findstr) 함수 완성하기

	
	// getter
	public String getName() {
		return this.name;
	}
	public String getAddr() {
		return this.addr;
	}
	public String getJob() {
		return this.job;
	}
	public String getMajor() {
		return this.major;
	}
	
	// setter
	
	public String setName(String name) {
		return this.name = name;
	}
	public String setAddr(String addr) {
		return this.addr = addr;
	}
	public String setJob(String job) {
		return this.job = job;
	}
	public String setMajor(String major) {
		return this.major = major;
	}
	
	// toString 재정의

	@Override
	public String toString() {
		return "Profile [name=" + name + ", addr=" + addr + ", job=" + job + ", major=" + major + "]";
	}
	
	
	boolean isContain(String findstr) {
	//findstr의 문자열이 각멤버인 name,addr,job,major 중 하나라도 포함되어 있으면 true 리턴
	//아니면 false 리턴
		if (this.name.contains(findstr)) {
			return true;
		}else if(this.addr.contains(findstr)) {
			return true;
		}else if(this.job.contains(findstr)) {
			return true;
		}else if(this.major.contains(findstr)){
			return true;
		}else {
			return false;
		}
		
}
	
	
 
	//4)
	boolean isEquals(String str) {
		//all로 받은 문자열을 , 단위로 잘라내어(split(",")) 각각 나눠진 문자열이
		//name,addr,job,major 와 일치 하면 true
		//아니면 false 를 리턴
		String arr2[] = str.split(",");
		if (arr2[0].equals(this.name)&&
			arr2[1].equals(this.addr)&&
			arr2[2].equals(this.job)&&
			arr2[3].equals(this.major)) {
			
			return true;
		}
		else {
			return false;
		}
	}
	
}
public class C06Ex {

	public static void main(String[] args) {
		Profile hong = new Profile("홍길동,대구,프로그래머,컴퓨터공학");
//		System.out.println(hong.toString());
		System.out.println("길동 포함여부 : " + hong.isContain("길동"));	//true
		System.out.println("컴퓨터 포함여부 : " + hong.isContain("컴퓨터"));	//true
		System.out.println("프로필 일치여부 : " + hong.isEquals("홍길동,대구,프로그래머,컴퓨터공학"));//false
		System.out.println("프로필 일치여부 : " + hong.isEquals("홍길동,울산,프로그래머,컴퓨터공학"));//false

	}

}

```

## Ch10

### C01ArrayMain

```java
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
```

### C02ArrayMain

```java
package Ch10;

import java.util.Arrays;

public class C02ArrayMain {
	public static void main(String[] args) {
		
		// 얕은복사(주소복사)
		int arr1[] = {10,20,30};
		int arr2[];
		arr2 = arr1;
		arr1[0] = 100;
		
		Arrays.stream(arr1).forEach(System.out::println);
		
		
		// 깊은 복사 (값복사)
		int arr3[] = new int[3];
		for (int i = 0; i < arr1.length; i++) {
			arr3[i] = arr1[i];
			
		}
		
		//Array API
		int arr4[] = Arrays.copyOf(arr1, arr1.length);
		
		System.out.println("arr1 : " + arr1);
		System.out.println("arr2 : " + arr2);
		System.out.println("arr3 : " + arr3);
		System.out.println("arr4 : " + arr4);
	}
}

```

### C03ArrayMain

```java
package Ch10;

public class C03ArrayMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {
				{10,20,30},
				{40,50,60,65,67},
				{70,80,90,96,11,56},
				{100,110,120,15,22,33,44},
		};
		
		System.out.println("행의 길이 : " + arr.length);
		System.out.println("행의 길이 : " + arr[0].length);
		System.out.println("행의 길이 : " + arr[1].length);
		System.out.println("행의 길이 : " + arr[2].length);
		System.out.println("행의 길이 : " + arr[3].length);
	}

}

```

### C04ClassArrayMain

```java
package Ch10;

class C04Person{
	String name;
	int age;
	

	public C04Person() {
		super();
		
	}

	public C04Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "C04Person [name=" + name + ", age=" + age + "]";
	}
}

public class C04ClassArrayMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C04Person list[] = new C04Person[3];
		
		list[0] = new C04Person();
		list[0].name = "홍길동";
		list[0].age = 55;
		
		
		list[1] = new C04Person();
		list[1].name = "김영희";
		list[1].age = 35;
		
		list[2] = new C04Person();
		list[2].name = "김범수";
		list[2].age = 40;
		
		
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
			
		}
		
		System.out.println("--------------------------------------");
		
		for (C04Person item : list) {
			System.out.println(item);
		}
	}

}

```

<aside>
💡

C04Person list[] = new C04Person[3];

이 코드는 C04Person 객체의 참조를 저장할 수 있는 배열 공간을 생성합니다. 배열의 각 요소는 처음에 **null**로 초기화됩니다.

list[0] = new C04Person();

이 코드는 힙 메모리 상에 새 C04Person 객체를 생성한 후, 그 객체의 참조(메모리 주소)를 list[0]에 할당합니다. 예를 들어, 새 객체의 주소가 200이라면 list[0]에는 200이 저장됩니다.

배열 자체는 객체들을 직접 저장하는 것이 아니라 객체의 참조(주소)를 저장합니다.

각 배열 요소에 실제 객체를 할당해야 해당 객체의 멤버에 접근하거나 메소드를 호출할 수 있습니다.

</aside>

![제목_없음](https://github.com/user-attachments/assets/e8ea4e1b-b7ad-4d8c-aa78-5e675a2481d8)

<aside>
💡

Call by Value

- 값을 복사해서 전달하기  때문에 원본 변수에는 영향 x
- JAVA는 기본 자료형을 전달할때 항상 Call by Value 방식 사용

```java
public class CallByValueExample {
    public static void main(String[] args) {
        int num = 10;
        modifyValue(num); // 메서드 호출
        System.out.println("메서드 호출 후 num: " + num); // 원본 값 유지
    }

    public static void modifyValue(int x) {
        x = 100; // x의 값을 변경
        System.out.println("메서드 내부 x: " + x);
    }
}
```

```java
메서드 내부 x: 100
메서드 호출 후 num: 10
```

원본은 그대로다.

왜냐하면 num의 값만 복사되어 전달되었기 때문에

Call by Reference

주소(참조)를 전달하므로 메서드 내에서 값을 변경하면 원본에도 영향을 준다.

Java는 객체(Object)**,** 배열(Array)**,** 컬렉션(Collection)을 전달할 때 Call by Reference처럼 ****동작한다.

```java
import java.util.Arrays;

public class CallByReferenceExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        modifyArray(arr); // 배열을 메서드에 전달
        System.out.println("메서드 호출 후 배열: " + Arrays.toString(arr));
    }

    public static void modifyArray(***int[] array***) {
        array[0] = 100; // 배열의 첫 번째 값 변경
        System.out.println("메서드 내부 배열: " + Arrays.toString(array));
    }
}
```

```java
메서드 내부 배열: [100, 2, 3, 4, 5]
메서드 호출 후 배열: [100, 2, 3, 4, 5]
```

modifyArray()에서 배열을 변경했더니 원본이 변경되었다.

왜냐하면 arr의 주소(참조값)가 전달되었기 때문이다. 

자바에서는 항상 Call by Value만 존재한다.!!!!

- Java는 **모든 인자를 Call by Value로 전달**함.
- 하지만 **객체나 배열을 전달할 때는 참조(주소) 자체가 값으로 전달**되므로, Call by Reference처럼 동작하는 것처럼 보임.
- 즉, **객체의 내용은 변경되지만, 객체 자체를 변경하면 원본에는 영향이 없음**.

```java
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}

public class CallByValueWithObject {
    public static void main(String[] args) {
        Person p = new Person("John");
        modifyPerson(p);
        System.out.println("메서드 호출 후 name: " + p.name);
    }

    public static void modifyPerson(Person person) {
        person = new Person("Alice"); // 새로운 객체 할당
        System.out.println("메서드 내부 name: " + person.name);
    }
}

```

```java
메서드 내부 name: Alice
메서드 호출 후 name: John
```

`person`에 새로운 객체를 할당해도 **원본 `p`에는 영향 없음!**
이유는 **새로운 객체의 참조값이 변경되었을 뿐, 기존 참조값은 유지됨**.

그림으로 설명

```java
초기 상태:
p  ----->  [ Person(name="John") ]

modifyPerson(p) 호출 후:
person  ----->  [ Person(name="Alice") ]  (새로운 객체)
p  ----->  [ Person(name="John") ]  (원본 객체는 그대로)

```

</aside>

### C05MainParam

```java
package Ch10;

public class C05MainParam {

	public static void main(String[] args) {
		System.out.println("length : " + args.length);
		for(String param : args) {
			System.out.println(param);
		}
	}

}

```

### C06Ex

```java
package Ch10;

import java.util.Scanner;

public class C06Ex {
	//5개의 정수값을 입력받아 int형 배열에 저장하고
	//최대값,최소값,전체합을 출력합니다.
	
	//5 명의 학생에 국영수점수를 입력받아 2차원배열 저장
	//각 학생의 국영수 점수의 합/평균 구하고
	//각 과목당 합 /평균 구해보세요
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score[][] = new int[5][3];
		
		for(int i=0;i<score.length;i++) {
			System.out.printf("%d 번째 학생 국영수 입력 : ",i+1);
			score[i][0] = sc.nextInt(); //i번째학생의 국어점수입력
			score[i][1] = sc.nextInt(); //i번째학생의 영어점수입력
			score[i][2] = sc.nextInt(); //i번째학생의 수학점수입력
		}
		
		//학생별 점수 총점 / 평균
		for(int i=0;i<score.length;i++) {
			int sum = score[i][0] +score[i][1]+score[i][2];
			double avg = (double)sum/3;
			System.out.printf("%d 번째 학생 총점 : %d 평균 : %f\n",i+1,sum,avg);
		}
		
		//과목별 점수 총점 / 평균
		int subject_sum[] = new int[3];
		for(int i=0;i<score[i].length;i++) //국어 , 영어 , 수학 
		{	
			for(int j=0;j<score.length;j++) {			
				subject_sum[i] +=score[j][i];	
			}
		}
		System.out.printf("국어 총점 : %d 국어 평균 : %f\n",subject_sum[0],(double)subject_sum[0]/score.length);
		System.out.printf("영어 총점 : %d 영어 평균 : %f\n",subject_sum[0],(double)subject_sum[1]/score.length);
		System.out.printf("수학 총점 : %d 수학 평균 : %f\n",subject_sum[0],(double)subject_sum[2]/score.length);
		
		
	}
}

```

## Ch11

### C01Simple

```java
package Ch11;

class C01Simple{
	static int num1;
	int num2;
	
	//static : 클래스 내에 멤버에 적용하는 경우
	//해당 클래스로 객체 생성시 모든 객체간의 공유되는 멤버로 지정
	//클래스이름으로도 static멤버에 접근이 가능
	
	
	public C01Simple() {
		num1 = 0;
		num2 = 0;
	}
	public C01Simple(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}

	@Override
	public String toString() {
		return "C01Simple [num1=" + num1 + ", num2=" + num2 + "]";
	}
}

public class C01StaticMain {
	
	public static void main(String[] args) {

		
		C01Simple ob1 = new C01Simple();
		C01Simple ob2 = new C01Simple();
		
		C01Simple.num1=100;
		System.out.println(C01Simple.num1);
		
		System.out.println(ob1);
		System.out.println(ob2);
	}
	
}

```

### C02StaticMain

```java
//package Ch11;
//
//
//class C02Simple{
//	static int n1;
//	int n2;
//	
//	void func1() {
//		n1=100;
//		n2=200;
//	}
//	static void func2() {
//		n1=100;
//		n2=200;		// static 함수에서 사용되는 변수는, static변수 or 지역변수 선언이후 사용가능
					// 사용할려면 인스턴스 변수이기 때문에 객체 생성후 사용해야한다. 
//	}
//	
//}
//
//public class C02StaticMain {
//
//	public static void main(String[] args) {
//	
//	}
//
//}

```

<aside>
💡

**객체마다 별도로 존재하는 인스턴스 변수와 달리**, `static` 변수는 클래스당 하나만 존재.모모든 객체가 해당 변수를 공유함

객체가 로드될때 메모리로 올라가는것이 아니라 클래스가 로드될때 자동으로 메모리에 할당된다.

```java
class Example {
    static int count = 0; // static 변수
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Example.count); // 클래스명으로 접근
    }
}
```

```java
0
```

static 변수는 클래스명을 통해서 직접 접근할 수 도 있다. 

객체로도 접근할 수 있지만 인스턴스랑 헷갈리기 때문에 가독성 측면에서 클래스명으로 호출하는것이 좋다.

static 메서드도 만차가지로 클래스명으로 접근할 수 있다.

</aside>

### C03SingletonPattern

```java
package Ch11;

class Company{
	
	// 싱글톤 패턴 구조
	private static Company instance;
	private Company() {}
	public static Company getInstance() {
		if (instance==null) {
			instance = new Company();
		}
		return instance;
		
	}
}

public class C03SingletonPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Company com1 = Company.getInstance();
		Company com2 = Company.getInstance();
	}

}

```

<aside>
💡

싱글톤 패턴(Singleton Pattern)은 클래스의 인스턴스를 **하나만 생성**하도록 보장하는 디자인 패턴입니다. 즉, 특정 클래스에 대해 오직 **하나의 객체만 존재**하고, 해당 객체를 여러 곳에서 공유해서 사용할 수 있도록 합니다.

`private static Company instance;` → 클래스 내부에서 단 하나의 객체를 저장하는 변수.

`private Company();` → **생성자를 `private`으로 설정하여 외부에서 객체 생성을 막음.**

public static Company getInstance() {
    if (instance == null) {  // 객체가 없을 경우에만 생성
        instance = new Company();
    }
    return instance;  // 항상 같은 객체를 반환
}

</aside>

### C04Ex

```java
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

```

### C05Ex

```java
package Ch11;

class ShopService{
	
	private static ShopService ss;
	
	public ShopService() {  // 디폴트 생성자
		
	}
	
	public static ShopService getInstance() {
		if (ss == null) {
			ss = new ShopService();
		}
		return ss;
	}
}

public class C05Ex {
	public static void main(String[] args) {
		//---------------------------------------
		//Practice
		//---------------------------------------
		//shopService 객체를 싱글톤으로 만들어 보세요 
		//ShopServiceExample 클래스에서 shopService 의 getInstance() 메소드로 싱글톤을 얻을 수 있도록
		//ShopService 클래스를 작성해보세요
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();
		if (obj1 == obj2) {
			System.out.println("같은 ShopService 객체입니다.");
		} else {
			System.out.println("다른 ShopService 객체 입니다.");
		}
	}
}

```

## Ch12

### C00INFO

```java
package Ch12;

public class C00INFO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 상속(물려줌 - 계층구조)
		// 상위(부모, super)클래스의 속성과 기능을 하위(자식, sub)클래스에서
		// 그대로 물려받아 사용할 수 있도록 허용한 문법
		
		// 상위클래스로부터 속성/기능을 물려받은 하위클래스는 그외의 속성/기능을 추가할  수 있다.
		// 상위클래스로부터 속성/기능을 물려받은 하위클래스는 물려받은 기능을 고쳐서 사용할 수 있다.
		// (오버라이딩)
		// extends 예약어 이용
		
		// 상속 쓰는 이유?
		// 1. 확장성
		// 2. 유지보수
		// 3. 가독성
		// 4. 코드중복 최소화
		
		
	}

}

```

### C01InheritanceMain

```java
//package Ch12;
//
//
//class Point2D{
//	int x;
//	int y;
//	
//	Point2D(){
//		System.out.println("Point2D 디폴트 생성자 호출!");
//	}
//}
//
//class Point3D extends Point2D{
//	int z;
//
//	Point3D(){
//		System.out.println("Point3D 디폴트 생성자 호출!");
//	}
//	
//	@Override
//	public String toString() {
//		return "Point3D [z=" + z + ", x=" + x + ", y=" + y + "]";
//	}
//	
//	
//}
//
//public class C01InheritanceMain {
//	public static void main(String[] args) {
//		Point3D ob1 = new Point3D();
//		ob1.x = 10;
//		ob1.y = 20;
//		ob1.z = 30;
//		System.out.println(ob1);
//	}
//}

```

### C02InheritanceMain

```java
package Ch12;

class Point2D{
	int x;
	int y;
	
	Point2D(){
		System.out.println("Point2D 디폴트 생성자 호출!");
	}
	
	Point2D(int x){
		this.x = x;
		System.out.println("Point2D (int x) 생성자 호출!");
	}
	
	Point2D(int x, int y){
		this.x = y;
		this.y = y;
		System.out.println("Point2D (int x, int y) 생성자 호출!");
	}
}

class Point3D extends Point2D{
	int z;

	Point3D(){
		System.out.println("Point3D 디폴트 생성자 호출!");
	}
	
	Point3D(int x){
		super(x); // 상위 클래스 Point2d(int x) 생성자 호출
		this.x = x;
	}
	
	Point3D(int x, int y){
		super(x,y);
		System.out.println("Point3D(int x, int y) 생성자 호출!");
		
	}
	
	Point3D(int x, int y, int z){
		super(x,y);
		this.z = z;
		System.out.println("Point3D(int x, int y, int z) 생성자 호출!");
		
	}
	
	@Override
	public String toString() {
		return "Point3D [z=" + z + ", x=" + x + ", y=" + y + "]";
	}
	
	
}

public class C02InheritanceMain {
	
	public static void main(String[] args) {
		Point3D ob1 = new Point3D(10,20,30);
		System.out.println(ob1);
	}
	

}

```

### C03MethodOverriding

```java
package Ch12;

// 함수 재정의(Method Overriding)
// 상속 관계룰 전제로 상위클래스의 메서들 하위클래스가 재정의(고쳐사용)하는 것을 헝용한 문법
/// 메서드의 헤더부분은 동일하게 두고 본체({})의 로직을 수정하게끔 허용함으로 다양한 형태의 객체가
// 형성될 수 있도록 유도(다형성)
//상위클래스로 부터 동일한 메서드를 물려받더라도 각 항위클래스마다 다른기능구현의
// 결과품을 만들어 낼수 있다.

// 오버로딩 vs 오버라이딩

// 오버로딩
// 상속전제 : x
// 함수헤더 변경(반환자료형-고정,함수명-고정,파라미터-변경)

// 오버라이딩
// 상속전제 : ㅇ
// 함수로직 변경(헤더 고정)
// 다형성을 목적으로 한 문법요소

class Animal{
	void sound() {
		System.out.println("소리낸다.");
	}
}
class dog extends Animal{
	
	@Override
	void sound() {
		System.out.println("멍멍");
	}
}
class Cat extends Animal{
	@Override
	void sound() {
		System.out.println("야옹");
	}
}

public class C03MethodOverriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal ani = new Animal();
		dog dog1 = new dog();
		dog1.sound();
		
		Cat cat1 = new Cat();
		cat1.sound();
		
		
		System.out.println();
		ani = dog1;  //상위클래스 참조변수로 하위객체 Dog 연결
		ani.sound();
		
		ani = cat1;  //상위클래스 참조변수로 하위객체 Cat 연결
		ani.sound();
	}

}

```

### C04Ex

```java
package Ch12;

//이것이자바다 상속문제 
//https://velog.io/@kaihojun/%EC%9D%B4%EA%B2%83%EC%9D%B4-%EC%9E%90%EB%B0%94%EB%8B%A4-%EA%B0%9C%EC%A0%95%ED%8C%90-7%EC%9E%A5-%EC%83%81%EC%86%8D-%ED%99%95%EC%9D%B8-%EB%AC%B8%EC%A0%9C-%ED%92%80%EC%9D%B4

//명품자바 상속문제
//https://cs-ssupport.tistory.com/84

//[1번] 다음 main() 메소드와 실행 결과를 참고하여 TV를 상속받은 ColorTV 클래스를 작성하라.
class TV{
	int size;
	
	TV(int size){
		this.size = size;
	}
}
class ColorTv extends TV{
	int color;
	
	ColorTv(int size, int color){
		super(size);
		this.color = color;
	}
	void printProperty() {
		System.out.printf("%d인치 %d컬러\n",this.size,this.color);
	}
}

//출력 결과
//32인치 1024컬러
public class C04Ex {
	public static void main(String[] args) {
		ColorTv myTV = new ColorTv(32, 1024);
		myTV.printProperty(); // 32인치 1024컬러 가 나오면 해결!
	}
	   
}

```

### C05Ex

```java
package Ch12;

class Employee{
	public String name;
	private int age;
	private String addr;
	
	Employee(String name, int age, String addr){
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddr(String addr) {
		this.addr = addr;
		
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getAddr() {
		return this.addr;
	}
	
	
}

class Parttimer extends Employee{
	
	private int hour_pay;
	
	
	Parttimer(String name, int age, String addr, int hour_pay){
		super(name,age,addr);
		setHourPay(hour_pay);
	}
	

	public void setHourPay(int pay) {
		this.hour_pay = pay;
		
	}

	@Override
	public String toString() {
		return "Parttimer [hour_pay=" + hour_pay + ", name=" + name + ", age" + getAge() + ", addr="
				+ getAddr();
	}
	
	
	
	
}
class Regular extends Employee{
	private int salary;
	
	
	Regular(String name, int age, String addr, int salary){
		super(name,age,addr);
		setSalary(salary);
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	@Override
	public String toString() {
		return "Regular [salary=" + salary + ", name=" + name + ", age=" + getAge() + ", addr=" + getAddr()
				+ "]";
	}
	
}

public class C05Ex {

	public static void main(String[] args) {
		Parttimer emp1 = new Parttimer("홍길동",25,"대구",20000);
		Regular emp2 = new Regular("서길동",45,"울산",50000000);
		System.out.println(emp1);
		System.out.println(emp2);		
	}

}

```

### C06UpDownCastingMai

```java
package Ch12;

class Super{
	int n1;

	@Override
	public String toString() {
		return "Super [n1=" + n1 + "]";
	}
	
	
}

class Sub extends Super{
	int n2;

	@Override
	public String toString() {
		return "Sub [n2=" + n2 + ", n1=" + n1 + "]";
	}
	
	
}

public class C06UpDownCastingMain {
	public static void main(String[] args) {
		// NOCasting (자료형의 일치)
		Super ob1 = new Super();
		ob1.n1 = 10;
		Sub ob2 = new Sub();
		ob2.n2 = 10;
		ob2.n1 = 20;
		
		System.out.println(ob1);
		System.out.println(ob2);
		
		// Upcasting(상위클래스 참조변수 = 하위클래스형 객체)(자동형변환)
		// Upcasting 쓰는 이유 : 상속관계에 있는 많은 클래스의 만들어진 하위객체들을 연결하는게 주목적이다
		// DownCasting : Upcasting 으로 연결된부분에서 하위객체의 접근 하기 위해서 쓴다.
		
		Super ob3 = new Sub(); // Sub 가 Super로 자동 형변환 (오른쪽에서 왼쪽으로)
		ob3.n1 = 100;
//		ob3.n2 = 200; // 접근 불가능
		Super ob4 = ob2;
		ob4.n1 = 100;
//		ob4.n2 = 200; // 접근 불가능   상위 객체가 이해할수 있는 영역까지만 접근 가능
		
		
		//Downcasting(하위클래스 참조변수 = 상위클래스형 객체) (강제형변환)
		// UPcasting된 상태에서 확장된 멤버에 접근하기 위한 용도
		// Sub ob5 = (Sub)new Super();
		//Sub ob5 = (Sub) ob1; // 강제로 형 변환 에러난다. 부모객체를 자식객체로 변환할 수 없다.
		Sub ob6 = (Sub)ob3;
	}
}

```

<aside>
💡

## **1. 업캐스팅(Upcasting)**

업캐스팅은 **자식 클래스 객체를 부모 클래스 타입으로 변환하는 것**을 의미합니다.

자동으로 형 변환(Implicit Casting)이 이루어지며, 명시적인 캐스팅이 필요 없습니다.

### **업캐스팅 특징**

- 자동 형 변환 (Implicit Casting)
- 부모 클래스의 멤버(메서드, 변수)만 접근 가능 (하지만 오버라이딩된 메서드는 호출 가능)

## **2. 다운캐스팅(Downcasting)**

다운캐스팅은 **부모 클래스 타입의 객체를 자식 클래스 타입으로 변환하는 것**을 의미합니다.

업캐스팅된 객체를 다시 원래 자식 타입으로 변환할 때 사용되며, **명시적인 형 변환(Explicit Casting)** 이 필요합니다.

### **다운캐스팅 특징**

- 명시적 형 변환 (Explicit Casting) 필요
- 런타임 오류 발생 가능 (`ClassCastException`)
- `instanceof` 연산자를 사용하여 안전한 형 변환 가능

---

## 다운캐스팅 시 주의할 점

```java
class Parent {
    void show() {
        System.out.println("부모 클래스 메서드");
    }
}

class Child extends Parent {
    void display() {
        System.out.println("자식 클래스 메서드");
    }
}

public class DowncastingExample {
    public static void main(String[] args) {
        Parent p = new Child(); // 업캐스팅
        p.show(); // 부모 클래스 메서드

        // 다운캐스팅 (명시적 변환)
        Child c = (Child) p;
        c.display(); // 자식 클래스 메서드
    }
}
```

부모 클래스 타입의 객체가 실제로 자식 클래스 객체가 아니라면, 다운캐스팅 시 **`ClassCastException` 오류가 발생**합니다.

```java
Parent p = new Parent();
Child c = (Child) p; // 오류 발생! (ClassCastException)
```

즉 업캐스팅이 됬다가 다운캐스팅은 가능하다.

하지만 업캐스팅하지 않고 다운캐스팅만 되지는 않는다.

### **안전한 다운캐스팅 방법 (instanceof 활용)**

다운캐스팅을 하기 전에 `instanceof` 연산자로 타입을 확인하면 예외를 방지할 수 있습니다.

</aside>

### C07UpDownCastingMain2

```java
package Ch12;

// 각 클래스에
// 모든 인자를 받는 생성자 코드 삽입
// toString 코드 삽입
class A{
	int A;
	
	
	public A(int a) {
		super();
		A = a;
	}

	@Override
	public String toString() {
		return "A [A=" + A + "]";
	}

	
	
}

class B extends A{
	int b;

	

	public B(int a, int b) {
		super(a);
		this.b = b;
	}

	@Override
	public String toString() {
		return "B [b=" + b + ", A=" + A + "]";
	}

	
	
	

}

class C extends A{
	int c;

	

	public C(int a, int c) {
		super(a);
		this.c = c;
	}

	@Override
	public String toString() {
		return "C [c=" + c + ", A=" + A + "]";
	}
	

}

class D extends B{
	int d;

	public D(int a, int b, int d) {
		super(a, b);
		this.d = d;
	}

	@Override
	public String toString() {
		return "D [d=" + d + ", b=" + b + ", A=" + A + "]";
	}

}

class E extends B{
	int e;
	
	public E(int a, int b, int e) {
		super(a, b);
		this.e = e;
	}

	@Override
	public String toString() {
		return "E [e=" + e + ", b=" + b + ", A=" + A + "]";
	}

	
	

}

class F extends C{
	int f;

	

	public F(int a, int c, int f) {
		super(a, c);
		this.f = f;
	}

	@Override
	public String toString() {
		return "F [f=" + f + ", c=" + c + ", A=" + A + "]";
	}

	
	

}

class G extends C{
	int g;

	public G(int a, int c, int g) {
		super(a, c);
		this.g = g;
	}

	@Override
	public String toString() {
		return "G [g=" + g + ", c=" + c + ", A=" + A + "]";
	}

}

public class C07UpDownCastingMain2 {
	
	public static void upDownCastTestFunc(A obj,int ...arg) {
		// A-G를 받아 모든 속성 출력
		
		obj.A = arg[0]; // upcasting된 상태니까 A의 멤버변수에만 접근가능.
		
		if (obj instanceof B) {
			B down = (B)obj; // Downcasting(확장된 멤버에 접근위해)
			down.b = arg[1];
		}if (obj instanceof C) {
			C down = (C)obj;
			down.c = arg[1];
		}if (obj instanceof D) {
			D down = (D)obj;
			down.b = arg[1];
			down.d = arg[2];
		}if (obj instanceof E) {
			E down = (E)obj;
			down.e = arg[2];
		}if(obj instanceof F) {
			F down = (F)obj;
			down.f = arg[2];
		}if(obj instanceof G) {
			G down = (G)obj;
			down.g = arg[2];
		}
		System.out.println(obj);
	}
	public static void main(String[] args) {
	
	
	A ob1 = new A(0);
	B ob2 = new B(0,0);
	C ob3 = new C(0,0);
	D ob4 = new D(0,0,0);
	E ob5 = new E(0,0,0);
	F ob6 = new F(0,0,0);
	G ob7 = new G(0,0,0);
	
	
//	upDownCastTestFunc(ob1,10);  // Nocasting
//	upDownCastTestFunc(ob2,10,20);  // Upcasting
//	upDownCastTestFunc(ob3,30,40);  // Upcasting
//	upDownCastTestFunc(ob4,50,60,70);  // Upcasting
//	upDownCastTestFunc(ob5,80,90,100);  // Upcasting
//	upDownCastTestFunc(ob6,110,120,130);  // Upcasting
//	upDownCastTestFunc(ob7,140,150,160);  // Upcasting
	
	}
}

```

### C08UpDownCastingMain

```java
package Ch12;

class C08Super{
	
	void func1() {
		System.out.println("C08.Super.fun1() call");
	}
	void func2() {}; // 이렇게하면 func2는 오버라이드 되기때문에 func2 이용 가능
}

class C08Sub extends C08Super{
	void func2() {
		System.out.println("C08.Sub.fun2() call");
	}
}

public class C08UpDownCastingMain {
	public static void main(String[] args) {
		C08Super ob1 = new C08Super(); // No casting
		ob1.func1();
		
		System.out.println("--------------------------");
		
		C08Sub ob2 = new C08Sub();  // No casting
		ob2.func1();
		ob2.func2();
		
		System.out.println("--------------------------");
		
		C08Super ob3 = new C08Sub(); // Upcasting // Super밖에 접근 못한다.
		ob3.func1(); // C08Super 메서드이니까 접근가능.
		ob3.func2(); // func2()를 Super에다가 선언만 해놓으면 접근가능. 오버라이드 되기 때문에.
		
		
		
		//Upcasting 상태에서
		//확장된(멤버추가) 멤버변수 접근 가능하다?  X => Downcasting 후 접근가능
		// 확장된(멤버추가) 멤버함수 접근 가능하다? X => Downcasting 후 접근가능 
		// 재정의된 메서드 접근 가능? O 
		
	}
}

```

## Ch02(문제 아직안풀었다.)

## Ch13

### C01AbstractMain

```java
package Ch13;

// 추상클래스는 초반에 큰 틀을 잡기위해서 주로 설정한다.

// 일반 클래스 상속관계
class Super1{
	void func() {
		
	}
}

class Sub1 extends Super1{
	
	@Override
	void func() {
		System.out.println("Overrided.. sub1.func()...Call!");
	}
}

// 추상 클래스 상속관계
abstract class Super2{
	abstract void func();  // 미완성된 함수
}

class Sub2 extends Super2{
	@Override
	void func() {
		System.out.println("Overrided.. sub2.func()...Call!");
	}
}

public class C01AbstractMain {
	public static void main(String[] args) {
		//01
//		Super1 ob1 = new Super1();  // 상위클래스형으로 객체생성 가능
//		Sub1 ob2 = new Sub1();  // 하위클래스형으로 객체생성 가능
//		Super1 ob3 = new Sub1(); // Upcasting 가능
//		ob3.func(); // 재정의된 함수 접근 가능
		
		// 02 추상클래스 상속 관계
		// Super2 ob1 = new Super2();  // 추상클래스로 객체생성 불가능
		Sub2 ob2 = new Sub2();  // 하위클래스형으로 객체생성 가능(미완성된 함수를 완성시켜줘야한다.)
		Super2 ob3 = new Sub2(); // Upcasting 가능
		ob3.func(); // 재정의된 함수 접근 가능
	}
}

```

### C02Ex

```java
package Ch13;

//다음은 단위를 변환하는 추상 클래스 Converter이다.
import java.util.Scanner;

abstract class Converter {
   abstract protected double convert(double src); // 추상 메소드
   abstract protected String getSrcString(); // 추상 메소드
   abstract protected String getDestString(); // 추상 메소드
   protected double ratio; // 비율
   public void run() { 
      Scanner scanner = new Scanner(System.in);
      System.out.println(getSrcString()+"을 "+getDestString()+"로 바꿉니다.");
      System.out.print(getSrcString()+"을 입력하세요>> ");
      double val = scanner.nextDouble();
      double res = convert(val);
      System.out.println("변환 결과: "+res+getDestString()+"입니다");
      scanner.close();
   }
}

class Won2Dollar extends Converter{

	public Won2Dollar() {
		super();
	}

	public Won2Dollar(double ratio) {
		super();
		this.ratio = ratio;
	}
	
	@Override
	protected double convert(double src) {
		// TODO Auto-generated method stub
		return Math.round(src/ratio);
	}

	@Override
	protected String getSrcString() {
		// TODO Auto-generated method stub
		return "원화";
	}

	@Override
	protected String getDestString() {
		// TODO Auto-generated method stub
		return "달러";
	}
	
	
}
public class C02Ex {

	public static void main(String[] args) {

		//[3번] Converter 클래스를 상속받아 원화를 달러로 변환하는 Won2Dollar 클래스를 작성하라. main() 메소드와 실행 결과는 다음과 같다.
		   Won2Dollar toDollar = new Won2Dollar(1446); // 1달러는 1200원
		   toDollar.run();
		   
		   //결과
//		   원을 달러로 바꿉니다.
//		   원을 입력하세요>> 24000
//		   변환 결과: 20.0달러입니다

	}

}

```

### C03InterfaceMain

```java
package Ch13;

import java.util.Scanner;

interface Remocon{
	int Max_Vol = 100;   // public static final
	int Min_Vol = 0;     // public static final
	
	void setVolumn(int vol);
	// TV, Radio 각각 메서드를 완성시켜주세요
	// MAX_VOL / MIN_VOL 을 적용해서 각각최대볼륨 최소볼륨을 제한해주세요 -!
	// 구현하는 클래스에서 외부로부터 받는 vol을 저장할 멤버변수(vol)을 지정해주세요.
	// vol 값이 100을 초과할때는 최대볼륨값으로 적용(print : 최대볼륨으로 설정합니다.)
	// vol 값이 0미만일떄는 최소볼륨값으로 적용(print : 최소볼륨으로 설정합니다.)
	//0<=vol<=100 사이이면 멤버변수 vol에 저장해주시고 현재볼륨을 출력해줍니다.(print : 현재볼륨 :n)
	void PowerOn();
	void PowerOff();
	
}

interface Browser{
	void SearchURL(String url);
}

class Tv implements Remocon{
	int vol;
	
	
	public Tv() {
		
	}
	
	@Override
	public void PowerOn() {
		// TODO Auto-generated method stub
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void PowerOff() {
		// TODO Auto-generated method stub
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void setVolumn(int vol) {
		// TODO Auto-generated method stub
		if (vol>100) {
			vol = Max_Vol;
			System.out.println("최대볼륨으로 설정합니다.");
		}else if(vol<0) {
			vol = Min_Vol;
			System.out.println("최소볼륨으로 설정합니다.");
		}else {
			this.vol = vol;
			System.out.println("현재볼륨 : "+this.vol);
		}
	}

	@Override
	public String toString() {
		return "Tv";
	}

}

class SmartTv extends Tv implements Browser{

	@Override
	public void SearchURL(String url) {
		// TODO Auto-generated method stub
		System.out.println(url + "로 이동합니다.");
	}
	
}

class Radio implements Remocon{
	int vol;
	
	public Radio() {
		
	}
	

	@Override
	public void PowerOn() {
		// TODO Auto-generated method stub
		System.out.println("Radio를 켭니다.");
	}

	@Override
	public void PowerOff() {
		// TODO Auto-generated method stub
		System.out.println("Radio를 끕니다.");
	}

	@Override
	public void setVolumn(int vol) {
		// TODO Auto-generated method stub
		if (vol>100) {
			vol = Max_Vol;
			System.out.println("최대볼륨으로 설정합니다.");
		}else if(vol<0) {
			vol = Min_Vol;
			System.out.println("최소볼륨으로 설정합니다.");
		}else {
			this.vol = vol;
			System.out.println("현재볼륨 : "+this.vol);
		}
	}
	
	@Override
	public String toString() {
		return "radio";
	}
	
}

public class C03InterfaceMain {
	public static void TurnOn(Remocon controller) {
		controller.PowerOn();
	}
	public static void TurnOff(Remocon controller) {
		controller.PowerOff();
	}
	public static void Volume(Remocon controller) {
		Scanner input = new Scanner(System.in);
		System.out.print(controller +"볼륨을 입력하세요 ");
		controller.setVolumn(input.nextInt());
	}
	public static void Internet(Browser browser, String url) {
		browser.SearchURL(url);
	}
	
	public static void main(String[] args) {
		Tv tv1 = new Tv();
		
		Radio radio1 = new Radio();
		
		SmartTv smartTv = new SmartTv();
		
		
		TurnOn(tv1);
		TurnOff(radio1);
		TurnOn(smartTv);
		System.out.println("-------------------------");
		
		Volume(tv1);
		Volume(tv1);
		Volume(radio1);
		Volume(radio1);
		
		System.out.println("-----------------------------");
		
		Internet(smartTv,"www.naver.com");
	
	}
}

```

### C04InterfaceMain

```java
package Ch13;

interface Tire{
	void run();
}
class 한국타이어 implements Tire{
	public void run(){System.out.println("한국타이어가 굴러갑니다");};
}
class 금호타이어 implements Tire{
	public void run(){System.out.println("금호타이어가 굴러갑니다");};
}
class Car{
	Tire FL;
	Tire FR;
	Tire BL;
	Tire BR;
	Car(){
		FL = new 한국타이어();
		FR = new 한국타이어();
		BL = new 한국타이어();
		BR = new 한국타이어();
	}
	void start() {
		FL.run();
		FR.run();
		BL.run();
		BR.run();
	}
	
}
public class C04InterfaceMain {
	
	public static void main(String[] args) {
		Car car = new Car();
		car.start();
		car.FL = new 금호타이어();
		car.BR = new 금호타이어();
		System.out.println();
		car.start();		
	}
	
}

```

### C05InterfaceMain

```java
package Ch13;

// interface 쓰는이유

// 협엽의 관점에서 : 작업 지시서
// 프로그래밍 관점에서 : - 결합도를 낮추기위해서, - 강제성

interface A{
	void ab();
}
interface B{
	void ab();
}

class C{
	
}
class D{

}
class E extends C implements A ,B{

	@Override
	public void ab() {
		// TODO Auto-generated method stub
		System.out.println("ABABABBA");
	}

	
}

public class C05InterfaceMain {

	public static void main(String[] args) {
		E ob1 = new E();
		ob1.ab();
	}
}

```

<aside>
💡

**추상 클래스(Abstract Class)와 인터페이스(Interface) 정리**

### **1. 추상 클래스(Abstract Class)**

✅ **정의**

- 하나 이상의 추상 메서드(abstract method)를 포함한 클래스
- 객체 생성 불가 (상속을 통해서만 사용 가능)
- 일반 메서드(구현된 메서드)와 추상 메서드를 모두 포함 가능

✅ **특징**

- `abstract` 키워드 사용
- 생성자, 필드, 일반 메서드 포함 가능
- 상속을 통해 하위 클래스에서 반드시 추상 메서드를 구현해야 함
- 단일 상속만 가능 (자바의 경우 다중 상속 불가능)

```java
abstract class Animal {
    String name;
    
    // 생성자
    Animal(String name) {
        this.name = name;
    }

    // 추상 메서드 (하위 클래스에서 반드시 구현)
    abstract void makeSound();

    // 일반 메서드 (구현이 되어 있음)
    void sleep() {
        System.out.println(name + " is sleeping.");
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says Woof!");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy");
        dog.makeSound(); // Buddy says Woof!
        dog.sleep();     // Buddy is sleeping.
    }
}

```

---

### **2. 인터페이스(Interface)**

✅ **정의**

- 메서드의 선언(구현 없이 이름만 선언)만 포함하는 추상 타입
- 다중 상속을 지원하기 위해 사용됨
- 객체 생성 불가 (구현한 클래스를 통해 사용 가능)

✅ **특징**

- `interface` 키워드 사용
- 모든 메서드는 기본적으로 `public abstract` (생략 가능)
- 모든 필드는 `public static final` (생략 가능)
- 다중 구현 가능 (`implements` 사용)

```java
interface Animal {
    void makeSound(); // 추상 메서드 (구현 없음)
}

interface Pet {
    void play();
}

class Dog implements Animal, Pet {
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }

    @Override
    public void play() {
        System.out.println("The dog is playing.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound(); // Woof! Woof!
        dog.play();      // The dog is playing.
    }
}
```

### **5. 정리**

- **추상 클래스**: "is-a" 관계, 공통된 기능을 가지는 클래스들의 부모 역할
- **인터페이스**: "can-do" 관계, 특정 기능을 강제하고 다중 구현 가능

💡 **Tip:**

✅ "여러 클래스가 공통으로 가지는 속성과 기능을 정의해야 한다면?" → **추상 클래스**

✅ "여러 개의 구현을 지원하고 싶다면?" → **인터페이스**

인터페이스는 원래 추상 메서드만 가질 수 있었지만, Java 8 이후부터 default 메서드와 static 메서드도 포함할 수 있게 되었다

### **디폴트 메서드란?**

- **Java 8부터 추가됨**
- 인터페이스에 **구현된 메서드**를 추가할 수 있음
- `default` 키워드를 사용
- **하위 클래스(구현 클래스)에서 재정의(Override) 가능**
- 기존 인터페이스를 변경할 때 **하위 클래스에 영향을 주지 않기 위해 추가됨**

```java
interface Animal {
    void makeSound(); // 추상 메서드 (구현 필요)

    default void sleep() { // 디폴트 메서드 (이미 구현됨)
        System.out.println("The animal is sleeping.");
    }
}
```

</aside>

## Ch14

### C01ObjectMain

```java
package Ch14;

class A{

	int x;
	int y;
	
	
	@Override
	public String toString() {
		return "A [x=" + x + ", y=" + y + "]";
	}
}

public class C01ObjectMain {
	public static void main(String[] args) {
		A ob1 = new A();
		System.out.println(ob1);
		System.out.println(ob1.toString()); // 재정의한 위치로 잡힌다.
		System.out.println(ob1.toString());
		
		Object ob2 = new Object();
		System.out.println(ob2);
		System.out.println(ob2.toString());
		
	}
}

```

## C02ObjectMain

```java
package Ch14;

class C02Simple{
	int n;
	
	
	C02Simple(int n){
		this.n = n;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		if(obj instanceof C02Simple) {
			C02Simple down = (C02Simple) obj;
			return this.n == down.n;
			
		}
		return false;
	}
	
	
}

public class C02ObjectMain {
	public static void main(String[] args) {
		C02Simple ob1 = new C02Simple(10);
		C02Simple ob2 = new C02Simple(10);
		C02Simple ob3 = new C02Simple(20);
		
		
		ob1.equals(ob2);
		System.out.println(ob1.equals(ob2)); 
		System.out.println(ob1.equals(ob3)); 
		
		String str1 = new String("JAVA");
		String str2 = new String("JAVA");
		System.out.println(str1.equals(str2));
		
		
		// Object클래스의 equals 메소드는 == 연산자로 두 객체를 비교한다. 
		// 즉 두 객체의 주소가 같으면 true, 두 객체의 주소가 다르면 false를 반환한다.
		// 오버라이드 하면 값을 비교할 수도 있다.
		
		// String 클래스의 equals 메서드는 두 문자열의 내용을 비교한다. (오버라이딩되어 있기 때문에.)
		// String 클래스의 == 연산자는 두 문자열의 주소를 비교한다.
	}
}

```

### C03ObjectMain

```java
package Ch14;

import java.util.Objects;

class C03Simple{
	int n;
	
	
	C03Simple(int n){
		this.n = n;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		if(obj instanceof C03Simple) {
			C03Simple down = (C03Simple) obj;
			return this.n == down.n;
			
		}
		return false;

	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(this.n);
	}
	
	
}

public class C03ObjectMain {
	public static void main(String[] args) {
		C03Simple ob1 = new C03Simple(1);
		System.out.println(ob1.toString());
		System.out.printf("%x\n",System.identityHashCode(ob1));
	
		C03Simple ob2 = new C03Simple(9);
		System.out.println(ob2.toString());
	}
}

```

### C04WrapperMain

```java
package Ch14;

public class C04WrapperMain {
	public static void main(String[] args) {
		
		// Boxing (기본자료형 -> Wrapper Class)
		Integer ob1 = new Integer(100);
		Integer ob2 = new Integer("100");
		Integer ob3 = Integer.valueOf("300");
		System.out.println(ob1+ob2+ob3);
		
		// unBoxing
		int n1 = ob1.intValue();
		int n2 = ob2.intValue(); // Wrapper class에서 기본 타입으로 값을 변환하는 메서드이다.
		int n3 = ob3.intValue(); 
		System.out.println(n1+n2+n3);
		
		// Auto Boxing
		Integer ob4 = 100; // Wrapper class에서 기본 타입으로 값이 자동으로 변환된다.
		int n4 = ob1 + ob2 + ob3;
		
	}
}

```

### C05DateMain

```java
package Ch14;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class C05DateMain {
	public static void main(String[] args) {
		
		// 실기평가칠때 무조건 나온다.
		
		
		// Date
		Date d1 = new Date();
		System.out.println(d1);
		System.out.println(d1.getYear()+1900);
		System.out.println(d1.getMonth()+1);
		System.out.println(d1.getDay()); // 0-6(일-토)
		System.out.println(d1.getHours());
		System.out.println(d1.getHours());
		System.out.println(d1.getMinutes());
		System.out.println(d1.getSeconds());
		System.out.println(d1.getTime());
		
		// Calendar
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK)); // 요일
														   // 1-7(일-토)
		
		System.out.println(cal.get(Calendar.HOUR_OF_DAY)); 
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
		
		// LocalDateTime
		LocalDateTime now = LocalDateTime.now();
		int year = now.getYear();
		int month = now.getMonthValue(); // 월(1~12);
		int day = now.getDayOfMonth(); //일(1~31);
		int hour = now.getHour(); // 시 (0~23)
		int minute = now.getMinute(); // 분(0~59)
		int second = now.getSecond(); // 초(0~59)
		DayOfWeek dayOfWeek = now.getDayOfWeek();
		
		// 결과 출력
		System.out.println("연 : "+year);
		System.out.println("월 : "+month);
		System.out.println("일 : "+day);
		System.out.println("시 : "+hour);
		System.out.println("분 : "+minute);
		System.out.println("초 : "+second);
		System.out.println("요일 : "+dayOfWeek);
		
	}
}

```

### C06SimpleDateFormatMain

```java
package Ch14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class C06SimpleDateFormatMain {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("YYYY/MM/DD 입력 : ");
		String ymd = sc.next();
		
		// 포메터 객체 생성(입력용)
		SimpleDateFormat fmtin = new SimpleDateFormat("yyyy/MM/dd"); // y,M,d,h,m,s
		System.out.println(ymd);
		Date date = fmtin.parse(ymd);
		System.out.println(date);
		
		// 포케터 객체 생성(출력용)
		SimpleDateFormat fmtout = new SimpleDateFormat("yyyy~MM~dd"); // y,M,d,h,m,s
		System.out.println(fmtout.format(date));
		
		
	}
}

```

### C07LocalDateTimeFormatMain

```java
package Ch14;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class C07LocalDateTimeFormatMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("YYYY/MM/DD 입력 : ");
		String ymd = sc.next();
		
		// 입력용 포메터
		DateTimeFormatter imputFormatter  = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		// 문자열을 LocalDate로 변환
		LocalDate date = LocalDate.parse(ymd,imputFormatter);
		System.out.println("입력된 날짜 : "+date);
		
		// 출력용 포메터
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy~MM~dd");
		
		// 포멧 변경 후 출력
		System.out.println("변환된 날짜 : "+ date.format(outputFormatter));
		
		sc.close();
				
	}

}

```

## Ch15

### C01NullpointerExceptionMain

```java
package Ch15;

public class C01NullpointerExceptionMain {
	public static void main(String[] args) {
		try {
			
			String str = null;
			System.out.println(str.toString());
			System.out.println("HelloWorld");
			System.out.println("Helloworld");
			
		} catch (NullPointerException e) {
			System.out.println("예외발생 : "+e);
			System.out.println(e.getCause()); // 반환값 : 원래 발생한 예외 객체 : null
			System.out.println(e.toString());
			System.out.println(e.getStackTrace()); // 예외 발생 위치 정보를 StackTraceElement[] 배열로 반환
		}
		
//		System.out.println("HelloWorld");
//		System.out.println("HelloWorld");
		
	}
}

```

### C02ArrayIndexBoundExceptionMain

```java
package Ch15;

public class C02ArrayIndexBoundExceptionMain {
	public static void main(String[] args) {
		int arr[] = {10,20,30};
		
		try {
			for (int i = 0; i < 4; i++) {
				System.out.println(arr[i]);
				
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Hello World");
		}
		
		
	}
}

```

### C03ClassCastExceptionMain

```java
package Ch15;

import java.nio.file.attribute.AclEntry;

class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}

public class C03ClassCastExceptionMain {
	
	public static void changeDog(Animal animal) { // 업캐스팅
		try {
			Dog down = (Dog)animal; // Dog로 다운캐스팅
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외 발생 : "+e.getMessage());
		}
			
	}
	
	public static void main(String[] args) {

		Animal poppi = new Dog();
		Animal tori = new Cat();
		
		changeDog(tori); // tori 객체가 가리키는 객체는 Cat 객체인데 다운캐스팅을 Dog로 해서 오류난다.
		changeDog(poppi);
		
	}
	
}

```

### C04ExceptionMain

```java
package Ch15;

public class C04ExceptionMain {
	public static void main(String[] args) {
		String str = null;
		try {
			str.toString(); // Null 예외 발생
			
			int arr[] = {10,20,30};
			arr[5] = 100; // Bound Exception 발생
			
			Integer.parseInt("a1234"); // Parse Exception 발생
			
			Animal animal = new Dog();
			Cat yummi = (Cat)animal;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
//		catch (NullPointerException e) {
//			System.out.println(e.getMessage()+1);
//			
//		}catch (ArrayIndexOutOfBoundsException e2) {
//			System.out.println(e2.getMessage()+2);
//		}catch (NumberFormatException e3) {
//			System.out.println(e3.getMessage()+3);
//		}catch (ClassCastException e4) {
//			System.out.println(e4.getMessage()+4);
//		}
		
		finally {
			System.out.println("Finally..test");
		}

	}
}

```

### C05ThrowAndThrowsMain

```java
package Ch15;
 
class A{ 
	public void Ex1() throws NullPointerException{

		System.out.println("Ex1 process..1");
		throw new NullPointerException("Ex1 Null Exception");
		
	}
}
class B{
	public void Ex2() throws NullPointerException{
		System.out.println("Ex2 process...1");
		throw new NullPointerException("Ex2 Null Exception");
	}
	
}
public class C05ThrowAndThrowsMain {
	public static void main(String[] args) {
		
		
		System.out.println("실행코드1");
		System.out.println("실행코드2");
		A a = new A();
		B b = new B();
		
		try {
			a.Ex1();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("실행코드3");
	}
}

// thorw는 예외를 만들때 생성
// thorws 예외를 던질때 생성

```

## Ch16

### C01GenericMain

```java
package Ch16;

class 민트초코{

	@Override
	public String toString() {
		return "민트초코 []";
	}
	
}

class 호빵재료{
	
}
class 야채 extends 호빵재료{

	@Override
	public String toString() {
		return "야채";
	}
	
}
class 슈크림 extends 호빵재료{

	@Override
	public String toString() {
		return "슈크림";
	}
	
}
class 팥 extends 호빵재료{

	@Override
	public String toString() {
		return "단팥";
	}
	
}

class 호빵 <T extends 호빵재료>{
	private T material;
	호빵(T material){
		this.material = material;
	}
	
	
	// toString 재정의
	
	@Override
	public String toString() {
		return "호빵 [material=" + material + "]";
	}

}

public class C01GenericMain {
	public static void main(String[] args) {
	호빵<팥> ob1 = new 호빵<팥>(new 팥());
	System.out.println(ob1);
	
	호빵<슈크림> ob2 = new 호빵<슈크림>(new 슈크림());
	System.out.println(ob2);
	
	호빵<야채> ob3 = new 호빵<야채>(new 야채());
	System.out.println(ob3);
	
//	호빵<민트초코> ob4 = new 호빵<민트초코>(new 민트초코());
//	System.out.println(ob3);
	}
}

```

<aside>
💡

// 호빵<팥> ob1 = new 호빵<팥>(new 팥());

// 여기서 (new 팥())은 기본적으로 new 호빵<팥>의 매개변수이다.

// new 팥() 여기서 팥 클래스의 객체가 생성이 된다. -> 디폴트 생성자가 호출이 된다. 없으니까 컴파일러가 자동 수행

// new 호빵<팥>(new 팥()) 매개변수로 팥 객체를 전달하는 생성자가 호출이 된다.

// private 팥 material;
// 호빵(팥 material){
//	 this.material = material;
// }

// 생성자가 호출이 되면서 팥 객체를 material로 받고 이를 멤버변수에 할당한다.

// 이후 

// System.out.println(ob1); 하면 ob1의 toString이 호출이 되고

// material이 문자열로 변환될떄 toString()이 자동 호출이 된다.

// (자바에서 객체를 문자열과 더할떄(+ 연산자 사용), toString()메서드가 호출이 된다.)

 //"호빵 [material=" + material.toString() + "]" 와 동일하다.

</aside>

### C02Ex

```java
package Ch16;
abstract class 팝콘재료{
	
}

class 캬라멜 extends 팝콘재료{

	@Override
	public String toString() {
		return "캬라멜";
	}
	
	
}
class 버터옥수수 extends 팝콘재료{

	@Override
	public String toString() {
		return "버터옥수수";
	}
 
}
class PopCorn<T extends 팝콘재료>{
	private T meterial;
	public PopCorn(T meterial) {
		this.meterial = meterial;
	}
	@Override
	public String toString() {
		return "PopCorn [meterial=" + meterial + " 맛 팝콘]";
	}
	
}

public class C02Ex {

	public static void main(String[] args) {
		PopCorn<캬라멜> ob1 = new PopCorn<캬라멜>(new 캬라멜());
		System.out.println(ob1);
		
		PopCorn<버터옥수수> ob2 = new PopCorn<버터옥수수>(new 버터옥수수());
		System.out.println(ob2);
	}
}

```

### C03GenericMain

```java
package Ch16;

class Person{
	String name;
	String age;
	String addr;
	
	
	public Person(String name, String age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
}
class Man extends Person{

	public Man(String name, String age, String addr) {
		super(name, age, addr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Man [name=" + name + ", age=" + age + ", addr=" + addr + ", toString()=" + super.toString() + "]";
	}
	
}
class Woman extends Person{

	public Woman(String name, String age, String addr) {
		super(name, age, addr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Woman [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
}
class Couple<X extends Person,Y extends Person>{
	private X member1;
	private Y member2;
	public Couple(X member1, Y member2) {
		super();
		this.member1 = member1;
		this.member2 = member2;
	}
	@Override
	public String toString() {
		return "Couple [member1=" + member1 + ", member2=" + member2 + "]";
	}
}
public class C03GenericMain {
	public static void main(String[] args) {
		
		Couple <Man,Woman> couple1 = new Couple<Man,Woman>(new Man("철수","50","대구"),new Woman("영희","40","대구"));
		System.out.println("couple : "+couple1);
		
		Couple <Man,Man> couple2 = new Couple<Man,Man>(new Man("철수","50","대구"),new Man("도후","20","서울"));
		System.out.println("couple : "+couple2);
		
//		Couple <Integer,Integer> couple3 = new Couple<Integer,Integer>(100,200);
//		System.out.println("couple 3 "+ couple3);
		
	}
}

```

### C04GenericMain

```java
package Ch16;

class Animal{
	String name;
}

class Panda extends Animal{
	// 생성자
	
	public Panda(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Panda [name=" + name + "]";
	}
}

class Tiger extends Animal{

	// 생성자
	
	public Tiger(String name) {
		super();
		this.name = name;
		
	}

	@Override
	public String toString() {
		return "Tiger [name=" + name + "]";
	}
	
	
}

public class C04GenericMain {
	//Generic
	public static <T extends Animal>void PrintByGeneric(T arr[]) {
		for (T el : arr) {
			System.out.println(el);
			
//			System.out.println(el)을 실행하면 내부적으로 println()메서드는 el.toString()을 호출합니다.
//			System.out.println(el); == System.out.println(el.toString()); 
		}
	}
	
	// Object
	public static void PrintByObject(Object animal []) {
		for (Object el : animal) {
			System.out.println(el);
		}
//		el은 Object 타입이지만 실제로는 Panda랑 Tiger객체를 가리키고 있다.
//		자바의 동적바인딩에 의해 객체의 실제 타입의 toString()을 호출합니다.
//		각자 클래스에서 toString()을 오버라이딩했으므로 각각의 toString()이 실행됩니다.
	}
	public static void main(String[] args) {
		Tiger arr1 [] = {new Tiger("시베리안 호랑이"), new Tiger("중국 호랑이"), new Tiger("86호랑이띠")};
		PrintByGeneric(arr1);
		
		Panda arr2 [] = {new Panda("시베리안 판다"), new Panda("중국 판다"), new Panda("80판다띠")};
		PrintByGeneric(arr2);
		
		Object arr3 [] = {new Panda("러시아 판다"), new Tiger("중국 호랭이"), new Tiger("96호랑이띠")};
		PrintByObject(arr3);
	}
}

```

<aside>
💡

왜  System.out.println(el)  하면 toString()이 실행될까?

// Generic

public static <T extends Animal>void PrintByGeneric(T arr[]) {

for (T el : arr) {
	System.out.println(el);

}

}

//	System.out.println(el)을 실행하면 내부적으로 println()메서드는 el.toString()을 호출합니다.
//	System.out.println(el); == System.out.println(el.toString()); 

// Object
public static void PrintByObject(Object animal []) {
	for (Object el : animal) {
		System.out.println(el);
      }

}

//	el은 Object 타입이지만 실제로는 Panda랑 Tiger객체를 가리키고 있다.
//	자바의 동적바인딩에 의해 객체의 실제 타입의 toString()을 호출합니다.
//	각자 클래스에서 toString()을 오버라이딩 했으므로 각각의 toString()이 실행됩니다.

</aside>

## Ch17

### C01ListMain

```java
package Ch17;

import java.util.ArrayList;
import java.util.List;

public class C01ListMain {
	public static void main(String[] args) {
		List<String> li = new ArrayList<>();
		
		
		// 추가
		li.add("HTML/CSS");
		li.add("JS/JAVA");
		li.add("SCSS");
		li.add("STS");
		li.add("STS");
		
		
		// 조회
		System.out.println("개수확인 : "+li.size());
		System.out.println("idx로 조회 : "+li.get(2));
		System.out.println("Value로 idx조회 : "+li.lastIndexOf("STS"));
		System.out.println("--------------------------------------");
		li.forEach(System.out::println); // 메서드 참조 사용
//		== 람다식 : li.forEach(s -> System.out.println(s)); 동일하다.
		System.out.println("--------------------------------------");
		
		
		// 삭제
		li.remove(0);
		li.remove("SCSS");
		for (String el : li) {
			System.out.println(el);
		}
		
		// 전체삭제
		
		li.clear();
		
		}
}

```

### C02Ex

```java
package Ch17;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class C02Ex {
	public static void func1(List<String> list) {
		//ArrayList에 있는 정수값을 입력받는데 전달되는 수중에
		//짝수의 값만 입력받는 코드를 작성하세요.
		Scanner input= new Scanner(System.in);
		
		while (true) {
			System.out.print("숫자를 입력하세요(종료 : -1입력) : ");
			int num = input.nextInt();
			if (num == -1) {
				break;
			}
			
			if (num %2 ==0) {
				list.add(String.valueOf(num));
			}
			
		}
		
	}
	public static List<String> func2(List<String> list) {
		//ArrayList에 있는 문자열 중에서 길이가 5보다 큰 문자열만 필터링해서 리턴하는 함수를 만드세요
		List<String> li2 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			
			if (list.get(i).length()>5) {
				li2.add(list.get(i));
			}
			
		
			
		}
		return li2; //바꿔주세요 작업시
	}
	public static int func3(List<String> list) {
		//ArrayList에 있는 문자열 중에서 숫자형 데이터만 추출해서 합을 구해보세요
		int sum=0;
//		for (String el : list) {
//			sum+=Integer.parseInt(el);
//		}
		for (int i = 0; i < list.size(); i++) {
			sum+=Integer.parseInt(list.get(i));
		}
		return sum; //바꿔주세요 작업시
	}
	public static void main(String[] args) {
		List<String> li = new ArrayList();
		func1(li);
		List<String> returndList =  func2(li);
		int sum =  func3(returndList);
		System.out.println(sum);
	}

}

```

### C03SetMain

```java
package Ch17;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class C03SetMain {
	public static void main(String[] args) {
		Set<String> set = new HashSet();
		
		// 추가
		set.add("HTML/CSS");
		set.add("JAVASCRIPT");
		set.add("TOSTRING");
		set.add("NO");
		set.add("YES");
		set.add("BOTTLE"); // older
		set.add("BOTTLE"); // newer(덮어쓰기)
		
		
		//확인
		System.out.println("갯수 확인 : "+set.size());
		
		
		//조회(idx -> Iterator)
		
//		Iterator <String> iter = set.iterator(); // 옛날방식(Iterator 사용)
//		while (iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		
//		for (String el : set) {  // 향상된 for문 사용해서 set 출력.(제일 편하다.)
//			System.out.println(el);
//		}
		
//		for (int i = 0; i < set.size(); i++) {   // set은 인덱스가 없기때문에 일반적인 for문으로 바로 접근할 수 없다.
//			System.out.println(set);
//			
//		}
		set.clear();
		
		
		
	}
}

```

### C04Ex

```java
package Ch17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class C04Ex {
	public static void main(String[] args) {
		// 1) 1 ~ 45 까지 숫자를 6개를 랜덤으로 받아(Random 클래스이용) set에 저장 / 출력
		// 2) [추가] 지정된 set의 오름차순정렬을 해보세요(검색을 통해서 해결해봅니다 - 스트림함수사용)
		
		Set <Integer> set = new HashSet<>();
		for (int i = 0; i <6; i++) {
			int number = (int)(Math.random() * 44)+1;
			set.add(number);
		}
		
		for (Integer el : set) {
			System.out.println(el);
		}
		
		
		// stream 사용해서 set 정렬
		List <Integer> li = set.stream().sorted().collect(Collectors.toList());
		System.out.println(li);
		
//		ArrayList 매개변수에 set 던지기
		
//		List<Integer> li = new ArrayList<>(set);
//		
//		Collections.sort(li); // li는 Collection이기 때문에 Collections 사용해야한다.
//		Collections.sort(li,Collections.reverseOrder()); // 내림자순 정렬
//		
//		System.out.println(li);
		
	}
}

```

<aside>
💡

| 특징 | **Set** (`HashSet`, `TreeSet`, `LinkedHashSet`) | **List** (`ArrayList`, `LinkedList`) |
| --- | --- | --- |
| **중복 허용** | 중복 허용 안 함 ❌ | 중복 허용 ✅ |
| **순서 유지** | `HashSet`은 순서 보장 안 함 `❌
LinkedHashSet`은 입력 순서 유지 ✅`TreeSet`은 오름차순 정렬됨 ✅  | 인덱스 기반 순서 유지 ✅ |
| **인덱스로 접근 가능 여부** | 인덱스 사용 불가능 (`for (int i = 0; ...)` ❌) | 인덱스 사용 가능 ✅(`list.get(i)`) |
| **조회 속도** | 빠름 (`O(1)~O(logN)`) | 느림 (`O(N)`) |
| **삽입/삭제 속도** | 빠름 (`O(1)`) | `ArrayList`는 중간 삽입/삭제 시 느림 (`O(N)`)`LinkedList`는 삽입/삭제 빠름 (`O(1)`) |
| **사용 예시** | 중복 없는 데이터 저장 (회원 ID, 태그 등) | 순서가 중요한 데이터 저장 (목록, 대기열 등) |
</aside>

<aside>
💡

| 컬렉션 | 탐색(Search) `contains(value)` | 조회(Lookup) `get(index)` |
| --- | --- | --- |
| `HashSet` | **빠름 (`O(1)`)** | **불가능 (`X`)** |
| `ArrayList` | **느림 (`O(N)`)** | **빠름 (`O(1)`)** |
</aside>

- `Set`은 **탐색(Search)이 빠름** (`contains(value)`)
- `ArrayList`는 **조회(Lookup)이 빠름** (`get(index)`)
- **특정 값을 빠르게 찾고 싶으면 `Set`**, 특정 인덱스 위치에서 데이터를 가져오려면 `List`.

```java
Set<String> set = new HashSet<>();
set.add("apple");
set.add("banana");

System.out.println(set.contains("apple")); // O(1), 매우 빠름
System.out.println(set.contains("cherry")); // O(1), 빠름

```

```java
List<String> list = new ArrayList<>();
list.add("apple");
list.add("banana");

// 조회 (Lookup) - O(1)
System.out.println(list.get(0)); // "apple"

// 탐색 (Search) - O(N)
System.out.println(list.contains("banana")); // O(N), 리스트를 처음부터 검사해야 함

```

### C05SetMain

```java
package Ch17;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person{
	String name;
	int age;
	
	// 생성자
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [hashCode()=" + hashCode() + "]";
	}

	
	// equals을 재정의해서 name,age가 동일하면 true / 아니면 false;
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person down = (Person) obj; // downcasting
			return this.name.equals(down.name) && this.age == down.age;
		}
		return false;
	}
	
	
	// hashCode()재정의 -> HashSet의 동등객체 판단
	@Override
	public int hashCode() {
		return Objects.hash(this.name,this.age);
	}
	
}

public class C05SetMain {
	public static void main(String[] args) {
		
		Set<Person> set = new HashSet();
		
		Person ob1 = new Person("홍길동",55);
		Person ob2 = new Person("남길동",35);
		Person ob3 = new Person("홍길동",55);
		
		System.out.println(ob1.equals(ob2));
		System.out.println(ob1.equals(ob3));
		set.add(ob1);
		set.add(ob2);
		set.add(ob3);
		
		System.out.println("SIZE : "+ set.size()   );
	}
}

```

```java
false
true
SIZE : 2
```

<aside>
💡

$\small\bf{HashSet객체 추가할 때 일어나는 과정}$

```java
set.add(ob3);
```

### **1. `hashCode()` 호출 (해시값 계산)**

- `HashSet`은 **새로운 요소(`ob3`)를 추가하기 전에** `hashCode()`를 먼저 호출합니다.
- `ob3.hashCode()`의 결과가 `ob1.hashCode()`와 같다면 **같은 해시 버킷**(같은 그룹)으로 간주됩니다.

### **2. `HashSet` 내에서 같은 해시코드가 있는지 확인**

- 만약 동일한 `hashCode()`를 가진 요소가 없다면 → `equals()` 비교 없이 바로 저장.
- 동일한 `hashCode()`를 가진 요소가 있다면 → **이제 `equals()`를 호출하여 실제로 같은 객체인지 비교**.

### **3. `equals()` 호출 (객체 동등성 비교)**

- `equals()`가 `true`라면 → **중복된 객체로 판단하고 추가하지 않음**.
- `equals()`가 `false`라면 → **다른 객체로 인식하고 추가**.

$\small\bf{hashCode()가~같아도~equals()를~한번~더~비교하는~이유}$

해시코드 충돌(Hash Collision) 때문이다.

hashCode()는 다른 객체라도 같은 해시코드를 가질 수 있다.

이것을 해시 충돌(Hash Collision) 이라고 한다.

그래서 

`hashCode()` 비교 (빠른 1차 필터링)

- 만약 다른 해시코드라면 equals() 비교 없이 바로 저장한다.
- 만약 같은 해시코드가 있다면? → equals()호출하여 최종 확인

`equals()` 비교 (진짜 중복인지 최종 확인)

- equals()가 true라면 완전히 같은 객체로 간주하고 추가하지 않는다.
- equals()가 false라면 단순한 해시 충돌일 뿐, 다른 객체이므로 추가함

### **HashSet에서 객체 추가 시 판단 기준**

1. **`hashCode()`가 다르면** → 다른 객체로 판단 → 추가 ✅
2. **`hashCode()`가 같아도 `equals()`가 다르면** → 해시 충돌이지만 다른 객체로 판단 → 추가 ✅
3. **`hashCode()`도 같고 `equals()`도 같으면** → 같은 객체로 판단 → 추가 ❌ (중복 제거)
</aside>

### C06MapMain

```java
package Ch17;

import java.util.HashMap;
import java.util.Map;

public class C06MapMain {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap();
		
		// 추가
		map.put("aaa", 1111);
		map.put("bbb",2222);
		map.put("ccc",3333);
		map.put("ddd",4444);
		map.put("ddd",4444); // 중복 key(나중에 put된 값으로 덮어쓰기)
		
		
		// 삭제
		map.remove("aaa");
		
		// 확인
		System.out.println("SIZE : " + map.size());
		System.out.println("단건 : " + map.get("bbb"));
		
		
		// for
		
		for(String key : map.keySet()) {
			System.out.println(key+" + " + map.get(key));
		}
	}
}

```

### C07Ex

```java
package Ch17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C07Ex {
	static Map<String,Object> map = new HashMap();
	//01 함수의 파라미터 형으로 사용되는 경우
	public static void setMap( Map<String,Object> params ) {

		//params console에 출력
		//params를 map 에 저장 
		for (String key  : params.keySet()) {
			Object value = params.get(key);
			if (value instanceof String[]) {
				System.out.println(key + " : "+Arrays.toString((String[])value));
			}else if(value instanceof List<?>) {
				System.out.println(key+" : "+ value);
			}else {
				System.out.println(key+" : "+ value);
			}
			
			map.put(key, value);
		}
		
	}
	//02 함수의 리턴형으로 사용되는 경우
	public static Map<String,Object> getMap(){
		return map;
	}
	public static void main(String[] args) {
		//01 파라미터 생성
		Map<String,Object> params = new HashMap();
		//02 데이터 전달
		String [] value ={"정보처리기사","빅데이터분석기사","네트워크 관리사","--"}; 
		params.put("자격증",value);
		setMap(params);
		params.clear();
		//02 데이터 전달		
		List<String> hobby = new ArrayList();
		hobby.add("등산");
		hobby.add("독서");
		hobby.add("게임");
		params.put("취미", hobby);
		setMap(params);

		//03 데이터 확인
		//getMap이용해서 저장된 데이터 확인(출력)
		for(String key : getMap().keySet()) {
			Object val = C07Ex.map.get(key);
			System.out.println("KEY : " + key + " val : " + (val instanceof String[] ? Arrays.toString((String[]) val) : val));
;
		}
		
	}
}

```

<aside>
💡

```java
for (String key  : params.keySet()) {
			Object value = params.get(key);
			if (value instanceof String[]) {
				System.out.println(key + " : "+Arrays.toString((String[])value));
			}else if(value instanceof List<?>) {
				System.out.println(key+" : "+ value);
			}else {
				System.out.println(key+" : "+ value);
			}
			
			map.put(key, value);
		}
```

- `instanceof String[]` → `String[]` 배열을 `Arrays.toString()`으로 출력
- `instanceof List` → 리스트는 그냥 출력 (`List.toString()`이 자동으로 요소들을 출력해줌)
- 기본적으로 `Object` 타입으로 받은 값은 `toString()`을 이용해 출력

else if(value instanceof List<?>)     ⇒    에러

- Java에서는 제너릭 타입(`List<String>`)을 `instanceof`로 직접 체크할 수 없습니다.
- `List<String>`은 런타임에 `List<?>`로 변환되므로 `instanceof List<?>`로 검사해야 한다.

```java
public static Map<String, Object> getMap() {
    return map;
}
```

$\small\bf{getMap()~메서드의~역할}$

```java
public static Map<String, Object> getMap() {
    return map;
}
```

### **1. `map` 변수를 반환하는 역할**

- 이 메서드는 **클래스의 정적 변수 `map`을 외부에서 접근할 수 있도록 반환**하는 역할을 합니다.
- 즉, `C07Ex` 클래스 내에서 유지되고 있는 `map` 데이터를 다른 메서드나 코드에서 가져올 수 있도록 해줍니다.

### **`getMap()`의 필요성**

✔ **데이터 저장:** `setMap()`으로 데이터를 `map`에 저장.

✔ **데이터 조회:** `getMap()`을 통해 저장된 데이터를 외부에서 조회 가능.

```java
for(String key : getMap().keySet()) {
			Object val = C07Ex.map.get(key);
			System.out.println("KEY : " + key + " val : " + (val instanceof String[] ? Arrays.toString((String[]) val) : val));
;
		}
```

`getMap()` 메서드를 통해서 map변수를 반환받고 키들의 모음에서 한개씩 뽑아온다.

val값이 배열이면 `Arrays.toString((String[]) val)` 출력하고 그렇지 않으면(리스트이면)

List인 `val`을 그냥 출력

---

```java
Object val = C07Ex.map.get(key);
```

클래스명을 꼭붙여야 할까?

answer : 아니요

why :  

- `map`이 `static`이므로 **클래스명을 사용하여 직접 접근**할 수 있습니다.
- `C07Ex` 클래스 내의 **어디에서든 접근 가능**.

```java
Object val = map.get(key);
```

- 같은 클래스(`C07Ex`) 안에서는 **클래스명 없이도 `map`에 접근 가능**.
- 하지만 **다른 클래스에서 접근하려면 `C07Ex.map.get(key)`처럼 클래스명을 붙여야 함.**
</aside>

### C08PropertiesMain

```java
package Ch17;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class C08PropertiesMain {
	public static void main(String[] args) throws IOException {
		String classPath = System.getProperty("java.class.path");
		System.out.println("classPath : " + classPath);
		String dirPath = System.getProperty("user.dir");
		System.out.println("dirPath : " + dirPath);
		
		String packagePath = C08PropertiesMain.class.getPackageName();
		System.out.println("packagePath : "+packagePath);
		
		String filePath = dirPath+File.separator+"src"+File.separator+packagePath+File.separator+"application.properties";
		FileInputStream fin = new FileInputStream(filePath);
		
		Properties properties  = new Properties();
		properties.load(fin);
		String url = properties.getProperty("url");
		String username = properties.getProperty("uesename");
		String password = properties.getProperty("password");
		
		System.out.printf("%s %s %s\n",url,username,password);
	}
}

```

## Ch18

### C01SwingMain

```java
package Ch18;

import javax.swing.JFrame;

public class C01SwingMain {
	public static void main(String[] args) {
		JFrame frame= new JFrame("첫번째 프레임입니다.");
		frame.setBounds(100,100,500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}
}

```

### C02SwingMain

```java
package Ch18;

import javax.swing.JFrame;

class C02GUI extends JFrame{
	C02GUI(String title){
		super(title);
		setBounds(100,100,500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
public class C02SwingMain {
	public static void main(String[] args) {
		new C02GUI("두번째 프레임입니다.");
		
	}
}

```

### C03SwingMain

```java
package Ch18;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

class C03GUI extends JFrame{
	C03GUI(String title){
		super(title);
		setBounds(100,100,500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// panel
		JPanel panel = new JPanel();
//		Color col = new Color(71,144,0);
//		panel.setBackground(col);
		//Frame(Panel)
		add(panel);
	}
}
public class C03SwingMain {
	public static void main(String[] args) {
		new C03GUI("두번째 프레임입니다.");
		
	}
}

```

### C04SwingMain

```java
package Ch18;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class C04GUI extends JFrame{
	C04GUI(String title){
		super(title);
		setBounds(100,100,300,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		// panel
		JPanel panel = new JPanel();
//		Color col = new Color(71,144,0);
//		panel.setBackground(col);
		panel.setLayout(null);
		
		// Component
		JButton btn1 = new JButton("BTN01");
		btn1.setBounds(10,10,100,30);
		
		JButton btn2 = new JButton("BTN02");
		btn2.setBounds(120,10,100,30);
		
		JTextField txt1 = new JTextField();
		txt1.setBounds(10,50,200,30);
		
		
		JTextArea area1 = new JTextArea();

		JScrollPane scroll = new JScrollPane(area1);
		scroll.setBounds(10,90,210,350);

		// pannel(Component)
		panel.add(btn1);
		panel.add(btn2);
		panel.add(txt1);
//		panel.add(area1);
		panel.add(scroll);
		
		//Frame(Pannel)
		add(panel);
		
		
		//Frame
		setVisible(true);

	}
	
	
}
public class C04SwingMain {
	public static void main(String[] args) {
		new C04GUI("네번째 프레임입니다.");
		
	}
}

```

### C05Ex

```java
package Ch18;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class GUI extends JFrame{
	GUI(String title){
		super(title);
		setBounds(100,100,300,500); // 프레임 크기 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pannel = new JPanel();
		pannel.setLayout(null);
		
		
		JTextArea area1 = new JTextArea();
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(15,30,150,300);

		JButton btn1 = new JButton();
		btn1.setBounds(177,30,100,30);
		btn1.setText("파일로 저장");
		
		JButton btn2 = new JButton();
		btn2.setBounds(177,80,100,30);
		btn2.setText("1 : 1 요청");
		
		JButton btn3 = new JButton();
		btn3.setBounds(177,130,100,30);
		btn3.setText("대화기록보기");
		
		
		JTextField txt1 = new JTextField();
		txt1.setBounds(15,370,150,40);
		
		JButton input = new JButton("입력");		
		input.setBounds(177,370,100,40);

		
		
//		pannel.add(area1);
		pannel.add(scroll1);
		pannel.add(btn1);
		pannel.add(btn2);
		pannel.add(btn3);
		pannel.add(txt1);
		pannel.add(input);
		
		//Frame에 pannel 더하기
		add(pannel);
		
		// 프레임 표시
		setVisible(true);
		
	}
}
public class C05Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Component 참조변수명
		//textarea = area1
		//textarea's scroll = scroll1
		//파일로저장 : btn1
		//1:1요청 : btn2
		//대화기록보기 : btn3
		//입력 : input
		//textfield : txt1
		new GUI("Chatting Server"); // 프레임 생성
	}

}

```

### C06SwingEventMain

```java
package Ch18;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class C06GUI extends JFrame implements ActionListener{
	JButton btn1; // 생성자 안에서 만들었기 때문에 생성자 밖에서도 쓰기위해서 멤버변수로 지정.
	JButton btn2;
	JButton btn3;   
	JButton input;
	
	C06GUI(String title){
		super(title);
		setBounds(100,100,300,500); // 프레임 크기 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pannel = new JPanel();
		pannel.setLayout(null);
		
		
		JTextArea area1 = new JTextArea();
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(15,30,150,300);

		btn1 = new JButton();
		btn1.setBounds(177,30,100,30);
		btn1.setText("파일로 저장");
		
		btn2 = new JButton();
		btn2.setBounds(177,80,100,30);
		btn2.setText("1 : 1 요청");
		
		btn3 = new JButton();
		btn3.setBounds(177,130,100,30);
		btn3.setText("대화기록보기");
		
		input = new JButton("입력");		
		input.setBounds(177,370,100,40);
		
		JTextField txt1 = new JTextField();
		txt1.setBounds(15,370,150,40);
		
		

		// 이벤트 리스너 add
		btn1.addActionListener(this); // btn1에 대한 위치정보를 this로 전달
		btn2.addActionListener(this); // btn2에 대한 위치정보를 this로 전달
		btn3.addActionListener(this);
		input.addActionListener(this);
		

//		pannel.add(area1);
		pannel.add(scroll1);
		pannel.add(btn1);
		pannel.add(btn2);
		pannel.add(btn3);
		pannel.add(txt1);
		pannel.add(input);
		
		//Frame에 pannel 더하기
		add(pannel);
		
		// 프레임 표시
		setVisible(true);
		
	}

	// 버튼클릭하면 그 감지를 여기서 한다. 항상감시하고 있으니까
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("클릭");
		if (e.getSource() == btn1 ) {
			System.out.println("파일로 저장 클릭");
		}else if(e.getSource() == btn2) {
			System.out.println("1:1 요청 클릭");
		}else if(e.getSource() == btn3) {
			System.out.println("대화기록보기");
		}
		
		else if(e.getSource() == input) {
			System.out.println("입력 클릭");
		}
	}
}
public class C06SwingEventMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Component 참조변수명
		//textarea = area1
		//textarea's scroll = scroll1
		//파일로저장 : btn1
		//1:1요청 : btn2
		//대화기록보기 : btn3
		//입력 : input
		//textfield : txt1
		new C06GUI("Chatting Server"); // 프레임 생성
	}

}

```

### C07SwingEventMain2

```java
package Ch18;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

import Ch01.Ch01SystemOut;

class C07GUI extends JFrame implements ActionListener, KeyListener,MouseListener{
	JButton btn1; // 생성자 안에서 만들었기 때문에 생성자 밖에서도 쓰기위해서 멤버변수로 지정.
	JButton btn2;
	JButton btn3;   
	JButton input;
	JTextField txt1;
	JTextArea area1;
	
	
	
	C07GUI(String title){
		super(title);
		setBounds(100,100,300,500); // 프레임 크기 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pannel = new JPanel();
		pannel.setLayout(null);
		
		
		area1 = new JTextArea();
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(15,30,150,300);

		btn1 = new JButton();
		btn1.setBounds(177,30,100,30);
		btn1.setText("파일로 저장");
		
		btn2 = new JButton();
		btn2.setBounds(177,80,100,30);
		btn2.setText("1 : 1 요청");
		
		btn3 = new JButton();
		btn3.setBounds(177,130,100,30);
		btn3.setText("대화기록보기");
		
		input = new JButton("입력");		
		input.setBounds(177,370,100,40);
		
		txt1 = new JTextField();
		txt1.setBounds(15,370,150,40);
		
		

		// 이벤트 리스너 add
		btn1.addActionListener(this); // btn1에 대한 위치정보를 this로 전달
		btn2.addActionListener(this); // btn2에 대한 위치정보를 this로 전달
		btn3.addActionListener(this);
		input.addActionListener(this);
		txt1.addKeyListener(this);
		area1.addMouseListener(this);

//		pannel.add(area1);
		pannel.add(scroll1);
		pannel.add(btn1);
		pannel.add(btn2);
		pannel.add(btn3);
		pannel.add(txt1);
		pannel.add(input);
		
		//Frame에 pannel 더하기
		add(pannel);
		
		// 프레임 표시
		setVisible(true);
		
	}

	// 버튼클릭하면 그 감지를 여기서 한다. 항상감시하고 있으니까
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("클릭");
		if (e.getSource() == btn1 ) {
			System.out.println("파일로 저장 클릭");
		}else if(e.getSource() == btn2) {
			System.out.println("1:1 요청 클릭");
		}else if(e.getSource() == btn3) {
			System.out.println("대화기록보기");
		}
		
		else if(e.getSource() == input) {
			System.out.println("입력 클릭");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("keyTyped..."+e.getKeyChar());
//		System.out.println("keyTyped..."+e.getKeyCode());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("keyPressed..."+e.getKeyChar());
		System.out.println("keyPressed..."+e.getKeyCode());
		if (e.getSource()==txt1) {
			if (e.getKeyCode()==10) {
				String message = txt1.getText();
				System.out.println(message);
				area1.append(message+"\n");
				txt1.setText("");
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		try {
//			System.out.println("mouseClicked"+e.getPoint());
			int offset = area1.viewToModel(e.getPoint());
//			System.out.println("mouse offset : "+offset);
			int row = area1.getLineOfOffset(offset);
//			System.out.println("mouseClicked...row : "+ row);
			int startOffset = area1.getLineStartOffset(row);
			int endOffset = area1.getLineEndOffset(row);
//			System.out.printf("%d %d\n",startOffset,endOffset);
			String str = area1.getText(startOffset, endOffset-startOffset);
			System.out.println(str);
		}
		 catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
public class C07SwingEventMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Component 참조변수명
		//textarea = area1
		//textarea's scroll = scroll1
		//파일로저장 : btn1
		//1:1요청 : btn2
		//대화기록보기 : btn3
		//입력 : input
		//textfield : txt1
		new C07GUI("Chatting Server"); // 프레임 생성
	}

}

```

## Ch19(파일 입출력)

### C01WriteMain

```java
package Ch19;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class C01WriteMain {
	public static void main(String[] args) throws IOException {
		// Writer fout = new FileWriter("C:\\IOTEST\\test1.txt",false); // 덮어쓰기
		Writer fout = new FileWriter("C:\\IOTEST\\test1.txt",true); // 추가하기
		
		fout.write("TEST1\n");
		fout.write("TEST2\n");
		fout.write("TEST3\n");
		fout.write("TEST4\n");
		
		fout.flush();
		fout.close();
	}
}

```

### C02ReaderMain

```java
package Ch19;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class C02ReaderMain {
	public static void main(String[] args) throws IOException {
		
		Reader fin = new FileReader("C:\\IOTEST\\test1.txt");
		
		int data=0;
		String str="";
		StringBuffer buffer = new StringBuffer();
		while ((data = fin.read()) != -1) {
			System.out.print((char)data);
			buffer.append((char)data+"");
		}
		
		System.out.println("---------------------------------------");
		System.out.println(buffer);
		
	}
}

```

### C03FileCopyMain

```java
package Ch19;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class C03FileCopyMain {
	
	private static String FileDir = "C:\\IOTEST\\" ;
	
	
	public static void main(String[] args) throws IOException { // args[0] 원본파일 args[1] 대상파일
		

		for(String arg : args) {
			System.out.println(arg);
		}
		Reader fin = new FileReader(FileDir + args[0]); //원본파일
		Writer fout = new FileWriter(FileDir+args[1]); // 대상파일
		
		while (true) {
			int data = fin.read();
			if(data ==-1) {
			 	break;
			}
			fout.write((char)data);
			fout.flush();
		}
		fin.close();
		fout.close();
			
			
	
	}
}

```

### C04FileCopyMain

```java
package Ch19;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class C04FileCopyMain {
	

	public static void main(String[] args) throws IOException {
			
		Reader fin = new FileReader("C:\\IOTEST\\test3.txt");
		
		int data=0;
		StringBuffer buffer = new StringBuffer();
		
		char [] buf = new char[4096]; //1024byte
		
		long startTime = System.currentTimeMillis();
		while ((data = fin.read(buf)) != -1) {

			//buffer.append((char)data);
			buffer.append(buf);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("소요시간 : "+(endTime-startTime) +"ms");
		System.out.println("---------------------------------------");
		//System.out.println(buffer);
			
	}
}

```

### C05FileInputStreamMain

```java
package Ch19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class C05FileInputStreamMain {
	public static void main(String[] args) throws IOException{
		
		InputStream fin =new  FileInputStream("C:\\IOTEST\\data.xlsx");
		StringBuffer StringBUffer =  new StringBuffer();
		
		
		// read({})
		byte [] buf = new byte[1024];
		long sTime = System.currentTimeMillis();
		while(true) {
			int data = fin.read(buf);
			if(data == -1) {
				break;
			}
			//System.out.print((char)data);
		}
		long eTime = System.currentTimeMillis();
		System.out.println("소요시간 : "+(eTime-sTime)+"ms");
		fin.close();
	}

}

```

### C06FileOutputStreamMain

```java
package Ch19;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class C06FileOutputStreamMain {
	public static void main(String[] args) throws IOException {
		OutputStream out = new FileOutputStream("C:\\IOTEST\\test4.txt");
		out.write("가".getBytes(StandardCharsets.UTF_8));
		out.write('a');
		out.write('b');
		out.write('c');
		
		out.flush();
		out.close();
	}
}

```

### C07FileCopyMain

```java
package Ch19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class C07FileCopyMain {
	public static void main(String[] args) throws Exception{
		InputStream in = new FileInputStream("C:\\IOTEST\\video.mp4");
		OutputStream out =new FileOutputStream("C:\\IOTEST\\video_복사본");
		
		
		// 01 버퍼미사용
//		while (true) {
//			int data = in.read();
//			if(data == -1) {
//				break;
//			}
//			out.write((byte)data);
//			out.flush(); // flush()를 호출하면 강제적으로 데이터가 기록됨: 버퍼에 남아 있는 
//						 //데이터를 강제로 내보내서 파일에 저장하게 합니다. => 버퍼링 떄문에 사용
//			
//		}
//		out.close();
//		in.close();
		
		// 02 버퍼사용
		byte [] buff = new byte[4096];
		System.out.println("진행중");
		while (true) {
			int data = in.read(buff);
			if(data == -1) {
				break;
			}
			out.write(buff, 0, data);;
			out.flush(); // flush()를 호출하면 강제적으로 데이터가 기록됨: 버퍼에 남아 있는 
						 //데이터를 강제로 내보내서 파일에 저장하게 합니다. => 버퍼링 떄문에 사용
			
		}
		out.close();
		in.close();
		System.out.println("끝");
		
		
		
	}
}

```

### C08SwingEventMain

```java
package Ch19;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

class C08GUI extends JFrame implements ActionListener, KeyListener,MouseListener{
	JButton btn1; // 생성자 안에서 만들었기 때문에 생성자 밖에서도 쓰기위해서 멤버변수로 지정.
	JButton btn2;
	JButton btn3;   
	JButton input;
	JTextField txt1;
	JTextArea area1;
	
	Writer out;
	
	
	C08GUI(String title){
		super(title);
		setBounds(100,100,300,500); // 프레임 크기 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pannel = new JPanel();
		pannel.setLayout(null);
		
		
		area1 = new JTextArea();
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(15,30,150,300);

		btn1 = new JButton();
		btn1.setBounds(177,30,100,30);
		btn1.setText("저장하기");
		
		btn2 = new JButton();
		btn2.setBounds(177,80,100,30);
		btn2.setText("불러오기");
		
		btn3 = new JButton();
		btn3.setBounds(177,130,100,30);
		btn3.setText("대화기록보기");
		
		input = new JButton("입력");		
		input.setBounds(177,370,100,40);
		
		txt1 = new JTextField();
		txt1.setBounds(15,370,150,40);
		
		

		// 이벤트 리스너 add
		btn1.addActionListener(this); // btn1에 대한 위치정보를 this로 전달
		btn2.addActionListener(this); // btn2에 대한 위치정보를 this로 전달
		btn3.addActionListener(this);
		input.addActionListener(this);
		txt1.addKeyListener(this);
		area1.addMouseListener(this);

//		pannel.add(area1);
		pannel.add(scroll1);
		pannel.add(btn1);
		pannel.add(btn2);
		pannel.add(btn3);
		pannel.add(txt1);
		pannel.add(input);
		
		//Frame에 pannel 더하기
		add(pannel);
		
		// 프레임 표시
		setVisible(true);
		
	}

	// 버튼클릭하면 그 감지를 여기서 한다. 항상감시하고 있으니까
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("클릭");
		if (e.getSource() == btn1 ) {
			System.out.println("저장하기");
			String contents = area1.getText();
			
			// 파일 탐색기 열기
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("파일 저장 위치를 선택하세요");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			File defaultDirPath = new File("C:\\IOTEST");
			if(defaultDirPath.exists()) {
				fileChooser.setCurrentDirectory(defaultDirPath);
			}
			int selectedVal = fileChooser.showSaveDialog(null);
			System.out.println("selectedVal"+selectedVal);
			
			
			if(selectedVal == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("selectedFile"+selectedFile);
				
				// 파일 확장자 추가
				String filePath = selectedFile.toString();
				if(!selectedFile.toString().endsWith(".txt")) {
					filePath = selectedFile.toString()+".txt";
				}
				System.out.println("filepath : "+ filePath);
				
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyMMdd_HHmmss");			
//				String filename = LocalDateTime.now().format(formatter);
				
				try {
					out = new FileWriter(filePath);
					out.write(contents);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}finally {
					try {out.close();} catch(IOException e2) {e2.printStackTrace();}
				}
				
	
		}else if(e.getSource() == btn2) {
			System.out.println("불러오기");
			
			// 파일 탐색기 열기
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("파일을 선택하세요.");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			File defaultDirPath = new File("C:\\IOTEST");
			if(defaultDirPath.exists()) {
				fileChooser.setCurrentDirectory(defaultDirPath);
			}
			int selectedVal = fileChooser.showSaveDialog(null);
			System.out.println("selectedVal"+selectedVal);
			
			if(selectedVal == JFileChooser.APPROVE_OPTION){
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("selectedFile : "+selectedFile);
				try {
					Reader fin = new FileReader(selectedFile.toString());
					StringBuffer buffer  = new StringBuffer();
					while(true) {
						int data = fin.read();
						if(data ==-1) {
							break;
						}
						buffer.append((char)data);
						
					}
					area1.setText("");
					area1.append(buffer.toString());
					fin.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
			
		}else if(e.getSource() == btn3) {
			System.out.println("대화기록보기");
		}
		
		else if(e.getSource() == input) {
			System.out.println("입력 클릭");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("keyTyped..."+e.getKeyChar());
//		System.out.println("keyTyped..."+e.getKeyCode());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("keyPressed..."+e.getKeyChar());
		System.out.println("keyPressed..."+e.getKeyCode());
		if (e.getSource()==txt1) {
			if (e.getKeyCode()==10) {
				String message = txt1.getText();
				System.out.println(message);
				area1.append(message+"\n");
				txt1.setText("");
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		try {
//			System.out.println("mouseClicked"+e.getPoint());
			int offset = area1.viewToModel(e.getPoint());
//			System.out.println("mouse offset : "+offset);
			int row = area1.getLineOfOffset(offset);
//			System.out.println("mouseClicked...row : "+ row);
			int startOffset = area1.getLineStartOffset(row);
			int endOffset = area1.getLineEndOffset(row);
//			System.out.printf("%d %d\n",startOffset,endOffset);
			String str = area1.getText(startOffset, endOffset-startOffset);
			System.out.println(str);
		}
		 catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
public class C08SwingEventMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Component 참조변수명
		//textarea = area1
		//textarea's scroll = scroll1
		//파일로저장 : btn1
		//1:1요청 : btn2
		//대화기록보기 : btn3
		//입력 : input
		//textfield : txt1
		new C08GUI("Chatting Server"); // 프레임 생성
	}

}

```

### C09URLStreamMain

```java
package Ch19;

import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URL;

public class C09URLStreamMain {
	public static void main(String[] args) throws Exception {
		URL url =  (new URI("https://n.news.naver.com/article/082/0001316059?cds=news_media_pc&type=editn")).toURL();
		InputStream in = url.openStream();
		
		// 보조 스트림 추가(Ch20에서 진행)
		BufferedInputStream buffIn = new BufferedInputStream(in);
		Reader rin = new InputStreamReader(buffIn);
		
		Writer out = new FileWriter("C:\\IOTEST\\index.html");
		
//		OutputStream out = new FileOutputStream("C:\\IOTEST\\index.html");
		
		while(true) {
			int data = rin.read();
			if (data==-1) {
				break;
			}
			System.out.print((char)data);
			out.write((char)data);
			out.flush();
		}
		rin.close();
		buffIn.close();
		in.close();
		out.close();
	}
}

```

### C10JsoupMain

```java
package Ch19;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.UUID;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class C10JsoupMain {
	public static void main(String[] args) throws IOException, URISyntaxException {
		// Maven repository에 들어가서 jsoup 검색 맨위에꺼 클릭 
		// verson - 1.19.1 클릭 후 들어가서 jar 클릭하면 다운로드된다.
		// 다운 후 해당 파일을 패키지 안으로 넣는다.
		// 넣은 후 JAVABOOK 우클릭 후 Properties 누른 후 Java Build Path 클릭
		// Library 클릭 후 Classpath 누른 후 addjars 클릭 후 해당 패키지 선택
		Connection conn = Jsoup.connect("https://www.op.gg/champions");
		
		Document document = conn.get();
		//System.out.println(document);
		
		Elements elements = document.getElementsByTag("img");
		//System.out.println(elements);
		
		for (Element el : elements) {
			//System.out.println(el);
			try {
			String img_url = el.getElementsByAttribute("src").attr("src");
			System.out.println(img_url);
			
			URL url =  (new URI(img_url)).toURL();
			InputStream in = url.openStream();
			BufferedInputStream buffIn = new BufferedInputStream(in); // 버퍼공간 추가
			
			OutputStream out = null;
			
			if (img_url.contains(".png")) {
				out = new FileOutputStream("C:\\IOTEST\\"+UUID.randomUUID()+".png");	
			}else if(img_url.contains(".svg")) {
				out = new FileOutputStream("C:\\IOTEST\\"+UUID.randomUUID()+".svg");	
			}else if(img_url.contains(".webp")) {
				out = new FileOutputStream("C:\\IOTEST\\"+UUID.randomUUID()+".webp");	
			}else {
				out = new FileOutputStream("C:\\IOTEST\\"+UUID.randomUUID()+".jpg");	
			}
			
			
			while(true) {
				int data = buffIn.read();
				if(data ==-1) {
					break;
				}
				out.write((byte)data);
				out.flush();
			}
			out.close();
			buffIn.close();
			in.close();
			}catch(Exception e){
				
			}
		}
			
	}
}

```

### C11SelenumAPIMain

```java
package Ch19;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//크롬서버.jar 다운로드 경로(셀레니움 공식 홈페이지)
//https://www.selenium.dev/downloads/

//크롬드라이브 다운로드 경로
//https://googlechromelabs.github.io/chrome-for-testing/#stable

public class C11SelenumAPIMain {

	private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	private static final String WEB_DRIVER_PATH = "src/Drivers/chromedriver.exe";

	
	public static void main(String[] args) throws IOException {
		
		//브라우저 옵션
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");			//백그라운드 실행
//		options.addArguments("--no-sandbox");		//리눅스환경 sendbox 사용 여부

		//브라우저 동작
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.naver.com");
		
		//특정 위치 요소 선택(키워드 입력하기)
		WebElement searchEl = driver.findElement(By.id("query"));
		
		//키워드 입력
		searchEl.sendKeys("노트북");
		
		//엔터키 전달
		searchEl.sendKeys(Keys.RETURN);
		
		//노트북 검색 이후에 쇼핑 버튼 클릭
		WebElement shoppingBtnEl =  driver.findElement(By.cssSelector(".api_pcpg_wrap .tab:nth-child(1)"));
		//target_blank(새창열기) 제거 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].removeAttribute('target')",shoppingBtnEl);
		
		shoppingBtnEl.click();
		//네이버포털 -> '노트북'검색 -> 쇼핑 클릭-> 삼성 노트북(엔터)
//		WebElement itemsHeaderEl =  driver.findElement(By.cssSelector("._searchInput_search_text_3CUDs"));
//		itemsHeaderEl.sendKeys("삼성 노트북");
//		itemsHeaderEl.sendKeys(Keys.RETURN);
		
		
		//네이버포털 -> '노트북'검색 -> 쇼핑 클릭-> 삼성 노트북(엔터) -> 리뷰 많은순 클릭
		List<WebElement> Els =  driver.findElements(By.cssSelector(".subFilter_sort__lhuHl"));
		Els.forEach(el->{
			if(el.getText().contains("리뷰 많은순"))
				el.click();
		});
		
		//영역내 모든 정보 긁어오기 basicList_list_basis__uNBZx
		List<WebElement> El2s =  driver.findElements(By.cssSelector(".basicList_list_basis__uNBZx"));
		
		
		//파일로 저장
		Writer out = new FileWriter("C:\\IOTEST\\index.html");
	
		//css link 빼내오기
		List<WebElement> cssLinks = driver.findElements(By.tagName("link"));
		for(WebElement link : cssLinks) {
			String rel = link.getAttribute("rel");
			if(rel.equals("stylesheet")){
				String href = link.getAttribute("href");
				System.out.println("CSS 링크 : " + href);
			}
		}
		
		//본문내용
		for(WebElement el :El2s) {
			String elHTML = el.getAttribute("outerHTML");
			out.write(elHTML+"\n");
		}
		out.flush();
		out.close();
		
	}
}
```

### C12RestRequestResponseMain

```java
package Ch19;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class C12RestRequestResponseMain {
	public static void main(String[] args) throws IOException, InterruptedException {
		// URL,PARAM 지정
		String url = "https://www.daegufood.go.kr/kor/api/tasty.html";
		String mode = "json";
		String addr = "중구";
		url= url+"?mode="+mode+"&addr="+addr;
		
		
		// Http Request 객체 생성
		HttpRequest httpRequest = HttpRequest.newBuilder()
									.uri(URI.create(url)) // 속성넣어준다
									.GET()  // 속성넣어준다
									.build();  // 객체 만들어준다.
		
		// Http Request 요청 / 응답 확인
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> response = 
                httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		
		
		// 가공 처리 (Class Type vs JSON Type)
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		
		
		// JSON TYPE
//		JsonNode jsonNode = objectMapper.readTree(response.body());
//		System.out.println("Status : " + jsonNode.get("status"));
//		System.out.println("Status : " + jsonNode.get("total"));
//		JsonNode data_arr = jsonNode.get("data");
//		for (int i = 0; i < data_arr.size(); i++) {
//			JsonNode el = data_arr.get(i);
//			System.out.println(el.get("BZ_NM"));
//			
//		}
		
		
		// CLASS TYPE
		ResponseObject responseObject = objectMapper.readValue(response.body(), ResponseObject.class);
		System.out.println("STATUS : " + responseObject.getStatus());
		System.out.println("total : " + responseObject.getTotal());
		System.out.println("total : " + responseObject.getTotal());
		System.out.println(responseObject.getData().get(0));
		
		
		responseObject.getData().get(0);
		
	}
	// class Type
	
		// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
		// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
		/* ObjectMapper om = new ObjectMapper();
		Root root = om.readValue(myJsonString, Root.class); */
		private static class Data{
		    public String cnt;
		    @JsonProperty("OPENDATA_ID") 
		    public String oPENDATA_ID;
		    @JsonProperty("GNG_CS") 
		    public String gNG_CS;
		    @JsonProperty("FD_CS") 
		    public String fD_CS;
		    @JsonProperty("BZ_NM") 
		    public String bZ_NM;
		    @JsonProperty("TLNO") 
		    public String tLNO;
		    @JsonProperty("MBZ_HR") 
		    public String mBZ_HR;
		    @JsonProperty("SEAT_CNT") 
		    public String sEAT_CNT;
		    @JsonProperty("PKPL") 
		    public String pKPL;
		    @JsonProperty("HP") 
		    public String hP;
		    @JsonProperty("PSB_FRN") 
		    public String pSB_FRN;
		    @JsonProperty("BKN_YN") 
		    public String bKN_YN;
		    @JsonProperty("INFN_FCL") 
		    public String iNFN_FCL;
		    @JsonProperty("BRFT_YN") 
		    public String bRFT_YN;
		    @JsonProperty("DSSRT_YN") 
		    public String dSSRT_YN;
		    @JsonProperty("MNU") 
		    public String mNU;
		    @JsonProperty("SMPL_DESC") 
		    public String sMPL_DESC;
		    @JsonProperty("SBW") 
		    public String sBW;
		    @JsonProperty("BUS") 
		    public String bUS;
		    
		    Data(){
		    	
		    }
		    
		    
		    //모든 인자 생성자

			public Data(String cnt, String oPENDATA_ID, String gNG_CS, String fD_CS, String bZ_NM, String tLNO,
					String mBZ_HR, String sEAT_CNT, String pKPL, String hP, String pSB_FRN, String bKN_YN,
					String iNFN_FCL, String bRFT_YN, String dSSRT_YN, String mNU, String sMPL_DESC, String sBW,
					String bUS) {
				super();
				this.cnt = cnt;
				this.oPENDATA_ID = oPENDATA_ID;
				this.gNG_CS = gNG_CS;
				this.fD_CS = fD_CS;
				this.bZ_NM = bZ_NM;
				this.tLNO = tLNO;
				this.mBZ_HR = mBZ_HR;
				this.sEAT_CNT = sEAT_CNT;
				this.pKPL = pKPL;
				this.hP = hP;
				this.pSB_FRN = pSB_FRN;
				this.bKN_YN = bKN_YN;
				this.iNFN_FCL = iNFN_FCL;
				this.bRFT_YN = bRFT_YN;
				this.dSSRT_YN = dSSRT_YN;
				this.mNU = mNU;
				this.sMPL_DESC = sMPL_DESC;
				this.sBW = sBW;
				this.bUS = bUS;
			}
			
			
			
			// getter and setter

			public String getCnt() {
				return cnt;
			}

			public void setCnt(String cnt) {
				this.cnt = cnt;
			}

			public String getoPENDATA_ID() {
				return oPENDATA_ID;
			}

			public void setoPENDATA_ID(String oPENDATA_ID) {
				this.oPENDATA_ID = oPENDATA_ID;
			}

			public String getgNG_CS() {
				return gNG_CS;
			}

			public void setgNG_CS(String gNG_CS) {
				this.gNG_CS = gNG_CS;
			}

			public String getfD_CS() {
				return fD_CS;
			}

			public void setfD_CS(String fD_CS) {
				this.fD_CS = fD_CS;
			}

			public String getbZ_NM() {
				return bZ_NM;
			}

			public void setbZ_NM(String bZ_NM) {
				this.bZ_NM = bZ_NM;
			}

			public String gettLNO() {
				return tLNO;
			}

			public void settLNO(String tLNO) {
				this.tLNO = tLNO;
			}

			public String getmBZ_HR() {
				return mBZ_HR;
			}

			public void setmBZ_HR(String mBZ_HR) {
				this.mBZ_HR = mBZ_HR;
			}

			public String getsEAT_CNT() {
				return sEAT_CNT;
			}

			public void setsEAT_CNT(String sEAT_CNT) {
				this.sEAT_CNT = sEAT_CNT;
			}

			public String getpKPL() {
				return pKPL;
			}

			public void setpKPL(String pKPL) {
				this.pKPL = pKPL;
			}

			public String gethP() {
				return hP;
			}

			public void sethP(String hP) {
				this.hP = hP;
			}

			public String getpSB_FRN() {
				return pSB_FRN;
			}

			public void setpSB_FRN(String pSB_FRN) {
				this.pSB_FRN = pSB_FRN;
			}

			public String getbKN_YN() {
				return bKN_YN;
			}

			public void setbKN_YN(String bKN_YN) {
				this.bKN_YN = bKN_YN;
			}

			public String getiNFN_FCL() {
				return iNFN_FCL;
			}

			public void setiNFN_FCL(String iNFN_FCL) {
				this.iNFN_FCL = iNFN_FCL;
			}

			public String getbRFT_YN() {
				return bRFT_YN;
			}

			public void setbRFT_YN(String bRFT_YN) {
				this.bRFT_YN = bRFT_YN;
			}

			public String getdSSRT_YN() {
				return dSSRT_YN;
			}

			public void setdSSRT_YN(String dSSRT_YN) {
				this.dSSRT_YN = dSSRT_YN;
			}

			public String getmNU() {
				return mNU;
			}

			public void setmNU(String mNU) {
				this.mNU = mNU;
			}

			public String getsMPL_DESC() {
				return sMPL_DESC;
			}

			public void setsMPL_DESC(String sMPL_DESC) {
				this.sMPL_DESC = sMPL_DESC;
			}

			public String getsBW() {
				return sBW;
			}

			public void setsBW(String sBW) {
				this.sBW = sBW;
			}

			public String getbUS() {
				return bUS;
			}

			public void setbUS(String bUS) {
				this.bUS = bUS;
			}

			@Override
			public String toString() {
				return "Data [cnt=" + cnt + ", oPENDATA_ID=" + oPENDATA_ID + ", gNG_CS=" + gNG_CS + ", fD_CS=" + fD_CS
						+ ", bZ_NM=" + bZ_NM + ", tLNO=" + tLNO + ", mBZ_HR=" + mBZ_HR + ", sEAT_CNT=" + sEAT_CNT
						+ ", pKPL=" + pKPL + ", hP=" + hP + ", pSB_FRN=" + pSB_FRN + ", bKN_YN=" + bKN_YN
						+ ", iNFN_FCL=" + iNFN_FCL + ", bRFT_YN=" + bRFT_YN + ", dSSRT_YN=" + dSSRT_YN + ", mNU=" + mNU
						+ ", sMPL_DESC=" + sMPL_DESC + ", sBW=" + sBW + ", bUS=" + bUS + "]";
			}
		    
		    
			
		}

		private static class ResponseObject{
		    public String status;
		    public String total;
		    public ArrayList<Data> data;
		    ResponseObject(){
		    	
		    }
		    
		    
		    //모든 인자 생성자
			public ResponseObject(String status, String total, ArrayList<Data> data) {
				super();
				this.status = status;
				this.total = total;
				this.data = data;
			}
			
			
			
			// getter and setter
			public String getStatus() {
				return status;
			}
			public void setStatus(String status) {
				this.status = status;
			}
			public String getTotal() {
				return total;
			}
			public void setTotal(String total) {
				this.total = total;
			}
			public ArrayList<Data> getData() {
				return data;
			}
			public void setData(ArrayList<Data> data) {
				this.data = data;
			}
		    
		    
			
		}
}

```

### C13Ex

```java
package Ch19;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class C13Ex {
	public static void main(String[] args) throws IOException, InterruptedException {
		// OPENWEATHER MAP API를 이용해서 날씨 정보 받아옵니다.
		String API_KEY = "ee6171cdf7597f9f51f38521a91dd6c1";
		String url = "https://api.openweathermap.org/data/2.5/weather?lat=33.44&lon=-94.04&appid="+API_KEY;
		
		// HTTP Request 객체생성
		HttpRequest httpRequest = HttpRequest.newBuilder()
									.uri(URI.create(url))
									.GET()
									.build();
								
		// Http Request 요청 / 응답 확인
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		
//		System.out.println(response.body());
		
		// 가공 처리
		ObjectMapper objectMapper = new ObjectMapper();
		
		// Clas Type
		Root RootObject = objectMapper.readValue(response.body(), Root.class);
		System.out.println("도시이름 : "+RootObject.getName());
		System.out.printf("현재온도 : %.2f°C\n",(RootObject.getMain().getTemp()-273.15));		
		System.out.printf("체감온도 : %.2f°C\n",(RootObject.getMain().getFeels_like()-273.15));
		System.out.printf("최저온도 : %.2f°C\n",(RootObject.getMain().getTemp_min()-273.15));
		System.out.printf("최고온도 : %.2f°C\n",(RootObject.getMain().getTemp_max()-273.15));
		System.out.printf("기압 : %dhPa\n",RootObject.getMain().getPressure());
		System.out.printf("습도 : %d%% \n",RootObject.getMain().getHumidity());
		System.out.printf("해수면 : %dhpa\n",RootObject.getMain().getSea_level());
		System.out.printf("지면기압 : %dhpa",RootObject.getMain().getGrnd_level());
		
		
		
	}	
	
	// class type
		// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
		// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
		/* ObjectMapper om = new ObjectMapper();
		Root root = om.readValue(myJsonString, Root.class); */
		public static class Clouds{
		    public int all;
		    
		    Clouds(){
		    	
		    }

			public Clouds(int all) {
				super();
				this.all = all;
			}

			public int getAll() {
				return all;
			}

			public void setAll(int all) {
				this.all = all;
			}
		    
		}

		public static class Coord{
		    public double lon;
		    public double lat;
		    
		    Coord(){
		    	
		    }
		    
			public Coord(double lon, double lat) {
				super();
				this.lon = lon;
				this.lat = lat;
			}

			public double getLon() {
				return lon;
			}

			public void setLon(double lon) {
				this.lon = lon;
			}

			public double getLat() {
				return lat;
			}

			public void setLat(double lat) {
				this.lat = lat;
			}
		    
			
			
		    
		}

		public static class Main{
		    public double temp;
		    public double feels_like;
		    public double temp_min;
		    public double temp_max;
		    public int pressure;
		    public int humidity;
		    public int sea_level;
		    public int grnd_level;
		    
		    
		    
		    Main(){
		    	
		    }
		    
			public double getTemp() {
				return temp;
			}

			public void setTemp(double temp) {
				this.temp = temp;
			}

			public double getFeels_like() {
				return feels_like;
			}

			public void setFeels_like(double feels_like) {
				this.feels_like = feels_like;
			}

			public double getTemp_min() {
				return temp_min;
			}

			public void setTemp_min(double temp_min) {
				this.temp_min = temp_min;
			}

			public double getTemp_max() {
				return temp_max;
			}

			public void setTemp_max(double temp_max) {
				this.temp_max = temp_max;
			}

			public int getPressure() {
				return pressure;
			}

			public void setPressure(int pressure) {
				this.pressure = pressure;
			}

			public int getHumidity() {
				return humidity;
			}

			public void setHumidity(int humidity) {
				this.humidity = humidity;
			}

			public int getSea_level() {
				return sea_level;
			}

			public void setSea_level(int sea_level) {
				this.sea_level = sea_level;
			}

			public int getGrnd_level() {
				return grnd_level;
			}

			public void setGrnd_level(int grnd_level) {
				this.grnd_level = grnd_level;
			}
			
			public Main(double temp, double feels_like, double temp_min, double temp_max, int pressure, int humidity,
					int sea_level, int grnd_level) {
				super();
				this.temp = temp;
				this.feels_like = feels_like;
				this.temp_min = temp_min;
				this.temp_max = temp_max;
				this.pressure = pressure;
				this.humidity = humidity;
				this.sea_level = sea_level;
				this.grnd_level = grnd_level;
			}
		    
		    
		}

		public static class Root{
		    public Coord coord;
		    public ArrayList<Weather> weather;
		    public String base;
		    public Main main;
		    public int visibility;
		    public Wind wind;
		    public Clouds clouds;
		    public int dt;
		    public Sys sys;
		    public int timezone;
		    public int id;
		    public String name;
		    public int cod;
		    
		    Root(){
		    	
		    }
			public Root(Coord coord, ArrayList<Weather> weather, String base, Main main, int visibility, Wind wind,
					Clouds clouds, int dt, Sys sys, int timezone, int id, String name, int cod) {
				super();
				this.coord = coord;
				this.weather = weather;
				this.base = base;
				this.main = main;
				this.visibility = visibility;
				this.wind = wind;
				this.clouds = clouds;
				this.dt = dt;
				this.sys = sys;
				this.timezone = timezone;
				this.id = id;
				this.name = name;
				this.cod = cod;
			}
			
			
			public Coord getCoord() {
				return coord;
			}
			public void setCoord(Coord coord) {
				this.coord = coord;
			}
			public ArrayList<Weather> getWeather() {
				return weather;
			}
			public void setWeather(ArrayList<Weather> weather) {
				this.weather = weather;
			}
			public String getBase() {
				return base;
			}
			public void setBase(String base) {
				this.base = base;
			}
			public Main getMain() {
				return main;
			}
			public void setMain(Main main) {
				this.main = main;
			}
			public int getVisibility() {
				return visibility;
			}
			public void setVisibility(int visibility) {
				this.visibility = visibility;
			}
			public Wind getWind() {
				return wind;
			}
			public void setWind(Wind wind) {
				this.wind = wind;
			}
			public Clouds getClouds() {
				return clouds;
			}
			public void setClouds(Clouds clouds) {
				this.clouds = clouds;
			}
			public int getDt() {
				return dt;
			}
			public void setDt(int dt) {
				this.dt = dt;
			}
			public Sys getSys() {
				return sys;
			}
			public void setSys(Sys sys) {
				this.sys = sys;
			}
			public int getTimezone() {
				return timezone;
			}
			public void setTimezone(int timezone) {
				this.timezone = timezone;
			}
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getCod() {
				return cod;
			}
			public void setCod(int cod) {
				this.cod = cod;
			}
		    
		    
		    
		}

		public static class Sys{
		    public int type;
		    public int id;
		    public String country;
		    public int sunrise;
		    public int sunset;
		    
		    
		    Sys(){
		    	
		    }
			public Sys(int type, int id, String country, int sunrise, int sunset) {
				super();
				this.type = type;
				this.id = id;
				this.country = country;
				this.sunrise = sunrise;
				this.sunset = sunset;
			}
			
			
			public int getType() {
				return type;
			}
			public void setType(int type) {
				this.type = type;
			}
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getCountry() {
				return country;
			}
			public void setCountry(String country) {
				this.country = country;
			}
			public int getSunrise() {
				return sunrise;
			}
			public void setSunrise(int sunrise) {
				this.sunrise = sunrise;
			}
			public int getSunset() {
				return sunset;
			}
			public void setSunset(int sunset) {
				this.sunset = sunset;
			}
		}

		public static class Weather{
		    public int id;
		    public String main;
		    public String description;
		    public String icon;
		    
		    Weather(){
		    	
		    }
			public Weather(int id, String main, String description, String icon) {
				super();
				this.id = id;
				this.main = main;
				this.description = description;
				this.icon = icon;
			}
			
			
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getMain() {
				return main;
			}
			public void setMain(String main) {
				this.main = main;
			}
			public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
			public String getIcon() {
				return icon;
			}
			public void setIcon(String icon) {
				this.icon = icon;
			}
		    
		    
		    
		}

		public static class Wind{
		    public double speed;
		    public int deg;
		    public double gust;
		    
		    Wind(){
		    	
		    }
			public Wind(double speed, int deg, double gust) {
				super();
				this.speed = speed;
				this.deg = deg;
				this.gust = gust;
			}
			public double getSpeed() {
				return speed;
			}
			public void setSpeed(double speed) {
				this.speed = speed;
			}
			public int getDeg() {
				return deg;
			}
			public void setDeg(int deg) {
				this.deg = deg;
			}
			public double getGust() {
				return gust;
			}
			public void setGust(double gust) {
				this.gust = gust;
			}
		    
		    
		}

}

```
