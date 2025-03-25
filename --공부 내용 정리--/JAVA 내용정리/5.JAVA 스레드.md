# 스레드

# Thread란 무엇인가?

하나의 프로세스 내에서 실행되는 흐름의 단위를 말한다. 한 프로그램은 하나의 스레드를 가지고 있고, 둘 이상의 스레드를 동시에 실행하는 경우 이 방식을 멀티스레드라고 한다.

ex) 배틀그라운드에서 한번 움직이고 총을 쏘는가? 아니다. 움직이면서 총을 쏘도록 할려고하면 멀티 스레드를 이용하여 많은 양을 한번에 처리하도록 해야한다.

## + 프로세스란?

프로세스란 실행중인 프로그램을 말한다. 프로그램은 기억장치(SSD)에 존재하며 실행되기를 기다리는 명령어와 정적인 데이터 묶음이다. 이 프로그램을 명령어와 정적 데이터로 메모리에 적재시키면 생명이 있는 프로세스가 된다

# +Process와 Thread의 차이는?

프로세스는 운영체제로부터 자원을 할당받는 작업 단위이다. 애플리케이션이 하나의 프로세스가 되고, 그 안에서 여러 개의 스레드가 할당 받은 자원을 이용하여 실행 단위로 존재할 수 있다. 즉 스레드는 하나의 프로세스 안에서 여러 실행의 흐름이라고 생각하면 된다.

### C01ThreadMain

```java
package CH23;

import java.util.Iterator;

public class C01ThreadMain {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			System.out.println("TASK01...");
			Thread.sleep(500);
			
		}
		for (int i = 0; i < 5; i++) {
			System.out.println("TASK02...");
			Thread.sleep(500);
			
		}
	}
}

```

### C01Worker1

```java
package CH23;

public class C01Worker1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("TASK01...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}

```

### C02ThreadMain

```java
package CH23;

public class C02ThreadMain {
	public static void main(String[] args) {
		// Runable Interface 스레드 분할
		
		//01
		C01Worker1 w1 = new C01Worker1();
		C02Worker2 w2 = new C02Worker2();
		
		
		// 02 메인 스레드에서 분리
		Thread th1 = new Thread(w1);
		Thread th2 = new Thread(w2);
		
		// 03 스레드 실행
		th1.start();
		th2.start();
		
		// Thread class 스레드 분할(익명 클래스 사용)
		
		new Thread() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("TASK03...");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
		}.start();
		
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Main THREAD...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

```

<aside>
💡

### 1️⃣ Runnable 인터페이스를 구현한 스레드

```java
C01Worker1 w1 = new C01Worker1();
C02Worker2 w2 = new C02Worker2();
```

Runnable 인터페이스를 이용해 두 개의 작업을 수행하는 스레드를 만든다.

- `C01Worker1` 와 `C02Worker2` 클래스는 `Runnable` 인터페이스를 구현하고 있다.
- `Runnable` 은 **스레드를 실행할 수 있는 작업을 정의**하는 역할을 해.

이제 이 작업을 별도의 스레드에서 실행하려면 Thread 객체를 만들어서 실행해야 한다.

```java
Thread th1 = new Thread(w1);
Thread th2 = new Thread(w2);
```

- `Thread` 클래스는 `Runnable`을 실행하기 위한 스레드 객체를 만든다.

```java
th1.start();
th2.start();
```

- `start()` 메서드는 **실제 스레드를 실행**하는 역할을 한다.
- `run()` 메서드를 직접 호출하는 것이 아니라, **`start()`를 호출해서 새로운 스레드에서 실행**되도록 해야 해.

### 2️⃣ 익명 클래스로 `Thread` 객체 생성

```java
new Thread() {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("TASK03...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}.start();
```

- `Thread` 클래스를 익명 클래스로 바로 생성해서 실행하는 방식이야.
- **익명 클래스를 사용하면 `Runnable`을 따로 구현하지 않아도 바로 `Thread` 객체를 만들고 실행할 수 있어.**
- `run()` 메서드 안에서 `"TASK03..."` 를 5번 출력하도록 설정되어 있어.

### 3️⃣ 메인 스레드의 동작

```java
for (int i = 0; i < 5; i++) {
    System.out.println("Main THREAD...");
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
```

