package DigitalWalletSystem;

import java.util.ArrayList;

//bank transfer class
public class BankTransfer implements TransferService {

	@Override
	public void transfer(User sender, User receiver, double amount, ArrayList<Transaction> transactions)
			throws InsufficientBalanceException {

		//bank transfer fee 2%
		double fee = amount * 0.02;
		double totalDebit = amount + fee;

		//checking balance
		sender.getWallet().withdrawMoney(totalDebit);

		//transfer money
		receiver.getWallet().addMoney(amount);

		//store transactions
		transactions.add(new Transaction(sender.getId(), "BANK_TRANSFER", totalDebit,
				"Transferred to User Id: " + receiver.getId() + " (Fee: ₹" + fee + ")"));

		transactions.add(new Transaction(receiver.getId(), "BANK_RECEIVE", amount,
				"Received from User Id: " + sender.getId()));
	}
}
