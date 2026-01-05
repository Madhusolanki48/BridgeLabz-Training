package scenario_based;
import java.util.*;

//custom exception class
class InvalidInvoiceFormatException extends Exception {
    public InvalidInvoiceFormatException(String message) {
        super(message);
    }
}

public class InvoiceGeneratorWithExceptionHandling {
    //method to parse invoice string into task entries
    public static String[] parseInvoice(String input) throws InvalidInvoiceFormatException {
        if (!input.contains("-")) {
            throw new InvalidInvoiceFormatException("Invoice format invalid! Missing '-' separator.");
        }
        return input.split(",");   //split tasks by comma
    }

    //method to calculate total amount
    public static int getTotalAmount(String[] tasks) throws InvalidInvoiceFormatException {
        int total = 0;
        System.out.println("\nInvoice Breakdown");
        System.out.println("--------------------------------------------------");
        for (String task : tasks) {
            task = task.trim();

            if (!task.contains("-"))
                throw new InvalidInvoiceFormatException("Invalid task entry: '" + task + "' — dash '-' missing.");
            String[] parts = task.split("-");
            if (parts.length < 2)
                throw new InvalidInvoiceFormatException("Amount missing in entry: '" + task + "'");

            String taskName = parts[0].trim();
            String amountPart = parts[1].trim().split(" ")[0];

            int amount;
            try {
                amount = Integer.parseInt(amountPart);
            }
            catch (NumberFormatException e) {
                throw new InvalidInvoiceFormatException("Invalid amount format in: '" + task + "'");
            }
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
            System.out.println("\nEnter invoice in format:");
            System.out.println("Example: Logo Design - 3000 INR, Web Page - 4500 INR");
            System.out.print("\nEnter here: ");

            String input = sc.nextLine();

            try {
                String[] tasks = parseInvoice(input);
                int total = getTotalAmount(tasks);

                System.out.println("Total Amount Payable: " + total);

            } catch (InvalidInvoiceFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.print("\nGenerate another invoice? (yes/no): ");
            String again = sc.nextLine();

            if (!again.equalsIgnoreCase("yes")) {
                System.out.println("\nThank you! Have a productive day.");
                break;
            }
        }
    }
}

