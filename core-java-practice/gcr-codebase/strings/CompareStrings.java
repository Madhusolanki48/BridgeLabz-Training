package strings;
import java.util.Scanner;
public class CompareStrings {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//strings input from the user
		System.out.print("Enter first string : ");
		String string1=sc.next();
		System.out.print("Enter second string : ");
		String string2=sc.next();
		//compare using charAt() method
		boolean resultUsingCharAt=compareStringsUsingCharAt(string1,string2);
		//compare using equals method
		boolean resultUsingEquals=string1.equals(string2);
		//print output
		System.out.println("The strings are equal using CharAt : "+resultUsingCharAt);
		System.out.print("The strings are equal using equals : "+resultUsingEquals);
		
	}
		//method to compare strings using charAt()
		public static boolean compareStringsUsingCharAt(String str1, String str2) {
			if(str1.length()!=str2.length()) {  //checking length of both strings
				return false;	
			}
			for(int i=0;i<str1.length();i++) {
				if(str1.charAt(i)!=str2.charAt(i)) {
					return false;
				}
			}
			return true;
		
	}
	

}
