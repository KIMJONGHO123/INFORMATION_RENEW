package Ch16;


class 민트초코{

	@Override
	public String toString() {
		return "민트초코 []";
	}
	
}

class 호빵재료{
	
}
class 야채 extends 호빵재료{

	@Override
	public String toString() {
		return "야채";
	}
	
}
class 슈크림 extends 호빵재료{

	@Override
	public String toString() {
		return "슈크림";
	}
	
}
class 팥 extends 호빵재료{

	@Override
	public String toString() {
		return "단팥";
	}
	
}

class 호빵 <T extends 호빵재료>{
	private T material;
	호빵(T material){
		this.material = material;
	}
	
	
	// toString 재정의
	
	@Override
	public String toString() {
		return "호빵 [material=" + material + "]";
	}

}


public class C01GenericMain {
	public static void main(String[] args) {
	호빵<팥> ob1 = new 호빵<팥>(new 팥());
	System.out.println(ob1);
	
	호빵<슈크림> ob2 = new 호빵<슈크림>(new 슈크림());
	System.out.println(ob2);
	
	호빵<야채> ob3 = new 호빵<야채>(new 야채());
	System.out.println(ob3);
	
//	호빵<민트초코> ob4 = new 호빵<민트초코>(new 민트초코());
//	System.out.println(ob3);
	}
}

// 호빵<팥> ob1 = new 호빵<팥>(new 팥());
// 여기서 (new 팥())은 기본적으로 new 호빵<팥>의 매개변수이다.
// new 팥() 여기서 팥 클래스의 객체가 생성이 된다. -> 디폴트 생성자가 호출이 된다. 없으니까 컴파일러가 자동 수행
// new 호빵<팥>(new 팥()) 매개변수로 팥 객체를 전달하는 생성자가 호출이 된다.
// private 팥 material;
// 호빵(팥 material){
//	 this.material = material;
// }
// 생성자가 호출이 되면서 팥 객체를 material로 받고 이를 멤버변수에 할당한다.
// 
// 이후 
// System.out.println(ob1); 하면 ob1의 toString이 호출이 되고
// material이 문자열로 변환될떄 toString()이 자동 호출이 된다.
// (자바에서 객체를 문자열과 더할떄(+ 연산자 사용), toString()메서드가 호출이 된다.)
// "호빵 [material=" + material.toString() + "]" 와 동일하다.
