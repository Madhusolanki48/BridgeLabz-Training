package leet_code_codebase;
import java.util.Scanner;
public class SearchElementInArray {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        //take input for array
        System.out.print("Enter array elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter key value : ");
        int key = sc.nextInt();
        int found = 0;  //initialize to 0
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at index " + i);
                found = 1;
                break;
            }
        }
        //not found
        if (found == 0) {
            System.out.println("Element not found");
        }
    }

}
