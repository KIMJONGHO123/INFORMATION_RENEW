package Ch14;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class C07LocalDateTimeFormatMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("YYYY/MM/DD 입력 : ");
		String ymd = sc.next();
		
		// 입력용 포메터
		DateTimeFormatter imputFormatter  = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		// 문자열을 LocalDate로 변환
		LocalDate date = LocalDate.parse(ymd,imputFormatter);
		System.out.println("입력된 날짜 : "+date);
		
		// 출력용 포메터
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy~MM~dd");
		
		// 포멧 변경 후 출력
		System.out.println("변환된 날짜 : "+ date.format(outputFormatter));
		
		sc.close();
				
	}

}
