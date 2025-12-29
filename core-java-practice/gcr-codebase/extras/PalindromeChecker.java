package extras;
import java.util.Scanner;
public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input 
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        //method calling
        boolean result = isPalindromeString(str);
        //print output
        System.out.println(result ? "It is a Palindrome String ! " : "It is not a Palindrome String !");
    }

    //method to check palindrome
    static boolean isPalindromeString(String str) {
        String reversedString = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(reversedString);
    }
}
