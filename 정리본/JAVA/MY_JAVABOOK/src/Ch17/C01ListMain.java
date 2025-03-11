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
