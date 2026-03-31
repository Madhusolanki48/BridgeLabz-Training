package leet_code_codebase;
import java.util.Scanner;
//Leetcode Problem: 303
//Build a class that supports sum queries on an array.
class NumArray {
    int[] nums;  //prefix sum array
    // onstructor to convert array into prefix sum form
    public NumArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        this.nums = nums;
    }
    //method to returns sum of elements from index i to j
    public int sumRange(int i, int j) {
        if (i == 0)
            return nums[j];     //full prefix
        return nums[j] - nums[i - 1];
    }
}

public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //method calling
        NumArray obj = new NumArray(arr);
        System.out.print("Enter range (i j): ");
        int i = sc.nextInt();
        int j = sc.nextInt();
        //print output
        System.out.println("Sum = " + obj.sumRange(i, j));

    }
}