- 이 코드는 **메인 스레드에서 실행되는 루프**야.
- `"Main THREAD..."` 를 5번 출력하면서, **0.5초(500ms) 동안 대기**하는 동작을 수행해.
</aside>

### C02Worker2

```java
package CH23;

public class C02Worker2 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("TASK02...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
// 프레임워크넘어가면 이거 할일 잘 없다 왜냐하면 프레임워크 자체가 멀티스레드이기 때문에.
// 어플리케이션 만들때는 필요하다.
}

```

### C03SwingMain

```java
package CH23;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class C03GUI extends JFrame implements ActionListener, KeyListener {
	//
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JTextField txt1;
	JTextArea area1;
	JTextArea area2;

	Thread th1;
	Thread th2;

	C03GUI() {
		super(); // 상위클래스 생성자 호출

		setTitle("THREAD 확인하기");

		// 패널 추가
		JPanel pan1 = new JPanel();

		// 컴포넌트 객체 생성
		btn1 = new JButton("시작");
		btn2 = new JButton("중지");

		btn3 = new JButton("시작");
		btn4 = new JButton("중지");
		txt1 = new JTextField();
		area1 = new JTextArea();
		area2 = new JTextArea();
		JScrollPane scroll1 = new JScrollPane(area1);
		JScrollPane scroll2 = new JScrollPane(area2);

		// 컴포넌트 위치 지정
		scroll1.setBounds(50, 50, 190, 280);
		scroll2.setBounds(300, 50, 190, 280);
		// area1.setBounds(50,50,190,280); // Scroll추가시 제거
		txt1.setBounds(50, 350, 190, 30);
		btn1.setBounds(50, 400, 80, 30);
		btn2.setBounds(160, 400, 80, 30);
		btn3.setBounds(300, 400, 80, 30);
		btn4.setBounds(410, 400, 80, 30);

		// 컴포넌트를 리스너에 등록
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		txt1.addKeyListener(this);

		// 기타설정
		area1.setEditable(false);

		// 패널에 컴포넌트 추가
		pan1.add(btn1);
		pan1.add(btn2);
		pan1.add(btn3);
		pan1.add(btn4);
		pan1.add(txt1);
		// pan1.add(area1); // Scroll추가시 제거
		pan1.add(scroll1);
		pan1.add(scroll2);

		// 레이아웃 null
		pan1.setLayout(null);

		// 패널을 프레임에 추가
		add(pan1);
		setBounds(100, 100, 600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			System.out.println("btn1..clicked");  // 시작
			C03Worker1 w1 = new C03Worker1(this); // 스레드 만들기 이떄 this는 C03GUI 생성자이다. 
			th1 = new Thread(w1); // 스레드분할
			th1.start(); // 스레드 실행
		}
		if (e.getSource() == btn2) {
			System.out.println("btn2..clicked");  // 종료
			if (th1 !=null) {
				th1.interrupt();
				th1=null;
			}
		}
		if (e.getSource() == btn3) {
			System.out.println("btn3..clicked");
			C03Worker2 w2 = new C03Worker2(this); // 스레드 만들기 이떄 this는 C03GUI 생성자이다. 
			th2 = new Thread(w2); // 스레드분할
			th2.start(); // 스레드 실행
		}
		if (e.getSource() == btn4) {
			System.out.println("btn4..clicked");
			if (th2 !=null) {
				th2.interrupt();
				th2=null;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// System.out.println(e.getKeyChar());
		// System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 10) // 엔터키 입력
		{
			String tmp = txt1.getText();
			area1.append(tmp + "\n");
			txt1.setText("");
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
public class C03SwingMain {

	public static void main(String[] args) {
		new C03GUI();
		

	}

}

```

<aside>
💡

```java
if (e.getSource() == btn1) {
			System.out.println("btn1..clicked");  // 시작
			C03Worker1 w1 = new C03Worker1(this); // 스레드 만들기 이떄 this는 C03GUI 생성자이다. 
			th1 = new Thread(w1); // 스레드분할
			th1.start(); // 스레드 실행
		}
```

여기서 왜 C01Worker1에있는 run함수를 호출을 하지 않을까?

1. `run()`을 직접 호출하지 않는 이유

만약에 run()메서드를 직접 호출하면 일반적인 메서드 호출과 다를 바 없어서 멀티스레드가 아닌 단일 스레드에서 실행된다.

