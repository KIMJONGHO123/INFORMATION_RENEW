package Ch31;

interface Calculator{
	int calculate(int num1,int num2);
}
public class C03LAMDA {
	public static void main(String[] args) {
		//덧셈 - Calculatior add
		//뺄셈 - Calculator sub
		//곱셈 - Calculator mul
		//나눗셈 - Calculator div
		
		Calculator add = (item1,item2)->{
			return item1+item2;
		};
		
		Calculator sub = (item1,item2)->{
			return item1>item2?item1-item2:item2-item1;
		};
		Calculator mul = (item1,item2)->{
			return item1*item2;
		};
		Calculator div = new Calculator() {  // 익명 클래스
			@Override
			public int calculate(int num1,int num2) {
				return num1/num2;
			}
		};
		
		// 결과
		System.out.println(add.calculate(10,20));
		System.out.println(sub.calculate(30,10));
		System.out.println(mul.calculate(10,20));
		System.out.println(div.calculate(100,5));
		
//		Calculator는 인터페이스이므로 직접 객체를 만들 수 없음.
//		람다식은 Calculator를 구현하는 익명 클래스의 객체로 변환됨.
//		add는 익명 클래스를 기반으로 생성된 객체이므로, add.calculate(10, 20);을 호출하면 해당 람다식이 실행됨.
//		즉, add는 "인터페이스를 구현한 익명 클래스의 인스턴스(객체)"이므로 객체가 맞다!
		
//		즉, add 객체에 람다식이 저장되어 있고, add.calculate(10,20)을 호출하면 해당 람다식이 실행된다!
	}
}
