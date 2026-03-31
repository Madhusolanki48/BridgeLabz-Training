package SmartWaterTankMonitoringSystem;

public class WaterTank {
	// attributes
	private String tankId;
	private double capacity;
	private double currentLevel;

	// constructor
	public WaterTank(String tankId, double capacity, double currentLevel) throws InvalidWaterLevelException {

		if (currentLevel > capacity) {
			throw new InvalidWaterLevelException("Level exceeds capacity for tank " + tankId);
		}

		this.tankId = tankId;
		this.capacity = capacity;
		this.currentLevel = currentLevel;
	}

	// usage percentage
	public double getUsagePercent() {
		return (currentLevel / capacity) * 100;
	}

	// check alert
	public boolean isLow() {
		return getUsagePercent() < 20;
	}

	public String getTankId() {
		return tankId;
	}

	public double getCurrentLevel() {
		return currentLevel;
	}
}
