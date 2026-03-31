package InventoryManagementSystem;
import java.util.ArrayList;
import java.util.Scanner;
//main class
public class InventoryManagementSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//inventory object
		Inventory inventory = new Inventory();
		//adding some products initially
		inventory.addProduct(new Product(1, "Bournvita", 50, 20));
		inventory.addProduct(new Product(2, "Biscuit", 30, 10));
		inventory.addProduct(new Product(3, "Choclate", 40, 15));

		//alert service object
		AlertService alert = new LowStockAlert();
		System.out.println("----  Welcome to Inventory Management System  ----");
		while (true) {
			System.out.println("\n----------- Home Page -----------");
			System.out.println("1. View All Products");
			System.out.println("2. Add New Product");
			System.out.println("3. Update Stock");
			System.out.println("4. Low Stock Alerts");
			System.out.println("0. Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();
			if (choice == 0) {
				System.out.println("Thank you! Visit Again...");
				break;
			}
			switch (choice) {
			case 1:
				inventory.displayProducts();
				break;

			case 2:
				System.out.print("\nEnter Product Id: ");
				int pid = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Product Name: ");
				String pname = sc.nextLine();

				System.out.print("Enter Product Price: ");
				double price = sc.nextDouble();

				System.out.print("Enter Stock Quantity: ");
				int stock = sc.nextInt();

				inventory.addProduct(new Product(pid, pname, price, stock));
				System.out.println("Product Added Successfully!");
				break;

			case 3:
				System.out.print("\nEnter Product Id to Update Stock: ");
				int updateId = sc.nextInt();

				System.out.println("1. Add Stock");
				System.out.println("2. Remove Stock");
				System.out.print("Enter option: ");
				int option = sc.nextInt();

				System.out.print("Enter Quantity: ");
				int qty = sc.nextInt();

				try {
					if (option == 1) {
						inventory.addStock(updateId, qty);
						System.out.println("Stock Updated Successfully!");
					} else if (option == 2) {
						inventory.removeStock(updateId, qty);
						System.out.println("Stock Updated Successfully!");
					} else {
						System.out.println("Invalid option!");
					}
				} catch (OutOfStockException e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;

			case 4:
				alert.checkLowStock(inventory);
				break;

			default:
				System.out.println("Invalid choice!");
			}
		}
	}
}
