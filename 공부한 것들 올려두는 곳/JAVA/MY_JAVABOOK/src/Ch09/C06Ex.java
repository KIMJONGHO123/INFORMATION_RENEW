package Ch09;

import java.util.Arrays;

class Profile{
	//속성
	String name;
	String addr;
	String job;
	String major;
	//생성자
	//1)디폴트생성자 삽입
	//2)모든 인자 받는 생성자 삽입 -> 각멤버에 대입
	//3)모든 인자 받는 생성자 삽입(가변인자사용할것) -> , 를기준으로 잘라내어 각속성에 저장
	//ex, "홍길동,대구,프로그래머,컴퓨터공학" ->[홍길동,대구,프로그래머,컴퓨터공학]
	
	public Profile() {
	}
	public Profile(String name, String addr, String job, String major) {
		this.name = name;
		this.addr = addr;
		this.job = job;
		this.major = major;
		
	}
	
	public Profile(String ...dumy) { // 가변인자 사용
		
		this.name = dumy[0];
		this.addr = dumy[1];
		this.job = dumy[2];
		this.major = dumy[3];
	}
	
	public Profile(String all) {  // 문자열로 받아와서 split으로 잘라 배열에 저장
		String [] arr = all.split(",");
		this.name = arr[0];
		this.addr = arr[1];
		this.job = arr[2];
		this.major = arr[3];
	}
	//기능
	//1) getter and setter 삽입
	//2) toString  재정의 
	//3) boolean isContain(String findstr) 함수 완성하기

	
	// getter
	public String getName() {
		return this.name;
	}
	public String getAddr() {
		return this.addr;
	}
	public String getJob() {
		return this.job;
	}
	public String getMajor() {
		return this.major;
	}
	
	// setter
	
	public String setName(String name) {
		return this.name = name;
	}
	public String setAddr(String addr) {
		return this.addr = addr;
	}
	public String setJob(String job) {
		return this.job = job;
	}
	public String setMajor(String major) {
		return this.major = major;
	}
	
	// toString 재정의

	@Override
	public String toString() {
		return "Profile [name=" + name + ", addr=" + addr + ", job=" + job + ", major=" + major + "]";
	}
	
	
	boolean isContain(String findstr) {
	//findstr의 문자열이 각멤버인 name,addr,job,major 중 하나라도 포함되어 있으면 true 리턴
	//아니면 false 리턴
		if (this.name.contains(findstr)) {
			return true;
		}else if(this.addr.contains(findstr)) {
			return true;
		}else if(this.job.contains(findstr)) {
			return true;
		}else if(this.major.contains(findstr)){
			return true;
		}else {
			return false;
		}
		
}
	
	
 
	//4)
	boolean isEquals(String str) {
		//all로 받은 문자열을 , 단위로 잘라내어(split(",")) 각각 나눠진 문자열이
		//name,addr,job,major 와 일치 하면 true
		//아니면 false 를 리턴
		String arr2[] = str.split(",");
		if (arr2[0].equals(this.name)&&
			arr2[1].equals(this.addr)&&
			arr2[2].equals(this.job)&&
			arr2[3].equals(this.major)) {
			
			return true;
		}
		else {
			return false;
		}
	}
	
}
public class C06Ex {

	public static void main(String[] args) {
		Profile hong = new Profile("홍길동,대구,프로그래머,컴퓨터공학");
//		System.out.println(hong.toString());
		System.out.println("길동 포함여부 : " + hong.isContain("길동"));	//true
		System.out.println("컴퓨터 포함여부 : " + hong.isContain("컴퓨터"));	//true
		System.out.println("프로필 일치여부 : " + hong.isEquals("홍길동,대구,프로그래머,컴퓨터공학"));//false
		System.out.println("프로필 일치여부 : " + hong.isEquals("홍길동,울산,프로그래머,컴퓨터공학"));//false

	}

}
