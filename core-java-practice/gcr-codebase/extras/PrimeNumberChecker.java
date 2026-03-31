package extras;
import java.util.Scanner;
class PrimeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        //method calling
        boolean prime = isPrimeNumber(number);
        //print output
        System.out.println(prime ? "It is a Prime Number !" : "It is not a Prime Number !");
    }

    //method to check prime number
    static boolean isPrimeNumber(int number) {
        if (number <= 1)
        	return false;
        for (int i = 2; i <= Math.sqrt(number); i++)
            if (number % i == 0)
            	return false;
        return true;
    }
}
