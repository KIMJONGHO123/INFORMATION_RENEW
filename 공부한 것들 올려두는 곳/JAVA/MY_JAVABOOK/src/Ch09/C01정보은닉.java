package Ch09;


// 접근 제어자
// 멤버 클래스의 접근범위를 제한을 위한 예약어
// public : 모든 클래스에서 접근가능
// private : 해당 클래스에서만 접근가능
// protected : 상속 관계를 가지는 경우에 접근가능
// default(기본) : 동일 패키지에 속한 클래스에서 접근가능.

class C01Person{
	private String name; // private는 처음 생성자에서 초기화한다.
	int age;
	private String addr;
	
	public C01Person(String name, int age, String addr) {
		this.name= name;
		this.age= age;
		this.addr = addr;
		
	}
	
//	//getter 함수(데이터를 외부로 반환)
//	public String getName() {
//		return this.name;
//		
//	}
//	
//	public int getAge1() {
//		return this.age;
//	}
//	
//	//setter 함수(기존데이터를 수정)
//	public void setAge(int age) {
//		this.age = age;
//	}

	
	// source에서 Generate Getters and Setters 클릭해서 자동 완성
	
	
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}
	
	public int setAge(int age) {
		return this.age =age;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}

public class C01정보은닉 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C01Person person1 = new C01Person("홍길동",55,"대구");
		System.out.println(person1.getName());
		person1.setAge(56);
		System.out.println(person1.getAge());
		
	}

}
