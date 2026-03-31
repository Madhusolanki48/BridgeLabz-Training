package methods;
import java.util.*;
public class NumberChecker3 { //reversing a array,comparing arrays, palindrome check, duck number check
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        //method calling
        int[] digits = getDigitsArray(number);
        int[] reversed = reversedArray(digits);
        System.out.println("Digits Array = " + Arrays.toString(digits));
        System.out.println("Reversed Digits Array = " + Arrays.toString(reversed));
        System.out.println("Are the Arrays equal ? : " + compareArrays(digits, reversed));
        System.out.println("Is "+number+" a Palindrome Number ? : " + isPalindromeNumber(digits));
        System.out.println("Is "+number+" a Duck Number ? : " + isDuckNumber(digits));

    }
    //method to find the count of digits in the number
    public static int countDigits(int num) {
        int count = 0;
        int temp = Math.abs(num); //for negative numbers
        while (temp > 0) {
            temp /= 10;
            count++;
        }
        return count;
    }

    //method to store digits of the number in a digits array
    public static int[] getDigitsArray(int num) {
        int count = countDigits(num);
        int[] digits = new int[count];
        int temp = Math.abs(num);
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }

    //method to reverse the digits array
    public static int[] reversedArray(int[] digits) {
        int[] reversed = new int[digits.length];
        int j = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            reversed[j++] = digits[i];
        }
        return reversed;
    }

    //method to compare two arrays and check if they are equal
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    //method to check if a number is a Palindrome using digits
    //A palindrome number is a number that remains the same when its digits are reversed.
    public static boolean isPalindromeNumber(int[] digits) {
        int[] reversed = reversedArray(digits);
        return compareArrays(digits, reversed);
    }

    //method to Check if a number is a Duck Number using digits array
    //A duck number is a number that has a non-zero digit present in it
    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) { 
            if (digits[i] == 0)
                return true;
        }
        return false;
    }
}
