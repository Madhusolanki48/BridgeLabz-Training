package ECommerceOrderManagementSystem;

public class WalletPayment implements Payment {
	private double walletBalance=12000;
	public void pay(double amount) throws PaymentFailedException{
		if(amount>walletBalance) {   //if amount exceeds walletBalance
			throw new PaymentFailedException("Wallet Balance Insufficient! Payment Failed.");
		}
		walletBalance-=amount;
		System.out.println("Payment Successfully Done!"+amount);
		System.out.println("Remaining Balance in Wallet"+walletBalance);
	}

}
