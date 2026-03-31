package OnlineBankingSystem;
//Custom exception thrown when withdrawal or transfer is not possible due to low balance
 
public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}