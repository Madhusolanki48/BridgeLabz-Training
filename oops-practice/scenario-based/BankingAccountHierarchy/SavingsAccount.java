package BankingAccountHierarchy;
import java.util.*;

class SavingsAccount extends BankAccount {

	//constructor
	SavingsAccount(String accountNumber, double balance) {
		super(accountNumber, balance);
	}

	//Savings: 0.5% of balance
	@Override
	public double calculateFee() {
		return getBalance() * 0.005;
	}
}
