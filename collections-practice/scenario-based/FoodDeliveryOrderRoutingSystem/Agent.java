package FoodDeliveryOrderRoutingSystem;

//represents a delivery agent
public class Agent {

	private String agentId;
	private boolean available;
    //constructor
	public Agent(String agentId) {
		this.agentId = agentId;
		this.available = true;
	}
    //getter method
	public String getAgentId() {
		return agentId;
	}

	public boolean isAvailable() {
		return available;
	}

	public void assign() {
		available = false;
	}

	public void freeUp() {
		available = true;
	}
}
