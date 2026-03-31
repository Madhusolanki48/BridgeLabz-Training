package stringbuilder_stringbuffer;
import java.util.*;
//StringBuffer Problem 1: Concatenate Strings Efficiently Using StringBuffer

public class ConcatenateStrings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//user input
		System.out.print("Enter the length of the String Array: ");
		int n = sc.nextInt();
		//array input
		String[] stringArray = new String[n];
		System.out.print("Enter Strings for a String Array: ");
		for (int i = 0; i < n; i++) {
			stringArray[i] = sc.next();
		}
		String concatenatedString = concatenateString(stringArray);
		System.out.println("Concatenated String : " + concatenateString(stringArray));
	}

	public static String concatenateString(String[] strArray) {
		//StringBuffer object
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strArray.length; i++) {
			sb.append(strArray[i]);
			sb.append(" ");
		}
		return sb.toString();
	}

}
