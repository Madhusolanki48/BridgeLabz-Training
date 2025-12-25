package methods;
import java.util.*;
public class NumberChecker5 { //checks Perfect, Abundant, Deficient, and Strong numbers.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//user input
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        //print output
        System.out.println("Sum of Proper Divisors : " + sumOfProperDivisors(number));
        System.out.println("Is Perfect Number ?     : " + isPerfectNumber(number));
        System.out.println("Is Abundant Number ?    : " + isAbundantNumber(number));
        System.out.println("Is Deficient Number ?   : " + isDeficientNumber(number));
        System.out.println("Is Strong Number ?      : " + isStrongNumber(number));
    }
    //method to find the sum of proper divisors of a number
    public static int sumOfProperDivisors(int num) {
        int sum = 1; 
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0)
                sum += i;
        }
        if (num == 1)
            return 0;

        return sum;
    }

    //method to check if number is Perfect
    //Perfect number is a number whose sum of proper divisors = number
    public static boolean isPerfectNumber(int num) {
        return sumOfProperDivisors(num) == num;
    }
    //method to check if number is Abundant
    //Abundant number is a number sum of proper divisors > number
    public static boolean isAbundantNumber(int num) {
        return sumOfProperDivisors(num) > num;
    }

    //method to check if number is Deficient
    //Deficient number is a number whose sum of proper divisors < number
    public static boolean isDeficientNumber(int num) {
        return sumOfProperDivisors(num) < num;
    }

    //method to compute factorial of a digit
    public static int factorial(int d) {
        int fact = 1;
        for (int i = 1; i <= d; i++) {
            fact *= i;
        }
        return fact;
    }
    //method to check if number is Strong
    //Strong number is a number whose sum of factorial of digits = number
    public static boolean isStrongNumber(int num) {
        int temp = num;
        int sum = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == num;
    }
   
}
