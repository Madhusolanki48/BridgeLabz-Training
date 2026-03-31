package extras;
import java.util.Scanner;
public class LexicographicalOrderOfStrings {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter a String1 : ");
		String str1=sc.nextLine();
		System.out.print("Enter a String2 : ");
		String str2=sc.nextLine();
		//method call
		lexicographicalOrder(str1,str2);
	}
	//method to compare two strings lexicographically without using built-in compare methods.
	public static void lexicographicalOrder(String str1,String str2) {
		int len = Math.min(str1.length(), str2.length());
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (str1.charAt(i) < str2.charAt(i))
                    System.out.println(str1 + " comes before " + str2+" in lexicographical order.");
                else
                    System.out.println(str2 + " comes before " + str1+" in lexicographical order.");
                return;
            }
        }
        if (str1.length() == str2.length())
            System.out.println("Both strings are equal in lexicographical order.");
        else if (str1.length() < str2.length())
            System.out.println(str1 + " comes before " + str2+" in lexicographical order.");
        else
            System.out.println(str2 + " comes before " + str1+" in lexicographical order.");
    }

}
