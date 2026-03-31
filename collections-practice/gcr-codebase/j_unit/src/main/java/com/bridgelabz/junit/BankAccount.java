package com.bridgelabz.junit;
public class BankAccount {
    private double balance = 0.0;
    //method to add money to balance
    public void deposit(double amount) {
        balance += amount;
    }

    //method to withdraw money if sufficient balance
    public void withdraw(double amount) {
        if (amount > balance) {
        	throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }

    //method to return current balance
    public double getBalance() {
        return balance;
    }
}

