package leet_code_codebase;
import java.util.Scanner;
//Check whether a given string is a palindrome by ignoring spaces, special characters, and case.
public class ValidPalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //take user input 
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        //method call
        boolean result = isPalindrome(s);
        //print result
        if (result) {
            System.out.println("The given string is a Palindrome string !");
        } else {
            System.out.println("The given string is not a palindrome string !");
        }
    }
    static boolean isPalindrome(String s) {
        int i = 0;                  // start 
        int j = s.length() - 1;     // end
        while (i < j) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            //skip non-alphanumeric characters from left
            if (!Character.isLetterOrDigit(left)) {
                i++;
                continue;
            }
            //skip non-alphanumeric characters from right
            if (!Character.isLetterOrDigit(right)) {
                j--;
                continue;
            }
            //compare characters after converting to lowercase
            if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            }
            i++;
            j--;
        }
        //string is palindrome
        return true;
    }
}

