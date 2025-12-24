package methods;
import java.util.Scanner;
public class IsLeapYear {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        //method call
        boolean result = isLeapYear(year);
        //display output
        if (result) {
            System.out.println(year+" is Leap Year !");
        } else {
            System.out.println(year+" not a Leap Year !");
        }
    }
    //method to check leap year using given conditions
    public static boolean isLeapYear(int year) {
        if (year < 1582) { //Gregorian calendar starts from 1582
            return false;
        }
        //leap year conditions
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }
}


