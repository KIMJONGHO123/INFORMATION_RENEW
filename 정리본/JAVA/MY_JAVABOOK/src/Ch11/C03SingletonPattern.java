package Ch11;

class Company{
	
	// 싱글톤 패턴 구조
	private static Company instance;
	private Company() {}
	public static Company getInstance() {
		if (instance==null) {
			instance = new Company();
		}
		return instance;
		
	}
}

public class C03SingletonPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Company com1 = Company.getInstance();
		Company com2 = Company.getInstance();
	}

}
