package methods;
import java.util.Scanner;
public class QuotientNRemainder {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter a number : ");
		int number=sc.nextInt();
		System.out.print("Enter a divisor : ");
		int divisor=sc.nextInt();
		//method call
		int[] result=findRemainderAndQuotient(number,divisor);
		//print output
		System.out.println("The Quotient is : "+result[0]);
		System.out.print("The Remainder is : "+result[1]);
	}
	//method to find the reminder and the quotient of a number 
	public static int[] findRemainderAndQuotient(int number, int divisor) {
		int quotient=number/divisor;  //--using / operator
		int remainder=number%divisor; //--using % operator
		int[] result= {quotient,remainder};
		return result;
	}
}
