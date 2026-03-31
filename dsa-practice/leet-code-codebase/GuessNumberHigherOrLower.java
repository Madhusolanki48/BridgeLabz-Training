package leet_code_codebase;
import java.util.Scanner;
// LeetCode Problem: 374
// Guess the number using binary search,we simulate the guess() API using a secret number input.

public class GuessNumberHigherOrLower {
    static int pickedNumber; // secret number
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // user input
        System.out.print("Enter n (range 1 to n): ");
        int n = sc.nextInt();
        System.out.print("Enter picked number (secret): ");
        pickedNumber = sc.nextInt();
        // method calling
        int result = guessNumber(n);

        // print output
        System.out.println("Guessed Number is: " + result);
    }

    // method to guess number using binary search
    public static int guessNumber(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int res = guess(mid);

            if (res == 0) {
                return mid;
            } else if (res == -1) {
                end = mid - 1;  // mid is greater
            } else {
                start = mid + 1; // mid is smaller
            }
        }

        return -1;
    }
    //simulated guess API
    public static int guess(int num) {
        if (num == pickedNumber)
            return 0;
        else if (num > pickedNumber)
            return -1;
        else
            return 1;
    }
}
