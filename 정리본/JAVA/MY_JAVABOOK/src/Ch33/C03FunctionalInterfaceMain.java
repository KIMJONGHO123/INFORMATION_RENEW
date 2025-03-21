package Ch33;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//제공되는 함수형 인터페이스들
//Function<T, R>:
//apply 메서드를 가지고 있어서 하나의 인자(T)를 받아서 결과(R)를 반환하는 함수형 인터페이스 입니다.

//Supplier<T>:
//get 메서드를 가지고 있어서 어떠한 인자도 받지 않고 결과만을 제공하는 함수형 인터페이스 입니다.
//
//Consumer<T>:
//accept 메서드를 가지고 있어서 어떠한 인자를 받아서 결과를 반환하지 않는 함수형 인터페이스 입니다.
//
//Predicate<T>:
//test 메서드를 가지고 있어서 어떠한 인자를 받아서 불리언 결과를 반환하는 함수형 인터페이스 입니다.
//
//UnaryOperator<T>:
//apply 메서드를 가지고 있어서 하나의 인자를 받아서 동일한 타입의 결과를 반환하는 함수형 인터페이스 입니다.
//
//BinaryOperator<T>:
//apply 메서드를 가지고 있어서 두 개의 인자를 받아서 동일한 타입의 결과를 반환하는 함수형 인터페이스 입니다.

public class C03FunctionalInterfaceMain {
	
	// 01
	public static Function<Integer, Integer> func1 = (x)-> x*x;
	
	// 02
	public static Function<Integer, Integer> func2 = (x)-> x+x;
	// 03
	public static Function<List<Integer>, Integer> func3 = (list)->{
		
		return list.stream().reduce(0,(sum,el)->{return sum+el;}); 		
	};
	
	
	// 04
	public static Function<List<Object>, Integer> func4 = (list)->{
			// Integer형만 필터링(instanceof)
			// 누적합 (reduce)
			int sum=0;
			for (Object ob : list) {
				if (ob instanceof Integer) {
					sum += (int)ob;
				}
			}
			return sum;
	};
	
	// 05
	public static Function<List<Object>, List<Integer>> func5 =(li)->{
		// List<Object>로 받은 파라미터 중에 Integer만 추출해서 리턴하기
		// 1. Integer형만 필터링(instanceof)
		// 2. 재구성(map)
		// 3. 리스트로 변환(collect);
		
		List<Integer> tiiss = li.stream().filter(i -> i instanceof Integer).map(i->(Integer)i).collect(Collectors.toList());
		return tiiss;
	};
		
	
	// 06
	public static Function<Integer,Integer> func6 = func1.andThen(func2);
	// func1의 결과를 func2의 인자로 집어넣는다.
	
	// 07
	public static Function<Integer,Integer> func7 = func2.andThen(func1);
	
	// 08
	public static Function<List<Integer>,Integer> subFunc = (x)->{return x.stream().reduce(0,(sum,x1)->sum+x1);};
	public static Function<List<Object>, Integer> func8 = func5.andThen(subFunc);
	
	
	// 09
	public static Function <Integer, Function<Integer,Integer>> func9 = (x)->{return (x1)->{return x1+x1;};};
	
	// 10
	
	public static Function<Integer, Function<Integer,Integer>> func10 = x->y->x+y;
	
	// 11
	public static Function<Integer, Function<Integer,Function<Integer,Integer>>> func11 = null;
	
	// 12
	public static void main(String[] args) {
		
		
		// 01
		System.out.println(func1.apply(10));
		
		// 02
		System.out.println(func2.apply(10));
		
		// 03
		System.out.println(func3.apply(Arrays.asList(10,20,30,40)));
		
		// 04
		System.out.println(func4.apply(Arrays.asList("홍길동",10,20,15,4,10.5,true,15)));
		
		// 05
		System.out.println(func5.apply(Arrays.asList("홍길동",10,20,15,4,10.5,true,15)));
		
		// 06
		System.out.println(func6.apply(7));
		
		// 07
		System.out.println(func7.apply(5));
		
		// 08
		System.out.println(func8.apply(Arrays.asList("홍길동",10,20,15,4,10.5,true,15)));
		
		// 09
		System.out.println(func9.apply(10).apply(20));
		
		
		// 11
		System.out.println(func11.apply(10).apply(20).apply(30));
	}
}