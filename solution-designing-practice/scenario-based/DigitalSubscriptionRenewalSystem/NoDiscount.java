package DigitalSubscriptionRenewalSystem;

//no discount strategy
public class NoDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double amount) {
        return amount;
    }
}