package Ch19;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.UUID;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class C10JsoupMain {
	public static void main(String[] args) throws IOException, URISyntaxException {
		// Maven repository에 들어가서 jsoup 검색 맨위에꺼 클릭 
		// verson - 1.19.1 클릭 후 들어가서 jar 클릭하면 다운로드된다.
		// 다운 후 해당 파일을 패키지 안으로 넣는다.
		// 넣은 후 JAVABOOK 우클릭 후 Properties 누른 후 Java Build Path 클릭
		// Library 클릭 후 Classpath 누른 후 addjars 클릭 후 해당 패키지 선택
		Connection conn = Jsoup.connect("https://www.op.gg/champions");
		
		Document document = conn.get();
		//System.out.println(document);
		
		Elements elements = document.getElementsByTag("img");
		//System.out.println(elements);
		
		for (Element el : elements) {
			//System.out.println(el);
			try {
			String img_url = el.getElementsByAttribute("src").attr("src");
			System.out.println(img_url);
			
			URL url =  (new URI(img_url)).toURL();
			InputStream in = url.openStream();
			BufferedInputStream buffIn = new BufferedInputStream(in); // 버퍼공간 추가
			
			OutputStream out = null;
			
			if (img_url.contains(".png")) {
				out = new FileOutputStream("C:\\IOTEST\\"+UUID.randomUUID()+".png");	
			}else if(img_url.contains(".svg")) {
				out = new FileOutputStream("C:\\IOTEST\\"+UUID.randomUUID()+".svg");	
			}else if(img_url.contains(".webp")) {
				out = new FileOutputStream("C:\\IOTEST\\"+UUID.randomUUID()+".webp");	
			}else {
				out = new FileOutputStream("C:\\IOTEST\\"+UUID.randomUUID()+".jpg");	
			}
			
			
			while(true) {
				int data = buffIn.read();
				if(data ==-1) {
					break;
				}
				out.write((byte)data);
				out.flush();
			}
			out.close();
			buffIn.close();
			in.close();
			}catch(Exception e){
				
			}
		}
			
	}
}
