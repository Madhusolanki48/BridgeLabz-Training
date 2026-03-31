package FoodDeliveryOrderRoutingSystem;
//main class
public class FoodDeliveryApp {

 public static void main(String[] args) {
     DeliveryService service = new DeliveryService();

     service.addAgent(new Agent("Agent1"));
     service.addAgent(new Agent("Agent2"));

     service.addOrder(new Order("101"));
     service.addOrder(new Order("102"));

     try {
         service.assignOrder();
         service.assignOrder();
         service.assignOrder(); // No agent available
     } catch (NoAgentAvailableException e) {
         System.out.println(e.getMessage());
     }

     service.viewActiveDeliveries();
     service.cancelOrder("101");
     service.viewActiveDeliveries();
 }
}

