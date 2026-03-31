package model;

//another violation type
public class SignalJumpViolation extends Violation {

    public SignalJumpViolation() {
        super("SignalJump", 1500);
    }

    @Override
    public int calculateFine(int offenseCount) {
        // extra penalty for repeat offender
        return baseFine + (offenseCount > 1 ? 700 : 0);
    }
}