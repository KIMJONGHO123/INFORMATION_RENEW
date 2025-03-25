package Ch18;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class C06GUI extends JFrame implements ActionListener{
	JButton btn1; // 생성자 안에서 만들었기 때문에 생성자 밖에서도 쓰기위해서 멤버변수로 지정.
	JButton btn2;
	JButton btn3;   
	JButton input;
	
	C06GUI(String title){
		super(title);
		setBounds(100,100,300,500); // 프레임 크기 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pannel = new JPanel();
		pannel.setLayout(null);
		
		
		JTextArea area1 = new JTextArea();
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(15,30,150,300);

		btn1 = new JButton();
		btn1.setBounds(177,30,100,30);
		btn1.setText("파일로 저장");
		
		btn2 = new JButton();
		btn2.setBounds(177,80,100,30);
		btn2.setText("1 : 1 요청");
		
		btn3 = new JButton();
		btn3.setBounds(177,130,100,30);
		btn3.setText("대화기록보기");
		
		input = new JButton("입력");		
		input.setBounds(177,370,100,40);
		
		JTextField txt1 = new JTextField();
		txt1.setBounds(15,370,150,40);
		
		

		// 이벤트 리스너 add
		btn1.addActionListener(this); // btn1에 대한 위치정보를 this로 전달
		btn2.addActionListener(this); // btn2에 대한 위치정보를 this로 전달
		btn3.addActionListener(this);
		input.addActionListener(this);
		

//		pannel.add(area1);
		pannel.add(scroll1);
		pannel.add(btn1);
		pannel.add(btn2);
		pannel.add(btn3);
		pannel.add(txt1);
		pannel.add(input);
		
		//Frame에 pannel 더하기
		add(pannel);
		
		// 프레임 표시
		setVisible(true);
		
	}

	// 버튼클릭하면 그 감지를 여기서 한다. 항상감시하고 있으니까
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("클릭");
		if (e.getSource() == btn1 ) {
			System.out.println("파일로 저장 클릭");
		}else if(e.getSource() == btn2) {
			System.out.println("1:1 요청 클릭");
		}else if(e.getSource() == btn3) {
			System.out.println("대화기록보기");
		}
		
		else if(e.getSource() == input) {
			System.out.println("입력 클릭");
		}
	}
}
public class C06SwingEventMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Component 참조변수명
		//textarea = area1
		//textarea's scroll = scroll1
		//파일로저장 : btn1
		//1:1요청 : btn2
		//대화기록보기 : btn3
		//입력 : input
		//textfield : txt1
		new C06GUI("Chatting Server"); // 프레임 생성
	}

}
