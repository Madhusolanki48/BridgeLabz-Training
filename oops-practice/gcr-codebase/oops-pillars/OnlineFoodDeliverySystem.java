package oops_pillars;
import java.util.*;

//interface
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

//abstract class
abstract class FoodItem implements Discountable {
    //encapsulated fields
    private String itemName;
    protected double price;
    protected int quantity;

    //constructor
    public FoodItem(String itemName,double price,int quantity){
        this.itemName=itemName;
        this.price=price;
        this.quantity=quantity;
    }

    //abstract method
    public abstract double calculateTotalPrice();

    //concrete method
    public void getItemDetails(){
        System.out.println("Item Name   : "+itemName);
        System.out.println("Price       : "+price);
        System.out.println("Quantity    : "+quantity);
        System.out.println("Total Price : "+calculateTotalPrice());
        System.out.println("------------------------------");
    }
}

//veg item
class VegItem extends FoodItem {
    public VegItem(String itemName,double price,int quantity){
        super(itemName,price,quantity);
    }
    @Override
    public double calculateTotalPrice(){
        return (price * quantity) - applyDiscount();
    }
    @Override
    public double applyDiscount(){
        return price * 0.05;
    }
    @Override
    public String getDiscountDetails(){
        return "5% Veg Discount Applied";
    }
}

//non-veg item
class NonVegItem extends FoodItem {
    public NonVegItem(String itemName,double price,int quantity){
        super(itemName,price,quantity);
    }
    @Override
    public double calculateTotalPrice(){
        return (price * quantity) + 50;
    }
    @Override
    public double applyDiscount(){
        return 0;
    }
    @Override
    public String getDiscountDetails(){
        return "No Discount";
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Paneer Roll",120,2));
        order.add(new NonVegItem("Chicken Biryani",250,1));

        //polymorphism
        for(FoodItem item : order){
            item.getItemDetails();
        }
    }
}
