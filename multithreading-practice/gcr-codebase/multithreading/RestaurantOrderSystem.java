package multithreading;

class Chef extends Thread {
	private final String dish;
	private final long cookingTimeMillis; // total time to prepare this dish

	public Chef(String chefName, String dish, double cookingTimeSeconds) {
		super(chefName); // Thread name = Chef-1, Chef-2, etc.
		this.dish = dish;
		this.cookingTimeMillis = (long) (cookingTimeSeconds * 1000);
	}

	@Override
	public void run() {
		String chefName = getName();

		System.out.println(chefName + " started preparing " + dish);

		// Progress checkpoints: 25%, 50%, 75%, 100%
		int[] percentages = { 25, 50, 75, 100 };
		long timePerStep = cookingTimeMillis / 4;

		try {
			for (int percent : percentages) {
				// Simulate cooking time for this segment
				Thread.sleep(timePerStep);

				System.out.printf("%s preparing %s: %d%% complete%n", chefName, dish, percent);
			}

			// Final completion message
			System.out.println(chefName + " completed " + dish + " ✓");

		} catch (InterruptedException e) {
			System.out.println(chefName + " was interrupted while preparing " + dish);
			Thread.currentThread().interrupt();
		}
	}
}

public class RestaurantOrderSystem {
	public static void main(String[] args) {
		System.out.println("Kitchen opened - Manager starting order processing...");
		System.out.println("----------------------------------------");

		// Define orders: dish + estimated cooking time in seconds
		String[] dishes = { "Pizza", "Pasta", "Salad", "Burger" };
		double[] timesSeconds = { 3.0, 2.0, 1.0, 2.5 };

		Chef[] chefs = new Chef[4];

		// Create and name chefs
		for (int i = 0; i < 4; i++) {
			String chefName = "Chef-" + (i + 1);
			chefs[i] = new Chef(chefName, dishes[i], timesSeconds[i]);
			System.out.println("Assigned: " + chefName + " → " + dishes[i]);
		}

		System.out.println("\nStarting cooking...\n");

		// Start all chef threads
		for (Chef chef : chefs) {
			chef.start();
		}

		// Manager (main thread) waits for all chefs to finish
		try {
			for (Chef chef : chefs) {
				chef.join(); // wait for this chef to complete
			}
		} catch (InterruptedException e) {
			System.out.println("Manager interrupted while waiting for chefs");
			Thread.currentThread().interrupt();
		}

		System.out.println("\n----------------------------------------");
		System.out.println("Kitchen closed - All orders completed");
	}
}