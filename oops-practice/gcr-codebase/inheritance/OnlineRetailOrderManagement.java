package inheritance;
//Multilevel Inheritance
//Sample Problem 1: Online Retail Order Management

class Order {   //base class
	int orderId;
	String orderDate;

	Order(int orderId,String orderDate){
		this.orderId=orderId;
		this.orderDate=orderDate;
	}

	String getOrderStatus(){
		return "Order Placed";
	}
}
//subclass
class ShippedOrder extends Order { //level 2
	String trackingNumber;

	ShippedOrder(int orderId,String orderDate,String trackingNumber){
		super(orderId,orderDate);
		this.trackingNumber=trackingNumber;
	}

	String getOrderStatus(){
		return "Order Shipped";
	}
}

class DeliveredOrder extends ShippedOrder { //level 3
	String deliveryDate;

	DeliveredOrder(int orderId,String orderDate,String trackingNumber,String deliveryDate){
		super(orderId,orderDate,trackingNumber);
		this.deliveryDate=deliveryDate;
	}

	String getOrderStatus(){
		return "Order Delivered";
	}
}

public class OnlineRetailOrderManagement {
	public static void main(String[] args) {

		Order order1 = new Order(101,"01-01-2026");
		ShippedOrder order2 = new ShippedOrder(102,"02-01-2026","TYUBSH7601");
		DeliveredOrder order3 = new DeliveredOrder(103,"03-01-2026","TDSHSIUS2","05-01-2026");

		System.out.println("Order 1 | Status : "+order1.getOrderStatus());
		System.out.println("Order 2 | Status : "+order2.getOrderStatus());
		System.out.println("Order 3 | Status : "+order3.getOrderStatus());
	}
}
