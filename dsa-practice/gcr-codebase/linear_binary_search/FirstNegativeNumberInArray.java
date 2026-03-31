package linear_binary_search;
import java.util.*;
//Linear Search Problem 1: Search for the First Negative Number

public class FirstNegativeNumberInArray {
    public static void main(String[] args) {
    	//user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of Array: ");
        int n = sc.nextInt();
        //array input
        int[] arr = new int[n];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) { //first negative
                index = i;
                break;
            }
        }

        System.out.println("Index of First Negative Number in Array: "+index);
    }
}

