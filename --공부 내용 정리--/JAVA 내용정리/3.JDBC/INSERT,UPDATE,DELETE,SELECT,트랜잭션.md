# INSERT,UPDATE,DELETE,SELECT,트랜잭션

### C01DBConn

```java
package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C01DBConn {
	public static void main(String[] args) {
		//DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/testdb";
		
		//JDBC 참조변수 (클래스 형태)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select결과
		
		//
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB CONNECTED");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {  // 종료되는 상황에서도 예외발생할 수 있어서 finally에서도 try catch 한것
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

```

### C02Insert

```java
package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C02Insert {
	public static void main(String[] args) {
		//DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/testdb";
		
		//JDBC 참조변수 (클래스 형태)
		Connection conn = null; // 데이터베이스 연결
		PreparedStatement pstmt = null; // SQL 실행. // 보안성 때문에 PreparedStatement를 사용
		ResultSet rs = null; // select결과
		
		//
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			
			//CONNECTION
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB CONNECTED");
			
			//SQL 쿼리 준비
			String name = args[0];
			int age = Integer.parseInt(args[1]);
			String addr = args[2];
			//pstmt = conn.prepareStatement("insert into tbl_std values(?,?,?)");  // insert문을 실행하여 데이터베이스에 값을 입력.
//			pstmt.setString(1, name);
//			pstmt.setInt(2, age);
//			pstmt.setString(3, addr);
			
			pstmt = conn.prepareStatement("insert into tbl_std values('"+name+"',"+age+",'"+addr+"')");  // ? 가 지원안 할시에 하는 방법 문자열은 ''으로 한번더 덮어씌어야 한다.
			
			// SQL 실행
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("INSERT 성공");
			}else {
				System.out.println("INSERT 실패");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {  // 종료되는 상황에서도 예외발생할 수 있어서 finally에서도 try catch 한것
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();  //printStackTrace(); → 예외 발생 시 오류 위치 & 원인을 콘솔에 출력
			}
		}
	}
}

```

### C03Update

```java
package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C03Update {

	public static void main(String[] args) {
		//DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/testdb";
		
		//JDBC참조변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		//
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB CONNECTED...");
			
			String name = "티모";
			int age = 30;
			String addr = "서울";
			String sql = "update tbl_std set age=?, addr = ? where name=?"; // PK가 name
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, age);
			pstmt.setString(2, addr);
			pstmt.setString(3, name);
			
			int result = pstmt.executeUpdate();
			
			if (result>0) {
				System.out.println("update 정상 실행");
			}else {
				System.out.println("update 실패");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {	
			try { conn.close();} catch (SQLException e) {e.printStackTrace(); }
		}
	}

}

```

### C04Delete

```java
package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C04Delete {

	public static void main(String[] args) {
		//DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/testdb";
		
		//JDBC참조변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//
		//tbl_std 에 삭제 코드 넣어보세요(단일삭제하기)
		
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB CONNECTED...");
			
			String sql = "delete from tbl_std where name = ?"; // PK가 name이니까 name을 기준으로 삭제
			String name = "티모";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int result = pstmt.executeUpdate();
			
			if (result >0) {
				System.out.println("delete 정상 작동");
			}else {
				System.out.println("delete 실패");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {	
			try { conn.close();} catch (SQLException e) {e.printStackTrace(); }
		}
	}

}

```

<aside>
💡

JDBC 참조변수 (클래스 형태)
Connection conn = null; // 데이터베이스 연결을 담당
PreparedStatement pstmt = null; // SQL 실행을 담당. // 보안성 때문에 PreparedStatement를 사용
ResultSet rs = null; // select결과을 저장하는 용도

드라이버 로드

Class.forName(”com.mysql.cj.jdbc.Driver”)을 사용하여 MySQL JDBC 드라이버를 로드

DriverManager.getConnection(url, id, pw)를 통해 데이터베이스 연결

SQL 쿼리 준비
String name = “티모”;
int age = 45;
String addr = “경기도”;
pstmt = conn.prepareStatement("insert into tbl_std values(?,?,?)");  // insert문을 실행하여 데이터베이스에 값을 입력.
pstmt.setString(1, name);
pstmt.setInt(2, age);
pstmt.setString(3, addr);

SQL 쿼리 실행

int result = pstmt.executeUpdate();

if (result >0) {
	System.out.println("delete 정상 작동");
}else {
	System.out.println("delete 실패");
}

executeUpdate는 실행된 SQL 문으로 인해 영향을 받은 행(row)의 개수를 의미합니다.

