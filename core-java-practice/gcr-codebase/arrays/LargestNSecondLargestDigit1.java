package arrays;
import java.util.Scanner;
public class LargestNSecondLargestDigit1 { 
	//Stores digits of the number up to a fixed array size (10) and 
	//finds the largest and second-largest digit only from the stored digits.
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Enter a number : ");
	    int number = sc.nextInt();
        //initializing maxDigit to 10
	    int maxDigit = 10;
	    int[] digits = new int[maxDigit];
	    int index = 0;

	    //taking digits from the number
	    while (number != 0 && index < maxDigit) {
	        digits[index++] = number % 10;
	        number /= 10;
	    }

	    int largest = 0;
	    int secondLargest = 0;

	    //largest and second largest digit
	    for (int i = 0; i < index; i++) {

	        if (digits[i] > largest) {
	            secondLargest = largest;
	            largest = digits[i];
	        }
	        else if (digits[i] > secondLargest && digits[i] != largest) {
	            secondLargest = digits[i];
	        }
	    }

	    // print result
	    System.out.println("Largest digit in the number is = " + largest);
	    System.out.println("Second largest digit in the number is = " + secondLargest);
	}
}
