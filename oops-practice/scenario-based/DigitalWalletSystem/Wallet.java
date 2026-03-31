package DigitalWalletSystem;

//wallet class
public class Wallet {
	//attribute
	private double balance;

	//constructor
	public Wallet(double balance) {
		this.balance = balance;
	}

	//getter
	public double getBalance() {
		return balance;
	}

	//method to add money
	public void addMoney(double amount) {
		balance += amount;
	}

	//method to withdraw money
	public void withdrawMoney(double amount) throws InsufficientBalanceException {
		if (amount > balance) {
			throw new InsufficientBalanceException("Insufficient balance! Available balance is ₹" + balance);
		}
		balance -= amount;
	}
}
