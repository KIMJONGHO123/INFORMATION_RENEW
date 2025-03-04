package Ch08;

class C07Simple{
	
	int sum(int ...arg) {
		System.out.println(arg);
		
		int sum=0;
//		for(int item : arg) {
//			System.out.println(item); // 숫자 출력
//			sum+=item;
//		}
		
		for (int i = 0; i < arg.length; i++) {
			System.out.println(arg[i]);
			sum+=arg[i];
			
		}
		return sum;
	}
}

public class C07가변인자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C07Simple ob= new C07Simple();
		System.out.println("최종 합계 : "+ob.sum(10,20,30,40,50,60,70));

		System.out.println();
		int bigSum = ob.sum(10,20,30,40,50,60,70,80,90,100);
		System.out.println("최종 합계 : "+bigSum);
	}

}
