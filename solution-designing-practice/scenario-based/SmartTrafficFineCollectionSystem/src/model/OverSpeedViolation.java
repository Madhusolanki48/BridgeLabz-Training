package model;

// Child class
public class OverSpeedViolation extends Violation {

    public OverSpeedViolation() {
        super("OverSpeed", 1000);
    }

    @Override
    public int calculateFine(int offenseCount) {
        //repeat offender penalty
        return baseFine + (offenseCount > 1 ? 500 : 0);
    }
}