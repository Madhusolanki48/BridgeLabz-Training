package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 217
// Check if the array contains any duplicate element using HashSet.

public class ContainsDuplicate {
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
        boolean result = containsDuplicate(nums);
        // print output
        if (result)
            System.out.println("Duplicate Found");
        else
            System.out.println("No Duplicate Found");
    }

    // method to check duplicates
    public static boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }

            set.add(num);
        }
        return false;
    }
}
