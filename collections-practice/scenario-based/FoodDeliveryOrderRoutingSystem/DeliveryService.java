package FoodDeliveryOrderRoutingSystem;
import java.util.*;

//manages order routing and delivery
public class DeliveryService {

	//FIFO order storage
	private Queue<Order> orderQueue = new LinkedList<>();

	//List of delivery agents
	private List<Agent> agents = new ArrayList<>();

	//Active deliveries
	private Map<String, String> activeDeliveries = new HashMap<>();

	//method to add new order
	public void addOrder(Order order) {
		orderQueue.offer(order);
	}

	//method to add delivery agent
	public void addAgent(Agent agent) {
		agents.add(agent);
	}

	// Assign order to nearest available agent-FIFO
	public void assignOrder() throws NoAgentAvailableException {

		Order order = orderQueue.poll();
		if (order == null)
			return;

		for (Agent agent : agents) {
			if (agent.isAvailable()) {
				agent.assign();
				activeDeliveries.put(order.getOrderId(), agent.getAgentId());
				return;
			}
		}
		throw new NoAgentAvailableException("No delivery agent available");
	}

	//method to cancel an active delivery
	public void cancelOrder(String orderId) {
		if (activeDeliveries.containsKey(orderId)) {
			String agentId = activeDeliveries.remove(orderId);
			for (Agent agent : agents) {
				if (agent.getAgentId().equals(agentId)) {
					agent.freeUp();
				}
			}
		}
	}

	//method to view active deliveries
	public void viewActiveDeliveries() {
		System.out.println(activeDeliveries);
	}
}
