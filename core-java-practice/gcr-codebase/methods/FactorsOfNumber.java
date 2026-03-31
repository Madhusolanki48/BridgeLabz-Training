package methods;
import java.util.*;
public class FactorsOfNumber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter number : ");
		int number=sc.nextInt();
		//method call
		int[] factors=factorsOfNumber(number);
		System.out.print("Factors of the given number are : ");
		for(int i:factors) {
			System.out.print(i+" ");
		}
		System.out.println();
		int sum=sumOfFactors(factors);
		int sumSquares=sumOfSquares(factors);
		int product=productOfFactors(factors);
        //print output
		System.out.println("Sum of the factors of the given number are : "+sum);
		System.out.println("Product of the factors are : "+product);
		System.out.println("Sum of the squares of factors are : "+sumSquares);
	}
	//method to find factors of a number
	public static int[] factorsOfNumber(int number) {
		int[] arr=new int[number];
		int j=0;
		for(int i=1;i<=number;i++) {
			if(number%i==0) {
				arr[j++]=i;
			}
		}
		int[] factors=new int[j];
		for(int i=0;i<factors.length;i++) {
			factors[i]=arr[i];
		}
		return factors;
	}
	//method to find the sum of the factors using factors array
	public static int sumOfFactors(int[] factors) {
		int sum=0;
		for (int i = 0; i < factors.length; i++) {
		    sum+=factors[i];
		}
		return sum;
	}
	//method to find sum of squares of factors
	public static int sumOfSquares(int[] factors) {
		int squareSum=0;
		for(int i:factors) {
			squareSum+=Math.pow(i,2);
		}
		return squareSum;
	}
	//method to find the product of the factors using factors array
	public static int productOfFactors(int[] factors) {
		int product=1;
		for (int i = 0; i < factors.length; i++) {
		    product*=factors[i];
		}
		return product;
	}
}