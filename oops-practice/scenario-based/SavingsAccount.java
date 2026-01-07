package OnlineBankingSystem;

public class SavingsAccount extends Account {
    private double interestRate = 0.05; // 5%

    public SavingsAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }
}

