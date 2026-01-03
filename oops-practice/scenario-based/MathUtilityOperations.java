package scenario_based;
import java.util.Scanner;
public class MathUtilityOperations {
	//method to calculate the factorial of a number.
	public static long findFactorial(int n) {
	    if (n < 0) {
	        System.out.println("Factorial is not defined for Negative Numbers!");
	        return -1;
	    }
	    long factorial = 1;
	    for (int i = 2; i <= n; i++) {
	        factorial *= i;
	    }

	    return factorial; 
	}
	//method to check if a number is prime
	public static boolean isPrime(int n) {
		if(n<=1)
			return false;
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
	//method to find GCD of two numbers
	public static int gcd(int x,int y) {
		if(x==0) return y;
		if(y==0) return x;
		return gcd(y%x,x);
	}
    //method to find the nth Fibonacci number
	public static int fibonacci(int n) {
		if(n<0){
			System.out.println("Fibonacci series is not defined for Negative Numbers!");
			return -1;
		}
		if(n==0) return 0;
		if(n==1) return 1;
		int a=0,b=1,c=0;
		for(int i=2;i<=n;i++) {
			c=a+b;
			a=b;
			b=c;
		}
		return c;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("-----------  Welcome to Math Utility Toolkit  -----------");
		System.out.println("---------------------------------------------------------");
		//choice using switch case
		while(true) {
			System.out.println("\nWhich operation would you like to perform ?");
            System.out.println("1️-  Calculate Factorial");
            System.out.println("2️-  Check Prime Number");
            System.out.println("3️-  Find GCD of Two Numbers");
            System.out.println("4️-  Find nth Fibonacci Number");
            System.out.println("5️-  Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            System.out.println("---------------------------------------------------------");
           
            switch (choice) {
            	case 1 :  
            		System.out.print("Enter a number for factorial: ");
                    System.out.println("Result = " + findFactorial(sc.nextInt()));
                 
                    break;
            	case 2 :
            		System.out.print("Enter a number to check prime: ");
                    int p = sc.nextInt();
                    System.out.println(isPrime(p) ? "Yes, " + p + " is a Prime number.": "No, " + p + " is not a Prime number.");
                   
                    break;
            	case 3 :
                    System.out.print("Enter first number: ");
                    int a = sc.nextInt();
                    System.out.print("Enter second number: ");
                    int b = sc.nextInt();
                    System.out.println("GCD = " + gcd(a, b));
                    
                    break;
            	case 4 :
                    System.out.print("Enter number for Fibonacci series: ");
                    int n = sc.nextInt();
                    System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
                    
                    break;
            	case 5:
                    System.out.println("Exiting Math Utility Toolkit — Goodbye!");
                    System.out.println("---------------------------------------------------------");
                    return;
            	 default:
                     System.out.println("Invalid choice, please try again.");
            }
            System.out.println("---------------------------------------------------------");
            System.out.print("Would you like to try another operation? (yes/no):");
            sc.nextLine(); 
            String again = sc.nextLine();
            if (!again.equalsIgnoreCase("yes")) {
            	System.out.println("Thanks for using Math Utility Toolkit!");
            	break;
            }
		}
	}
}
