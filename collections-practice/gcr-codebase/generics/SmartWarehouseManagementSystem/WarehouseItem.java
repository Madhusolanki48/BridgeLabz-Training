package SmartWarehouseManagementSystem;

abstract class WarehouseItem {  //abstract class
	//attributes
	int itemId;
	String itemName;
	int quantity;
    double price;
	//constructor
	WarehouseItem(int itemId, String itemName,int quantity, double price){
		this.itemId=itemId;
		this.itemName=itemName;
		this.quantity = quantity;
        this.price = price;
	}
	//getter method
	public int getId() {
		return itemId;
	}
	public String getName() {
		return itemName;
	}
	public void displayItem() {
		System.out.println("Item ID      : " + itemId);
        System.out.println("Item Name    : " + itemName);
        System.out.println("Quantity     : " + quantity);
        System.out.println("Price        : " + price);
        System.out.println();
	}

}
