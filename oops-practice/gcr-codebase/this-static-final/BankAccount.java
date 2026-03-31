package this_static_final;
//Program 1: Bank Account System
public class BankAccount {
    //static variable shared by all accounts
    private static String bankName = "State Bank of India";
    private static int totalAccounts = 0;
    //final variable
    private final String accountNumber;
    //instance variables
    private String accountHolderName;
    private double balance;
    //default constructor
    public BankAccount() {
        this.accountHolderName = "Bhumika";
        this.accountNumber = "345675643";
        this.balance = 567898876;
        totalAccounts++;
    }
    //parameterized constructor
    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber; // final variable assigned once
        this.balance = balance;
        totalAccounts++;
    }
    //getter and setter
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    //static method to take account details
    public static void getTotalAccounts() {
        System.out.println("\nTotal number of accounts: " + totalAccounts);
    }
    //display account details
    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name       : " + bankName);
            System.out.println("Account Holder  : " + accountHolderName);
            System.out.println("Account Number  : " + accountNumber);
            System.out.print("Balance         : $" + balance);
        } else {
            System.out.print("Invalid account instance");
        }
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount>0) {
            balance+=amount;
            System.out.println("\nDeposited: $" + amount);
        } else {
            System.out.println("\nInvalid deposit amount");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }
    //main method
    public static void main(String[] args) {
        //create two bank accounts
        BankAccount account1 = new BankAccount("Lynda Princy", "ACC12345", 1000.00);
        BankAccount account2 = new BankAccount("Prince Danish", "ACC67890", 500.00);
        //display account details
        System.out.println("Account 1 Details");
        account1.displayAccountDetails();
        System.out.println("\nAccount 2 Details");
        account2.displayAccountDetails();
        //check total accounts
        BankAccount.getTotalAccounts();
        //transactions
        System.out.print("Performing transactions on Account 1:");
        account1.deposit(200);
        account1.withdraw(150);
        account1.displayAccountDetails();
        System.out.println("\nPerforming transactions on Account 2:");
        account2.displayAccountDetails();
        account2.deposit(100);
        account2.withdraw(800);
    }
}