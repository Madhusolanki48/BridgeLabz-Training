package methods;
import java.util.Scanner;
public class SumOfNaturalNumbersRecursion {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    //user input
	    System.out.print("Enter a natural number : ");
	    int number= sc.nextInt();
	    if (number <= 0) {    //natural number
	        System.out.println("Not a natural number");
	        return;
	    }
	    //method calls
	    int recursiveSum = sumUsingRecursion(number);
	    int formulaSum = sumUsingFormula(number);
	    //print output
	    System.out.println("Sum of first "+number+" natural numbers using recursion = " + recursiveSum);
	    System.out.println("Sum of first "+number+" natural numbers using formula = " + formulaSum);
	    //compare both results
	    System.out.println("Are both the sum equal ? : " + (recursiveSum == formulaSum));
	}
	//method to find the sum of n natural numbers using recursion
	public static int sumUsingRecursion(int n) {
	    if (n == 0)  //base condition
	        return 0;
	    //recursive call
	    return n + sumUsingRecursion(n - 1);
	}
	//method to find the sum of n natural numbers using the formulae
	public static int sumUsingFormula(int n) {
	    return n * (n + 1) / 2;
	}
}
