package strings;
import java.util.Scanner;
public class IllegalArgumentExceptionDemo {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text : ");
        String text= sc.next();
        //methods created
        generateIllegalArgumentException(text);
        handleIllegalArgumentException(text);
    }

    //method to generate exception
    public static void generateIllegalArgumentException(String text) {
        System.out.println(text.substring(4, 2)); // startIndex > endIndex
    }

    //method to handle exception
    public static void handleIllegalArgumentException(String text) {
        try { //code containing exception
            System.out.println(text.substring(4, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled !"+e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException handled !"+e.getMessage());
        }
    }

}
