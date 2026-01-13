package DigitalWalletSystem;
import java.util.ArrayList;
import java.util.Scanner;
//main class
public class DigitalWalletSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//lists
		ArrayList<User> users = new ArrayList<>();
		ArrayList<Transaction> transactions = new ArrayList<>();
		System.out.println("-------  Welcome to Digital Wallet System  -------");
		//polymorphism
		TransferService walletTransfer = new WalletTransfer();
		TransferService bankTransfer = new BankTransfer();
		while (true) {
			System.out.println("\n----------- HOME PAGE -----------");
			System.out.println("1. Create User Wallet");
			System.out.println("2. Add Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Fund Transfer");
			System.out.println("5. View Transaction History");
			System.out.println("6. View All Users");
			System.out.println("0. Exit");
			System.out.print("Enter choice: ");
			int choice = sc.nextInt();
			if (choice == 0) {
				System.out.println("Thank you for using Digital Wallet System!!");
				break;
			}
			switch (choice) {
			//CRUD Operations
			case 1:     //create user wallet
				System.out.print("\nEnter User Id: ");
				int uid = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter User Name: ");
				String uname = sc.nextLine();

				User user = new User(uid, uname);
				users.add(user);

				System.out.println("Wallet Created Successfully!");
				break;

			case 2:   //add money
				System.out.print("\nEnter User Id: ");
				int addId = sc.nextInt();

				User addUser = findUser(users, addId);
				if (addUser == null) {
					System.out.println("User not found!");
					break;
				}

				System.out.print("Enter Amount to Add: ");
				double addAmount = sc.nextDouble();

				addUser.getWallet().addMoney(addAmount);
				transactions.add(new Transaction(addId, "ADD", addAmount, "Money Added"));

				System.out.println("Money Added Successfully!");
				break;
				
			case 3:   //withdraw money
				System.out.print("\nEnter User Id: ");
				int wid = sc.nextInt();

				User withdrawUser = findUser(users, wid);
				if (withdrawUser == null) {
					System.out.println("User not found!");
					break;
				}

				System.out.print("Enter Amount to Withdraw: ");
				double withdrawAmount = sc.nextDouble();

				try {
					withdrawUser.getWallet().withdrawMoney(withdrawAmount);
					transactions.add(new Transaction(wid, "WITHDRAW", withdrawAmount, "Money Withdrawn"));
					System.out.println("Money Withdrawn Successfully!");
				} catch (InsufficientBalanceException e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;

			case 4:   //fund transfer 
				if (users.size() < 2) {
					System.out.println("Need at least 2 users for transfer!");
					break;
				}
				System.out.print("\nEnter Sender User Id: ");
				int senderId = sc.nextInt();
				System.out.print("Enter Receiver User Id: ");
				int receiverId = sc.nextInt();
				User sender = findUser(users, senderId);
				User receiver = findUser(users, receiverId);

				if (sender == null || receiver == null) {
					System.out.println("Invalid sender/receiver id!");
					break;
				}

				System.out.print("Enter Amount to Transfer: ");
				double amount = sc.nextDouble();

				System.out.println("Select Transfer Type:");
				System.out.println("1. Wallet Transfer");
				System.out.println("2. Bank Transfer");
				System.out.print("Enter type: ");
				int ttype = sc.nextInt();

				try {
					if (ttype == 1) {
						walletTransfer.transfer(sender, receiver, amount, transactions);
						System.out.println("Wallet Transfer Successful!");
					} else if (ttype == 2) {
						bankTransfer.transfer(sender, receiver, amount, transactions);
						System.out.println("Bank Transfer Successful!");
					} else {
						System.out.println("Invalid transfer type!");
					}
				} catch (InsufficientBalanceException e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;

			//transaction tracking
			case 5:
				System.out.print("\nEnter User Id: ");
				int tid = sc.nextInt();

				System.out.println("\n----- Transaction History -----");
				boolean found = false;
				for (Transaction t : transactions) {
					if (t.getUserId() == tid) {
						System.out.println(t);
						found = true;
					}
				}
				if (!found) {
					System.out.println("No transactions found!");
				}
				break;

			case 6:
				System.out.println("\n----- Users -----");
				if (users.size() == 0) {
					System.out.println("No users created yet!");
				} else {
					for (User u : users) {
						System.out.println(u);
					}
				}
				break;

			default:
				System.out.println("Invalid choice!");
			}
		}
	}

	//method to find user
	private static User findUser(ArrayList<User> users, int userId) {
		for (User u : users) {
			if (u.getId() == userId)
				return u;
		}
		return null;
	}
}
