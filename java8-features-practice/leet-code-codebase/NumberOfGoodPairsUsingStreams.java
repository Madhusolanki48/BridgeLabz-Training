package leet_code_codebase;
import java.util.*;
import java.util.stream.*;

// LeetCode Problem: 1512
// Count number of good pairs using Java 8 streams.

public class NumberOfGoodPairsUsingStreams {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1, 1, 3 };

		// method calling
		int result = numIdenticalPairs(nums);

		// print output
		System.out.println("Number of Good Pairs: " + result);
	}

	// Java 8 method
	public static int numIdenticalPairs(int[] nums) {

		return Arrays.stream(nums).boxed().collect(Collectors.groupingBy(n -> n, Collectors.counting())).values()
				.stream().mapToInt(count -> (int) (count * (count - 1) / 2)).sum();
	}
}
