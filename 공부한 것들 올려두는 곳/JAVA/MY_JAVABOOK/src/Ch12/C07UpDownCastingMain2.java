package Ch12;

// 각 클래스에
// 모든 인자를 받는 생성자 코드 삽입
// toString 코드 삽입
class A{
	int A;
	
	
	public A(int a) {
		super();
		A = a;
	}


	@Override
	public String toString() {
		return "A [A=" + A + "]";
	}

	
	
}

class B extends A{
	int b;

	

	public B(int a, int b) {
		super(a);
		this.b = b;
	}



	@Override
	public String toString() {
		return "B [b=" + b + ", A=" + A + "]";
	}

	
	
	

}

class C extends A{
	int c;

	

	public C(int a, int c) {
		super(a);
		this.c = c;
	}



	@Override
	public String toString() {
		return "C [c=" + c + ", A=" + A + "]";
	}
	


}

class D extends B{
	int d;

	public D(int a, int b, int d) {
		super(a, b);
		this.d = d;
	}

	@Override
	public String toString() {
		return "D [d=" + d + ", b=" + b + ", A=" + A + "]";
	}

}

class E extends B{
	int e;
	
	public E(int a, int b, int e) {
		super(a, b);
		this.e = e;
	}

	@Override
	public String toString() {
		return "E [e=" + e + ", b=" + b + ", A=" + A + "]";
	}

	
	



}

class F extends C{
	int f;

	

	public F(int a, int c, int f) {
		super(a, c);
		this.f = f;
	}



	@Override
	public String toString() {
		return "F [f=" + f + ", c=" + c + ", A=" + A + "]";
	}

	
	



}

class G extends C{
	int g;

	public G(int a, int c, int g) {
		super(a, c);
		this.g = g;
	}

	@Override
	public String toString() {
		return "G [g=" + g + ", c=" + c + ", A=" + A + "]";
	}


}

public class C07UpDownCastingMain2 {
	
	public static void upDownCastTestFunc(A obj,int ...arg) {
		// A-G를 받아 모든 속성 출력
		
		obj.A = arg[0]; // upcasting된 상태니까 A의 멤버변수에만 접근가능.
		
		if (obj instanceof B) {
			B down = (B)obj; // Downcasting(확장된 멤버에 접근위해)
			down.b = arg[1];
		}if (obj instanceof C) {
			C down = (C)obj;
			down.c = arg[1];
		}if (obj instanceof D) {
			D down = (D)obj;
			down.b = arg[1];
			down.d = arg[2];
		}if (obj instanceof E) {
			E down = (E)obj;
			down.e = arg[2];
		}if(obj instanceof F) {
			F down = (F)obj;
			down.f = arg[2];
		}if(obj instanceof G) {
			G down = (G)obj;
			down.g = arg[2];
		}
		System.out.println(obj);
	}
	public static void main(String[] args) {
	
	
	A ob1 = new A(0);
	B ob2 = new B(0,0);
	C ob3 = new C(0,0);
	D ob4 = new D(0,0,0);
	E ob5 = new E(0,0,0);
	F ob6 = new F(0,0,0);
	G ob7 = new G(0,0,0);
	
	
//	upDownCastTestFunc(ob1,10);  // Nocasting
//	upDownCastTestFunc(ob2,10,20);  // Upcasting
//	upDownCastTestFunc(ob3,30,40);  // Upcasting
//	upDownCastTestFunc(ob4,50,60,70);  // Upcasting
//	upDownCastTestFunc(ob5,80,90,100);  // Upcasting
//	upDownCastTestFunc(ob6,110,120,130);  // Upcasting
//	upDownCastTestFunc(ob7,140,150,160);  // Upcasting
	
	}
}
