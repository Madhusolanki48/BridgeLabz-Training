package strings;
import java.util.Scanner;
public class ArrayIndexOutOfBoundsExceptionDemo {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Enter the array size i.e. number of names to be entered : ");
	    int n=sc.nextInt();
	    //array for names
	    String[] names = new String[n];
	    System.out.print("Enter the names : ");
	    //input array values
	    for (int i = 0; i < names.length; i++) {
	        names[i] = sc.next();
	    }
	    //methods created
	    generateArrayIndexException(names);
	    handleArrayIndexException(names);
	}
	// method to generate ArrayIndexOutOfBoundsException
	public static void generateArrayIndexException(String[] names) {
	    // access invalid index
	    System.out.println(names[5]); // exception
	}
	// method to handle ArrayIndexOutOfBoundsException
	public static void handleArrayIndexException(String[] names) {
	    try {  //code containing exception
	        System.out.println(names[5]);
	    } catch (ArrayIndexOutOfBoundsException e) {
	        System.out.println("ArrayIndexOutOfBoundsException handled !"+e.getMessage());
	    } catch (RuntimeException e) {
	        System.out.println("Generic RuntimeException handled !"+e.getMessage());
	    }
	}


}
