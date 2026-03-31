package OnlineBankingSystem;
import java.util.Scanner;

public class OnlineBankingSystem {
	private static void printMenu() {
		System.out.println("""
				------------ ONLINE BANKING SYSTEM ------------
				Welcome! What would you like to do today?
				
				1. Create Account
				2. Deposit Money
				3. Withdraw Money
				4. Check Balance
				5. Fund Transfer
				6. View Transaction History
				7. List All Accounts
				8. Delete Account
				0. Exit
				
				Please select an option from the menu above.
				------------------------------------------------
				""");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankServiceManager manager = new BankServiceManager();
		BankService service = new BankServiceImplementation();
		while (true) {

			printMenu();
			System.out.print("Enter your choice: ");
			int ch = sc.nextInt();
			sc.nextLine();

			switch (ch) {

			case 1: //create account
				System.out.println("""

						You have chosen: Create New Account
						Please select account type:
						1. Savings Account
						2. Current Account
						""");
				int type = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Account Number: ");
				int accountNumber = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Account Holder Name: ");
				String name = sc.nextLine();

				System.out.print("Enter Initial Deposit Amount: ");
				double balance = sc.nextDouble();

				Account acc;

				if (type == 1) {
				    acc = new SavingsAccount(accountNumber, name, balance);
				} else {
				    acc = new CurrentAccount(accountNumber, name, balance);
				}

				manager.addAccount(acc);
				System.out.println("Account created successfully. You may continue with another operation.\n");
				break;

			case 2: //deposit
				System.out.println("\nYou have selected: Deposit Money");
				System.out.print("Enter Account Number: ");
				acc = manager.getAccount(sc.nextInt());

				if (acc == null) {
					System.out.println("Account not found. Please try again.\n");
					break;
				}

				System.out.print("Enter Amount to Deposit: ");
				acc.deposit(sc.nextDouble());
				System.out.println("Amount deposited successfully. Thank you.\n");
				break;

			case 3: //withdraw
				System.out.println("\nYou have selected: Withdraw Money");
				System.out.print("Enter Account Number: ");
				acc = manager.getAccount(sc.nextInt());

				if (acc == null) {
					System.out.println("Account not found. Please try again.\n");
					break;
				}

				System.out.print("Enter Withdrawal Amount: ");
				try {
					acc.withdraw(sc.nextDouble());
					System.out.println("Withdrawal completed successfully.\n");
				} catch (InsufficientBalanceException e) {
					System.out.println("Transaction failed: " + e.getMessage());
				}
				break;

			case 4: //check balance 
				System.out.println("\nYou have selected: Balance Inquiry");
				System.out.print("Enter Account Number: ");
				acc = manager.getAccount(sc.nextInt());

				if (acc == null) {
					System.out.println("Account not found.\n");
					break;
				}

				System.out.println("Current Balance: " + acc.getBalance());
				System.out.println("Interest : " + acc.calculateInterest() + "\n");
				break;

			case 5: //transfer fund
				System.out.println("\nYou have selected: Fund Transfer");

				try {
					System.out.print("Enter Sender Account Number: ");
					Account from = manager.getAccount(sc.nextInt());

					System.out.print("Enter Receiver Account Number: ");
					Account to = manager.getAccount(sc.nextInt());

					System.out.print("Enter Transfer Amount: ");
					double amt = sc.nextDouble();

					service.transfer(from, to, amt);
					System.out.println("Transfer completed successfully.\n");

				} catch (InsufficientBalanceException e) {
					System.out.println("Transfer failed: " + e.getMessage());
				}
				break;

			case 6: //transaction history
				System.out.println("\nYou have selected: View Transaction History");
				System.out.print("Enter Account Number: ");
				acc = manager.getAccount(sc.nextInt());

				if (acc != null) {
					acc.printTransactions();
				} else {
					System.out.println("Account not found.\n");
				}
				break;

			case 7:
				System.out.println("\nListing all registered accounts:");
				manager.listAccounts();
				System.out.println();
				break;

			case 8:
				System.out.println("\nYou have selected: Delete Account");
				System.out.print("Enter Account Number: ");
				manager.deleteAccount(sc.nextInt());
				System.out.println();
				break;

			case 0:
				System.out.println("\nThank you for using the Online Banking System.");
				System.out.println("Session ended. Have a great day.");
				return;

			default:
				System.out.println("Invalid selection. Please choose a valid option.\n");
			}
		}
	}
}
