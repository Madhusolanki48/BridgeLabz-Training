package OnlineBankingSystem;

public class CurrentAccount extends Account {
    private double interestRate = 0.02; // 2%

    public CurrentAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }
}

