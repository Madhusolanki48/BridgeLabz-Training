package DisasterReliefResourceAllocationSystem;

public class DisasterReliefApp {

	public static void main(String[] args) {

		ReliefRepository repo = new ReliefRepository();

		// create center
		ReliefCenter center1 = new ReliefCenter("Relief Center 1");
		center1.addResource("Food", 100);
		center1.addResource("Water", 50);

		repo.addCenter(center1);

		// service
		AllocationService service = new AllocationService(repo);

		// requests (FIFO)
		service.addRequest(new AreaRequest("AreaA", "Food", 40));
		service.addRequest(new AreaRequest("AreaB", "Water", 60));

		service.processRequests();
	}
}
