package scenario_based;
import java.util.Scanner;
public class RohansLibraryReminderApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------ Rohan's Library Fine Calculator ------------\n");
        int totalFine=0;
        //for 5 books using for-loop
        for (int book = 1; book <= 5; book++) {
            System.out.println("Book " + book + ":");
            //user input
            System.out.print("Enter due date (in days): ");
            int dueDate = sc.nextInt();
            System.out.print("Enter return date (in days): ");
            int returnDate = sc.nextInt();
            int fine = 0;
            int delayDays = 0;
            if (returnDate > dueDate) {
                delayDays = returnDate - dueDate;
                fine = delayDays * 5;
                totalFine+=fine;
                //calculates total delay days
                System.out.println("Days overdue: " + delayDays + " day(s)");
            } else if (returnDate == dueDate) {
            	//if no fine
                System.out.println("Returned on time — no fine");
            } else {
                int earlyDays = dueDate - returnDate;
                System.out.println("Returned " + earlyDays + " day(s) early — no fine");
            }
            //fine on each book
            System.out.println("Fine for Book " + book + ": " + fine + " Rupees \n");
        }
        //total fine calculated
        System.out.println("Total calculated fine on issued 5 books : "+totalFine);
    }
}

