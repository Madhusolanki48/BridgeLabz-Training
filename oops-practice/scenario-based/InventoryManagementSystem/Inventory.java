package InventoryManagementSystem;
import java.util.ArrayList;

//inventory class
public class Inventory {
	//attributes
	private ArrayList<Product> productList;

	//constructor
	public Inventory() {
		productList = new ArrayList<>();
	}
	//method to add product
	public void addProduct(Product product) {
		productList.add(product);
	}

	//method to find product by id
	public Product findProduct(int productId) {
		for (Product p : productList) {
			if (p.getId() == productId) {
				return p;
			}
		}
		return null;
	}

	//method to add stock
	public void addStock(int productId, int quantity) {
		Product p = findProduct(productId);
		if (p != null) {
			p.setStock(p.getStock() + quantity);
		} else {
			System.out.println("Product not found!");
		}
	}

	//method to remove stock
	public void removeStock(int productId, int quantity) throws OutOfStockException {
		Product p = findProduct(productId);
		if (p != null) {
			if (quantity > p.getStock()) {
				throw new OutOfStockException("Not enough stock available for product: " + p.getName());
			}
			p.setStock(p.getStock() - quantity);
		} else {
			System.out.println("Product not found!");
		}
	}

	//getter
	public ArrayList<Product> getProductList() {
		return productList;
	}
	//method to display products
	public void displayProducts() {
		System.out.println("\n----- Inventory Products -----");
		if (productList.size() == 0) {
			System.out.println("No products available!");
			return;
		}
		for (Product p : productList) {
			System.out.println(p);
		}
	}
}
