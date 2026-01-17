package linear_binary_search;
import java.util.*;
//Binary Search Problem 2: Find the Peak Element in an Array

public class PeakElement {
    public static void main(String[] args) {
        //user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Length: ");
        int n = sc.nextInt();

        //array input
        int[] arr = new int[n];
        System.out.print("Enter Array Elements: ");
        for (int i = 0; i < n; i++)
        	arr[i] = sc.nextInt();
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < arr[mid + 1])
            	left = mid + 1; //peak in right
            else right = mid;   //peak in left
        }
        System.out.println("Peak Element = " + arr[left]+" at index: "+left);
        
    }
}
