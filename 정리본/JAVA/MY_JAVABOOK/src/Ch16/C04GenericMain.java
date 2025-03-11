package Ch16;

class Animal{
	String name;
}

class Panda extends Animal{
	// 생성자
	
	public Panda(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Panda [name=" + name + "]";
	}
}

class Tiger extends Animal{

	// 생성자
	
	public Tiger(String name) {
		super();
		this.name = name;
		
	}

	@Override
	public String toString() {
		return "Tiger [name=" + name + "]";
	}
	
	
}

public class C04GenericMain {
	//Generic
	public static <T extends Animal>void PrintByGeneric(T arr[]) {
		for (T el : arr) {
			System.out.println(el);
			
//			System.out.println(el)을 실행하면 내부적으로 println()메서드는 el.toString()을 호출합니다.
//			System.out.println(el); == System.out.println(el.toString()); 
		}
	}
	
	// Object
	public static void PrintByObject(Object animal []) {
		for (Object el : animal) {
			System.out.println(el);
		}
//		el은 Object 타입이지만 실제로는 Panda랑 Tiger객체를 가리키고 있다.
//		자바의 동적바인딩에 의해 객체의 실제 타입의 toString()을 호출합니다.
//		각자 클래스에서 toString()을 오버라이딩했으므로 각각의 toString()이 실행됩니다.
	}
	public static void main(String[] args) {
		Tiger arr1 [] = {new Tiger("시베리안 호랑이"), new Tiger("중국 호랑이"), new Tiger("86호랑이띠")};
		PrintByGeneric(arr1);
		
		Panda arr2 [] = {new Panda("시베리안 판다"), new Panda("중국 판다"), new Panda("80판다띠")};
		PrintByGeneric(arr2);
		
		Object arr3 [] = {new Panda("러시아 판다"), new Tiger("중국 호랭이"), new Tiger("96호랑이띠")};
		PrintByObject(arr3);
	}
}
