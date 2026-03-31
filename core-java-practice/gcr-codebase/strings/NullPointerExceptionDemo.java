 package strings;
 
public class NullPointerExceptionDemo {
	public static void main(String[] args) {
		//methods created
		generateNullPointerException();
		handleNullPointerException();
	}
	//method to generate NullPointer exception
	public static void generateNullPointerException() {
		String text=null;
		//access method on null reference
		System.out.println(text.length());  //exception
	}
	//method to handle exception
	public static void handleNullPointerException() {
		try {
			String text=null;
			//code containing exception
			System.out.println(text.length());
		} catch(NullPointerException e) {
			System.out.println("Successfully handled NullPointer Exception !"+e.getMessage());
		}
	}
}
