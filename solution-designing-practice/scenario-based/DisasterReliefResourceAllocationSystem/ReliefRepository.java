package DisasterReliefResourceAllocationSystem;
import java.util.*;

public class ReliefRepository {
	//stores all centers
    private Map<String, ReliefCenter> centers = new HashMap<>();

    public void addCenter(ReliefCenter center) {
        centers.put(center.getCenterId(), center);
    }
    public ReliefCenter getCenter(String id) {
        return centers.get(id);
    }

    public Map<String, ReliefCenter> getAllCenters() {
        return centers;
    }

}
