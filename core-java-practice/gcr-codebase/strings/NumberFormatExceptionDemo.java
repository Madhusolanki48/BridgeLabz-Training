package strings;
import java.util.Scanner;
public class NumberFormatExceptionDemo {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text : ");
        String text = sc.next();
        //methods created
        generateNumberFormatException(text);
        handleNumberFormatException(text);
    }

    //method to generate exception
    public static void generateNumberFormatException(String text) {
    	 //convert string to integer
        int number = Integer.parseInt(text);
        System.out.println(number);   //exception if string is not numeric
    }

    //method to handle exception
    public static void handleNumberFormatException(String text) {
        try { //code containing exception
            int number = Integer.parseInt(text);
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled !"+e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException handled !"+e.getMessage());
        }
    }

}
