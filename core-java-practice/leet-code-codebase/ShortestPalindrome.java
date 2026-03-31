package leet_code_codebase;
import java.util.Scanner;
public class ShortestPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a string : ");
        String s = sc.nextLine();
        //method call
        String result = shortestPalindrome(s);
        //print output
        System.out.println("Shortest Palindrome is " + result);
    }
    public static String shortestPalindrome(String s) {
        int end = s.length() - 1;
        //longest palindromic prefix
        while (end >= 0) {
            if (isPalindrome(s, 0, end)) {
                break;
            }
            end--;
        }
        String suffix = s.substring(end + 1);

        // reverse suffix manually
        String rev = "";
        for (int i = suffix.length() - 1; i >= 0; i--) {
            rev += suffix.charAt(i);
        }

        return rev + s;
    }

    static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
