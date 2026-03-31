package linear_binary_search;
import java.util.*;
//Binary Search Problem 4: Find the First and Last Occurrence of an Element in a Sorted Array

public class FirstLastOccurrence {
    public static void main(String[] args) {
        //user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Length: ");
        int n = sc.nextInt();

        //sorted array input
        int[] arr = new int[n];
        System.out.print("Enter Sorted Array Elements: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.print("Enter Target: ");
        int target = sc.nextInt();
        //method calling
        int first = firstOccurrence(arr, target);
        int last = lastOccurrence(arr, target);

        System.out.println("First Occurrence Index of Target Element: " + first);
        System.out.println("Last Occurrence Index of Target Element: " + last);
    }

    //method to find first occurrence using binary search
    public static int firstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                ans = mid;
                right = mid - 1; //search left
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    //method to find last occurrence using binary search
    public static int lastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                ans = mid;
                left = mid + 1; //search right
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}

