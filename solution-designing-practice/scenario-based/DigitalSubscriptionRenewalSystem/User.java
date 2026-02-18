package DigitalSubscriptionRenewalSystem;

import java.time.LocalDate;

//user entity
public class User {
    //attribute
    String name;
    LocalDate expiryDate;
    boolean paymentValid;
    //constructor
    public User(String name, LocalDate expiryDate, boolean paymentValid) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.paymentValid = paymentValid;
    }
}