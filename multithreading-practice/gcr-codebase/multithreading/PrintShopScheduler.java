package multithreading;

import java.util.ArrayList;
import java.util.List;

class PrintJob implements Runnable {
	private final String jobName;
	private final int totalPages;
	private final int priority; // 1 (lowest) to 10 (highest)
	private final Printer printer;

	public PrintJob(String jobName, int totalPages, int priority, Printer printer) {
		this.jobName = jobName;
		this.totalPages = totalPages;
		this.priority = Math.max(1, Math.min(10, priority)); // clamp 1–10
		this.printer = printer;
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public void run() {
		Thread.currentThread().setPriority(priority);

		String threadName = Thread.currentThread().getName();
		String priorityLabel = getPriorityLabel(priority);

		for (int page = 1; page <= totalPages; page++) {
			printer.printPage(threadName, priorityLabel, jobName, page, totalPages);

			// Simulate printing time: 100ms per page
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("[" + threadName + "] Printing interrupted!");
				return;
			}
		}

		System.out.printf("[%s] %s completed (all %d pages printed)%n", threadName, jobName, totalPages);
	}

	private String getPriorityLabel(int pri) {
		if (pri >= 8)
			return "High Priority";
		if (pri >= 5)
			return "Medium Priority";
		return "Low Priority";
	}
}

class Printer {
	private long startTime;

	public synchronized void printPage(String threadName, String priorityLabel, String jobName, int page,
			int totalPages) {
		if (startTime == 0) {
			startTime = System.currentTimeMillis();
		}

		long currentTime = System.currentTimeMillis() - startTime;

		System.out.printf("[%s] [%s] Printing %s - Page %d of %d (at %d ms)%n", threadName, priorityLabel, jobName,
				page, totalPages, currentTime);
	}

	public long getElapsedTime() {
		return System.currentTimeMillis() - startTime;
	}
}

public class PrintShopScheduler {
	public static void main(String[] args) {
		System.out.println("Starting print jobs...\n");

		Printer sharedPrinter = new Printer();

		// Job specifications (fixed formatting + commas)
		Object[][] jobsData = { { "Job1", 10, 5 }, { "Job2", 5, 8 }, { "Job3", 15, 3 }, { "Job4", 8, 6 },
				{ "Job5", 12, 7 } };

		List<Thread> printThreads = new ArrayList<>();

		// Create and prepare threads
		for (Object[] data : jobsData) {
			String name = (String) data[0];
			int pages = (Integer) data[1]; // safer than (int)
			int prio = (Integer) data[2];

			PrintJob job = new PrintJob(name, pages, prio, sharedPrinter);
			Thread t = new Thread(job, name);
			printThreads.add(t);

			System.out.printf("Submitted: %s (%d pages, priority %d)%n", name, pages, prio);
		}

		System.out.println("\nAll jobs submitted. Starting printing...\n");

		// Start all threads
		for (Thread t : printThreads) {
			t.start();
		}

		// Wait for all to finish
		for (Thread t : printThreads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		long totalTime = sharedPrinter.getElapsedTime();
		System.out.println("\n----------------------------------------");
		System.out.printf("All jobs completed in %d ms%n", totalTime);
		System.out.println("Printer is now idle.");
	}
}