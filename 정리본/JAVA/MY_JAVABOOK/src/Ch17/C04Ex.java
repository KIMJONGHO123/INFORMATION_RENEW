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
