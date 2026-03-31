package constructors_access_modifiers;

public class CarRental {
	//attributes
    private String customerName,carModel;
    private int rentalDays;
    private double costPerDay = 12000;

    //parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    //method to calculate total rental cost
    double calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    //method to display details
    void display() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Cost Per Day: " + costPerDay);
        System.out.println("Total Cost: " + calculateTotalCost());
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
        CarRental rental1 = new CarRental("Maxwell", "Rolls-Royce Phantom", 4); 
        rental1.display();
    }
}

