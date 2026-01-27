package exceptions;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			//user inputs
			System.out.print("Enter Number1: ");
			int a=sc.nextInt();
			System.out.print("Enter Number2: ");
			int b=sc.nextInt();
			int result=a/b;
			System.out.println("a/b = "+result);
		}
		catch(ArithmeticException e) {
			//handles arithmetic exception, if user enters zero as denominator
			System.out.println("Cannot divide by zero!");
			
		}
		catch (InputMismatchException e) {
			//handles non-numeric inputs
			System.out.println("Invalid Input!");
		}
	}

}
