package extras;
import java.util.Scanner;
public class ToggleCaseOfCharacters {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter a String : ");
		String str=sc.nextLine();
		//method call
		String result=toggleCase(str);
		//print output
		System.out.print("String after Toggle Case : "+result);
	}
	//method to toggle the case of each character in a given string.
	public static String toggleCase(String s) {
		String result="";
		char[] charArray=s.toCharArray();
		for(char ch:charArray) {
			if(Character.isUpperCase(ch)) {
				result+=Character.toLowerCase(ch);
			}else {
				result+=Character.toUpperCase(ch);
			}
		}
		return result;
	}

}