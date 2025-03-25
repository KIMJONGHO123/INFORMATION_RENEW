package Ch15;


public class C04ExceptionMain {
	public static void main(String[] args) {
		String str = null;
		try {
			str.toString(); // Null 예외 발생
			
			int arr[] = {10,20,30};
			arr[5] = 100; // Bound Exception 발생
			
			Integer.parseInt("a1234"); // Parse Exception 발생
			
			Animal animal = new Dog();
			Cat yummi = (Cat)animal;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
//		catch (NullPointerException e) {
//			System.out.println(e.getMessage()+1);
//			
//		}catch (ArrayIndexOutOfBoundsException e2) {
//			System.out.println(e2.getMessage()+2);
//		}catch (NumberFormatException e3) {
//			System.out.println(e3.getMessage()+3);
//		}catch (ClassCastException e4) {
//			System.out.println(e4.getMessage()+4);
//		}
		
		finally {
			System.out.println("Finally..test");
		}

	}
}
