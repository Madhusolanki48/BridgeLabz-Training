package strings;
import java.util.Scanner;
public class AllCharactersInString {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//taking input string
		System.out.print("Enter text : ");
		String text=sc.next();
		//get characters using charAt method
		char[] arr1=getCharacterUsingCharAt(text);
		//get characters using built-in method
		char[] arr2=text.toCharArray();
		//compare both character arrays
		boolean result=compareCharArrays(arr1,arr2);
		//print output
		System.out.print("Both the arrays are same ? : "+result);
	}
	//method to get characters using charAt
	public static char[] getCharacterUsingCharAt(String str) {
		char[] charactersArray=new char[str.length()];
		for(int i=0;i<str.length();i++) {
			charactersArray[i]=str.charAt(i);
		}
		return charactersArray;
	}
	//method to compare two character arrays
	public static boolean compareCharArrays(char[] a1,char[] a2) {
		if(a1.length!=a2.length) { //checking the length of arrays
			return false;	
		}
		for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i])
            	return false;
        }
        return true;	
	}

}
