package SmartWaterTankMonitoringSystem;
import java.util.Comparator;
import java.util.List;

public class TankService {
	//attribute
	private TankRepository repo;
	//constructor
	public TankService(TankRepository repo) {
		this.repo = repo;
	}

	// sort by lowest level
	public void sortByLevel() {
		List<WaterTank> tanks = repo.getAllTanks();

		tanks.sort(Comparator.comparingDouble(WaterTank::getCurrentLevel));
	}

	// generate alerts
	public void checkAlerts() {
		for (WaterTank tank : repo.getAllTanks()) {

			if (tank.isLow()) {
				System.out.println("ALERT: Tank " + tank.getTankId() + " below 20%");
			}
		}
	}

	public void printReport() {
		for (WaterTank t : repo.getAllTanks()) {
			System.out.println(t.getTankId() + " -> " + t.getUsagePercent() + "%");
		}
	}
}
