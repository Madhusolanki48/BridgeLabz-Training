package exceptions;
import java.util.Scanner;

public class ThrowVsThrows {
	public static double calculateInterest(double amount, double rate, int years) 
		throws IllegalArgumentException{
			if (amount<0 || rate<0) {   //given
				throw new IllegalArgumentException();
			}
			return (amount*rate*years)/100;  //interest calculation
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			//user input
			System.out.print("Enter Amount: ");
			int amount=sc.nextInt();
			System.out.print("Enter Rate of Interest: ");
			int rate=sc.nextInt();
			System.out.print("Enter years: ");
			int years=sc.nextInt();
			//method calling
			double interest = calculateInterest(amount,rate,years);
			System.out.print("Interest Calculated: "+interest);
		}
		catch(IllegalArgumentException e) {  
			System.out.println("Invalid input: Amount and rate must be positive.");
		}
		
	}

}
