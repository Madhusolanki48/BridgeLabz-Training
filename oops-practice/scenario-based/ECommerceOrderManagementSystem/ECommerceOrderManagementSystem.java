package ECommerceOrderManagementSystem;
import java.util.ArrayList;
import java.util.Scanner;
//main class
public class ECommerceOrderManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //product catalog
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Smart Phone", 45000, 10));
        products.add(new Product(2, "Power Bank", 3500, 30));
        products.add(new Product(3, "DSLR Camera", 35000, 30));
        Customer customer = new Customer(101, "Maxwell", "8974647382");
        System.out.println("Welcome to E-Commerce Order Management System");

        //show Catalog
        System.out.println("\n----- Product Catalog -----");
        for (Product p : products) System.out.println(p);
        //create Order
        Order order = new Order(1001, customer);
        //user input to add items id and quantity
        while (true) {
            System.out.print("\nEnter Product ID to buy (0 to stop): ");
            int productId = sc.nextInt();

            if (productId == 0)
                break;

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            Product selected = null;

            for (Product product : products) {
                if (product.getId() == productId) {
                    selected = product;
                    break;
                }
            }
            if (selected == null) {
                System.out.println("Invalid Product ID!");
            } else if (quantity <= 0) {
                System.out.println("Quantity must be greater than 0!");
            } else if (quantity > selected.getStock()) {
                System.out.println("Not enough stock available!");
            } else {
                order.addItem(selected, quantity);
                System.out.println("Added to order: " + selected.getName() + " | Quantity Ordered: " + quantity);
            }
        }

        double total = order.calculateTotalPrice();
        System.out.println("\nTotal Payable Amount: ₹" + total);

        //choose payment method
        System.out.println("\nSelect Payment Method:");
        System.out.println("1. Card");
        System.out.println("2. UPI");
        System.out.println("3. Wallet");
        int choice = sc.nextInt();
        Payment payment = null;
        if (choice == 1)
            payment = new CardPayment();
        else if (choice == 2)
            payment = new UPIPayment();
        else if (choice == 3)
            payment = new WalletPayment();
        else
            System.out.println("Invalid choice");
        boolean paymentSuccess = false;
        try {
            if (payment != null) {
                payment.pay(total);
                paymentSuccess = true;
                System.out.println("Payment Successful! Order Confirmed.");
            }
        } catch (PaymentFailedException e) {
            System.out.println("Error " + e.getMessage());
            System.out.println("Order not placed due to payment failure.");
           
        }
        //only if payment successful
        if (paymentSuccess) {
            //tracking delivery
            System.out.println("\nUpdating Delivery Status...");
            order.updateDeliveryStatus("Shipped");
            System.out.println("Delivery Status: " + order.getDeliveryStatus());
            //cancel order
            System.out.println("\nDo you want to cancel the order? (yes/no): ");
            String cancel = sc.next();
            if (cancel.equalsIgnoreCase("yes")) {
                order.cancelOrder();
                System.out.println("Order Cancelled Successfully!");
            }
            order.displayOrderDetails();
        }
        System.out.println("Thank you for Shopping! Visit Again.");
    }
}
