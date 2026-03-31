package leet_code_codebase;
// LeetCode Problem: 1464
// Find the maximum product of (a - 1) * (b - 1) for two largest elements

public class MaximumProductOfTwoElements {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 2};
        // method calling
        int result = maxProduct(nums);
        // print output
        System.out.println("Maximum Product: " + result);
    }

    // method to calculate maximum product
    public static int maxProduct(int[] nums) {
        int first = 0;   // largest element
        int second = 0;  // second largest element
        for (int n : nums) {
            if (n >= first) {
                second = first;
                first = n;
            } 
            else if (n > second) {
                second = n;
            }
        }
        return (first - 1) * (second - 1);
    }
}
