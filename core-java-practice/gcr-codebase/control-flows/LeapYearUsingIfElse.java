package control_flows;
import java.util.Scanner;
public class LeapYearUsingIfElse {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year : ");
        int year = sc.nextInt();
        // Gregorian calendar starts from 1582
        //Leap year using multiple if-else
        if (year < 1582) {
            System.out.println("Year is not valid for Leap Year according to Gregorian calender");
        } 
        //Leap Year is a Year divisible by 4 and not 100 unless it is divisible by 400
        else if (year % 400 == 0) {
            System.out.println("Year is a Leap Year !");
        } 
        else if (year % 100 == 0) {
            System.out.println("Year is not a Leap Year !");
        } 
        else if (year % 4 == 0) {
            System.out.println("Year is a Leap Year !");
        } 
        else {
            System.out.println("Year is not a Leap Year !");
        }
    }
}
