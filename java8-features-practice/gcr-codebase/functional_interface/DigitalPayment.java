package functional_interface;

//interface
interface Payment {
	void pay();
}

//UPI implementation
class UPI implements Payment {
	public void pay() {
		System.out.println("Payment done using UPI!");
	}
}

//credit card implementation
class CreditCard implements Payment {
	public void pay() {
		System.out.println("Payment done using Credit Card!");
	}
}

//wallet implementation
class Wallet implements Payment {
	public void pay() {
		System.out.println("Payment done using Wallet!");
	}
}

//Test class
public class DigitalPayment {
	public static void main(String[] args) {
		Payment upi = new UPI();
		Payment card = new CreditCard();
		Payment wallet = new Wallet();

		upi.pay();
		card.pay();
		wallet.pay();
	}
}
