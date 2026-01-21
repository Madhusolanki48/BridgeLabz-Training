package leet_code_codebase;
import java.util.*;
// LeetCode Problem: 349
// Return the intersection of two arrays (unique common elements) using HashSet.

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input nums1
        System.out.print("Enter size of first array: ");
        int n1 = sc.nextInt();
        int[] nums1 = new int[n1];
        System.out.println("Enter first array elements:");
        for (int i = 0; i < n1; i++) {
            nums1[i] = sc.nextInt();
        }
        // input nums2
        System.out.print("Enter size of second array: ");
        int n2 = sc.nextInt();

        int[] nums2 = new int[n2];
        System.out.println("Enter second array elements:");
        for (int i = 0; i < n2; i++) {
            nums2[i] = sc.nextInt();
        }

        //method calling
        int[] result = intersection(nums1, nums2);

        // print output
        System.out.println("Intersection Array:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    // method to find intersection
    public static int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        // store nums1 in set
        for (int element : nums1) {
            set.add(element);
        }
        // check nums2 elements
        for (int element : nums2) {
            if (set.contains(element)) {
                resultSet.add(element);
            }
        }
        // convert set to array
        int[] res = new int[resultSet.size()];
        int i = 0;
        for (int element : resultSet) {
            res[i++] = element;
        }

        return res;
    }
}
