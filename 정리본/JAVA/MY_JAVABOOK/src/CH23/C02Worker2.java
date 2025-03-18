package CH23;

public class C02Worker2 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("TASK02...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
// 프레임워크넘어가면 이거 할일 잘 없다 왜냐하면 프레임워크 자체가 멀티스레드이기 때문에.
// 어플리케이션 만들때는 필요하다.
}
