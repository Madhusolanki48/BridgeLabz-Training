package extras;
import java.util.Scanner;
public class SubstringOccurencesCount {
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	//user input
	System.out.print("Enter a String : ");
	String str=sc.nextLine();
	System.out.print("Enter a Substring : ");
	String substring=sc.nextLine();
	//method call
	int result=countSubStringOccurences(str,substring);
	//print output
	System.out.println("Substring occurrences count in the given String : "+result);
	}
	//method to count how many times a given substring occurs in a string.
	public static int countSubStringOccurences(String string,String subString) {
		int count=0;
		for(int i=0;i<=string.length()-subString.length();i++) {
			if(string.substring(i,i+subString.length()).equals(subString)) {
				count++;
			}
		}
		return count;
	}

}
