package CH23;

public class C03Worker2 implements Runnable{
	
	C03GUI gui;
	C03Worker2(C03GUI gui){
		this.gui = gui;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			
			try {
				gui.area2.append("WORKER2...\n");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
		System.out.println("WORKER02 INTERRUPTED...");
		
	}

}
