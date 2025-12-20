package arrays;
import java.util.Scanner;
public class OddNEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        //validate input
        if (number <= 0) {  //not a natural number
            System.out.println("Invalid input !");
            return;
        }
        //array for even numbers
        int[] evenArray = new int[number / 2 + 1];  //half of no.
        //array for odd numbers
        int[] oddArray = new int[number / 2 + 1];   
        int evenIndex = 0, oddIndex = 0;
        //separate even and odd numbers
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0)
                evenArray[evenIndex++] = i;
            else
                oddArray[oddIndex++] = i;
        }
        //print even numbers
        System.out.println("Even Numbers:");
        for (int i = 0; i < evenIndex; i++)
            System.out.print(evenArray[i] + " ");
        //print odd numbers
        System.out.println("\nOdd Numbers:");
        for (int i = 0; i < oddIndex; i++)
            System.out.print(oddArray[i] + " ");
    }

}
