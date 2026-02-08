package multithreading;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class TaskRunner extends Thread {
	private final int id;
	private final AtomicInteger activeTasks;

	public TaskRunner(int id, AtomicInteger activeTasks) {
		super("Task-" + id);
		this.id = id;
		this.activeTasks = activeTasks;
	}

	@Override
	public void run() {
		try {
			// State: RUNNABLE (just entered run())
			System.out.println("[" + getName() + "] Starting task...");

			// Simulate some quick work (RUNNABLE)
			Thread.sleep(400); // small computation

			// Enter TIMED_WAITING
			System.out.println("[" + getName() + "] Entering sleep (TIMED_WAITING)...");
			Thread.sleep(2000); // 2 seconds sleep → TIMED_WAITING

			// Back to RUNNABLE, finishing work
			System.out.println("[" + getName() + "] Woke up, finishing task...");
			Thread.sleep(600); // final small work

			System.out.println("[" + getName() + "] Task completed.");
		} catch (InterruptedException e) {
			System.out.println("[" + getName() + "] Interrupted!");
			Thread.currentThread().interrupt();
		} finally {
			activeTasks.decrementAndGet();
		}
	}
}

class StateMonitor extends Thread {
	private final List<Thread> tasksToMonitor;
	private final AtomicInteger activeTasks;
	private final List<String> stateHistory = new ArrayList<>();

	public StateMonitor(List<Thread> tasks, AtomicInteger activeTasks) {
		super("Monitor");
		this.tasksToMonitor = tasks;
		this.activeTasks = activeTasks;
	}

	@Override
	public void run() {
		DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern("HH:mm:ss");

		while (activeTasks.get() > 0 || anyThreadAlive()) {
			try {
				Thread.sleep(500); // check every 500ms

				String now = LocalTime.now().format(timeFmt);

				for (Thread t : tasksToMonitor) {
					Thread.State state = t.getState();
					String msg = String.format("[%s] %s is in %s state at %s", getName(), t.getName(), state, now);

					System.out.println(msg);
					stateHistory.add(msg);
				}

			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
		}

		// Final summary
		System.out.println("\n" + "=".repeat(50));
		System.out.println("Monitoring complete. Summary of observed states:");
		System.out.println("-".repeat(40));

		// Show NEW and TERMINATED lines
		for (String line : stateHistory) {
			if (line.contains("NEW") || line.contains("TERMINATED")) {
				System.out.println(line);
			}
		}

		// Count unique states per task (fixed version)
		System.out.println("\nDistinct states count per task:");
		for (int i = 1; i <= tasksToMonitor.size(); i++) {
			final int taskNumber = i; // <--- this makes it effectively final for the lambda

			long count = stateHistory.stream().filter(s -> s.contains("Task-" + taskNumber)).map(s -> {
				try {
					return s.split(" is in ")[1].split(" state")[0].trim();
				} catch (Exception ex) {
					return "UNKNOWN";
				}
			}).distinct().count();

			System.out.printf("Task-%d went through %d distinct states%n", taskNumber, count);
		}

		System.out.println("=".repeat(50));
	}

	private boolean anyThreadAlive() {
		for (Thread t : tasksToMonitor) {
			if (t.isAlive()) {
				return true;
			}
		}
		return false;
	}
}

public class ThreadStateMonitorDemo {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("=== Thread State Monitoring Demo Started ===\n");

		AtomicInteger activeTasks = new AtomicInteger(0);

		List<Thread> tasks = new ArrayList<>();

		// Create 2 worker tasks
		for (int i = 1; i <= 2; i++) {
			Thread t = new TaskRunner(i, activeTasks);
			tasks.add(t);
			activeTasks.incrementAndGet();
		}

		// Create monitor
		StateMonitor monitor = new StateMonitor(tasks, activeTasks);

		// Show initial NEW state
		System.out.println("Initial thread states (before start):");
		for (Thread t : tasks) {
			System.out.printf("%s → %s%n", t.getName(), t.getState());
		}
		System.out.println();

		// Start monitor first
		monitor.start();

		// Then start worker threads
		for (Thread t : tasks) {
			t.start();
		}

		// Wait for monitor to finish
		monitor.join();

		System.out.println("\nMain thread: All monitoring completed.");
	}
}