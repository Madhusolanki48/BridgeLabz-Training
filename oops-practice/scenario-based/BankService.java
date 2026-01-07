package OnlineBankingSystem;

public interface BankService {

    void transfer(Account from, Account to, double amount)
        throws InsufficientBalanceException;
}

