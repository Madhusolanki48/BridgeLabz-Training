package BankingAccountHierarchy;
import java.util.*;

class CheckingAccount extends BankAccount {

	//constructor
	CheckingAccount(String accountNumber, double balance) {
		super(accountNumber, balance);
	}

	//Checking: flat 1.0 if balance < 1000
	@Override
	public double calculateFee() {
		if (getBalance() < 1000)
			return 1.0;
		return 0.0;
	}
}
