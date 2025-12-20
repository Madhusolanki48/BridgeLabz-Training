package arrays;
import java.util.Scanner;
public class LargestNSecondLargestDigit2 {
	//Stores all digits of the number by dynamically increasing the array size when needed and 
	//then finds the largest and second-largest digit from all digits.
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Enter a number : ");
	    int number = sc.nextInt();
	    int maxDigit = 10;
	    int[] digits = new int[maxDigit];
	    int index = 0;

	    //taking digits from the number and resize array if needed
	    while (number != 0) {
	        //increase array size if full
	        if (index == maxDigit) {
	            maxDigit += 10;
	            int[] temp = new int[maxDigit];

	            for (int i = 0; i < digits.length; i++)
	                temp[i] = digits[i];

	            digits = temp;
	        }

	        //store digit
	        digits[index++] = number % 10;
	        number /= 10;
	    }

	    int largest = 0;
	    int secondLargest = 0;

	    // find largest and second largest digit
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
	    System.out.println("Largest digit in the number is : " + largest);
	    System.out.println("Second largest digit in the number is : " + secondLargest);
	}

}
