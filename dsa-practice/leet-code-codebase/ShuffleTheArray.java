package leet_code_codebase;
import java.util.Scanner;
// LeetCode Problem: 1470
// Given array nums of length 2n in the form [x1,x2,...,xn,y1,y2,...,yn], return the array in the form [x1,y1,x2,y2,...,xn,yn].

public class ShuffleTheArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter n value: ");
        int n = sc.nextInt();
        int[] nums = new int[2 * n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = sc.nextInt();
        }

        //method calling
        int[] result = shuffle(nums, n);
        //print output
        System.out.println("Shuffled Array:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    //method to shuffle array
    static int[] shuffle(int[] nums, int n) {
        int[] out = new int[2 * n];
        for (int i = 0; i < n; i++) {
            out[2 * i] = nums[i];
            out[2 * i + 1] = nums[i + n];
        }

        return out;
    }
}
