package extras;
import java.util.Scanner;
public class GCDAndLCMCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int number2 = sc.nextInt();
        //method calling
        int gcd = findGCD(number1, number2);
        int lcm = findLCM(number1, number2, gcd);
        //print output
        System.out.println("GCD = " + gcd);
        System.out.println("LCM = " + lcm);
    }
    //method to calculate GCD
    static int findGCD(int a, int b) {
    	if (b == 0) return a;
        return findGCD(b, a % b);
    }

    //method to calculate LCM
    static int findLCM(int a, int b, int gcd) {
    	return (a * b) / findGCD(a, b);
    }
}

