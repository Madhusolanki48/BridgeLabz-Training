package DisasterReliefResourceAllocationSystem;

import java.util.*;

public class AllocationService {

	private ReliefRepository repo;
	private Queue<AreaRequest> requestQueue = new LinkedList<>(); // FIFO queue

	public AllocationService(ReliefRepository repo) {
		this.repo = repo;
	}

	// method to add area request
	public void addRequest(AreaRequest request) {
		requestQueue.offer(request);
	}

	// FIFO allocation
	public void processRequests() {

		while (!requestQueue.isEmpty()) {
			AreaRequest req = requestQueue.poll();

			try {
				allocate(req);
			} catch (InsufficientResourceException e) {
				System.out.println("ERROR: " + e.getMessage());
			}
		}
	}

	// allocation logic
	private void allocate(AreaRequest req) throws InsufficientResourceException {

		for (ReliefCenter center : repo.getAllCenters().values()) {

			Map<String, Integer> stock = center.getResources();
			int available = stock.getOrDefault(req.getItem(), 0);

			if (available >= req.getQuantity()) {

				stock.put(req.getItem(), available - req.getQuantity());

				System.out.println("Allocated " + req.getQuantity() + " " + req.getItem() + " to " + req.getAreaName()
						+ " from Center " + center.getCenterId());

				return;
			}
		}

		// if no center has enough stock
		throw new InsufficientResourceException(
				"Insufficient stock for " + req.getItem() + " requested by " + req.getAreaName());
	}
}
