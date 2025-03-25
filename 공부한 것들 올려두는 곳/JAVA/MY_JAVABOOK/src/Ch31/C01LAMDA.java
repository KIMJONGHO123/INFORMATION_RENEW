package Ch31;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person{
	private String name;
	private int age;
	// 생성자(디폴트, 모든인자)
	// getter and setter
	// toString
	public Person() {
		
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;  
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}
public class C01LAMDA {
	
	public static void main(String[] args) {
		List<Person> li = new ArrayList<>();
		li.add(new Person("jung",55));
		li.add(new Person("hong",23));
		li.add(new Person("bob",27));
		
		li.forEach(System.out::println);
		System.out.println("-----------------------");
		
		//정렬
		li.sort((a,b)->{return b.getAge()-a.getAge();});
		li.forEach(System.out::println);
	}
}
