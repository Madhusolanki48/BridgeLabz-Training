package FutureLogistics;
public abstract class GoodsTransport {
	//attributes
	protected String transportId;
	protected String transportDate;
	protected int transportRating;

	//3-argument constructor
	public GoodsTransport(String transportId, String transportDate, int transportRating) {
		this.transportId = transportId;
		this.transportDate = transportDate;
		this.transportRating = transportRating;
	}

	//getters and setters
	public String getTransportId() {
		return transportId;
	}

	public void setTransportId(String transportId) {
		this.transportId = transportId;
	}

	public String getTransportDate() {
		return transportDate;
	}

	public void setTransportDate(String transportDate) {
		this.transportDate = transportDate;
	}

	public int getTransportRating() {
		return transportRating;
	}

	public void setTransportRating(int transportRating) {
		this.transportRating = transportRating;
	}

	//abstract methods
	public abstract String vehicleSelection();

	public abstract float calculateTotalCharge();
}
