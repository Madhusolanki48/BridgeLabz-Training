package leet_code_codebase;
import java.util.Scanner;
public class TwoSumProblem {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //size of array
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        //take array elements
        System.out.print("Enter elements in array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter target sum : ");
        int targetSum = sc.nextInt();
        //check every pair in the array
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //if sum of two numbers equals to the targetSum
                if (arr[i] + arr[j] == targetSum) {
                    System.out.println(i + " " + j);
                    return;  
                }
            }
        }
        // if no pair matches
        System.out.println("No pair found");
    }

}
