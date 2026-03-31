package DigitalWalletSystem;

import java.util.ArrayList;

//wallet transfer class
public class WalletTransfer implements TransferService {

	@Override
	public void transfer(User sender, User receiver, double amount, ArrayList<Transaction> transactions)
			throws InsufficientBalanceException {

		//checking balance
		sender.getWallet().withdrawMoney(amount);

		//transfer
		receiver.getWallet().addMoney(amount);

		//store transactions
		transactions.add(new Transaction(sender.getId(), "WALLET_TRANSFER", amount,
				"Transferred to User Id: " + receiver.getId()));

		transactions.add(new Transaction(receiver.getId(), "WALLET_RECEIVE", amount,
				"Received from User Id: " + sender.getId()));
	}
}
