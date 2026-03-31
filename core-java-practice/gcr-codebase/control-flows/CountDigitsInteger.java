package control_flows;
import java.util.Scanner;
public class CountDigitsInteger {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an Integer number : ");
        int number = sc.nextInt();
        int count = 0;
        //count number of digits
        while (number != 0) {
            number = number / 10;
            count++;
        }
        System.out.println("Number of digits = " + count);
    }
	
}
