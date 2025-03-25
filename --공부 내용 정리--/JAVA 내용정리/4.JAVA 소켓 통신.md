# 자바 소켓 통신

내 ip 주소 찾기 : 실행에서 ncpa.cpl 검색후 이더넷 자세히보기

### C01Client

```java
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

```

### C01Server

```java
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

```

## TCP 기반의 양방향 통신 서버를 구현

### C02Server

```java
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

```

<aside>
💡

## **실행 흐름**

1. 서버가 **포트 7003에서 클라이언트 연결을 대기**
2. 클라이언트가 접속하면 **연결을 수락**
3. 서버가 클라이언트에게 **"[INFO] WELCOME TO KIM SERVER"** 메시지를 보냄
4. 서버와 클라이언트는 **서로 번갈아가며 메시지를 주고받음**
    - `q`를 입력하면 통신 종료
5. 서버가 연결을 종료

 

## 1️⃣ 서버 소켓 생성 & 클라이언트 연결 대기

```java
ServerSocket server = new ServerSocket(7003);  
System.out.println("[INFO] SERVER SOCKET LISTENING");

// 클라이언트의 연결 요청 대기 (클라이언트가 접속할 때까지 블로킹)
Socket client = server.accept(); 
System.out.println("서버 연결 시작합니다.");
```

- `ServerSocket server = new ServerSocket(7003);`
    - 포트 7003에서 클라이언트 연결을 기다림
- `Socket client = server.accept();`
    - 클라이언트가 접속할 때까지 대기 (블로킹 상태)
- 클라이언트가 연결되면 “서버 연결 시작합니다”메시지를 출력

## 2️⃣ 입출력 스트림 설정

```java
OutputStream out = client.getOutputStream(); 
DataOutputStream dout = new DataOutputStream(out);
InputStream in = client.getInputStream();  
DataInputStream din = new DataInputStream(in);
```

- `OutputStream out = client.getOutputStream();`
    - 클라이언트에게 메시지를 보내기 위한 출력 스트림
- `DataOutputStream dout = new DataOutputStream(out);`
    - 문자열을 쉽게 보내기 위해 `DataOutputStream` 사용(보조 스트림)
- `InputStream in = client.getInputStream();`
    - 클라이언트가 보낸 데이터를 받기위한 입력 스트림
- `DataInputStream din = new DataInputStream(in);`
    - 데이터를 UTF-8 문자열 형태로 쉽게 읽기 위해 `DataInputStream` 사용(보조 스트림)

## 3️⃣ 클라이언트에게 환영 메시지 전송

```java
dout.writeUTF("[INFO] WELCOME TO KIM SERVER"); 
```

- 클라이언트가 접속하면 환영 메시지를 보냄
- 클라이언트는 `readUTF();` 으로 이 메시지를 받을 수 있음.

## 4️⃣ 서버와 클라이언트의 채팅 시작

```java
Scanner sc = new Scanner(System.in);
String recv = null;
String send = null;

while (true) {
    // SERVER → CLIENT 메시지 전송
    System.out.print("[SERVER(q: 종료)] : ");
    send = sc.nextLine(); // 서버에서 메시지 입력
    if (send.equals("q")) {
        break; // "q" 입력 시 종료
    }
    dout.writeUTF(send); // 클라이언트에게 메시지 전송
    dout.flush(); // 즉시 전송
```

- `Scanner sc = new Scanner(System.in);`
    - **서버에서 메시지를 입력받기 위해 `Scanner` 사용**
- `System.out.print("[SERVER(q: 종료)] : ");`
    - **서버에서 메시지 입력 요청**
- `send = sc.nextLine();`
    - **사용자가 입력한 메시지를 저장**
- `if (send.equals("q")) { break; }`
    - 사용자가 `"q"`를 입력하면 **반복문을 종료** (채팅 종료)
- `dout.writeUTF(send);`
    - 입력한 메시지를 클라이언트에게 전송
- `dout.flush();`
    - 출력버퍼를 비워 즉시 메시지 전송

## 5️⃣ 클라이언트 메시지 수신

```java
// CLIENT → SERVER (수신)
recv = din.readUTF();
if (recv.equals("q")) {
    break;
}
System.out.println("[CLIENT] : " + recv);
```

- `recv = din.readUTF();`
    - **클라이언트가 보낸 메시지를 읽음**
- `if (recv.equals("q")) { break; }`
    - 클라이언트가 `"q"`를 입력하면 종료
