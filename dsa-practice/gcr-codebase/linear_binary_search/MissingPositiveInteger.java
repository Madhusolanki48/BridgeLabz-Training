package linear_binary_search;
import java.util.*;

public class MissingPositiveInteger {
    public static void main(String[] args) {
        //user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Length of Array: ");
        int n = sc.nextInt();
        //array input
        int[] arr = new int[n];
        System.out.print("Enter Array Elements: ");
        for (int i = 0; i < n; i++)
        	arr[i] = sc.nextInt();

        System.out.print("Enter Target Element: ");
        int target = sc.nextInt();
        //method calling
        int firstMissingPositive = findFirstMissingPositive(arr); 

        Arrays.sort(arr); 
        int targetIndex = findIndexOfTarget(arr, target); 

        System.out.println("First Missing Positive Integer: " + firstMissingPositive);
        System.out.println("Index of Target Element: " + targetIndex);
    }

    //method to find first missing positive using linear search
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n + 2]; //mark positives

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 && arr[i] <= n + 1)
            	visited[arr[i]] = true; 
        }

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) 
            	return i; //first missing
        }

        return -1;
    }

    //method to find index of a target using binary search
    public static int findIndexOfTarget(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target)
            	return mid;
            else if (arr[mid] < target)
            	left = mid + 1;
            else
            	right = mid - 1;
        }

        return -1;
    }
}
