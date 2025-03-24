package Ch35;

import Ch35gun.*;
import Ch35unit.*;

public class Main {
	public static void main(String[] args) {
		Marine marine1 = new Marine();
		marine1.setGun(new Pistol());
		marine1.myGun.reload(100);
		Medic medic1 = new Medic();
		medic1.type = "medic";
		
		
		marine1.setType("marine1");
		Marine marine2 = new Marine();
		marine2.setGun(new Rifle());
		marine2.myGun.reload(100);
		marine2.setType("marine2");
		
		
		
		new Thread() {
			@Override
			public void run() {
				while (true) {
					medic1.Healing(marine1);
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				
			}
		}.start();
		new Thread() {

			@Override
			public void run() {
				while (true) {
					marine1.attack(marine2);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
			
		}.start();
		
		new Thread() {

			@Override
			public void run() {
				while (true) {
					marine2.attack(marine1);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		}.start();;
	}
}
