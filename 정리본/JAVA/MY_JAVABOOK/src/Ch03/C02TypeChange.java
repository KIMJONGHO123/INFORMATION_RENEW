package Ch03;

public class C02TypeChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// 강제 형변환 // (큰 곳 -> 작은 곳)
		// 좁은 범위공간에 큰값을 넣을려고 하는 경우
		// 기본적으로 부락능하기 때문에 강제로 자료형을 바꾸어 전달한다.
		// 데이터 손실의 염려가 있다.
		 
		int intValue = 44032;
		char charValue = (char)intValue; // 44032가 char형으로 강제형변환된다.
		System.out.println((int)charValue); // 출력할때는 다시 int형으로 형변환해서 원래대로 출력
		
		long longValue =  500;
		intValue = (int)longValue; // long 을 int로 강제 형변환을 하면 데이터 손실이 생길 수도 있다. 근데 여기서는 숫자가 500이기때문에 데이터 손실이 생기지 않는다. 
		System.out.println(intValue);
		
		// 데이터 손실
		double doubleValue = 3.14;
		intValue  = (int)doubleValue; // double 형을 int형으로 강제 형변환을 하면 뒤에 소수점은 다 날라간다.
		System.out.println(intValue);
	}

}
