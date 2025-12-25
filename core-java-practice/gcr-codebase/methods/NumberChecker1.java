package methods;
import java.util.*;
public class NumberChecker1 {
//digit operations, duck & armstrong number check,get largest/second largest and smallest/second smallest digit 
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        //method calling
        int count = countDigits(number);
        int[] digits = getDigitsArray(number);
        findLargestTwoElements(digits);
        findSmallestTwo(digits);
        //print output
        System.out.println("Total number of digits = " + count);
        System.out.println("Digits Array = " + Arrays.toString(digits));
        System.out.println("Is "+number+" a Duck Number ? : " + isDuckNumber(digits));
        System.out.println("Is "+number+" a Armstrong Number ? : " + isArmstrongNumber(number, digits));
        
    }
    //method to find the count of digits in the number
    public static int countDigits(int num) {
        int count = 0;
        int temp = Math.abs(num); // handle negative numbers safely
        while (temp > 0) {
            temp /= 10;
            count++;
        }
        return count;
    }

    //method to store digits of the number in a digits array
    public static int[] getDigitsArray(int num) {
        int count = countDigits(num);
        int[] digits = new int[count];
        int temp = Math.abs(num);

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }

    //method to check if a number is a Duck Number using the digits array
    //A duck number is a number that has a non-zero digit present in it
    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) { // skip first digit
            if (digits[i] == 0) {
                return true;
            }
        }
        return false;
    }

    //method to check if the number is an Armstrong number using the digits array
    //Armstrong number is a number that is equal to the sum of its own digits raised to the power of the number of digits
    public static boolean isArmstrongNumber(int num, int[] digits) {
        int n = digits.length;
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, n);
        }
        return sum == num;
    }
    //method to find the largest and second largest elements in digits array
    public static void findLargestTwoElements(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }
        System.out.println("Largest Digit = " + largest);
        System.out.println("Second Largest Digit = " + secondLargest);
    }

    //method to find the smallest and second smallest elements in digits array
    public static void findSmallestTwo(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int d : digits) {
            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest) {
                secondSmallest = d;
            }
        }

        System.out.println("Smallest Digit  = " + smallest);
        System.out.println("Second Smallest Digit = " + secondSmallest);
    }
}
