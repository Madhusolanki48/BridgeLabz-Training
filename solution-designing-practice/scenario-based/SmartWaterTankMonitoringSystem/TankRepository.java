package SmartWaterTankMonitoringSystem;
import java.util.ArrayList;
import java.util.List;

public class TankRepository {
    //list to store tanks
    private List<WaterTank> tanks = new ArrayList<>();
    //method to add tank
    public void addTank(WaterTank tank) {
        tanks.add(tank);
    }

    public List<WaterTank> getAllTanks() {
        return tanks;
    }
}

