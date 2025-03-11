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
