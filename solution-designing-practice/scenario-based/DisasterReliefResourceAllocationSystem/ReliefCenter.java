package DisasterReliefResourceAllocationSystem;
import java.util.*;

public class ReliefCenter {
	private String centerId;
	//store resources
	private Map<String, Integer> resources;
	//constructor
	public ReliefCenter(String centerId) {
		this.centerId=centerId;
		this.resources=new HashMap<>();
	}
	//add resource stock
    public void addResource(String item, int qty) {
        resources.put(item, resources.getOrDefault(item, 0) + qty);
    }

    public Map<String, Integer> getResources() {
        return resources;
    }

    public String getCenterId() {
        return centerId;
    }
}

