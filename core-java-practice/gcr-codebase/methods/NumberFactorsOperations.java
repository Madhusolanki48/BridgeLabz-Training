package methods;
import java.util.*;
public class NumberFactorsOperations {
//Find factors of a number & performs various operations using the factors array
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        //method call
        int[] factors = getFactors(number);
        //print output
        System.out.println("Factors Array = " + Arrays.toString(factors));
        System.out.println("Greatest Factor = " + greatestFactor(factors));
        System.out.println("Sum of Factors = " + sumOfFactors(factors));
        System.out.println("Product of Factors = " + productOfFactors(factors));
        System.out.println("Product of Cube of Factors = " +productOfCubeOfFactors(factors));
    }
    //method to find factors of a number and return them as an array
    public static int[] getFactors(int num) {
        int count = 0;
        //loop to count the number of factors
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                count++;
        }
        int[] factors = new int[count];
        int index = 0;
        //loop to store factors in the array
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                factors[index++] = i;
        }
        return factors;
    }

    //method to find the greatest factor using the factors array
    public static int greatestFactor(int[] factors) {
        int max = Integer.MIN_VALUE;
        for (int f : factors) {
            if (f > max)
                max = f;
        }
        return max;
    }
    //method to find the sum of factors using the array
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors)
            sum += f;

        return sum;
    }
    //method to find the product of factors using the array
    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int f : factors)
            product *= f;
        return product;
    }
    //method to find the product of cube of factors using Math.pow()
    public static long productOfCubeOfFactors(int[] factors) {
        long product = 1;
        for (int f : factors) {
            product *= (long) Math.pow(f, 3);
        }
        return product;
    }
}