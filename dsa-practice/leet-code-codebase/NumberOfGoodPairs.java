package leet_code_codebase;
import java.util.Scanner;
// LeetCode Problem: 1512
// Count number of good pairs (i, j) where nums[i] == nums[j] and i < j.

public class NumberOfGoodPairs {
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
        int result = numIdenticalPairs(nums);
        //print output
        System.out.println("Number of Good Pairs: " + result);
    }
    //method to count good pairs using frequency array
    static int numIdenticalPairs(int[] nums) {

        int[] freq = new int[101]; //values are from 1 to 100
        int count = 0;
        for (int num : nums) {
            freq[num]++;
        }

        //if frequency is k, number of pairs = k*(k-1)/2
        for (int f : freq) {
            if (f > 1) {
                count += f * (f - 1) / 2;
            }
        }
        return count;
    }
}
