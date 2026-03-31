package control_flows;
import java.util.Scanner;
public class LeapYearUsingOperators {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter a year : ");
	        int year = sc.nextInt();
            //Leap year using  logical operators i.e. && and ||
	        if (year >= 1582 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
	            System.out.println("Year is a Leap Year !");
	        } else {
	            System.out.println("Year is not a Leap Year !");
	        }
	    }
}
