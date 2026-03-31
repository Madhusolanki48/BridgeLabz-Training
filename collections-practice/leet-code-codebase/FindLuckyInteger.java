package leet_code_codebase;
import java.util.*;

// LeetCode Problem: 1394
// Find the lucky integer using HashMap.

public class FindLuckyInteger {
	public static void main(String[] args) {
		int[] arr = { 2, 2, 3, 4 };

		// method calling
		int result = findLucky(arr);

		// print output
		System.out.println("Lucky Integer: " + result);
	}

	public static int findLucky(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		// count frequency
		for (int num : arr) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int maxLucky = -1;
		// check lucky condition
		for (int key : map.keySet()) {
			if (key == map.get(key)) {
				maxLucky = Math.max(maxLucky, key);
			}
		}

		return maxLucky;
	}
}