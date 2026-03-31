package SmartParkingSystem;

//pepresents parking slot
public class ParkingSlot {
    //attributes
    int slotId;
    boolean isOccupied;
    //constructor
    public ParkingSlot(int slotId) {
        this.slotId = slotId;
        this.isOccupied = false;
    }
}
