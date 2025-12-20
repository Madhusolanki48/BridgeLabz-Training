package leet_code_codebase;
import java.util.Scanner;
public class SumOfElementsInArray {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;      // initializing sum to zero
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum = sum + arr[i];
        }
        System.out.println("The sum of elements in the array is "+sum);
    }

}
