package strings;
import java.util.Scanner;
public class IsPalindromeText {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter some text : ");
        String text = sc.nextLine();
        //Logic 1:compare the characters from the start and using loop
        boolean result1 = isPalindromeUsingLoop(text);
        //Logic 2:compare using recursion
        boolean result2 = isPalindromeUsingRecursion(text, 0, text.length() - 1);
        //Logic 3:compare using character arrays
        boolean result3 = isPalindromeUsingArray(text);
        //print results
        System.out.println("Is the text Palindrome using Loop Logic ? : " + result1);
        System.out.println("Is the text Palindrome using Recursion ? : " + result2);
        System.out.println("Is the text Palindrome using Array comparison ? : " + result3);

    }

    //Logic 1: compare characters using loop
    public static boolean isPalindromeUsingLoop(String text) {
        int startIndex = 0;
        int endIndex = text.length() - 1;
        while (startIndex < endIndex) {
            if (text.charAt(startIndex) != text.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
    //Logic 2: recursive palindrome check
    public static boolean isPalindromeUsingRecursion(String text, int start, int end) {
        // base condition
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        //recursive call
        return isPalindromeUsingRecursion(text, start + 1, end - 1);
    }

    //Logic 3:palindrome by comparing character arrays
    public static boolean isPalindromeUsingArray(String text) {
        char[] originalString = text.toCharArray();
        char[] reversedString = reverseString(text);
        for (int i = 0; i < originalString.length; i++) {
            if (originalString[i] != reversedString[i]) {
                return false;
            }
        }
        return true;
    }
    //method to reverse string using charAt method
    public static char[] reverseString(String text) {
        char[] reversedString = new char[text.length()];
        int index = 0;
        for (int i = text.length() - 1; i >= 0; i--) {
        	reversedString[index++] = text.charAt(i);
        }
        return reversedString;
    }
}
