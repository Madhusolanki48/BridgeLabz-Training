package Review2;
import java.util.*;

public class ArithmethicException{
	public static void main(String[] args) {
		try {
			int a=10,b=0;
			int result=a/b;
			System.out.println("Result: "+result);
		}
		//for arithmetic exception
		catch(ArithmeticException e) {
			System.out.println("Error detected: "+e);	
		}
		//for any other exception
		catch(Exception e) {
			System.out.println("Any other exception: "+e);
		}
		finally {
			System.out.println("It will always exectuted!");
		}
	}

}
