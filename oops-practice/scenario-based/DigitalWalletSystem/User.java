package DigitalWalletSystem;

//user class
public class User {
	//attributes
	private int userId;
	private String name;
	private Wallet wallet;

	//constructor
	public User(int userId, String name) {
		this.userId = userId;
		this.name = name;
		this.wallet = new Wallet(0);
	}

	//getters
	public int getId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public Wallet getWallet() {
		return wallet;
	}

	@Override
	public String toString() {
		return "User Details: " + "Id - " + userId + " | Name - " + name + " | Balance - ₹" + wallet.getBalance();
	}
}
