//package Ch33;
//
//import java.util.Arrays;
//import java.util.List;
//
//import zmq.util.function.Function;
//
////01 func1완성 - List<String>에 저장된 문자열 리스트에서 길이가 5이상인 문자열의 개수를 반환
////02 func2완성 - List<Integer>에 저장된 숫자들의 제곱한 값의 합을 반환
////03 func3완성 - List<String>에서 각 문자열의 첫 글자를 추출하여 대문자로 변환하여 리턴
//
//public class C04Ex {
//
//	
//	public static Function<List<String>,Integer> func1; //
//	public static Function<List<String>,Integer> func2; //
//	public static Function<List<String>,Integer> func3; //
//	
//	
//	public static void main(String[] args) {
//		List<String> list =   Arrays.asList("aaaaaa","bbbbb","cc","ddeeeeee","ee");
//		
//		int r1 =  func1.apply(list);
//		System.out.println("r1 : " + r1);
//		
//		
//		List<Integer> list2 =   Arrays.asList(1,2,3,4,5);
//		int r2 =  func2.apply(list2);
//		System.out.println("r2 : " + r2);
//		
//		List<String> list3 =   Arrays.asList("apple","banana","orange");
//		List<String> r3 = func3.apply(list3);
//		System.out.println("r3 : " + r3);
//	}
//	
//}
//
