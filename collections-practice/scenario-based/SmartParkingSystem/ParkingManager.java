package SmartParkingSystem;

import java.util.*;

//Service class
public class ParkingManager {

	Map<Integer, ParkingSlot> slotMap = new HashMap<>();
	Queue<Vehicle> waitingQueue = new LinkedList<>();

	// method to add slot
	public void addSlot(ParkingSlot slot) {
		slotMap.put(slot.slotId, slot);
	}

	// method to add vehicle to queue
	public void addVehicle(Vehicle vehicle) {
		waitingQueue.add(vehicle);
	}

	// method to allocate nearest free slot
	public void allocateSlot() throws NoParkingSlotAvailableException {

		if (waitingQueue.isEmpty())
			return;

		for (ParkingSlot slot : slotMap.values()) {
			if (!slot.isOccupied) {
				Vehicle vehicle = waitingQueue.poll();
				slot.isOccupied = true;
				System.out.println("Vehicle Number : " + vehicle.vehicleNumber);
				System.out.println("Allocated Slot : " + slot.slotId);
				System.out.println("Status         : SUCCESS");
				System.out.println("----------------------------------");

				return;
			}
		}

		throw new NoParkingSlotAvailableException("No Parking Slot Available");
	}
}
