package Ch22;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class C01Server {
	public static void main(String[] args) throws IOException {
		// 서버 소켓 생성
		ServerSocket server = new ServerSocket(7000);  // 192.168.16.62
		System.out.println("[INFO] SERVER SOCKET LISTENING");
		
		
		//  클라이언트의 연결 요청 대기
		Socket client = server.accept(); //accept() 메서드는 클라이언트가 접속할 때까지 블로킹(blocking) 상태로 대기
		
		//클라이언트에게 메세지 전송
		OutputStream out = client.getOutputStream(); //클라이언트에게 데이터를 보내기 위한 출력 스트림 생성
		DataOutputStream dout = new DataOutputStream(out); // DataOutputStream은 문자열, 정수 등의 데이터를 쉽게 전송할 수 있도록 하는 보조 스트림
		
		dout.writeUTF("[INFO] WLECOME TO KIM SERVER"); //writeUTF() 메서드를 사용하여 문자열을 클라이언트에게 전송
		// 클라이언트는 이 데이터를 받아 화면에 출력 가능

		
		dout.flush(); // 출력 버퍼를 비워서 데이터 전송 완료(출력 버퍼에 있는 데이터를 강제로 전송)
		dout.close();
		out.close();
		client.close();
		server.close();
		
		System.out.println("서버 종료합니다.");
		
	}
}
