package extras;
import java.util.Scanner;
public class RemoveCharacterFromString {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter a String : ");
		String str=sc.nextLine();
		System.out.print("Enter character to be removed : ");
		char ch=sc.next().charAt(0);
		//method call
		String result=removeCharacter(str,ch);
		//print output
		System.out.print("Modified string : "+result);
		
	}
	//method to remove a specific character from the string 
	public static String removeCharacter(String str,char ch) {
		String result = "";
        for (char c : str.toCharArray())
            if (c != ch)
            	result += c;
        return result;
    }
}
