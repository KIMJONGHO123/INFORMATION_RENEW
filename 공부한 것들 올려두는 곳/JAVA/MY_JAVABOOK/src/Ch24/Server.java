package Ch24;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws IOException, InterruptedException {
		// 서버 소켓 생성
		ServerSocket server = new ServerSocket(7002);  // 192.168.16.62
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
		
		// 객체생성하기
		ServerSendThread send = new ServerSendThread(dout);
		SeverRecvThread recv = new SeverRecvThread(din);
		
		
		// 스레드 분리(나누기)
		Thread th1 = new Thread(send);
		Thread th2 = new Thread(recv);
		
		th1.start();
		th2.start();
		
		th1.join(); // join() 메서드는 해당 쓰레드가 종료될 때까지 현재 실행 중인 메인 쓰레드를 대기(block)시키는 역할을 합니다.
		th2.join(); // ClientSendThread(th1) 와 ClientRecvThread(th2) 가 모두 종료될 때까지 main 쓰레드는 기다린다.
		
		// 만약 join()을 사용하지 않으면, 메인 쓰레드가 바로 종료되어버려 서버와의 연결이 닫히고, 송수신 작업이 중간에 멈출 수 있음.
		
		din.close();
		dout.close();
		client.close();
		server.close();
		System.out.println("[SERVER] 연결 종료합니다.");
	}
}
