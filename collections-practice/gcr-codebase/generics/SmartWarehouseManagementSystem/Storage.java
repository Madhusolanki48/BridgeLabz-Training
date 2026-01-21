package SmartWarehouseManagementSystem;
import java.util.*;

public class Storage<T extends WarehouseItem> {
	private List<T> items=new ArrayList<>();
	//method to add item
	public void addItem(T item) {
		items.add(item);
	}
	T getItem(int index) {
		return items.get(index);
	}
	List<T> getItems(){
		return items;
	}
	

}
