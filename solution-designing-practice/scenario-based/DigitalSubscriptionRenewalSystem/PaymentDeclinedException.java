package DigitalSubscriptionRenewalSystem;

//custom exception
public class PaymentDeclinedException extends Exception {
    public PaymentDeclinedException(String msg) {
        super(msg);
    }
}