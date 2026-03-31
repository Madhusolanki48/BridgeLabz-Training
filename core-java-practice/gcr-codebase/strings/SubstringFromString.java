package strings;
import java.util.Scanner;
public class SubstringFromString {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//taking input from the user
		System.out.print("Enter a string : ");
        String str = sc.next();
        System.out.print("Enter start index: ");
        int startIndex = sc.nextInt();
        System.out.print("Enter end index: ");
        int endIndex = sc.nextInt();
     
        //create substring using charAt() method
        String subStringUsingCharAt= createSubStringUsingCharAt (str,startIndex,endIndex);
        //create substring using .substring() method
        String subStringUsingBuiltIn= str.substring (startIndex,endIndex);
        //compare both substrings
        boolean result= compareStringsUsingCharAt (subStringUsingCharAt,subStringUsingBuiltIn);
        //print output
        System.out.println("Substring created using CharAt() : "+subStringUsingCharAt);
        System.out.println("Substring created using built-in method i.e. substring() : "+subStringUsingBuiltIn);
        System.out.print("The substrings are same ? "+result);
        
        
	}
	//method to create substring using charAt
	public static String createSubStringUsingCharAt(String str, int startIndex,int endIndex) {
		String result="";
		for(int i=startIndex;i< endIndex;i++) {
			result+=str.charAt(i);
		}
		return result;
		
	}
	//method to compare substrings
	public static boolean compareStringsUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {  //checking length of both strings
            return false;
        }

        // compare each character
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i))
                return false;
        }

        return true;
	}

}
