package leet_code_codebase;
import java.util.Scanner;
// LeetCode Problem: 66
// Given an array of digits representing a number, add one to the number.

public class PlusOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter number of digits: ");
        int n = sc.nextInt();

        int[] digits = new int[n];
        System.out.println("Enter digits:");
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }
        //method calling
        int[] result = plusOne(digits);
        //print output
        System.out.println("After Plus One:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    //method to add one to digits array
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        //start from last digit
        for (int i = n - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0; 
        }
        //if all digits were 9,result has extra digit
        int[] result = new int[n + 1];
        result[0] = 1;

        return result;
    }
}
