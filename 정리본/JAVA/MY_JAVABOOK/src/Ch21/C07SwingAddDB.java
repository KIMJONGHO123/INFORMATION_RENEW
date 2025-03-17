package Ch21;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

class Memo{
	private int id;
	private String text;
	private LocalDateTime createdAt;
	
	public Memo(int id, String text, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.text = text;
		this.createdAt = createdAt;
	}
	
	public Memo() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Memo [id=" + id + ", text=" + text + ", createdAt=" + createdAt + "]";
	}
	

	
	
}
class C07GUI extends JFrame implements ActionListener, KeyListener,MouseListener{
	JButton btn1; // 생성자 안에서 만들었기 때문에 생성자 밖에서도 쓰기위해서 멤버변수로 지정.
	JButton btn2;
	JButton btn3;  //INSERT 버튼
	JButton btn4;  //UPDATE 버튼
	JButton btn5;  //DELETE 버튼
	JButton btn6;  //SELECT one 버튼
	
	JButton input;
	JTextField txt1;
	JTextArea area1;
	
	Writer out;
	
	//DB CONN DATA
	static String id = "root";
	static String pw = "1234";
	static String url = "jdbc:mysql://localhost:3306/testdb";
	
	//JDBC참조변수
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	
	C07GUI(String title) throws ClassNotFoundException, SQLException{
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
		btn1.setText("저장하기");
		
		btn2 = new JButton();
		btn2.setBounds(177,80,100,30);
		btn2.setText("불러오기");
		
		btn3 = new JButton();
		btn3.setBounds(177,130,100,30);
		btn3.setText("INSERT");
		
		btn4 = new JButton("UPDATE");
		btn4.setBounds(177,180,100,30);
		
		btn5 = new JButton("DELETE");
		btn5.setBounds(177,230,100,30);
		
		btn6 = new JButton("SELECT");
		btn6.setBounds(177,280,100,30);
		
		
		input = new JButton("입력");		
		input.setBounds(177,370,100,40);
		
		txt1 = new JTextField();
		txt1.setBounds(15,370,150,40);
		
		

		// 이벤트 리스너 add
		btn1.addActionListener(this); // btn1에 대한 위치정보를 this로 전달
		btn2.addActionListener(this); // btn2에 대한 위치정보를 this로 전달
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);

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
		pannel.add(btn4);
		pannel.add(btn5);
		pannel.add(btn6);
		
		
		//Frame에 pannel 더하기
		add(pannel);
		
		// 프레임 표시
		setVisible(true);
		
		
		// DB CONN
		//DB 연결코드
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is loaded");
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("Driver is connected");
	}

	// 버튼클릭하면 그 감지를 여기서 한다. 항상감시하고 있으니까
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("클릭");
		if (e.getSource() == btn1 ) {
			System.out.println("저장하기");
			String contents = area1.getText();
			
			// 파일 탐색기 열기
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("파일 저장 위치를 선택하세요");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			File defaultDirPath = new File("C:\\IOTEST");
			if(defaultDirPath.exists()) {
				fileChooser.setCurrentDirectory(defaultDirPath);
			}
			int selectedVal = fileChooser.showSaveDialog(null);
			System.out.println("selectedVal"+selectedVal);
			
			
			if(selectedVal == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("selectedFile"+selectedFile);
				
				// 파일 확장자 추가
				String filePath = selectedFile.toString();
				if(!selectedFile.toString().endsWith(".txt")) {
					filePath = selectedFile.toString()+".txt";
				}
				System.out.println("filepath : "+ filePath);
				
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyMMdd_HHmmss");			
//				String filename = LocalDateTime.now().format(formatter);
				
				try {
					out = new FileWriter(filePath);
					out.write(contents);
					out.flush();
				} catch (Exception e2) {
					e2.printStackTrace();
				}finally {
					try {out.close();} catch(IOException e2) {e2.printStackTrace();}
				}
				
			}
			
			
			
			
		}else if(e.getSource() == btn2) {
			System.out.println("불러오기");
			
			// 파일 탐색기 열기
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("파일을 선택하세요.");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			File defaultDirPath = new File("C:\\IOTEST");
			if(defaultDirPath.exists()) {
				fileChooser.setCurrentDirectory(defaultDirPath);
			}
			int selectedVal = fileChooser.showSaveDialog(null);
			System.out.println("selectedVal"+selectedVal);
			
			if(selectedVal == JFileChooser.APPROVE_OPTION){
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("selectedFile : "+selectedFile);
				try {
					Reader fin = new FileReader(selectedFile.toString());
					StringBuffer buffer  = new StringBuffer();
					while(true) {
						int data = fin.read();
						if(data ==-1) {
							break;
						}
						buffer.append((char)data);
						
					}
					area1.setText("");
					area1.append(buffer.toString());
					fin.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
			
			
			
			
		}else if(e.getSource() == btn3) {
			System.out.println("INSERT");
			try {
				pstmt = conn.prepareStatement("insert into tbl_memo values (null,?,now())");
				pstmt.setString(1, area1.getText());
				int result = pstmt.executeUpdate();
				
				if (result>0) {
					System.out.println("[INFO] INSERT 성공");
					JOptionPane.showMessageDialog(null, "INSERT 성공","INSERT 확인창",JOptionPane.INFORMATION_MESSAGE);;
				}else {
					System.out.println("[INFO] INSERT 실패");
					JOptionPane.showMessageDialog(null, "INSERT 실패","INSERT 확인창",JOptionPane.ERROR_MESSAGE);;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {
					pstmt.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
					
				}
			}
		}
		
		else if(e.getSource() == btn4) {
			
		}
		
		else if(e.getSource() == btn5) {
			
		}
		
		else if(e.getSource() == btn6) {
			// 전체 조회 가져와서 CONSOLE에 출력
			try {
				// SQL 준비
				pstmt = conn.prepareStatement("select * from tbl_memo");
				// SQL 실행
				List <Memo> li = new ArrayList<>();
				Memo memo;
				rs = pstmt.executeQuery();
				if (rs !=null) {
					JOptionPane.showMessageDialog(null, "SELECT 성공","SELECT 확인창", JOptionPane.INFORMATION_MESSAGE);;
					while(rs.next()) {
//						System.out.print(rs.getInt("id")+"\n");
//						System.out.print(rs.getString("text")+"\n");
//						System.out.print(rs.getTimestamp("createdAt")+"\n");
						memo = new Memo();
						memo.setId(rs.getInt("id"));
						memo.setText(rs.getString("text"));
						Timestamp timestamp = rs.getTimestamp("createdAt");
						memo.setCreatedAt(timestamp.toLocalDateTime());
						li.add(memo);
					}
					
				}li.forEach(i->System.out.println(i));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {rs.close();}catch(Exception e2) {}
				try {pstmt.close();}catch(Exception e2) {}
			}
			
			
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
public class C07SwingAddDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
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
