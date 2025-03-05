package Ch08;

import java.util.Scanner;

import javax.security.sasl.RealmCallback;

//class TV{
//	String brand;
//	int leaseYear;
//	int size;
//	
//	TV(String Brand, int makeYear, int size){
//		this.brand = Brand;
//		this.leaseYear = makeYear;
//		this.size = size;
//		
//	}
//	
//	public void show() {
//		System.out.printf("%s에서 만든 %d년 %d인치 TV",this.brand,this.leaseYear,this.size);
//	}
//}

//class Grade{
//	int mathScore;
//	int scienceScore;
//	int englishScore;
//	
//	Grade(int math, int science, int english){
//		mathScore=math;  // 멤버변수와 생성자의 매개변수의 이름이 달라서 this 안써도 된다.
//		scienceScore= science;
//		englishScore=english;
//	}
//	
//	public double average(){
//		double avg = (mathScore + scienceScore + englishScore)/3.0;
//		return avg;
//	}
//}

class Song{
	String title;
	String artist;
	int year;
	String country;
	
	Song(){
		this("title","artist",0000,"country");
	}
	Song(String SongTitle, String SongArtist, int releaseYear, String CountryName){
		title = SongTitle;
		artist = SongArtist;
		year = releaseYear;
		country = CountryName;
	}
	
	public void show() {
		System.out.printf("%d년 %s국적의 %s가 부른 %s\n",year,country,artist,title);
	}
}

public class C09Ex {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		//package Ch08Ex;
		//
		//public class C00문제 {
//			--------------------------------------------
//			문제 - 이것이자바다
//			--------------------------------------------
//			https://scksk.tistory.com/6
		//

//     1번
//	   TV myTV = new TV("LG", 2017, 32); //LG에서 만든 2017년 32인치
//	   myTV.show();
	   
//	   2번
//	   Scanner sc = new Scanner(System.in);
//	   
//	   System.out.print("수학, 과학, 영어 순으로 3개의 정수 입력 >> ");
//	   int math = sc.nextInt();
//	   int science = sc.nextInt();
//	   int english = sc.nextInt();
//	   Grade me = new Grade(math, science, english);
//	   System.out.println("평균은 "+me.average()); // average()는 평균을 계산하여 리턴
//	   
//	   sc.close();
	   
//	   3번
	   Song song1 = new Song();
	   song1.show();
		
	   Song song2 = new Song("Dancing Queen","ABBA",1978,"스웨덴");
       song2.show();
	   
//     LG에서 만든 2017년형 32인치 TV

//			12번-16번 확인하기
		//
//			--------------------------------------------
//			--추가(명품자바)
//			--------------------------------------------
//			https://security-nanglam.tistory.com/213
		//
		//
//			--------------------------------------------
//			--추가
//			--------------------------------------------
//			https://iu-corner.tistory.com/entry/JAVA-%EC%9E%90%EB%B0%94-%ED%81%B4%EB%9E%98%EC%8A%A4-%EC%97%B0%EC%8A%B5-%EB%AC%B8%EC%A0%9C-%EB%AA%A8%EC%9D%8C-1
		//
	}
}
	



