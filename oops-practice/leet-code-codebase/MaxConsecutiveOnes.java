package leet_code_codebase;
import java.util.Scanner;
//Leetcode problem : 485
//Given a binary array, find the maximum number of consecutive 1s in the array.

public class MaxConsecutiveOnes {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements (0 or 1):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        //method calling
        int result = findMaxConsecutiveOnes(nums);
        System.out.println("Maximum Consecutive 1s: " + result);
    }
    //method to find longest streak of 1s
    static int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = 0;
        int currentLength = 0;
        for (int num : nums) {
            if (num == 1) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            }
            else {
                currentLength = 0;
            }
        }

        return maxLength;
    }
}

