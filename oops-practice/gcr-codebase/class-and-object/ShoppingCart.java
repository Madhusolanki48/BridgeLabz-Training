package class_and_object;

// Class to model cart items
class CartItem {
	//attributes
    private String itemName;   
    private double price;
    private int quantity;

    //constructor
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    //method to add an item to the cart
    public void addItem(int qty) {
        quantity += qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }

    //method to remove an item from the cart
    public void removeItem(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        }
    }

    //calculate total cost
    public double getTotalCost() {
        return price * quantity;
    }

    //method to display item details
    public void display() {
        System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity);
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        CartItem c = new CartItem("Laptop", 999.99, 1);
        c.display();
        c.addItem(2);
        c.removeItem(1);

        System.out.println("Total cost: $" + c.getTotalCost());
    }
}
