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
