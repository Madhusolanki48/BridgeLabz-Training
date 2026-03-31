package strings;
import java.util.Scanner;
public class StringIndexOutOfBoundsExceptionDemo {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter text : ");
        String text = sc.next();
        //methods created
        generateStringIndexException(text);
        handleStringIndexException(text);
    }
    //method to generate StringIndexOutOfBounds Exception
    public static void generateStringIndexException(String text) {
        // access invalid index
        System.out.println(text.charAt(text.length())); // exception 
    }

    //method to handle StringIndexOutOfBounds Exception
    public static void handleStringIndexException(String text) {
        try {
            //code containing exception
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Successfully handled StringIndexOutOfBoundsException !"+e.getMessage());
        }
    }
}
