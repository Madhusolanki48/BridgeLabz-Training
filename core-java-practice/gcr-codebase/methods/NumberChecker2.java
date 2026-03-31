package methods;
import java.util.*;
public class NumberChecker2 { //digit operations, sum of digits, sum of squares
	//Harshad number check and digit frequency using arrays.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        //method calling
        int[] digits = getDigitsArray(number);
        int sum = sumOfDigits(digits);
        int sumOfSquares = sumOfSquares(digits);
        int[][] frequencyTable = digitFrequency(digits);
        //print output
        System.out.println("Digits Array = " + Arrays.toString(digits));
        System.out.println("Sum of Digits = " + sum);
        System.out.println("Sum of Squares of Digits = " + sumOfSquares);
        System.out.println("Is "+number+" Harshad Number ? " + isHarshadNumber(number, digits));
        System.out.println("\nDigit Frequency (Digit & Count) : ");

        for (int i = 0; i < frequencyTable.length; i++) {
            if (frequencyTable[i][1] > 0) { // print only occurring digits
                System.out.println(frequencyTable[i][0] + " - " + frequencyTable[i][1]);
            }
        }
    }
    //method to find the count of digits in the number
    public static int countDigits(int num) {
        int count = 0;
        int temp = Math.abs(num); //for negative numbers
        while (temp > 0) {
            temp /= 10;
            count++;
        }
        return count;
    }
    //method to store the digits of the number in a digits array
    public static int[] getDigitsArray(int num) {
        int count = countDigits(num);
        int[] digits = new int[count];
        int temp = Math.abs(num);
        //extract digits and store in array
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }
    //method to find the sum of digits using the digits array
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }
    //method to find the sum of squares of digits using Math.pow()
    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += (int) Math.pow(d, 2);
        }
        return sum;
    }

    //method to check if a number is a Harshad number using digits array
    //A Harshad number is divisible by the sum of its digits
    public static boolean isHarshadNumber(int num, int[] digits) {
        int sum = sumOfDigits(digits);
        return num % sum == 0;
    }
    //method to find frequency of each digit using a 2D array
    public static int[][] digitFrequency(int[] digits) {
        int[] freq = new int[10];

        // Count frequency
        for (int d : digits) {
            freq[d]++;
        }
        //2D result array
        int[][] result = new int[10][2];
        for (int i = 0; i < 10; i++) {
            result[i][0] = i;       // digit
            result[i][1] = freq[i]; // frequency
        }
        return result;
    }
}
