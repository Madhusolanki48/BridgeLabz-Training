package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 2215
// Find elements present in one array but not the other using HashSet.

public class FindDifferenceOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        //method calling
        List<List<Integer>> result = findDifference(nums1, nums2);
        //print output
        System.out.println("Elements only in nums1: " + result.get(0));
        System.out.println("Elements only in nums2: " + result.get(1));
    }

    //method to find difference
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        //add elements to sets
        for (int num : nums1)
        	set1.add(num);
        for (int num : nums2)
        	set2.add(num);

        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(new ArrayList<>());
        resultList.add(new ArrayList<>());

        //elements in nums1 but not in nums2
        for (int num : set1) {
            if (!set2.contains(num)) {
                resultList.get(0).add(num);
            }
        }

        //elements in nums2 but not in nums1
        for (int num : set2) {
            if (!set1.contains(num)) {
                resultList.get(1).add(num);
            }
        }

        return resultList;
    }
}
