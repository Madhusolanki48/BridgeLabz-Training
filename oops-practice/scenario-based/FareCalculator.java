package CabBookingManagementSystem;
// polymorphism
public interface FareCalculator {   //interface for fare calculation
    double calculateFare(double distance);
}

//normal pricing
class NormalFareCalculator implements FareCalculator {
    public double calculateFare(double d) {
        return d * 10;
    }
}

//peak pricing
class PeakFareCalculator implements FareCalculator {
    public double calculateFare(double d) {
        return d * 15;
    }
}
