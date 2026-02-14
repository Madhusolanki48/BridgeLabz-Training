package DisasterReliefResourceAllocationSystem;

public class AreaRequest {
	// attributes
	private String areaName;
	private String item;
	private int quantity;

	// constructor
	public AreaRequest(String areaName, String item, int quantity) {
		this.areaName = areaName;
		this.item = item;
		this.quantity = quantity;
	}
    //getters
	public String getAreaName() {
		return areaName;
	}

	public String getItem() {
		return item;
	}

	public int getQuantity() {
		return quantity;
	}
}
