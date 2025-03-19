package Ch24;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class ClientSendThread implements Runnable {
	
	DataOutputStream dout;
	Scanner sc = new Scanner(System.in);
	ClientSendThread(DataOutputStream dout){
		this.dout = dout;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			while (true) {
				String send;
				// CLIENT -> SERVER(송신)
				System.out.print("[CLIENT(q: 종료)] : ");
				send = sc.nextLine(); //띄어쓰기까지 포함
				if (send.equals("q")) {
					break;
				}
				dout.writeUTF(send);
				dout.flush();	
			}
		} catch (Exception e) {
			System.out.println("[EXCEPTION] 예외발생 ClientSendThread 종료");
		}finally {
			try {
				dout.close();
			} catch (Exception e2) {
			}
		}
		
	}

}
