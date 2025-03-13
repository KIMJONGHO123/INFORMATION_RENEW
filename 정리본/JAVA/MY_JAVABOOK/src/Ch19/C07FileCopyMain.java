package Ch19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class C07FileCopyMain {
	public static void main(String[] args) throws Exception{
		InputStream in = new FileInputStream("C:\\IOTEST\\video.mp4");
		OutputStream out =new FileOutputStream("C:\\IOTEST\\video_복사본");
		
		
		// 01 버퍼미사용
//		while (true) {
//			int data = in.read();
//			if(data == -1) {
//				break;
//			}
//			out.write((byte)data);
//			out.flush(); // flush()를 호출하면 강제적으로 데이터가 기록됨: 버퍼에 남아 있는 
//						 //데이터를 강제로 내보내서 파일에 저장하게 합니다. => 버퍼링 떄문에 사용
//			
//		}
//		out.close();
//		in.close();
		
		// 02 버퍼사용
		byte [] buff = new byte[4096];
		System.out.println("진행중");
		while (true) {
			int data = in.read(buff);
			if(data == -1) {
				break;
			}
			out.write(buff, 0, data);;
			out.flush(); // flush()를 호출하면 강제적으로 데이터가 기록됨: 버퍼에 남아 있는 
						 //데이터를 강제로 내보내서 파일에 저장하게 합니다. => 버퍼링 떄문에 사용
			
		}
		out.close();
		in.close();
		System.out.println("끝");
		
		
		
	}
}
