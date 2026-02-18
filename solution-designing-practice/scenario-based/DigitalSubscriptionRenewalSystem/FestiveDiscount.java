package DigitalSubscriptionRenewalSystem;

// 10% discount strategy
public class FestiveDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double amount) {
        return amount * 0.9;
    }
}