package OceanFleet;
import java.util.*;

public class VesselUtil {

    private List<Vessel> vesselList = new ArrayList<>();

    //getter and setter
    public List<Vessel> getVesselList() {
        return vesselList;
    }

    public void setVesselList(List<Vessel> vesselList) {
        this.vesselList = vesselList;
    }

    //adds vessel to list
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    //returns vessel by vesselId
    public Vessel getVesselById(String vesselId) {
        for (Vessel v : vesselList) {
            if (v.getVesselId().equals(vesselId)) {
                return v;
            }
        }
        return null;
    }

    //returns vessels with highest speed
    public List<Vessel> getHighPerformanceVessels() {
        List<Vessel> result = new ArrayList<>();
        double maxSpeed = 0;

        for (Vessel v : vesselList) {
            if (v.getAverageSpeed() > maxSpeed) {
                maxSpeed = v.getAverageSpeed();
            }
        }

        for (Vessel v : vesselList) {
            if (v.getAverageSpeed() == maxSpeed) {
                result.add(v);
            }
        }
        return result;
    }
}
