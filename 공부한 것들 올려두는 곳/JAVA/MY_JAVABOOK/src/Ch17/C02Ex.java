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