- `System.out.println("[CLIENT] : " + recv);`
    - **클라이언트가 보낸 메시지를 서버에서 출력**

## 6️⃣ 연결 종료

```java
din.close();
dout.close();
in.close();
out.close();
client.close();
server.close();
System.out.println("[SERVER] 연결 종료합니다.");
```

- **모든 스트림과 소켓을 닫아 리소스 정리**
- `"서버 종료합니다."` 메시지 출력

## 실행 예시

### 서버에서 실행

```java
[INFO] SERVER SOCKET LISTENING
서버 연결 시작합니다.
[SERVER(q: 종료)] : 안녕하세요, 환영합니다!
[CLIENT] : 안녕하세요, 서버님!
[SERVER(q: 종료)] : 오늘 날씨 좋네요!
[CLIENT] : 네! 진짜 좋아요.
[SERVER(q: 종료)] : q
[SERVER] 연결 종료합니다.
```

### 클라이언트에서 실행

```java
[INFO] WELCOME TO KIM SERVER
[CLIENT] : 안녕하세요, 서버님!
[SERVER] : 오늘 날씨 좋네요!
[CLIENT] : 네! 진짜 좋아요.
```

</aside>

### C02Client

```java
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

```

<aside>
💡

## 실행 흐름

- 서버(`192.168.16.42:7001`)에 **연결 요청**
- 서버가 메시지를 보내면 **클라이언트가 이를 출력**
- **클라이언트는 서버에게 메시지를 보냄**
- 서버와 클라이언트가 **"q" 입력 전까지 메시지를 계속 주고받음**
- `"q"`를 입력하면 연결 종료

## 1️⃣ 서버에 연결 요청

```java
Socket client = new Socket("192.168.16.42", 7001);
System.out.println("CLIENT 연결 시작합니다.");
```

- `Socket client = new Socket("192.168.16.42", 7001);`
    - **서버(`192.168.16.42:7001`)에 연결 요청**
    - 연결이 성공하면 `client` 객체가 생성됨
- `System.out.println("CLIENT 연결 시작합니다.");`
    - 연결 성공 메시지를 출력

## 2️⃣ 입출력 스트림 설정

```java
OutputStream out = client.getOutputStream();
DataOutputStream dout = new DataOutputStream(out);
InputStream in = client.getInputStream();
DataInputStream din = new DataInputStream(in);
```

- `OutputStream out = client.getOutputStream();`
    - 서버에게 메시지를 보내기 위한 **출력 스트림**
- `DataOutputStream dout = new DataOutputStream(out);`
    - **문자열을 쉽게 전송하기 위해 `DataOutputStream` 사용(보조 스트림)**
- `InputStream in = client.getInputStream();`
    - 서버가 보낸 데이터를 받기 위한 **입력 스트림**
- `DataInputStream din = new DataInputStream(in);`
    - **UTF-8 문자열 형태로 데이터를 쉽게 읽기 위해 `DataInputStream` 사용(보조스트림)**

## 3️⃣ 서버의 메시지를 수신

```java
recv = din.readUTF();
if (recv.equals("q")) {
    break;
}
System.out.println("[SERVER] : " + recv);
```

- `recv = din.readUTF();`
    - **서버가 보낸 메시지를 읽음**
- `if (recv.equals("q")) { break; }`
    - 서버가 `"q"`를 보냈다면, 통신을 종료
- `System.out.println("[SERVER] : " + recv);`
    - **서버가 보낸 메시지를 출력**

## 4️⃣ 클라이언트가 서버에 메시지 전송

```java
System.out.print("[CLIENT(q: 종료)] : ");
send = sc.nextLine(); // 띄어쓰기 포함
if (send.equals("q")) {
    break;
}
dout.writeUTF(send);
dout.flush();
```

- `send = sc.nextLine();`
    - **클라이언트가 메시지를 입력**
- `if (send.equals("q")) { break; }`
    - **"q"를 입력하면 종료**
- `dout.writeUTF(send);`
    - **입력된 메시지를 서버에게 전송**
- `dout.flush();`
    - **출력 버퍼를 비워 즉시 전송**

## 5️⃣ 연결 종료

```java
din.close();
dout.close();
in.close();
out.close();
client.close();
System.out.println("[CLIENT] 연결 종료합니다.");
```

- **모든 스트림과 소켓을 닫아 리소스 정리**
- `"CLIENT 연결 종료합니다."` 메시지를 출력
</aside>
