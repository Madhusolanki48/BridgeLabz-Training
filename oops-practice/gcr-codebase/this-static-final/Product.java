package this_static_final;
//Program 4: Shopping Cart System
public class Product {
    //static variable shared by all products
    private static double discount = 10.0; //(in perecentage)
    //final variable
    private final String productID;
    //instance variables
    private String productName;
    private double price;
    private int quantity;
    //constructor using 'this'
    public Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
    //static method to update discount
    public static void updateDiscount(double newDiscount) {
        if (newDiscount >= 0 && newDiscount <= 100) {
            discount = newDiscount;
        }
    }
    //calculate price after discount
    public double getPriceAfterDiscount() {
        return price - (price * discount / 100);
    }
    //display product details using instanceof
    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Price after Discount: $" + getPriceAfterDiscount());
        } else {
            System.out.println("Invalid Product Object");
        }
    }
    //main method
    public static void main(String[] args) {
        //create products
        Product product1 = new Product("P001", "Laptop", 1200.0, 5);
        Product product2 = new Product("P002", "Smartphone", 800.0, 10);
        //display product details
        product1.displayProductDetails();
        product2.displayProductDetails();
    }
}