package OnlineBankingSystem;
import java.util.ArrayList;
import java.util.List;

public class BankServiceManager {

    private List<Account> accounts = new ArrayList<>();

    //create operation
    public void addAccount(Account account) {
        accounts.add(account);
    }

    //read operation
    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }
        for (Account account : accounts) {
            System.out.println("Account No: " + account.getAccountNumber()+ "| Name: " + account.getHolderName()
                    + "| Balance: " + account.getBalance());
        }
    }

    //find account
    public Account getAccount(int accNo) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accNo)
                return account;
        }
        return null;
    }

    //delete operation
    public void deleteAccount(int accountNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accountNumber) {
                accounts.remove(i);
                System.out.println("Account deleted.");
                return;
            }
        }
        System.out.println("Account not found.");
    }
}

