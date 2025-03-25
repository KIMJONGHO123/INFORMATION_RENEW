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
