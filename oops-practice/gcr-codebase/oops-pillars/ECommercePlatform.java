package oops_pillars;
import java.util.*;

//interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

//abstract class
abstract class Product implements Taxable {
    //encapsulated fields
    private int productId;
    private String name;
    protected double price;

    //constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    //abstract method
    public abstract double calculateDiscount();

    //concrete method
    public void displayProduct() {
        double finalPrice = price + calculateTax() - calculateDiscount();
        System.out.println("Product ID  : " + productId);
        System.out.println("Product Name: " + name);
        System.out.println("Price       : " + price);
        System.out.println("Final Price : " + finalPrice);
        System.out.println("------------------------------");
    }

    //getters
    public int getProductId() { 
    	return productId; 
    	}
    public String getName() { 
    	return name; 
    	}
}

//electronics product
class Electronics extends Product {
    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }
    @Override
    public double calculateDiscount() {
    	return price * 0.10;  //10% discount
    	} 
    @Override
    public double calculateTax() {
    	return price * 0.18;  //GST
    	} 
    @Override
    public String getTaxDetails() {
    	return "18% GST applied"; 
    	}
}

//clothing product
class Clothing extends Product {
    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }
    @Override
    public double calculateDiscount() {
    	return price * 0.15;   //15% discount
    	} 
    @Override
    public double calculateTax() {
    	return price * 0.05;
    	}
    @Override
    public String getTaxDetails() {
    	return "5% GST applied";
    	}
}

//groceries product
class Groceries extends Product {
    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }
    @Override
    public double calculateDiscount() {
    	return price * 0.05;
    	}
    @Override
    public double calculateTax() {
    	return 0; 
    	} //no tax
    @Override
    public String getTaxDetails() {
    	return "No tax";
    	}
}

public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Electronics(1, "Laptop", 70000));
        products.add(new Clothing(2, "Muffler", 3000));
        products.add(new Groceries(3, "Biscuit", 89));

        //polymorphism
        for(Product p : products) {
            p.displayProduct();
        }
    }
}
