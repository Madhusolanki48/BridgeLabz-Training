package extras;
import java.util.Scanner;
public class FactorialUsingRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        System.out.println("Factorial of "+number+ " = " + factorial(number));
    }

    //method to calculate factorial of a number
    static int factorial(int number) {
    	if (number== 0 || number== 1)
    		return 1;
        return number * factorial(number - 1);
    }   
}

