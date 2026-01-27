package exceptions;
import java.util.Scanner;
//custom checked exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
//Bank account class
class BankAccount {
    double balance = 5000;
    //constructor
    BankAccount() {
    	System.out.println("Current Balance: " + balance);
    	}
    //method to withdraw
    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful, New Balance: " + balance);
    }
}

public class BankTransactionSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();
        //user input
        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();

        try {
            account.withdraw(amount);
        } catch (InsufficientBalanceException e) {   //handles insufficient balance exception
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {   //handles negative input
            System.out.println("Invalid amount!");
        }
    }
}
