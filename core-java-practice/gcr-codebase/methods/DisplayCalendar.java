package methods;
import java.util.Scanner;
public class DisplayCalendar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter month (1-12) : ");
        int month = sc.nextInt();
        System.out.print("Enter year : ");
        int year = sc.nextInt();
        //method call
        printCalendar(month, year);
    }
    //method to get a month name
    public static String getMonthName(int month) {
        String[] months = {"January","February","March","April","May","June",
            "July","August","September","October","November","December"
        };
        return months[month - 1];
    }
    //method to get number of days in month
    public static int getDaysInMonth(int month, int year) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (month == 2 && isLeapYear(year))
            return 29;
        return days[month - 1];
    }
    //method to check a Leap year 
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    //method to get first day of month using Gregorian algorithm
    public static int getFirstDay(int day, int month, int year) {
        //given
        int y0 = year - (14 - month) / 12;
        int x  = y0 + y0/4 - y0/100 + y0/400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (day + x + (31*m0)/12) % 7;
        return d0;
    }
    //method to print calendar
    public static void printCalendar(int month, int year) {
        String monthName = getMonthName(month);
        int days = getDaysInMonth(month, year);
        System.out.println("\n       " + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        
        //get 1st day of the month
        int startDay = getFirstDay(1, month, year);
        //print spaces before first date
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }
        //print all days
        for (int d = 1; d <= days; d++) {
            System.out.printf("%3d ", d);
            if ((startDay + d) % 7 == 0)
                System.out.println();
        }
        System.out.println();
    }
}
