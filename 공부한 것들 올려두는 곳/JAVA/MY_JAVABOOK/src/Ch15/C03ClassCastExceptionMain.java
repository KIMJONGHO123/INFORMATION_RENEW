package Ch15;

import java.nio.file.attribute.AclEntry;

class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}

public class C03ClassCastExceptionMain {
	
	public static void changeDog(Animal animal) { // 업캐스팅
		try {
			Dog down = (Dog)animal; // Dog로 다운캐스팅
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외 발생 : "+e.getMessage());
		}
			
	}
	
	public static void main(String[] args) {

		Animal poppi = new Dog();
		Animal tori = new Cat();
		
		changeDog(tori); // tori 객체가 가리키는 객체는 Cat 객체인데 다운캐스팅을 Dog로 해서 오류난다.
		changeDog(poppi);
		
	}
	
}
