package FoodDeliveryOrderRoutingSystem;

//custom exception when no agent is available
public class NoAgentAvailableException extends Exception {

	public NoAgentAvailableException(String message) {
		super(message);
	}
}
