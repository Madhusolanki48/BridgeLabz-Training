package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 1748
// Find the sum of elements that appear exactly once in the array.

public class SumOfUniqueElements {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 4, 1};
        //method calling
        int result = sumOfUnique(nums);
        //print output
        System.out.println("Sum of unique elements: " + result);
    }

    // method to calculate sum of unique elements
    public static int sumOfUnique(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            // first occurrence -> add
            if (map.get(num) == 1) {
                result += num;
            }
            // second occurrence -> remove
            else if (map.get(num) == 2) {
                result -= num;
            }
        }
        return result;
    }
}
