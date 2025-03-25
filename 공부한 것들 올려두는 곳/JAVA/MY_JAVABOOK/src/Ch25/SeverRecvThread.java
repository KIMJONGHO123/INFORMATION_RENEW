package Ch25;

import java.io.DataInputStream;
import java.io.IOException;

public class SeverRecvThread implements Runnable{
	
	//InputStream
	DataInputStream din;  // 클라이언트가 보낸 데이터를 읽기 위한 입력 스트림을 저장하는 역할을 한다.
	Sgui gui;
	SeverRecvThread(DataInputStream din,Sgui gui){
		this.din = din;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				String recv;
				// CLIENT -> SERVER (수신)
				recv = din.readUTF();
				if (recv.equals("q")) {
					break;
				}
			gui.area.append("[CLIENT] : "+recv+"\n");
			
		}
		} catch (Exception e) {
			System.out.println("[EXCEPTION] 예외발생 ServerRecvThread 종료");
		}finally {
			try {
				din.close();
			} catch (IOException e) {
			}
		}
			
	}

}
//서버에서 여러 개의 클라이언트와 통신할 경우, 각 클라이언트마다 수신 전용 스레드가 필요하기
//때문에 이와 같은 방식으로 구현됩니다.
