package methods;
import java.util.Scanner;
public class IsPositiveNegativeZero {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter a number : ");
		int number=sc.nextInt();
		//method call
		int result= checkNumber(number);
		//print output
		if(result==-1) {
			System.out.print("Number is a Negative Number !");
		}
		else if(result==1) {
			System.out.print("Number is a Positive Number !");
		}
		else {
			System.out.print("Number is Zero !");	
		}
		
	}
	//method to determine if a number is positive, negative or zero
	public static int checkNumber(int number) {
		if(number<0)  //checking negative number
			return -1;
		if(number>0)  //checking positive number
			return 1;
		return 0;
	}

}
