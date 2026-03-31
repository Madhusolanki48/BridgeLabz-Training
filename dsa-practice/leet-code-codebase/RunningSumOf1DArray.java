package leet_code_codebase;
import java.util.Scanner;
//LeetCode Problem: 1480
//Given an array, return the running sum of the array.

public class RunningSumOf1DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.print("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        //method calling
        int[] result = runningSum(nums);
        //print output
        System.out.print("Running Sum:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
    //method to calculate running sum
    static int[] runningSum(int[] nums) {
        int sum = 0;
        int[] retSums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            retSums[i] = sum;
        }
        return retSums;
    }
}
