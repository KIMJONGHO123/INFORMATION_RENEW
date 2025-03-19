package Ch24;

import java.io.DataInputStream;

public class ClientRecvThread implements Runnable {
	
	DataInputStream din;
	ClientRecvThread(DataInputStream din){
		this.din = din;
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
				System.out.println("\n[SERVER] : "+recv);
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
