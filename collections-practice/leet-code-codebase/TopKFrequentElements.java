package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 347 (Easy practice version)
// Find top k frequent elements using collections.

public class TopKFrequentElements {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;

		// method calling
		int[] result = topKFrequent(nums, k);

		// print output
		System.out.println("Top K Frequent: " + Arrays.toString(result));
	}

	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		// count frequency
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		// sort by frequency descending
		List<Integer> list = new ArrayList<>(map.keySet());
		list.sort((a, b) -> map.get(b) - map.get(a));

		// pick first k elements
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = list.get(i);
		}

		return result;
	}
}