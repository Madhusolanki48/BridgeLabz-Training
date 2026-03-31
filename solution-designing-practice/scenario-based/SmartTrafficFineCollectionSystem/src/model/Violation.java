package model;

//base class for polymorphism
public abstract class Violation {
	//attribute
    protected String type;
    protected int baseFine;
    //constructor
    public Violation(String type, int baseFine) {
        this.type = type;
        this.baseFine = baseFine;
    }

    //polymorphic fine calculation
    public abstract int calculateFine(int offenseCount);

    public String getType() {
        return type;
    }
}