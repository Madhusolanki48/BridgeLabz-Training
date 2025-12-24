package reviews;
import java.util.Scanner;
public class IsPalindromeNumber{
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		//taking user input
		System.out.print("Enter a number : ");
		int  number=sc.nextInt();
		int originalNumber=0;
		int reverseNumber=0;
		//reverse number logic 
		while(originalNumber!=0){
			int remaining=originalNumber/10;
			int digit=originalNumber%10;
			reverseNumber=10*digit+remaining;
		}
		if(originalNumber==reverseNumber){
			System.out.print(number+" is a palindrome number !");
		}
		else{
			System.out.print(number+" is not a palindrome number !");
		}
	}

}