즉

```java
C03Worker1 w1 = new C03Worker1(this);
w1.run();  // ❌ 이렇게 하면 멀티스레드가 아님! 그냥 일반 메서드 실행임
```

이렇게 하면 run()이 끝날때 까지 메인 스레드는 다른 작업을 할 수 없다. 

하지만 `Thread` 객체를 만들어 `start()`함수를 호출하면 새로운 스레드에서 `run()` 이 실행돼서 동시에 여러 작업을 수행할 수 있다.

</aside>

### C03Worker1

```java
package CH23;

public class C03Worker1 implements Runnable {
	
	C03GUI gui;
	C03Worker1(C03GUI gui){
		this.gui = gui;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			
			try {
				gui.area1.append("WORKER1...\n");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
		System.out.println("WORKER01 INTERRUPTED...");
		
	}

}

```

### C03Worker2

```java
package CH23;

public class C03Worker2 implements Runnable{
	
	C03GUI gui;
	C03Worker2(C03GUI gui){
		this.gui = gui;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			
			try {
				gui.area2.append("WORKER2...\n");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
		System.out.println("WORKER02 INTERRUPTED...");
		
	}

}

```

### C04ThreadMain_Ex_문제코드

```java
package CH23;

class IncrementThread implements Runnable {
	private static int counter = 0;

	public int getCounter() {
		return counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			counter++; // 공유변수값증가
			System.out.println(Thread.currentThread().getName() + "s counter : " + counter);
		}
	}

}

public class C04ThreadMain_Ex_문제코드 {

	public static void main(String[] args) throws InterruptedException {

		
		IncrementThread incrementThread1 = new IncrementThread();
		IncrementThread incrementThread2 = new IncrementThread();
		IncrementThread incrementThread3 = new IncrementThread();
		IncrementThread incrementThread4 = new IncrementThread();

		Thread thread1 = new Thread(incrementThread1);
		Thread thread2 = new Thread(incrementThread2);
		Thread thread3 = new Thread(incrementThread3);
		Thread thread4 = new Thread(incrementThread3);

		thread1.setName("TH1");
		thread2.setName("TH2");
		thread3.setName("TH3");
		thread4.setName("TH4");

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		//메인 스레드가 thread1,thread2의 작업이 모두 완료될 때까지 대기하도록 설정
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();

		System.out.println("Final value: " + incrementThread1.getCounter());

	}
}

```

### C05ThreadMain_Ex_임계영역설정

```java
package CH23;

class IncrementThread implements Runnable {
	private static int counter = 0;
	private static final Object Lock = new Object();
	
	public int getCounter() {
		return counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			synchronized (Lock) {
				counter++; // 공유변수값증가
				System.out.println(Thread.currentThread().getName() + "s counter : " + counter);
				try {
					if (i<99999) {
						Lock.notifyAll();  // 다른 스레드에게 알림
						Lock.wait(5);  // 잠깐대기
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}
			
		}
	}
}

public class C05ThreadMain_Ex_임계영역설정 {

	public static void main(String[] args) throws InterruptedException {

		
		IncrementThread incrementThread1 = new IncrementThread();
		IncrementThread incrementThread2 = new IncrementThread();
		IncrementThread incrementThread3 = new IncrementThread();
		IncrementThread incrementThread4 = new IncrementThread();

		Thread thread1 = new Thread(incrementThread1);
		Thread thread2 = new Thread(incrementThread2);
		Thread thread3 = new Thread(incrementThread3);
		Thread thread4 = new Thread(incrementThread3);

		thread1.setName("TH1");
		thread2.setName("TH2");
		thread3.setName("TH3");
		thread4.setName("TH4");

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		//메인 스레드가 thread1,thread2의 작업이 모두 완료될 때까지 대기하도록 설정
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();

		System.out.println("Final value: " + incrementThread1.getCounter());

	}
}

```

<aside>
💡

```java
synchronized (Lock) { ... }
```

- **여러 스레드가 동시에 counter 값을 수정하는 문제(레이스 컨디션)를 방지**하기 위해 `synchronized`를 사용합니다.
- `Lock.notifyAll()`: 다른 대기 중인 스레드에게 **진행할 수 있음을 알림**.
</aside>
