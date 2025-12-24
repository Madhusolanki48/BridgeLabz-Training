package methods;
import java.util.*;
public class SumOfNaturalNumbers {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//user input
		System.out.print("Enter a number : ");
		int n=sc.nextInt();
		//method call
		int result=sum(n);
		System.out.println("Sum of "+n+" natural numbers = "+result);		
	}
	//method to find the sum of n natural numbers using loop
	public static int sum(int n) {
		int sum=0;
		for(int i=1;i<=n;i++) {
			sum+=i;
		}
		return sum;
	}

}
