package exceptions;
import java.util.Scanner;

public class FinallyBlockExecution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
		//user input
		System.out.print("Enter Number1: ");
		int a=sc.nextInt();
		System.out.print("Enter Number2: ");
		int b=sc.nextInt();
		int result=a/b;
		//print output
		System.out.println("a/b = "+result);
		}
		catch(ArithmeticException e) {
			System.out.println("Cannot divide by Zero!");
		}
		finally {  //always execute
			System.out.println("Operation Completed!");
		}
	}

}
