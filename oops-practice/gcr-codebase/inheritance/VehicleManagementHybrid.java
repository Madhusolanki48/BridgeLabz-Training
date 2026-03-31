package inheritance;
//Hybrid Inheritance (Simulating Multiple Inheritance)
//Sample Problem 2: Vehicle Management System with Hybrid Inheritance

interface Refuelable {
    void refuel();
}

class Vehicle { //superclass
    int maxSpeed;
    String model;

    Vehicle(int maxSpeed,String model){
        this.maxSpeed=maxSpeed;
        this.model=model;
    }

    void showDetails(){ //common method
        System.out.println("Model : "+model);
        System.out.println("Max Speed : "+maxSpeed);
    }
}
//subclass
class ElectricVehicle extends Vehicle {
    ElectricVehicle(int s,String m){ super(s,m); }

    void charge(){
        System.out.println(model+" is charging");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    PetrolVehicle(int s,String m){ super(s,m); }

    public void refuel(){
        System.out.println(model+" is refueling");
    }
}

public class VehicleManagementHybrid {
    public static void main(String[] args) {

        ElectricVehicle vehicle1 = new ElectricVehicle(150,"Tesla Model 3");
        PetrolVehicle vehicle2 = new PetrolVehicle(160,"Honda City");

        // Electric Vehicle
        vehicle1.charge();
        vehicle1.showDetails();
        System.out.println("-------------------------------");

        // Petrol Vehicle
        vehicle2.refuel();
        vehicle2.showDetails();
    }
}
