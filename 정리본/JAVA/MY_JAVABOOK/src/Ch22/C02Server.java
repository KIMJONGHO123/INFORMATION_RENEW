package Ch22;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class C02Server {
	public static void main(String[] args) throws IOException {
		// 서버 소켓 생성
		ServerSocket server = new ServerSocket(7003);  // 192.168.16.62
		System.out.println("[INFO] SERVER SOCKET LISTENING");
		
		// 1회 응답
		//  클라이언트의 연결 요청 대기
		Socket client = server.accept(); //accept() 메서드는 클라이언트가 접속할 때까지 블로킹(blocking) 상태로 대기
		
		System.out.println("서버 연결 시작합니다.");
		
		//INOUT STREAM
		//클라이언트에게 메세지 전송
		OutputStream out = client.getOutputStream(); //클라이언트에게 데이터를 보내기 위한 출력 스트림 생성
		DataOutputStream dout = new DataOutputStream(out); // DataOutputStream은 문자열, 정수 등의 데이터를 쉽게 전송할 수 있도록 하는 보조 스트림
		InputStream in = client.getInputStream();  // client가 보낸 메시지를 받을 입력 스트림이 필요함.
		DataInputStream din = new DataInputStream(in);   // DataInputStream을 사용하면 UTF-8 문자열, 정수 등 다양한 데이터 타입을 쉽게 읽을 수 있음.
		dout.writeUTF("[INFO] WLECOME TO KIM SERVER"); //writeUTF() 메서드를 사용하여 문자열을 클라이언트에게 전송
		// 클라이언트는 이 데이터를 받아 화면에 출력 가능

		// 내용교환(q: 종료)
		Scanner sc = new Scanner(System.in);
		String recv= null;
		String send =null;
		while (true) {
			// SERVER -> CLIENT
			System.out.print("[SERVER(q: 종료)] : ");
			send = sc.nextLine(); //띄어쓰기까지 포함
			if (send.equals("q")) {
				break;
			}
			dout.writeUTF(send);
			dout.flush();
			
			// CLIENT -> SERVER (수신)
			recv = din.readUTF();
			if (recv.equals("q")) {
				break;
				
			}
			System.out.println("[CLIENT] : "+recv);
		}
		din.close();
		dout.close();
		in.close();
		out.close();
		client.close();
		server.close();
		System.out.println("[SERVER] 연결 종료합니다.");
	}
}
