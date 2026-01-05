package scenario_based;
import java.util.*;

public class InvoiceGeneratorForFreelancers {
    //method to parse invoice string into task entries
    public static String[] parseInvoice(String input) {
        return input.split(",");   //split items by comma
    }
    //method to calculate total amount
    public static int getTotalAmount(String[] tasks) {
        int total = 0;
        System.out.println("\nInvoice Breakdown");
        System.out.println("--------------------------------------------------");

        for (String task : tasks) {
            task = task.trim();
            //safety validation
            if (!task.contains("-")) {
                System.out.println("Skipping invalid entry: " + task);
                continue;
            }

            String[] parts = task.split("-");
            String taskName = parts[0].trim();
            String amountPart = parts[1].trim().split(" ")[0]; //numeric part

            int amount = Integer.parseInt(amountPart);
            total += amount;

            System.out.println("Task: " + taskName + " | Amount: " + amount);
        }

        System.out.println("--------------------------------------------------");
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------- Freelancer Invoice Generator -----------");
        while (true) {

            //user input
            System.out.println("\nEnter invoice details in format:");
            System.out.println("Example: Logo Design - 3000 INR, Web Page - 4500 INR");
            System.out.print("\nEnter here: ");

            String input = sc.nextLine();
            //method calling
            String[] tasks = parseInvoice(input);
            System.out.println("\n----------------- Invoice Summary ------------------");
            int total = getTotalAmount(tasks);
            System.out.println("Total Amount Payable: " + total);
            System.out.println("------------------------------------------------------");

            // ask user to continue
            System.out.print("\nWould you like to generate another invoice? (yes/no): ");
            String again = sc.nextLine();

            if (!again.equalsIgnoreCase("yes")) {
                System.out.println("\nThank you! Have a productive day.");
                break;
            }
        }
    }
}
