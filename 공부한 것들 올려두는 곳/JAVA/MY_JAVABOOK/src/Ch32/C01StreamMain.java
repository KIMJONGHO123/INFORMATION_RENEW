package Ch32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person{
	protected String name;
	protected int age;
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

class Employee extends Person{
	String company;
	String department;
	String role;
	
	
	public Employee() {
		super();
	}

	Employee (Person person){
		this.name = person.getName();
		this.age = person.getAge();
	}
	public Employee(String name, int age) {
		super(name,age);
		
	}

	public Employee(String company, String department, String role) {
		super();
		this.company = company;
		this.department = department;
		this.role = role;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Employee [company=" + company + ", department=" + department + ", role=" + role + ", getName()="
				+ getName() + ", getAge()=" + getAge() + "]";
	}


	
	
	
	
}
public class C01StreamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <Integer>list = Arrays.asList(1,2,3,4,5);
		System.out.println(list);
		
		// filter
		List<Integer> li = 
		list.stream().filter((item)->{return item%2==0;})
							.collect(Collectors.toList());
		
		System.out.println("짝수 필터링 : " + li);
		
		List<Integer>list3=
		list.stream().filter((item)->{return item%2==0;})
							.map((item)->{return item*item;})
							.collect(Collectors.toList());
		
		System.out.println("MAP적용 : "+list3);
		
		
		List<Person> list4 = Arrays.asList(
					new Person("홍길동동주",55),
					new Person("김철수수깡", 24),
					new Person("동길동네꼬마", 34),
					new Person("박길동네개미", 22) 
				);
		
		List<Integer> list5=
		list4.stream()
							
						//map((person)->{return person.getAge();})
						//.map((person)->person.getAge())
						.map(Person::getAge)  // 메서드 참조(::)이용
						.sorted((a,b)->{return b-a;})
						.collect(Collectors.toList());
						
		
		System.out.println(list5);
		
		List<Integer> list6=
		list4.stream()
				.map(Person::getName)
				.map(String::length)
				.sorted((a,b)->{return a-b;})
				.collect(Collectors.toList());
		
		
		System.out.println(list6);
		
		
		
		List<Employee> list7 = 
		list4.stream()
					.map(Employee::new)
					.map(Employee::new)
					.collect(Collectors.toList());
		
		
		
		
		list7.forEach(System.out::println);
		
		
	}
	
	
	
	
	

	private static void sorted(Object object) {
		// TODO Auto-generated method stub
		
	}

}
