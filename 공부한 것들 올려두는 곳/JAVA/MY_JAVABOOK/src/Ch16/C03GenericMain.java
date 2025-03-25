package Ch16;


class Person{
	String name;
	String age;
	String addr;
	
	
	public Person(String name, String age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
}
class Man extends Person{

	public Man(String name, String age, String addr) {
		super(name, age, addr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Man [name=" + name + ", age=" + age + ", addr=" + addr + ", toString()=" + super.toString() + "]";
	}

	

	
	
	
	
}
class Woman extends Person{

	public Woman(String name, String age, String addr) {
		super(name, age, addr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Woman [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}

	
	
	
}
class Couple<X extends Person,Y extends Person>{
	private X member1;
	private Y member2;
	public Couple(X member1, Y member2) {
		super();
		this.member1 = member1;
		this.member2 = member2;
	}
	@Override
	public String toString() {
		return "Couple [member1=" + member1 + ", member2=" + member2 + "]";
	}
	
	
	
}
public class C03GenericMain {
	public static void main(String[] args) {
		
		Couple <Man,Woman> couple1 = new Couple<Man,Woman>(new Man("철수","50","대구"),new Woman("영희","40","대구"));
		System.out.println("couple : "+couple1);
		
		Couple <Man,Man> couple2 = new Couple<Man,Man>(new Man("철수","50","대구"),new Man("도후","20","서울"));
		System.out.println("couple : "+couple2);
		
//		Couple <Integer,Integer> couple3 = new Couple<Integer,Integer>(100,200);
//		System.out.println("couple 3 "+ couple3);
		
	}
}
