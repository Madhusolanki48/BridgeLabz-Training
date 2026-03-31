package constructors_access_modifiers;
//Instance vs. Class Variables and Methods
//Problem 1: Product Inventory
public class Product {
    private String productName;     // instance variable
    private double price;           // instance variable
    private static int totalProducts; // class variable

    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;    //count products
    }

    //instance method
    public void displayProductDetails() {
        System.out.println("Product name: "+productName);
        System.out.println("Product price: "+price);
        System.out.println("----------------------------------");
        
    }

    //class method
    public static void displayTotalProducts() {
    	
        System.out.println("Total Products: " + totalProducts);
    }

    public static void main(String[] args) {
        Product product1 = new Product("Guitar", 8900);
        Product product2 = new Product("Instax Camera", 6799);

        product1.displayProductDetails();
        product2.displayProductDetails();

        Product.displayTotalProducts();
    }
}

