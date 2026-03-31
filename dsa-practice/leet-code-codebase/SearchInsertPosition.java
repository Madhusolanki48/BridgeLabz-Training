package leet_code_codebase;
import java.util.Scanner;
// LeetCode Problem: 35
// Given a sorted array and a target, return the index if found,if not found, return the index where it should be inserted.

public class SearchInsertPosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter target value: ");
        int target = sc.nextInt();

        //method calling
        int result = searchInsert(nums, target);

        //print output
        System.out.println("Insert Position Index: " + result);
    }

    //method to find insert position using binary search
    public static int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return start;
    }
}
