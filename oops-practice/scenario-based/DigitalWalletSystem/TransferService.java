package DigitalWalletSystem;

import java.util.ArrayList;

//interface
public interface TransferService {
	void transfer(User sender, User receiver, double amount, ArrayList<Transaction> transactions)
			throws InsufficientBalanceException;
}
