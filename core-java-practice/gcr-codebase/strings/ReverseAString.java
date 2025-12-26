package extras;
import java.util.*;
public class ReverseAString {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter a String : ");
		String string=sc.nextLine();
		//method call
		String revString=reverseString(string);
		//print output
		System.out.println("Reversed string : "+revString);
	}
	//method to reverse string
	public static String reverseString(String str) {
		String reversedString=new String();
		int i=str.length()-1;
		while(i>=0) {
			reversedString+=str.charAt(i);
			i--;
		}
		return reversedString;
	}
}