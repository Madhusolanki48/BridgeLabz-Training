package ECommerceOrderManagementSystem;

public class OrderItem {
	//attributes
	private Product product;
	private int quantity;
	//constructor
	public OrderItem(Product product,int quantity) {
		this.product=product;
		this.quantity=quantity;
	}
	//getters
	public Product getProduct() {
		return product;
	}
	public int getQuantity() {
		return quantity;
	}
	//method to calculate total price
	public double totalPrice() {
		return quantity*product.getPrice();
	}
	@Override
	public String toString() {
		return "Order Item Details : "+"Product Name - "+product.getName()+" | Quantity - "+quantity+
				" | Total Price - "+totalPrice();
		
	}
	

}
