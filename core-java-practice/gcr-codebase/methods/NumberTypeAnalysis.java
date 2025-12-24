package methods;
import java.util.Scanner;
public class NumberTypeAnalysis {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        //user input
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + " : ");
            numbers[i] = sc.nextInt();
            if (isPositive(numbers[i])) {
                if(isEven(numbers[i]))
                    System.out.println("Positive and Even");
                else
                    System.out.println("Positive and Odd");
            } else if (numbers[i] < 0) {
                System.out.println("Negative");
            } else {
                System.out.println("Zero");
            }
        }
        //compare first and last elements
        int result = compare(numbers[0], numbers[4]);
        if (result == 1)
            System.out.println("First number is greater than last");
        else if (result == -1)
            System.out.println("First number is less than last");
        else
            System.out.println("First and last number are equal");
    }
    //method to check if number is positive
    public static boolean isPositive(int number) {
        return number > 0;
    }
    //method to check if number is even
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    //method to compare two numbers
    public static int compare(int number1, int number2) {
        if (number1 > number2)
            return 1;
        else if (number1 < number2)
            return -1;
        else
            return 0;
    }
}

