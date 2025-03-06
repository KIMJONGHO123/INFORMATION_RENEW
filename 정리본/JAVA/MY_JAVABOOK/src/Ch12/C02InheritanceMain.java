package Ch12;


class Point2D{
	int x;
	int y;
	
	Point2D(){
		System.out.println("Point2D 디폴트 생성자 호출!");
	}
	
	Point2D(int x){
		this.x = x;
		System.out.println("Point2D (int x) 생성자 호출!");
	}
	
	Point2D(int x, int y){
		this.x = y;
		this.y = y;
		System.out.println("Point2D (int x, int y) 생성자 호출!");
	}
}

class Point3D extends Point2D{
	int z;

	Point3D(){
		System.out.println("Point3D 디폴트 생성자 호출!");
	}
	
	Point3D(int x){
		super(x); // 상위 클래스 Point2d(int x) 생성자 호출
		this.x = x;
	}
	
	Point3D(int x, int y){
		super(x,y);
		System.out.println("Point3D(int x, int y) 생성자 호출!");
		
	}
	
	Point3D(int x, int y, int z){
		super(x,y);
		this.z = z;
		System.out.println("Point3D(int x, int y, int z) 생성자 호출!");
		
	}
	
	@Override
	public String toString() {
		return "Point3D [z=" + z + ", x=" + x + ", y=" + y + "]";
	}
	
	
}


public class C02InheritanceMain {
	
	public static void main(String[] args) {
		Point3D ob1 = new Point3D(10,20,30);
		System.out.println(ob1);
	}
	

}
