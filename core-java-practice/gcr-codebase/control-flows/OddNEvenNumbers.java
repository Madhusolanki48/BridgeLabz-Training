package control_flows;
import java.util.Scanner;
public class OddNEvenNumbers {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        //check natural number
        if (number > 0) {
            for (int i = 1; i <= number; i++) {
            	//check even or odd
                if (i % 2 == 0)
                    System.out.println(i + " is even number");
                else
                    System.out.println(i + " is odd number");
            }
        } else {
        	//5invalid input
            System.out.println("Not a natural number");
        }
    }

}
