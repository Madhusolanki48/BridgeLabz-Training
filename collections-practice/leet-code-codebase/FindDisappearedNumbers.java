package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 448
// Find all numbers missing from the array using HashSet.
public class FindDisappearedNumbers {
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
        List<Integer> result = findDisappearedNumbers(nums);
        //print output
        System.out.println("Missing Numbers: " + result);
    }

    //method to find disappeared numbers
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        //store all numbers in set
        for (int num : nums) {
            numSet.add(num);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!numSet.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
