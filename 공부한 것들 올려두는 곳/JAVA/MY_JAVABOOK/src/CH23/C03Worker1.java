package CH23;

public class C03Worker1 implements Runnable {
	
	C03GUI gui;
	C03Worker1(C03GUI gui){
		this.gui = gui;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			
			try {
				gui.area1.append("WORKER1...\n");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
		System.out.println("WORKER01 INTERRUPTED...");
		
	}

}
