package leet_code_codebase;
import java.util.Scanner;
// LeetCode Problem: 1122
// Sort arr1 such that the relative order follows arr2,& the remaining elements are sorted in ascending order.

public class RelativeSortArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter size of arr1: ");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];

        System.out.print("Enter elements of arr1:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter size of arr2: ");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];

        System.out.print("Enter elements of arr2:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }
        //method calling
        int[] result = relativeSortArray(arr1, arr2);
        //print output
        System.out.println("Relative Sorted Array:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
    //method to relative sort using counting array
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        //frequency of elements from arr1
        for (int n : arr1) {
            count[n]++;
        }
        int index = 0;
        //elements in arr2 order first
        for (int n : arr2) {
            while (count[n]-- > 0) {
                arr1[index++] = n;
            }
        }
        //remaining elements in sorted order
        for (int n = 0; n < count.length; n++) {
            while (count[n]-- > 0) {
                arr1[index++] = n;
            }
        }
        return arr1;
    }
}

