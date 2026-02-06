package functional_interface;

//interface with default method
interface PaymentProcessor {

	void pay(double amount);

	//default method
	default void refund(double amount) {
		System.out.println("Refund processed: " + amount);
	}
}

//existing implementation 
class UpiPayment implements PaymentProcessor {
	public void pay(double amount) {
		System.out.println("UPI payment: " + amount);
	}
}

public class PaymentGatewayIntegration {
	public static void main(String[] args) {
		PaymentProcessor payment = new UpiPayment();
		payment.pay(500);
		payment.refund(200);
	}
}
