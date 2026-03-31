package inheritance;
//Hierarchical Inheritance
//Sample Problem 1: Bank Account Types

class BankAccount { //superclass
	//attributes
    String accountNumber;
    double balance;

    BankAccount(String accountNumber,double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    void showAccountDetails(){ //common method
        System.out.println("Account Number : "+accountNumber);
        System.out.println("Balance : "+balance);
    }
}
//subclass
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String acc,double bal,double rate){
        super(acc,bal);
        this.interestRate=rate;
    }

    void displayAccountType(){  //overridden method
        System.out.println("Savings Account");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String acc,double bal,double limit){
        super(acc,bal);
        this.withdrawalLimit=limit;
    }

    void displayAccountType(){
        System.out.println("Checking Account");
    }
}

class FixedDepositAccount extends BankAccount {
    int durationMonths;

    FixedDepositAccount(String acc,double bal,int months){
        super(acc,bal);
        this.durationMonths=months;
    }

    void displayAccountType(){  //method to specify the account type
        System.out.println("Fixed Deposit Account");
    }
}

public class BankAccountTypes {
    public static void main(String[] args) {

        SavingsAccount account1 = new SavingsAccount("1777003738",508900,5.5);
        CheckingAccount account2 = new CheckingAccount("2666728292",805600,30000);
        FixedDepositAccount account3 = new FixedDepositAccount("262829222",2055000,12);

        //savings Account
        account1.displayAccountType();
        account1.showAccountDetails();
        System.out.println("--------------------------------------");

        //checking Account
        account2.displayAccountType();
        account2.showAccountDetails();
        System.out.println("--------------------------------------");

        //fixed Deposit Account
        account3.displayAccountType();
        account3.showAccountDetails();
    }
}
