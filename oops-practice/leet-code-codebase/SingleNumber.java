package leet_code_codebase;
import java.util.Scanner;
// LeetCode Problem: 136
// In an array where every element appears twice except one,find the element that appears only once.

public class SingleNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // user input
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        // method calling
        int result = findSingleNumber(nums);
        // print output
        System.out.println("Single Number is: " + result);
    }

    //method to find the unique element using XOR
    static int findSingleNumber(int[] nums) {

        int ans = 0;

        for (int num : nums) {
            ans ^= num;   //XOR to remove duplicate numbers
        }

        return ans;
    }
}