**예외 처리**

`try-catch` 블록을 사용하여 예외 발생 시 오류 메시지를 출력.

`SQLException`이 발생할 경우 `printStackTrace()`를 통해 디버깅 가능.

**자원 해제**

`finally` 블록에서 `conn.close()`를 호출하여 데이터베이스 연결을 닫음.

</aside>

### C05SELECT

```java
package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C05SELECT {
	public static void main(String[] args) {
		//DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/testdb";
		
		//JDBC 참조변수 (클래스 형태)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // select결과
		
		//
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB CONNECTED");
			
			// SQL 준비
			pstmt = conn.prepareStatement("select * from tbl_std");
			
			
			// SQL 실행
			rs = pstmt.executeQuery(); //executeQuery()은 반환값이 ResultSet object이다.
			
			if (rs != null) {
				while (rs.next()) { // 기본적으로 rs는 행의 타이틀에 가리킨다. 그래서 next하면 커서의 위치가 밑에 행으로 이동한다. 계속 밑으로 내려가다가 값이 없으면 false를 반환하고 while을 멈춘다.
					System.out.print(rs.getString("name")+" ");
					System.out.print(rs.getInt("age")+" ");
					System.out.print(rs.getString("addr")+"\n");
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {  // 종료되는 상황에서도 예외발생할 수 있어서 finally에서도 try catch 한것
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
//			try {
//				if (!rs.isClosed()) {
//					rs.close();
//				}
//				if (!pstmt.isClosed()) {
//					pstmt.close();
//				}
//				if (!conn.isClosed()) {
//					conn.close();
//				}
//			} catch (SQLException e2) {
//				e2.printStackTrace();
//			}
		}
	}
}

```

### C06Ex

```java
package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class ChargeStation{
	private int no;
	private String section;
	private String station;
	private String name;
	private int zipcode;
	private String address;
	//Getter and Setter
	//toString
	//모든 인자 생성자 	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "ChargeStation [no=" + no + ", section=" + section + ", station=" + station + ", name=" + name
				+ ", zipcode=" + zipcode + ", address=" + address + "]";
	}
	public ChargeStation(int no, String section, String station, String name, int zipcode, String address) {
		super();
		this.no = no;
		this.section = section;
		this.station = station;
		this.name = name;
		this.zipcode = zipcode;
		this.address = address;
	}
	
}
public class C06Ex {
	//DB CONN DATA
	static String id = "root";
	static String pw = "1234";
	static String url = "jdbc:mysql://localhost:3306/testdb";
	
	//JDBC참조변수
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	public static void connect() throws Exception {
		//DB 연결코드
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is loaded");
		conn = DriverManager.getConnection(url,id,pw);
		System.out.println("Driver is connected");
		
	}
	public static void Select() throws Exception {
			//전체 조회
		pstmt = conn.prepareStatement("select * from charge_station");
		rs = pstmt.executeQuery();
		if (rs != null) {
			
			while (rs.next()) {
				System.out.print(rs.getInt(1)+"\n");
				System.out.print(rs.getString(2)+"\n");
				System.out.print(rs.getString(3)+"\n");
				System.out.print(rs.getString(4)+"\n");
				System.out.print(rs.getInt(5)+"\n");
				System.out.print(rs.getString(6)+"\n");
				System.out.println("-----------------------------------------");
			}
		}else {
			System.out.println("rs가 null 입니다.");
		}
	}
	public static void Insert(ChargeStation obj) throws Exception {
		//ChargeStation 객체를 받아 내용 insert
		
		pstmt = conn.prepareStatement("insert into charge_station values(?,?,?,?,?,?)");
		pstmt.setInt(1,obj.getNo());
		pstmt.setString(2, obj.getSection());
		pstmt.setString(3, obj.getStation());
		pstmt.setString(4, obj.getName());
		pstmt.setInt(5, obj.getZipcode());
		pstmt.setString(6, obj.getAddress());
		
		int result = pstmt.executeUpdate();
		if (result>0) {
			System.out.println("INSERT 정상 실행");
		}else {
			System.out.println("INSERT 실패");
		}
		
		freeConnection(pstmt);

	}
	public static void Update(ChargeStation obj) throws Exception {
		//수정
		pstmt = conn.prepareStatement("update charge_station set 행정구역 = ? , 지사=?,시설명=? , 우편번호=?, 주소=? where 순번=? ");
		pstmt.setString(1, obj.getSection());
		pstmt.setString(2, obj.getStation());
		pstmt.setString(3, obj.getName());
		pstmt.setInt(4, obj.getZipcode());
		pstmt.setString(5, obj.getAddress());
		pstmt.setInt(6, obj.getNo());
		
		int result = pstmt.executeUpdate();
		if (result>0) {
			System.out.println("UPDATE 성공");
		}else {
			System.out.println("UPDATE 실패");
		}
		freeConnection(pstmt);
	}
	public static void Delete(int number) throws Exception {
		//삭제
		pstmt = conn.prepareStatement("delete from charge_station where 순번=?");
		pstmt.setInt(1, number);
		int result = pstmt.executeUpdate();
		if (result>0) {
			System.out.println("DELETE 성공");
		}else {
			System.out.println("DLETE 실패");
		}
		
		freeConnection(pstmt);
	}
	
	//자원제거용 함수 오버로딩
	public static void freeConnection(Connection conn) throws Exception  {}
	public static void freeConnection(PreparedStatement pstmt) throws Exception{
		pstmt.close();
	}
	public static void freeConnection(PreparedStatement pstmt,ResultSet rs)throws Exception {
		pstmt.close();
		rs.close();
	}
	
	public static void main(String[] args) {
		try {
			connect();
			Insert(new ChargeStation(201,"대구광역시","대구지사","대구가스",10101,"대구"));
			Select();
			Update(new ChargeStation(1,"경상북도 경산시", "서울지사","현대건설" , 3003,"경산"));
			Delete(2);
			

		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

```

