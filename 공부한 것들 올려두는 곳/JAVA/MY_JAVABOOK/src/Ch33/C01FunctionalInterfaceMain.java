package Ch33;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface Func1{  // 함수형인터페이스 선언(Compiler에게 전달)
	void say(String message); //추상 메서드
	
	// 함수형인터페이스에서는 메서드는 무조건 하나여야 한다.
	
}

@FunctionalInterface
interface Func2{
	int sum(Integer ...args);
}

@FunctionalInterface
interface Func3{
	List<Integer> createListDesc(int ...args);
}

public class C01FunctionalInterfaceMain {

	public static void main(String[] args) {
		
		//01
		Func1 func1 = (message)->{System.out.println(message);};
		func1.say("HelloWorld");
		
		Func1 func1_1 = System.out::println;
		func1_1.say("HELLOWORLD");
		
		//02
		Func2 func2 = (items)->{
			// {}에 모든 items를 더한값을 리턴
			int sum=0;
			for (Integer il : items) {
				sum+=il;
			}
			return sum;};  
		System.out.println(func2.sum(10,20,30,40,556,6,7,8,9));
		
		
		Func2 func2_2 = (items)->{
			// {}에 모든 items를 더한값을 리턴(reduce)
			return Arrays.stream(items).reduce(0,(sum,el)->{return sum+=el;}); // 0은 sum의 초기값
		};
		System.out.println(func2_2.sum(10,20,30,40,556,6,7,8,9));
		
		
		// 원시타입 int[] 받기 -> int를 Integer로 boxing -> 내림차순 -> List<Integer변환>
		Func3 func3 = (items)->{
			return Arrays.stream(items).boxed().sorted((a,b)-> b-a).collect(Collectors.toList());
			
			};
			
		List<Integer> li = func3.createListDesc(10,100,24,1612,42,123,15,4,1);
		System.out.println(li);
	}
	
	// 함수형 인터페이스 사용하면 같은 함수에 다른 로직을 구현할 수 있다.
}