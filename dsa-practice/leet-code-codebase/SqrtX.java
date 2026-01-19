package leet_code_codebase;
import java.util.Scanner;
// LeetCode Problem: 69
// Find the integer square root of x (floor value) using binary search.

public class SqrtX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // user input
        System.out.print("Enter a number: ");
        int x = sc.nextInt();

        // method calling
        int result = mySqrt(x);

        // print output
        System.out.println("Square root (floor value): " + result);
    }

    // method to find sqrt using binary search
    public static int mySqrt(int x) {

        if (x == 0 || x == 1)
            return x;

        int start = 1;
        int end = x;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // if mid*mid is greater than x, move left
            if ((long) mid * mid > (long) x) {
                end = mid - 1;
            }
            // exact square root
            else if ((long) mid * mid == (long) x) {
                return mid;
            }
            // move right
            else {
                start = mid + 1;
            }
        }

        return end;
    }
}
