package extras;
import java.util.*;
public class FibonacciSequenceGenerator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter terms : ");
        int number= sc.nextInt();
        //method calling
        printFibonacciSeries(number);
    }

    //method calculates and prints the Fibonacci sequence.
    static void printFibonacciSeries(int number) {
        int a = 0, b = 1;
        System.out.print("Fibonacci series : ");
        System.out.print(a + " " + b + " ");
        for (int i = 3; i <= number; i++) {
            int c = a + b;
            //print ouput
            System.out.print(c + " ");
            a = b; b = c;
        }
    }
}
