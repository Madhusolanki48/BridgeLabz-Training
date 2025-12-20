package control_flows;
import java.util.Scanner;
public class PowerUsingWhile {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a base number : ");
        int number = sc.nextInt();
        System.out.print("Enter the power number : ");
        int power = sc.nextInt();
        int result = 1;
        int counter = 0;
        //power using while loop
        while (counter < power) {
            result *= number;
            counter++;
        }
        System.out.println(number + " raised to power " + power + " is " + result);
	}

}
