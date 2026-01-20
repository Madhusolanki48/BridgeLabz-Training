package BankingAccountHierarchy;
import java.util.*;

abstract class BankAccount {
	//immutable core data
	private final String accountNumber;
	private final double balance;

	//parameterized constructor
	BankAccount(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	//getter methods
	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	//polymorphic method
	public abstract double calculateFee();
}
