package Ch13;

import java.util.Scanner;

interface Remocon{
	int Max_Vol = 100;   // public static final
	int Min_Vol = 0;     // public static final
	
	void setVolumn(int vol);
	// TV, Radio 각각 메서드를 완성시켜주세요
	// MAX_VOL / MIN_VOL 을 적용해서 각각최대볼륨 최소볼륨을 제한해주세요 -!
	// 구현하는 클래스에서 외부로부터 받는 vol을 저장할 멤버변수(vol)을 지정해주세요.
	// vol 값이 100을 초과할때는 최대볼륨값으로 적용(print : 최대볼륨으로 설정합니다.)
	// vol 값이 0미만일떄는 최소볼륨값으로 적용(print : 최소볼륨으로 설정합니다.)
	//0<=vol<=100 사이이면 멤버변수 vol에 저장해주시고 현재볼륨을 출력해줍니다.(print : 현재볼륨 :n)
	void PowerOn();
	void PowerOff();
	
}

interface Browser{
	void SearchURL(String url);
}

class Tv implements Remocon{
	int vol;
	
	
	public Tv() {
		
	}
	
	@Override
	public void PowerOn() {
		// TODO Auto-generated method stub
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void PowerOff() {
		// TODO Auto-generated method stub
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void setVolumn(int vol) {
		// TODO Auto-generated method stub
		if (vol>100) {
			vol = Max_Vol;
			System.out.println("최대볼륨으로 설정합니다.");
		}else if(vol<0) {
			vol = Min_Vol;
			System.out.println("최소볼륨으로 설정합니다.");
		}else {
			this.vol = vol;
			System.out.println("현재볼륨 : "+this.vol);
		}
	}

	@Override
	public String toString() {
		return "Tv";
	}

}

class SmartTv extends Tv implements Browser{

	@Override
	public void SearchURL(String url) {
		// TODO Auto-generated method stub
		System.out.println(url + "로 이동합니다.");
	}
	
}

class Radio implements Remocon{
	int vol;
	
	public Radio() {
		
	}
	

	@Override
	public void PowerOn() {
		// TODO Auto-generated method stub
		System.out.println("Radio를 켭니다.");
	}

	@Override
	public void PowerOff() {
		// TODO Auto-generated method stub
		System.out.println("Radio를 끕니다.");
	}

	@Override
	public void setVolumn(int vol) {
		// TODO Auto-generated method stub
		if (vol>100) {
			vol = Max_Vol;
			System.out.println("최대볼륨으로 설정합니다.");
		}else if(vol<0) {
			vol = Min_Vol;
			System.out.println("최소볼륨으로 설정합니다.");
		}else {
			this.vol = vol;
			System.out.println("현재볼륨 : "+this.vol);
		}
	}
	
	@Override
	public String toString() {
		return "radio";
	}
	
}

public class C03InterfaceMain {
	public static void TurnOn(Remocon controller) {
		controller.PowerOn();
	}
	public static void TurnOff(Remocon controller) {
		controller.PowerOff();
	}
	public static void Volume(Remocon controller) {
		Scanner input = new Scanner(System.in);
		System.out.print(controller +"볼륨을 입력하세요 ");
		controller.setVolumn(input.nextInt());
	}
	public static void Internet(Browser browser, String url) {
		browser.SearchURL(url);
	}
	
	public static void main(String[] args) {
		Tv tv1 = new Tv();
		
		Radio radio1 = new Radio();
		
		SmartTv smartTv = new SmartTv();
		
		
		TurnOn(tv1);
		TurnOff(radio1);
		TurnOn(smartTv);
		System.out.println("-------------------------");
		
		Volume(tv1);
		Volume(tv1);
		Volume(radio1);
		Volume(radio1);
		
		System.out.println("-----------------------------");
		
		Internet(smartTv,"www.naver.com");
	
	}
}
