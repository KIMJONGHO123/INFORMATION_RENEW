package Ch13;

// interface 쓰는이유

// 협엽의 관점에서 : 작업 지시서
// 프로그래밍 관점에서 : - 결합도를 낮추기위해서, - 강제성


interface A{
	void ab();
}
interface B{
	void ab();
}

class C{
	
}
class D{

}
class E extends C implements A ,B{

	@Override
	public void ab() {
		// TODO Auto-generated method stub
		System.out.println("ABABABBA");
	}

	
}


public class C05InterfaceMain {

	public static void main(String[] args) {
		E ob1 = new E();
		ob1.ab();
	}
}
