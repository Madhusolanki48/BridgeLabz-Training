package arrays;
import java.util.Scanner;
public class StoreAndSumUntilZero {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] arr = new double[10];
        double total = 0;
        int index = 0;
        //Infinite loop to take input
        while (true) {
        	System.out.print("Enter any number or 0 to terminate : ");
            double number = sc.nextDouble();
            //break if number is negative or zero
            if (number <= 0) {
                break;
            }
            //break if number exceeds array size i.e. 10
            if (index == 10) {
                break;
            }
            //store the value and move the index
            arr[index] = number;
            index++;
        }
        //sum of numbers in array
        for (int i = 0; i < index; i++) {
            total += arr[i];
        }
        System.out.println("Total Sum = " + total);
    }
}


