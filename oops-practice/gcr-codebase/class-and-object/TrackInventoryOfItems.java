package class_and_object;

// Class to represent store items
class Item {
	//attributes
    private String itemCode;   
    private String itemName;
    private double price;
    //constructor
    public Item(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }
    //method to display item details
    public void display() {
        System.out.println("itemCode : " + itemCode);
        System.out.println("itemPrice : " + price);
        System.out.println("itemName : " + itemName);
        System.out.println("----------------------------");
    }
}

public class TrackInventoryOfItems {
    public static void main(String[] args) {
        Item item1 = new Item("01AA", "Water bottle", 500);
        Item item2 = new Item("01BB", "Rice", 700);
        Item item3 = new Item("02AA", "blackboard", 400);
        item1.display();
        item2.display();
        item3.display();
    }
}