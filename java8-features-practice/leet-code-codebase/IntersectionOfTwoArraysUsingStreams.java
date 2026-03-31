package leet_code_codebase;
import java.util.*;
import java.util.stream.*;
// LeetCode Problem: 349
// Find the intersection of two arrays using Java 8 streams.
public class IntersectionOfTwoArraysUsingStreams {
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		//method calling
		int[] result = intersection(nums1, nums2);

		//print output
		System.out.println("Intersection: " + Arrays.toString(result));
	}

	//Java 8 method to find intersection
	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

		return Arrays.stream(nums1).distinct().filter(set::contains).toArray();
	}
}
