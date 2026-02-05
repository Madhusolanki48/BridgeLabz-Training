package leet_code_codebase;
import java.util.*;
import java.util.stream.*;
// LeetCode Problem: 217
// Check if the array contains any duplicate element using Java 8 streams.

public class ContainsDuplicateUsingStreams {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };
		// method calling
		boolean result = containsDuplicate(nums);
		// print output
		if (result)
			System.out.println("Duplicate Found!");
		else
			System.out.println("No Duplicate Found!");
	}

	// Java 8 method to check duplicates
	public static boolean containsDuplicate(int[] nums) {
		long distinctCount = Arrays.stream(nums).distinct().count();

		return distinctCount < nums.length;
	}
}
