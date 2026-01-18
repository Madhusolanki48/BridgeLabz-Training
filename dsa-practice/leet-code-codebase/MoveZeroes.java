package leet_code_codebase;
import java.util.Scanner;
// LeetCode Problem: 283
// Move all 0's to the end of the array while maintaining the relative order of the non-zero elements.

public class MoveZeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        //method calling
        moveZeroes(nums);
        //print output
        System.out.println("Array after moving zeroes:");
        for (int val : nums) {
            System.out.print(val + " ");
        }
    }

    //method to move zeroes to end
    public static void moveZeroes(int[] nums) {
        int i = 0; 
        //copy all non-zero values in front
        for (int n : nums) {
            if (n != 0) {
                nums[i++] = n;
            }
        }

        //fill remaining positions with 0
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
}
