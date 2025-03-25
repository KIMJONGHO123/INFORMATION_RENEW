package Ch08;

// 멤버변수 : 클래스 내부 - 메서드 영영 바깥에서 생성

//          생성된 객체의 개별 정보 저장


// static 변수 : 동일 클래스로부터 만든 여러객체간 공유하는 멤버 변수

//지역변수 : 메서드 영역내에서 
//         (or 메서드 영역내의 {}범위에서 포함) 
//		   생성되는 변수
//         (파라미터, 일반변수 포함)


// 하나의 .java 파일에는 public class가 하나만 가능
// 만약 두 개의 public class가 필요하면, 따로 .java 파일을 만들어야 함

class C05Simple{
	int num=10;  // 멤버변수
	
	void Fun1() {
		System.out.println("멤버변수 num : "+num);
		int num=10; // 지역변수
		System.out.println("지역변수 num : "+num);
		num++;
		this.num++;
	}
	void Fun2() {
		System.out.println("멤버변수 num : "+num);
		if (true) {
			int num=10;
			System.out.println("FUnc2's if안 지역변수 num : "+num);
		}
		System.out.println("num : "+num);
		
		while (num<15) {
			int num=7;
			System.out.println(num);
			num++;
			
		}
	}
	
	void Func3(int num) {
		this.num = num;
	}
}
public class C05LocalVarMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C05Simple obj = new C05Simple();
		
		obj.Fun1();
		obj.Fun2();
	}

}
