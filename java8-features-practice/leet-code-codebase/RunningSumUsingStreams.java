package leet_code_codebase;
import java.util.*;

// LeetCode Problem: 1480
// Return running sum of array using Java 8.

public class RunningSumUsingStreams {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        // method calling
        int[] result = runningSum(nums);

        // print output
        System.out.println("Running Sum: " + Arrays.toString(result));
    }

    // Java 8 running sum
    public static int[] runningSum(int[] nums) {

        int[] sum = {0};

        return Arrays.stream(nums)
                     .map(n -> sum[0] += n)
                     .toArray();
    }
}
