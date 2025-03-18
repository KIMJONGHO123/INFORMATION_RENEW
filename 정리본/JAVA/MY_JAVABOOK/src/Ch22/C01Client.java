package Ch22;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class C01Client {
	public static void main(String[] args) throws IOException  {
		Socket client =new Socket("192.168.16.203",7000);  // 연결이 성공하면 client 객체가 생성됨
		
		InputStream in = client.getInputStream();  //서버에서 보낸 데이터를 받기 위한 입력 스트림 생성
		DataInputStream din = new DataInputStream(in);  //데이터를 쉽게 읽기 위해 보조 스트림 DataInputStream 사용
		String recv = din.readUTF();  //서버에서 전송한 문자열을 읽음 (writeUTF()로 보낸 데이터 수신)
		System.out.println(recv);  //서버에서 받은 메시지를 출력
		
		din.close();
		in.close();
		client.close();
	}
}
