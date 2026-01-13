package DigitalWalletSystem;

//transaction class
public class Transaction {
	//attributes
	private int userId;
	private String type;
	private double amount;
	private String message;

	//constructor
	public Transaction(int userId, String type, double amount, String message) {
		this.userId = userId;
		this.type = type;
		this.amount = amount;
		this.message = message;
	}

	//getters
	public int getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "Transaction Details: " + "User Id - " + userId + " | Type - " + type + " | Amount - ₹" + amount
				+ " | Note - " + message;
	}
}
