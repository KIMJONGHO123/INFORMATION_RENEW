package Ch34;

@CustomAnnotation(value="HELLO WORLD",number=5,isOpen=true)
class Simple{
	String v1;
	int v2;
	
	Simple(){
		CustomAnnotation ref = this.getClass().getAnnotation(CustomAnnotation.class);
		System.out.println("value : "+ref.value());
		System.out.println("number : " +ref.number());
		System.out.println("number : "+ ref.isOpen());
		this.v1 = ref.value();
		this.v2 = ref.number();
	}
	

	@Override
	public String toString() {
		return "Simple [v2=" + v2 + "]";
	}
	
	
}
public class Main {
	public static void main(String[] args) {
		Simple s =new Simple();
		s.toString();
	}
}
