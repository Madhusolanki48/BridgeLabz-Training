package extras;
import java.util.Scanner;
public class RemoveDuplicatesFromString {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter a String : ");
		String str=sc.nextLine();
		//method calling
		String result=removeDuplicatesFromString(str);
		System.out.print("The modified string without duplicates : "+result);
	}
	//method to remove duplicates from a string
	public static String removeDuplicatesFromString(String s) {
		String result="";
		for(char ch:s.toCharArray()) {
			if(result.indexOf(ch)==-1) {
				result+=ch;
			}
		}
		return result;
	}

}
