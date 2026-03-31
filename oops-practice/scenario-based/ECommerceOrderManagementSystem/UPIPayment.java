package ECommerceOrderManagementSystem;

public class UPIPayment implements Payment {
	public void pay(double amount) throws PaymentFailedException{
		if(amount>20000) {
		throw new PaymentFailedException("UPI Transaction Limit Exceeded! Transaction Failed.");
	}
	System.out.println("UPI Transaction Successfully Done!"+amount);
	}

}
