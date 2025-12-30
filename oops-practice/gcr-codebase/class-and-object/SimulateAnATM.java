package class_and_object;

// Class to simulate bank account operations
class BankAccount {
	//attributes
    private String accountHolder, accountNumber;  
    private double balance;

    //constructor
    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //method to deposit money
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        displayBalance();
    }

    //method to withdrawing money (only if sufficient balance exists)
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw amount is : " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
        displayBalance();
    }

    //method to display the current balance.
    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }
}

public class SimulateAnATM {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("State of Chennai", "ACC101", 700);
        acc.displayBalance();
        acc.deposit(200);
        acc.withdraw(100);
        acc.withdraw(900);
    }
}
