package leet_code_codebase;
import java.util.Scanner;
// LeetCode Problem: 1346
// Check if there exist two indices i and j such that arr[i] == 2 * arr[j] and i != j.

public class CheckIfNAndItsDoubleExist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //method calling
        boolean result = checkIfExist(arr);

        //print output
        if (result)
            System.out.println("Yes, N and its double exist");
        else
            System.out.println("No, such pair does not exist");
    }

    //method to check using nested loops
    public static boolean checkIfExist(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                if (i != j && arr[i] == arr[j] * 2) {
                    return true;
                }
            }
        }

        return false;
    }
}
