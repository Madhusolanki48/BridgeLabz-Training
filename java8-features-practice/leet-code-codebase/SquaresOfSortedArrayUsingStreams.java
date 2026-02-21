package leet_code_codebase;
import java.util.*;

// LeetCode Problem: 977
// Return squares of sorted array using Java 8 streams.

public class SquaresOfSortedArrayUsingStreams {
	public static void main(String[] args) {
		int[] nums = { -4, -1, 0, 3, 10 };
		// method calling
		int[] result = sortedSquares(nums);

		// print output
		System.out.println("Squared Array: " + Arrays.toString(result));
	}
	// Java 8 method
	public static int[] sortedSquares(int[] nums) {

		return Arrays.stream(nums).map(n -> n * n).sorted().toArray();
	}
}