package ECommerceOrderManagementSystem;

public class Product {
	//attributes
	private int productId;
	private String productName;
	private double price;
	private int stock;
	//constructor
	public Product(int productId,String productName,double price,int stock) {
		this.productId=productId;
		this.productName=productName;
		this.price=price;
		this.stock=stock;
	}
	//getters
	public int getId() {
		return productId;
	}
	public String getName() {
		return productName;
	}
	public double getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	//method to add quantity to stock
	public void addStock(int quantity ) {
		stock+=quantity;
	}
	//method to remove quantity from stock
	public void removeStock(int quantity) {
		stock-=quantity;
	}
	public String toString(){
		return "Product details[ "+"Id - "+productId+" | Name - "+productName+" | Price - "
	           +price+" | Quantity in Stock - "+stock+" ]";
	}
}
