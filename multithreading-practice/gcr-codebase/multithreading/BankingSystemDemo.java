package multithreading;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

class BankAccount {
	private double balance = 10000.0;

	//for demo: we will toggle synchronization
	private final boolean isSynchronized;

	public BankAccount(boolean isSynchronized) {
		this.isSynchronized = isSynchronized;
	}

	public double getBalance() {
		return balance;
	}

	public void withdraw(double amount, String customerName) {
		if (isSynchronized) {
			synchronizedWithdraw(amount, customerName);
		} else {
			unsynchronizedWithdraw(amount, customerName);
		}
	}

	private synchronized void synchronizedWithdraw(double amount, String customerName) {
		performWithdraw(amount, customerName);
	}

	private void unsynchronizedWithdraw(double amount, String customerName) {
		performWithdraw(amount, customerName);
	}

	private void performWithdraw(double amount, String customerName) {
		if (balance >= amount) {
			// Simulate processing delay ->increases chance of race condition in unsafe mode
			try {
				Thread.sleep(30 + new Random().nextInt(120));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}

			balance -= amount;

			System.out.printf("Transaction successful: %s, Amount: %.0f, Balance: %.0f, Time: %s%n", customerName,
					amount, balance, LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));
		} else {
			System.out.printf("Transaction FAILED: %s, Amount: %.0f, Insufficient balance: %.0f%n", customerName,
					amount, balance);
		}
	}
}

class Transaction implements Runnable {
	private final BankAccount account;
	private final double amount;
	private final String customerName;

	public Transaction(BankAccount account, double amount, String customerName) {
		this.account = account;
		this.amount = amount;
		this.customerName = customerName;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.printf("[%s] %s attempting to withdraw %.0f (Balance before: %.0f)%n", threadName, customerName,
				amount, account.getBalance());

		account.withdraw(amount, customerName);
	}
}

public class BankingSystemDemo {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("=== PART 1: UNSAFE (race condition likely) ===");
		runSimulation(false);

		System.out.println("\n=== PART 2: SAFE (synchronized) ===");
		runSimulation(true);
	}

	private static void runSimulation(boolean synchronizedMode) throws InterruptedException {
		BankAccount account = new BankAccount(synchronizedMode);

		double[] amounts = { 3000, 4000, 2000, 5000, 1500 };
		String[] customers = { "Andrew", "Pablo", "Raven", "Samuel", "Venom" };

		Thread[] threads = new Thread[5];

		System.out.println("Initial balance: ₹" + account.getBalance());
		System.out.println("----------------------------------------");

		for (int i = 0; i < 5; i++) {
			threads[i] = new Thread(new Transaction(account, amounts[i], customers[i]), "Customer-" + (i + 1));
			System.out.println("Created thread: " + threads[i].getName() + " (" + customers[i] + ")");
		}

		System.out.println("\nStarting transactions...\n");

		// Start all threads
		for (Thread t : threads) {
			t.start();
		}

		// Wait for completion
		for (Thread t : threads) {
			t.join();
		}

		System.out.println("\nFinal balance: " + account.getBalance());
		double totalWithdrawn = 3000 + 4000 + 2000 + 5000 + 1500;
		System.out.println("Expected final balance (if all succeed): " + (10000 - totalWithdrawn));
		System.out.println("----------------------------------------\n");
	}
}