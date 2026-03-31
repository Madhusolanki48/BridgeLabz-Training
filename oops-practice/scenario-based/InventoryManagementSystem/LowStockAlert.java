package InventoryManagementSystem;

//alert class
public class LowStockAlert implements AlertService {

	//method to check low stock
	public void checkLowStock(Inventory inventory) {
		System.out.println("\n----- Low Stock Alerts -----");

		boolean found = false;
		for (Product p : inventory.getProductList()) {
			if (p.getStock() <= 5) {
				System.out.println("Alert! Low stock for: " + p.getName() + " | Remaining: " + p.getStock());
				found = true;
			}
		}

		if (!found) {
			System.out.println("No low stock alerts.");
		}
	}
}