<aside>
💡

```java
Insert(new ChargeStation(201,"대구광역시","대구지사","대구가스",10101,"대구"));
```

`ChargeStation` 클래스의 생성자와 private로 되어있기때문에  getter와 setter를 만들어줘야한다.

```java
pstmt = conn.prepareStatement("update charge_station set 행정구역 = ? , 지사=?,시설명=? , 우편번호=?, 주소=? where 순번=? ");
```

`UPDATE` 할때 테이블의 칼럼명으로 적어야한다.(’’하면 안된다.) 멤버변수명으로 적는게 아니다.

```java
pstmt.setString(1, obj.getSection());
pstmt.setString(2, obj.getStation());
pstmt.setString(3, obj.getName());
pstmt.setInt(4, obj.getZipcode());
pstmt.setString(5, obj.getAddress());
pstmt.setInt(6, obj.getNo());
```

여기서 이제 매개변수로 받은 객체의 getter 함수를 호출해야한다.

</aside>

### C07SwingAddDB

```java
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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

class Memo{
	private int id;
	private String text;
	private LocalDateTime createdAt;
	Memo(){}
	public Memo(int id, String text, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.text = text;
		this.createdAt = createdAt;
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
	//toString
	//getter and setter
	//모든 인자생성자
	//디폴트 생성자
}

class SelectFrame extends JFrame implements MouseListener,ActionListener {
	
	C07GUI mainUi;
	JTable table;
	JScrollPane scroll;
	JPanel panel;
	JButton btn1;
	String selectedText;
	SelectFrame(C07GUI mainUi){
		super("SELECT 결과");
		this.mainUi = mainUi;
		
		setBounds(100,100,500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//panel
		panel = new JPanel();
		panel.setLayout(null);
		
		//
		btn1 = new JButton("선택");
		btn1.setBounds(410,10,70,30);
		btn1.addActionListener(this);

		panel.add(btn1);
		
		//frame(panel)
		add(panel);
		
		//event
		
		
		setVisible(false);
	}
	void select(Connection conn , PreparedStatement pstmt , ResultSet rs) {
		
		if(scroll!=null) {
			panel.remove(table);
			panel.remove(scroll);
		}
		
		//component
		String [] columns = {"ID","TEXT","CREATED_AT"};
		List<String[]>data = new ArrayList();
		

		try {
			
			//SQL 준비
			pstmt = conn.prepareStatement("select * from tbl_memo");
			
			//SQL 실행
			List<Memo> list = new ArrayList();
			Memo memo;
			rs =  pstmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					memo = new Memo();
					memo.setId(rs.getInt("id"));
					memo.setText(rs.getString("text"));
					Timestamp timestamp = rs.getTimestamp("createdAt");
					memo.setCreatedAt(timestamp.toLocalDateTime());
					list.add(memo);
					
					data.add(new String[] {rs.getString("id"),rs.getString("text"),rs.getString("createdAt")});
					
				}
			}
			list.forEach(System.out::println);
			
			//------------------------------------------
			
			String[][] arr = new String[data.size()][];
			//for 값복사
			for(int i=0;i<data.size();i++) {
				arr[i]=data.get(i);
				System.out.println(data.get(i));
			}
			table = new JTable(arr,columns);
			table.addMouseListener(this);
//			table.setBounds(10,10,400,400);
			
			scroll = new JScrollPane(table);
			scroll.setBounds(10,10,400,400);
			//panel(component)
//			panel.add(table);
			panel.add(scroll);
			
		}catch(Exception e3) {
			e3.printStackTrace();
		}finally {
			try {rs.close();}catch(Exception e2) {}
			try {pstmt.close();}catch(Exception e2) {}
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int selectedRow = table.getSelectedRow();
		selectedText = table.getValueAt(selectedRow, 1).toString();
		System.out.println("CLICKED.." + selectedText);
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
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			//mainUI에 selectedText를 전달
			mainUi.area1.setText(selectedText);
			//현재프레임은 종료
//			dispose();
		}
		
	}
	
}

class C07GUI extends JFrame implements ActionListener, KeyListener, MouseListener {
	JButton btn1;
	JButton btn2;
	JButton btn3;	//INSERT
	JButton btn4;	//UPDATE
	JButton btn5;	//DELETE
	JButton btn6;	//SELECTONE
	
	JButton input;
	JTextField txt1;
	JTextArea area1;
	
	Writer out;
	
	// DB CONN DATA
	static String id = "root";
	static String pw = "1234";
	static String url = "jdbc:mysql://localhost:3306/testdb";

	// JDBC참조변수
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	//SELECT FRAME
	SelectFrame selectFrame;
	
	C07GUI(String title) throws ClassNotFoundException, SQLException {
		// frame
		super(title);
		setBounds(100, 100, 410, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);

		// Component 참조변수명
		area1 = new JTextArea(); // textarea = area1
		area1.setBounds(10, 10, 260, 280);
		// textarea's scroll = scroll1
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(10, 10, 250, 280);

		btn1 = new JButton("저장하기");// 파일로저장 : btn1
		btn1.setBounds(270, 10, 110, 30);

		btn2 = new JButton("불러오기");// 1:1요청 : btn2
		btn2.setBounds(270, 50, 110, 30);

		btn3 = new JButton("INSERT");// INSERT : btn3
		btn3.setBounds(270, 90, 110, 30);

		btn4 = new JButton("UPDATE");
		btn4.setBounds(270, 130, 110, 30);
		
		btn5 = new JButton("DELETE");
		btn5.setBounds(270, 170, 110, 30);
		
		btn6 = new JButton("SELECT");
		btn6.setBounds(270, 210, 110, 30);
		
		input = new JButton("입력"); // 입력 : input
		input.setBounds(270, 300, 110, 30);

		txt1 = new JTextField(); // textfield : txt1
		txt1.setBounds(10, 300, 250, 30);

		// event listener add
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		input.addActionListener(this);
		txt1.addKeyListener(this);
		area1.addMouseListener(this);

		// panel(component)
//		panel.add(area1);
		panel.add(scroll1);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		panel.add(input);
		panel.add(txt1);

		// frame(panel)
		add(panel);

		// frame
		setVisible(true);
		
		//DB CONN
		// DB 연결코드
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loading Success...");
		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("DB CONNECTED...");
		
		//SELECT FRAME
		selectFrame = new SelectFrame(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		System.out.println("클릭!");
		if (e.getSource() == btn1) {
			System.out.println("저장하기");
			String contents = area1.getText();
			
			//파일탐색기 열기
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("파일 저장 위치를 선택하세요");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			File defaultDirPath = new File("C:\\IOTEST");
			if(defaultDirPath.exists())
				fileChooser.setCurrentDirectory(defaultDirPath);
			
			int selectedVal = fileChooser.showSaveDialog(null);
			System.out.println("selectedVal : " + selectedVal);
			
			if(selectedVal == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("selectedFile : " + selectedFile);
				
				//파일확장자 추가
				String filePath = selectedFile.toString();
				if(!selectedFile.toString().endsWith(".txt")) {
					filePath = selectedFile.toString()+".txt";
				}
				System.out.println("filePath : " + filePath);
				
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
//				String filename = LocalDateTime.now().format(formatter);
				
				try {
					out = new FileWriter(filePath);
					out.write(contents);
					out.flush();
				}catch(Exception e1) {
					e1.printStackTrace();
				}finally {
					try {out.close();} catch (IOException e1) {e1.printStackTrace();}
				}
			}
					
			
		} else if (e.getSource() == btn2) {
			
			System.out.println("불러오기");
			//파일탐색기 열기
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("파일을 선택하세요");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		 
			File defaultDirPath = new File("C:\\IOTEST");
			if(defaultDirPath.exists())
				fileChooser.setCurrentDirectory(defaultDirPath);
			
	
			int selectedVal = fileChooser.showSaveDialog(null);
			System.out.println("selectedVal : " + selectedVal);
			if(selectedVal == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				System.out.println("selectedFile : " + selectedFile);
				
				try {
					
					Reader fin =new FileReader(selectedFile.toString()); 
					StringBuffer buffer = new StringBuffer();
					while(true) {
						int data = fin.read();
						if(data==-1) 
							break;
						buffer.append((char)data);
					}
					area1.setText("");
					area1.append(buffer.toString());
					fin.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
	
		} 
		else if (e.getSource() == btn3) 
		{
			System.out.println("INSERT");
			
			try {
				
				pstmt = conn.prepareStatement("insert into tbl_memo values(null,?,now())");
				pstmt.setString(1,area1.getText());
				int result=pstmt.executeUpdate();
				
				if(result>0) {
					System.out.println("[INFO] INSERT 성공");
					JOptionPane.showMessageDialog(null, "INSERT 성공","INSERT 확인창",JOptionPane.INFORMATION_MESSAGE);	
				}
				else {
					System.out.println("[INFO] INSERT 실패");
					JOptionPane.showMessageDialog(null, "INSERT 실패","INSERT 확인창",JOptionPane.ERROR_MESSAGE);	
				}
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {pstmt.close();}catch(Exception e1) {e1.printStackTrace();}
			}
			
			
		} 
		else if (e.getSource() == btn4) {
			
		}
		else if (e.getSource() == btn5) {
			
		}
		else if (e.getSource() == btn6) {
			selectFrame.setVisible(true);
			//전체 조회 가져와서 CONSOLE에 출력
			selectFrame.select(conn, pstmt, rs);
	
		}
		
		else if (e.getSource() == input) 
		{
			System.out.println("입력");
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println("keyTyped..."+e.getKeyChar());
//		System.out.println("keyTyped..."+e.getKeyCode());

	}

	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("keyPressed..."+e.getKeyChar());	
//		System.out.println("keyPressed..."+e.getKeyCode());
		if (e.getSource() == txt1) {
			if (e.getKeyCode() == 10) {
				String message = txt1.getText();
				System.out.println(message);
				area1.append(message + "\n");
				txt1.setText("");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println("keyReleased..."+e.getKeyChar());
//		System.out.println("keyReleased..."+e.getKeyChar());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {

//			System.out.println("mouseClicked..." + e.getPoint());
			int offset = area1.viewToModel(e.getPoint());
//			System.out.println("mouseClicked...offset : " + offset);
			int row = area1.getLineOfOffset(offset);
//			System.out.println("mouseClicked...row : " + row);
			int startOffset = area1.getLineStartOffset(row);
			int endOffset = area1.getLineEndOffset(row);
//			System.out.printf("%d %d\n", startOffset,endOffset);
			String str = area1.getText(startOffset,endOffset-startOffset );
			System.out.println(str);
			
			
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
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

}

public class C07SwingAddDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		new C07GUI("Chatting UI");

	}

}

```

