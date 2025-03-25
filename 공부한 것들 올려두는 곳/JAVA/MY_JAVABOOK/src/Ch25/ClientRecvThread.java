package Ch25;

import java.io.DataInputStream;

public class ClientRecvThread implements Runnable {
	
	//InputStream
		DataInputStream din;
		Cgui gui;
		ClientRecvThread(DataInputStream din,Cgui gui){
			this.din = din;
			this.gui = gui;
		}
		
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			while (true) {
				String recv;
				// CLIENT <- SERVER (수신)
				recv = din.readUTF();
				if (recv.equals("q")) {
					break;
				}
				gui.area.append("[Client]"+recv+"\n");
			}
		} catch (Exception e) {
			System.out.println("[EXCEPTION 예외발생 ClientRecvThread 종료]");
		}finally {
			try {
				din.close();
			} catch (Exception e2) {
			}
		}
	}

}
