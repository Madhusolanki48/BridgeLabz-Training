package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 1
// Find two indices such that nums[i] + nums[j] = target using HashMap.

public class TwoSum{
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

        System.out.print("Enter target: ");
        int target = sc.nextInt();
        //method calling
        int[] result = twoSum(nums, target);
        //print output
        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + " " + result[1]);
        } else {
            System.out.println("No pair found");
        }
    }

    //method to find two sum indices using HashMap
   public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            //if complement exists, return answer
            if (map.containsKey(comp)) {
                return new int[]{map.get(comp), i};
            }

            //store value and index
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
