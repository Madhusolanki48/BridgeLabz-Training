package methods;
import java.util.*;
public class NumberChecker4 { //Checks Prime, Neon, Spy, Automorphic, and Buzz numbers
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        //print output
        System.out.println("Is Prime Number ? : " + isPrimeNumber(number));
        System.out.println("Is Neon Number ? : " + isNeonNumber(number));
        System.out.println("Is Spy Number ? : " + isSpyNumber(number));
        System.out.println("Is Automorphic Number ? : " + isAutomorphicNumber(number));
        System.out.println("Is Buzz Number ? : " + isBuzzNumber(number));
    }
    //method to check if a number is Prime
    public static boolean isPrimeNumber(int num) {
        if (num <= 1)
        	return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    //method to check if a number is Neon
    // Neon number is a number whose sum of digits of square = number
    public static boolean isNeonNumber(int num) {
        int square = num * num;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == num;
    }

    //method to check if a number is Spy
    //Spy number is a number whose sum of digits = product of digits
    public static boolean isSpyNumber(int num) {
        int sum = 0;
        int product = 1;
        int temp = num;

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }

    //method to check if a number is Automorphic
    //Automorphic number is a number whose square ends with the number
    public static boolean isAutomorphicNumber(int num) {
        int square = num * num;
        return (square + "").endsWith(num + "");
    }

    //method to check if a number is Buzz
    //Buzz number is a number which is either divisible by 7 or ends with 7
    public static boolean isBuzzNumber(int num) {
        return (num % 7 == 0) || (num % 10 == 7);
    }
}
