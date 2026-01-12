package ECommerceOrderManagementSystem;
import java.util.Date;
import java.util.ArrayList;

public class Order {
	//attributes
	private int orderId;
	private Customer customer;
	private String status;
	private String deliveryStatus;
	private ArrayList<OrderItem> orderList;
	//constructor
	public Order(int orderId,Customer customer) {
		this.orderId=orderId;
		this.customer=customer;
		this.status="PLACED";
		this.deliveryStatus="Packed";
		this.orderList = new ArrayList<>();
	}
	//getters 
	public int getId() {
		return orderId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public String getStatus() {
		return status;
		}
    public String getDeliveryStatus() {
    	return deliveryStatus;
    	}
	
	//method to add item in list
    public void addItem(Product product, int quantity) {
    	orderList.add(new OrderItem(product, quantity));
    }
	//method to calculate total price
    public double calculateTotalPrice() {
        double total = 0;
        for (OrderItem item : orderList)
        	total += item.totalPrice();
        return total;
    }
	//method to change status
	public void cancelOrder() {
		status="CANCELLED";
		deliveryStatus="Cancelled";
	}
	public void updateDeliveryStatus(String status) {
		status="DELIVERED";
		deliveryStatus="Delivered";
	}
	//method to show order details
	public void displayOrderDetails() {
	System.out.println("--------- Order Deatils ----------");
	System.out.println("Order Id: "+orderId);
	System.out.println("Customer Name: "+customer.getName());
	System.out.println("Items Ordered: ");
	for(OrderItem item: orderList) {
		System.out.println(" "+item);
	}
	System.out.println("Order Status: "+status);
	System.out.println("Delivery Status: "+deliveryStatus);
	System.out.println("Total Amount: "+calculateTotalPrice());
	}

}
