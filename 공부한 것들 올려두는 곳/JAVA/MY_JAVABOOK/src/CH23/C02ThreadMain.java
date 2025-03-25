package CH23;

public class C02ThreadMain {
	public static void main(String[] args) {
		// Runable Interface 스레드 분할
		
		//01
		C01Worker1 w1 = new C01Worker1();
		C02Worker2 w2 = new C02Worker2();
		
		
		// 02 메인 스레드에서 분리
		Thread th1 = new Thread(w1);
		Thread th2 = new Thread(w2);
		
		// 03 스레드 실행
		th1.start();
		th2.start();
		
		// Thread class 스레드 분할(익명 클래스 사용)
		
		new Thread() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("TASK03...");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
		}.start();
		
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Main THREAD...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
