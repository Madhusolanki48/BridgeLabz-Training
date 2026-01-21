package SmartWarehouseManagementSystem;
import java.util.*;

public class SmartWarehouse {
	public static void displayAll(String sectionName,List<? extends WarehouseItem> list) {
		System.out.println("\n" + sectionName + " Items Available:\n");
		System.out.println("-----------------------------------------------");

        for (WarehouseItem item : list) {
            item.displayItem();
        }
        System.out.println("-----------------------------------------------");
    }
	public static void main(String[] args) {
		System.out.println("-----  Welcome to Smart Warehouse System  -----");
		System.out.println("-----------------------------------------------");
		Storage<Electronics> electronicStore=new Storage<>();
		electronicStore.addItem(new Electronics(101,"Laptop",10,75900));
		electronicStore.addItem(new Electronics(102,"Phone",15,56000));
		
		Storage<Furniture> furnitureStore=new Storage<>();
		furnitureStore.addItem(new Furniture(201,"Chair",7,4500));
		furnitureStore.addItem(new Furniture(202,"Table",5,5600));
		
		Storage<Groceries> groceryStore=new Storage<>();
		groceryStore.addItem(new Groceries(301,"Biscuits",59,10));
		groceryStore.addItem(new Groceries(301,"Cold Drinks",25,120));
		
		//method calling
		displayAll("Electronics", electronicStore.getItems());
		displayAll("Furniture", furnitureStore.getItems());
		displayAll("Groceries", groceryStore.getItems());
		
		
	}

}