### C08Tx

```java
package Ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.DefPKCS12KeyStoreAES256;

public class C08Tx {
	// DB CONN DATA
	static String id = "root";
	static String pw = "1234";
	static String url = "jdbc:mysql://localhost:3306/testdb";

	// JDBC참조변수
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	
	public static void main(String[] args) {
		
		try {
			// DB 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB CONNECTED...");
			
			//
			System.out.println("INSERT 시작...");
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement("insert into tbl_test values('a',1,'a')");
			pstmt = conn.prepareStatement("insert into tbl_test values('b',1,'a')");
			pstmt = conn.prepareStatement("insert into tbl_test values('c',1,'a')");
			pstmt = conn.prepareStatement("insert into tbl_test values('d',1,'a')");

			
			pstmt.executeUpdate();
			conn.commit();
			System.out.println("INSERT 종료");
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
			}
		}finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
				
			}
			try {
				conn.close();
			} catch (Exception e2) {
				
			}
		}
	}
}

```

### C09분산Tx

```java
package Ch21;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.XAConnection;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

import com.mysql.cj.jdbc.MysqlXADataSource;

public class C09분산Tx {
	
	public static void main(String[] args) throws Exception{
		//트랜잭션은 기본적으로 단일 Connection 에서 여러 Sql처리시 Tx 설정할 수있다
		//만약 여러 Connection 에서 각기 다른 sql문을 사용할 때 분산된 여러 Connection
		//의 sql을 하나의 트랜잭션으로 묶어주어야한다

		
        // 첫 번째 DB1에 대한 XADataSource 설정
        MysqlXADataSource xaDataSource1 = new MysqlXADataSource();
        xaDataSource1.setUrl("jdbc:mysql://localhost:3306/bookdb");
        xaDataSource1.setUser("root");
        xaDataSource1.setPassword("1234");
        
        //생략
        MysqlXADataSource xaDataSource2 = new MysqlXADataSource();
        xaDataSource2.setUrl("jdbc:mysql://localhost:3306/testdb");
        xaDataSource2.setUser("root");
        xaDataSource2.setPassword("1234");
        
        //------------------------------------
        // XAConnection 및 Connection 가져오기
        //------------------------------------
        XAConnection xaConnection1 = xaDataSource1.getXAConnection();
        Connection conn1 = xaConnection1.getConnection();
        XAResource xaResource1 = xaConnection1.getXAResource();

        XAConnection xaConnection2 = xaDataSource2.getXAConnection();
        Connection conn2 = xaConnection2.getConnection();
        XAResource xaResource2 = xaConnection2.getXAResource();
        
        // 트랜잭션 식별자 (XID) 생성
        Xid xid1 = createXid(100, 1); // 첫 번째 DB용 XID	(100 branchId , 1 GlobalId)
        Xid xid2 = createXid(100, 2); // 두 번째 DB용 XID    

        
        try {
            // 첫 번째 DB 트랜잭션 시작
            xaResource1.start(xid1, XAResource.TMNOFLAGS);
            PreparedStatement pstmt1 = conn1.prepareStatement("insert into tbl_user values('a','1')");
            
            pstmt1.executeUpdate();
            PreparedStatement pstmt2 = conn1.prepareStatement("insert into tbl_user values('b','1')");
            pstmt2.executeUpdate();
            PreparedStatement pstmt3 = conn1.prepareStatement("insert into tbl_user values('c','1')");
            pstmt3.executeUpdate();
            xaResource1.end(xid1, XAResource.TMSUCCESS);
            

            // 두 번째 DB 트랜잭션 시작
            xaResource2.start(xid2, XAResource.TMNOFLAGS);
            PreparedStatement pstmt4 = conn2.prepareStatement("INSERT INTO tbl_std values('a','1','a')");
            pstmt4.executeUpdate();
            PreparedStatement pstmt5 = conn2.prepareStatement("INSERT INTO tbl_std values('a','2','b')");//!!!!!!!!!!!
            pstmt5.executeUpdate();
            PreparedStatement pstmt6 = conn2.prepareStatement("INSERT INTO tbl_std values('c','2','c')");
            pstmt6.executeUpdate();
            xaResource2.end(xid2, XAResource.TMSUCCESS);

            // 2-Phase Commit 준비
            int prepare1 = xaResource1.prepare(xid1);
            int prepare2 = xaResource2.prepare(xid2);

            // 커밋
            if (prepare1 == XAResource.XA_OK && prepare2 == XAResource.XA_OK) {
                xaResource1.commit(xid1, false);
                xaResource2.commit(xid2, false);
                System.out.println("Transaction committed successfully.");
            } else {
                throw new Exception("Prepare failed for one or both databases.");
            }

        } catch (Exception e) {
            // 롤백
            xaResource1.rollback(xid1);
            xaResource2.rollback(xid2);
            System.out.println("Transaction rolled back due to an error.");
            e.printStackTrace();
        } finally {
            // 자원 해제
            conn1.close();
            conn2.close();
            xaConnection1.close();
            xaConnection2.close();
        }
        //-----------
        
		
	}
	
	//----------------------------
    private static Xid createXid(int bid, int tid) {
        return new Xid() {
            private int formatId = 1;
            private byte[] branchQualifier = new byte[] { (byte) tid };
            private byte[] globalTransactionId = new byte[] { (byte) bid };

            @Override
            public int getFormatId() {
                return formatId;
            }

            @Override
            public byte[] getBranchQualifier() {
                return branchQualifier;
            }

            @Override
            public byte[] getGlobalTransactionId() {
                return globalTransactionId;
            }
        };
    }
}	

```
