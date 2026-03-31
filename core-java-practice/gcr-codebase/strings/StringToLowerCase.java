package strings;
import java.util.Scanner;
public class StringToLowerCase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	     System.out.print("Enter text: ");
	     String text = sc.nextLine();
	     //convert using method created
	     String conversionUsingCharAt = convertToLowerCase(text);
	     //convert using built-in method
	     String conversionUsingBuiltIn = text.toLowerCase();
	     //compare both results
	     boolean result = compareStrings(conversionUsingCharAt, conversionUsingBuiltIn);
         //print output
	     System.out.println("Text in lower case using method created : " + conversionUsingCharAt );
	     System.out.println("Text in lower case using built-in method : " + conversionUsingBuiltIn);
	     System.out.println("Are both the texts in lowercase are same ? " + result);
	     }
	//method to convert string to lowercase using charAt
	public static String convertToLowerCase(String text) {
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			//check uppercase character
			if (ch >= 'A' && ch <= 'Z') {
				result += (char) (ch + 32);  //convert to lowercase
				} else {
					result += ch;
	            }
	        }
		return result;
	    }
	//method to compare two strings using charAt
	public static boolean compareStrings(String s1, String s2) {
		if (s1.length() != s2.length())   //checking length
			return false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) 
				return false;
			}
		return true;
	    }

}
