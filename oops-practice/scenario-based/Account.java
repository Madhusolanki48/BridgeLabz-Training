package OnlineBankingSystem;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
	// attributes
	protected int accountNumber;
	protected String holderName;
	protected double balance;
	protected List<String> transactions = new ArrayList<>();

	// constructor
	public Account(int accountNumber, String holderName, double balance) {
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}

	// getters
	public int getAccountNumber() {
		return accountNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public double getBalance() {
		return balance;
	}

	public synchronized void deposit(double amount) {
		balance += amount;
		transactions.add("Deposited: ₹" + amount);
	}
  
	public synchronized void withdraw(double amount) throws InsufficientBalanceException {
		if (amount > balance)
			throw new InsufficientBalanceException("Insufficient Balance!");

		balance -= amount;
		transactions.add("Withdrawn: " + amount);
	}

	public void printTransactions() {
		System.out.println("\nTransaction History for " + holderName + ":");
		if (transactions.isEmpty()) {
			System.out.println("No transactions yet.");
			return;
		}
		for (String t : transactions) {
			System.out.println(t);
		}
	}

	//abstract : polymorphism in subclasses
	public abstract double calculateInterest();
}
