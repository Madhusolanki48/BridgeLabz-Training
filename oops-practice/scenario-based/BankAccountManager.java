package scenario_based;
import java.util.*;

class BankAccount {
	//attributes
    private String accountNumber;
    private double balance;
    //parameterized constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    //method to deposit amount
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Please enter a positive deposit amount!");
            return;
        }
        balance += amount;
        System.out.println("---------------------------------------------------------");
        System.out.println("Amount added successfully! New balance: " + balance);
        System.out.println("---------------------------------------------------------");
    }
    //method to withdraw amount
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Please enter a valid withdrawal amount!");
            return;
        }
        //to prevent overdraft
        if (amount > balance) {
            System.out.println("Oops! You don’t have enough balance for this transaction.");
            return;
        }
        balance -= amount;
        System.out.println("---------------------------------------------------------");
        System.out.println("Withdrawal successful! Remaining balance: " + balance);
        System.out.println("---------------------------------------------------------");
    }
    //method to check balance
    public void checkBalance() {
        System.out.println("Your current balance is: " + balance);
        System.out.println("---------------------------------------------------------");
    }
}

public class BankAccountManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount("AC001", 5000);
        System.out.println("-----------  Welcome to Indian Overseas Bank  -----------");
        System.out.println("---------------------------------------------------------");
       
        while (true) {
        	//bank operations
            System.out.println("\nWhat would you like to do?");
            System.out.println("1️-Deposit money");
            System.out.println("2️-Withdraw money");
            System.out.println("3️-Check my balance");
            System.out.println("4️-Exit banking session");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            System.out.println("---------------------------------------------------------");
            
            switch (choice) {
                case 1:
                    System.out.print("How much would you like to deposit? :");
                    account.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("How much would you like to withdraw? :");
                    account.withdraw(sc.nextDouble());
                    break;

                case 3:
                    System.out.println("Fetching your balance...");
                    System.out.println("---------------------------------------------------------");
                    account.checkBalance();
                    break;

                case 4:
            
                    System.out.println("Thanks for using our banking service. Have a great day!");
                    System.out.println("---------------------------------------------------------");
                    return;

                default:
                    System.out.println("That doesn’t seem right — please choose a valid option.");
            }
        }
    }
}
