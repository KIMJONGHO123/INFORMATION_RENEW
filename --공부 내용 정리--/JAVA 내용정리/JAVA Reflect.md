# Reflect란?

## **1. 리플렉션이란?**

자바 리플렉션(Reflection)은 **런타임(실행 중)에 클래스, 메서드, 필드, 생성자 등의 정보를 동적으로 가져오고 조작할 수 있는 기능**이다. 이를 통해 **컴파일 타임이 아닌 실행 중에 객체 생성, 메서드 호출, 필드 접근 등이 가능**하다.

## **2. 리플렉션을 사용하는 이유**

- **컴파일 타임에 알 수 없는 클래스 및 메서드 호출**
    - 예: 플러그인 시스템, JSON 직렬화/역직렬화, 의존성 주입(DI) 등
- **런타임 동적 객체 생성**
    - 예: 스프링 프레임워크에서 빈(Bean) 동적 생성
- **프레임워크 및 라이브러리 개발**
    - ORM (예: Hibernate), DI 프레임워크 (예: Spring) 등에서 활용

## **3. 리플렉션 주요 기능**

### **(1) 클래스 정보 가져오기**

```java
Class<?> clazz1 = String.class; // 직접 참조
Class<?> clazz2 = Class.forName("java.lang.String"); // 문자열로 클래스 찾기
Class<?> clazz3 = new String().getClass(); // 객체에서 클래스 가져오기
```

### **(2) 생성자 정보 가져오기 및 객체 생성**

```java
import java.lang.reflect.Constructor;

Class<?> clazz = Class.forName("java.lang.String");
Constructor<?> constructor = clazz.getConstructor(String.class);
Object obj = constructor.newInstance("Hello Reflection!"); // 동적 객체 생성
System.out.println(obj);
```

### **(3) 필드 정보 가져오기 및 값 변경**

```java
import java.lang.reflect.Field;

class Person {
    private String name = "John Doe";
}

Person person = new Person();
Field field = person.getClass().getDeclaredField("name");
field.setAccessible(true); // private 필드 접근 허용
field.set(person, "Alice"); // 필드 값 변경

System.out.println(field.get(person)); // "Alice"
```

### **(4) 메서드 정보 가져오기 및 실행**

```java
import java.lang.reflect.Method;

class Example {
    private void sayHello(String name) {
        System.out.println("Hello, " + name);
    }
}

Example example = new Example();
Method method = example.getClass().getDeclaredMethod("sayHello", String.class);
method.setAccessible(true); // private 메서드 접근 허용
method.invoke(example, "Reflection!"); // 실행 → "Hello, Reflection!"
```

### **(5) 모든 필드, 메서드, 생성자 나열**

```java
Class<?> clazz = Class.forName("java.lang.String");

System.out.println("필드 목록:");
for (Field f : clazz.getDeclaredFields()) {
    System.out.println(f.getName() + " : " + f.getType());
}

System.out.println("메서드 목록:");
for (Method m : clazz.getDeclaredMethods()) {
    System.out.println(m.getName() + " : " + m.getReturnType());
}

System.out.println("생성자 목록:");
for (Constructor<?> c : clazz.getDeclaredConstructors()) {
    System.out.println(c);
}
```

---

## **4. 리플렉션의 단점**

- **성능 저하**
    - 컴파일 타임이 아닌 런타임에서 동작하므로 속도가 느림.
- **보안 문제**
    - `setAccessible(true)`를 사용하면 private 접근 가능 → 보안 취약점 발생 가능.
- **코드 유지보수 어려움**
    - 정적 코드보다 디버깅이 어려움.

---

## **5. 리플렉션 사용을 피할 수 있는 대안**

- **직접적인 메서드 호출을 선호** (가능하면 리플렉션 대신 정적 호출 사용)
- **인터페이스 기반 설계 활용** (다형성을 이용해 동적 호출을 최소화)
- **최적화된 API 사용**
    - `MethodHandle` (Java 7+)
    - `LambdaMetafactory` (Java 8+)

### C01BASIC

```java
package Ch29_;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class C01BASIC {

	public static void main(String[] args) throws Exception {
		
		Class<?> clazz =  Class.forName("java.lang.String");
		
		//모든 Field 확인
//		Field[] fields = clazz.getDeclaredFields();
//		for(Field field : fields) {
//			System.out.println(field);
//		}
		
		//모든 생성자 확인
		Constructor[] constructors =  clazz.getDeclaredConstructors();
		for(Constructor con : constructors) {
			System.out.println(con);
		}
		
		//모든 메서드 확인
		Method [] methods = clazz.getDeclaredMethods();
		for(Method m : methods)
			System.out.println(m);
	}

}

```

### C02BASIC

```java
package Ch29_;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Simple{
	String name;
	int age;
	String addr;
	public Simple() {}
	public Simple(String name) {this.name = name;}
	public Simple(String name,int age) {this.name = name;this.age = age;}
	public Simple(String name,int age, String addr) {this.name=name;this.age=age;this.addr=addr;}
	//getter and Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Simple [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
	//toString 
	
	
}

public class C02BASIC {

	public static void main(String[] args) throws Exception {
		//reflect로  매서드 사용하기
		Simple ob = new Simple();
		ob.setAge(10);

//		System.out.println(Simple.class);
		Class<?> clazz = Class.forName( String.valueOf(Simple.class).split(" ")[1] );
//		Method method = clazz.getDeclaredMethod("getAge", null);
//		Object result = method.invoke(ob,null);
//		System.out.println(result);
		
		//reflect로 생성자 사용하기
//		Constructor<?> constructor = clazz.getConstructor(String.class); //인자1 개받는 생성자
//		System.out.println(constructor);
//		Object obj =  constructor.newInstance("홍길동");
//		System.out.println(obj);
//		
//		//reflect로 field에 값넣기
		Field field = clazz.getDeclaredField("addr");
		field.set(ob, "대구");
		System.out.println(ob);
		
	}

}

```
