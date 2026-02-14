package SmartWaterTankMonitoringSystem;


public class WaterMonitorApp {

    public static void main(String[] args) throws Exception {

        TankRepository repo = new TankRepository();

        repo.addTank(new WaterTank("Tank1", 1000, 150));
        repo.addTank(new WaterTank("Tank2", 1000, 700));
        repo.addTank(new WaterTank("Tank3", 1000, 50));

        TankService service = new TankService(repo);

        service.sortByLevel();
        service.checkAlerts();
        service.printReport();
    }
}
