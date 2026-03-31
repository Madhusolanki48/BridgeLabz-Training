package linear_binary_search;
import java.util.*;
//Binary Search Problem 1: Find the Rotation Point in a Rotated Sorted Array

public class RotationPoint {
    public static void main(String[] args) {
        //integer array
        int[] arr = {3, 4, 5, 1, 2};

        //start and end variables
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            //rotation is in right half
            if (arr[mid] > arr[right]) 
            	left = mid + 1;
            else right = mid;   //rotation in left half
        }

      
        System.out.println("Rotation Point Index: " + left);
        System.out.println("Smallest Element: " + arr[left]);
    }
}
