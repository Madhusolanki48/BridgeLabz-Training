package OnlineBankingSystem;
 
public class BankServiceImplementation implements BankService {  //handles fund transfers safely using synchronized block

    @Override
    public synchronized void transfer(Account from, Account to, double amount)
            throws InsufficientBalanceException {
    	from.withdraw(amount);
        to.deposit(amount);

        System.out.println("Transfer Successful: " + amount);
    }
}
