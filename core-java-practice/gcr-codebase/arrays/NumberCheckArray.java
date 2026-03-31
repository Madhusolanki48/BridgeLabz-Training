package arrays;
import java.util.Scanner;
public class NumberCheckArray {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        // taking input values
        for (int i = 0; i < arr.length; i++) {
        	System.out.print("Enter number" + (i + 1) + " : ");
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
        	//check if number is a positive number
            if (arr[i] > 0) {
                //even or odd condition 
                if (arr[i] % 2 == 0)
                    System.out.println(arr[i] + " is positive and even");
                else
                    System.out.println(arr[i] + " is positive and odd");

            }else if (arr[i] < 0) {  //if number is a negative number
                System.out.println(arr[i] + " is negative");
            } else {
                //for number to be zero
                System.out.println(arr[i] + " is zero");
            }
        }
        // compare first and last element
        if (arr[0] == arr[4]) {
            System.out.println("First and last elements are equal");
        } else if (arr[0] > arr[4]) {
            System.out.println("First element is greater than last");
        } else {
            System.out.println("First element is less than last");
        }
    }

}
