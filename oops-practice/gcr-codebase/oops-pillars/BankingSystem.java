package oops_pillars;
import java.util.*;

//interface
interface Loanable {
    void applyForLoan();
    double calculateLoanEligibility();
}

//abstract class
abstract class BankAccount {
    //encapsulated fields
    private String accountNumber;
    private String holderName;
    protected double balance;

    //constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    //concrete methods
    public void deposit(double amount) {
    	balance += amount;
    	}
    public void withdraw(double amount) {
    	balance -= amount;
    	}

    //abstract method
    public abstract double calculateInterest();

    //display
    public void displayAccount() {
        System.out.println("Account No. : " + accountNumber);
        System.out.println("Holder Name : " + holderName);
        System.out.println("Balance     : " + balance);
        System.out.println("Interest    : " + calculateInterest());
        System.out.println("------------------------------");
    }
}

//savings account
class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance){
    	super(accountNumber,holderName,balance);
    	}
    @Override
    public double calculateInterest() {
    	return balance * 0.04;
    	}
    @Override
    public void applyForLoan() {
    	System.out.println("Loan request submitted");
    	}
    @Override
    public double calculateLoanEligibility() {
    	return balance * 2;
    	}
}

//current account
class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String accountNumber,String holderName,double balance){
    	super(accountNumber,holderName,balance);
    	}
    @Override
    public double calculateInterest() {
    	return 0;   //no interest
    	} 
    @Override
    public void applyForLoan() {
    	System.out.println("Loan request processed");
    	}
    @Override
    public double calculateLoanEligibility() {
    	return balance * 1.5;
    	}
}

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SB10341","Maxwell",50700));
        accounts.add(new CurrentAccount("CA20332","Marine",95600));

        //polymorphism
        for(BankAccount acc : accounts) {
            acc.displayAccount();
        }
    }
}
