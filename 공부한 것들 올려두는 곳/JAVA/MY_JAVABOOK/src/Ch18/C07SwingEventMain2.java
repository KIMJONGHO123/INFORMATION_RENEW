package Ch18;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

import Ch01.Ch01SystemOut;

class C07GUI extends JFrame implements ActionListener, KeyListener,MouseListener{
	JButton btn1; // 생성자 안에서 만들었기 때문에 생성자 밖에서도 쓰기위해서 멤버변수로 지정.
	JButton btn2;
	JButton btn3;   
	JButton input;
	JTextField txt1;
	JTextArea area1;
	
	
	
	C07GUI(String title){
		super(title);
		setBounds(100,100,300,500); // 프레임 크기 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pannel = new JPanel();
		pannel.setLayout(null);
		
		
		area1 = new JTextArea();
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
		
		txt1 = new JTextField();
		txt1.setBounds(15,370,150,40);
		
		

		// 이벤트 리스너 add
		btn1.addActionListener(this); // btn1에 대한 위치정보를 this로 전달
		btn2.addActionListener(this); // btn2에 대한 위치정보를 this로 전달
		btn3.addActionListener(this);
		input.addActionListener(this);
		txt1.addKeyListener(this);
		area1.addMouseListener(this);

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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("keyTyped..."+e.getKeyChar());
//		System.out.println("keyTyped..."+e.getKeyCode());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("keyPressed..."+e.getKeyChar());
		System.out.println("keyPressed..."+e.getKeyCode());
		if (e.getSource()==txt1) {
			if (e.getKeyCode()==10) {
				String message = txt1.getText();
				System.out.println(message);
				area1.append(message+"\n");
				txt1.setText("");
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		try {
//			System.out.println("mouseClicked"+e.getPoint());
			int offset = area1.viewToModel(e.getPoint());
//			System.out.println("mouse offset : "+offset);
			int row = area1.getLineOfOffset(offset);
//			System.out.println("mouseClicked...row : "+ row);
			int startOffset = area1.getLineStartOffset(row);
			int endOffset = area1.getLineEndOffset(row);
//			System.out.printf("%d %d\n",startOffset,endOffset);
			String str = area1.getText(startOffset, endOffset-startOffset);
			System.out.println(str);
		}
		 catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



}
public class C07SwingEventMain2 {

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
		new C07GUI("Chatting Server"); // 프레임 생성
	}

}
