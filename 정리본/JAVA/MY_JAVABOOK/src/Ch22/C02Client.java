package Ch22;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class C02Client {
	public static void main(String[] args) throws IOException  {
		Socket client =new Socket("192.168.16.42",7001);  // 연결이 성공하면 client 객체가 생성됨
		
		System.out.println("CLIENT 연결 시작합니다.");
		OutputStream out = client.getOutputStream(); //클라이언트에게 데이터를 보내기 위한 출력 스트림 생성
		DataOutputStream dout = new DataOutputStream(out); // DataOutputStream은 문자열, 정수 등의 데이터를 쉽게 전송할 수 있도록 하는 보조 스트림
		InputStream in = client.getInputStream();  // client가 보낸 메시지를 받을 입력 스트림이 필요함.
		DataInputStream din = new DataInputStream(in);   // DataInputStream을 사용하면 UTF-8 문자열, 정수 등 다양한 데이터 타입을 쉽게 읽을 수 있음.
		
		
		// 내용교환(q: 종료)
		Scanner sc = new Scanner(System.in);
		String recv= null;
		String send =null;
		
		while (true) {
			
			// CLIENT <- SERVER (수신)
			recv = din.readUTF();
			if (recv.equals("q")) {
				break;
				
			}
			System.out.println("[SERVER] : "+recv);
						
			// CLIENT -> SERVER(송신)
			System.out.print("[CLIENT(q: 종료)] : ");
			send = sc.nextLine(); //띄어쓰기까지 포함
			if (send.equals("q")) {
				break;
			}
			dout.writeUTF(send);
			dout.flush();
			
			
		}
		din.close();
		dout.close();
		in.close();
		out.close();
		client.close();
		System.out.println("[CLIENT] 연결 종료합니다.");
	}
}
