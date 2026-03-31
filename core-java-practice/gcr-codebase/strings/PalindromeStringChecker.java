package extras;
import java.util.Scanner;
public class PalindromeStringChecker {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter a String : ");
		String str=sc.nextLine();
		//method call
		boolean result=isPalindromeString(str);
		//print output
		System.out.print("Is the string Palindrome ? : "+result);
	}
	//method to check if string is a palindrome or not 
	public static boolean isPalindromeString(String s) {
		int i=0;
		int j=s.length()-1;
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
