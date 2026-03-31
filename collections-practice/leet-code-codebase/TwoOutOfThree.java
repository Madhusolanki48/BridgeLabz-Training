package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 2032
// Find numbers present in at least two of the three arrays using HashSet.
public class TwoOutOfThree {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 3, 2};
        int[] nums2 = {2, 3};
        int[] nums3 = {3};
        // method calling
        List<Integer> result = twoOutOfThree(nums1, nums2, nums3);
        // print output
        System.out.println("Numbers present in at least two arrays: " + result);
    }
    // method to find elements present in at least two arrays
    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        Set<Integer> all = new HashSet<>();
        //fill sets and collect all unique numbers
        for (int i : nums1) {
        	set1.add(i); all.add(i); }
        for (int i : nums2) {
        	set2.add(i); all.add(i); }
        for (int i : nums3) {
        	set3.add(i); all.add(i); }

        List<Integer> result = new ArrayList<>();
        // check presence in at least two sets
        for (int i : all) {
            if ((set1.contains(i) && set2.contains(i)) ||
                (set2.contains(i) && set3.contains(i)) ||
                (set1.contains(i) && set3.contains(i))) {
                result.add(i);
            }
        }
        return result;
    }
}
