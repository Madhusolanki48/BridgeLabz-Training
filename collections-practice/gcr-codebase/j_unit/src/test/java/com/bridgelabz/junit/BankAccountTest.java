package com.bridgelabz.junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    //check deposit updates balance
    @Test
    void testDeposit() {
        BankAccount account = new BankAccount();
        account.deposit(1000);
        assertEquals(1000, account.getBalance());
    }

    //check withdraw updates balance
    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount();
        account.deposit(1000);
        account.withdraw(400);
        assertEquals(600, account.getBalance());
    }

    //withdraw fails if balance is insufficient
    @Test
    void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount();
        account.deposit(500);

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(800);
        });
    }
}

