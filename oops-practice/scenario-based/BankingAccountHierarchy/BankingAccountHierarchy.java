package BankingAccountHierarchy;
import java.util.*;

public class BankingAccountHierarchy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------- Banking Account Fee Calculator ---------");
		System.out.println("--------------------------------------------------");

		while (true) {
			System.out.println("\n1- Savings Account Fee");
			System.out.println("2- Checking Account Fee");
			System.out.println("3- Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();
			sc.nextLine();

			if (choice == 3) {
				System.out.println("--------------------------------------------------");
				System.out.println("System Closed. Thank you!");
				System.out.println("--------------------------------------------------");
				return;
			}

			System.out.print("Enter Account Number: ");
			String acc = sc.nextLine();

			System.out.print("Enter Balance: ");
			double balance = sc.nextDouble();
			sc.nextLine();

			BankAccount account = null;

			if (choice == 1) {
				account = new SavingsAccount(acc, balance);
				System.out.println("Savings Account Created!");
			}
			else if (choice == 2) {
				account = new CheckingAccount(acc, balance);
				System.out.println("Checking Account Created!");
			}
			else {
				System.out.println("Invalid choice!");
				continue;
			}

			System.out.println("--------------------------------------------------");
			System.out.printf("Transaction Fee: %.2f%n", account.calculateFee());
			System.out.println("--------------------------------------------------");
		}
	}
}
