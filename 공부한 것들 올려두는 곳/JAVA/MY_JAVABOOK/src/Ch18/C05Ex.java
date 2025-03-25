package Ch18;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class GUI extends JFrame{
	GUI(String title){
		super(title);
		setBounds(100,100,300,500); // 프레임 크기 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pannel = new JPanel();
		pannel.setLayout(null);
		
		
		JTextArea area1 = new JTextArea();
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(15,30,150,300);

		JButton btn1 = new JButton();
		btn1.setBounds(177,30,100,30);
		btn1.setText("파일로 저장");
		
		JButton btn2 = new JButton();
		btn2.setBounds(177,80,100,30);
		btn2.setText("1 : 1 요청");
		
		JButton btn3 = new JButton();
		btn3.setBounds(177,130,100,30);
		btn3.setText("대화기록보기");
		
		
		JTextField txt1 = new JTextField();
		txt1.setBounds(15,370,150,40);
		
		JButton input = new JButton("입력");		
		input.setBounds(177,370,100,40);

		
		
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
}
public class C05Ex {

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
		new GUI("Chatting Server"); // 프레임 생성
	}

}
