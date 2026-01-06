package leet_code_codebase;
import java.util.Scanner;
//Leetcode Problem : 1603
//Design a Parking System that supports three types of car slots:big, medium and small.
//A car can park only if a slot of its type is available.

public class ParkingSystem {
    private int big;
    private int medium;
    private int small;
    //constructor 
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    //method to add a car of given type
    public boolean addCar(int carType) {
        if (carType == 1) {  // big
            if (big == 0) 
            	return false;
            big--;
            return true;
        }

        if (carType == 2) { // medium
            if (medium == 0) 
            	return false;
            medium--;
            return true;
        }
        if (small == 0) 
        	return false;
        small--;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user input
        System.out.print("Enter slot counts (big/medium/small): ");
        int big = sc.nextInt();
        int medium = sc.nextInt();
        int small = sc.nextInt();
        ParkingSystem ps = new ParkingSystem(big, medium, small);
        System.out.print("Enter car type to park (1=big, 2=medium, 3=small): ");
        int type = sc.nextInt();
        boolean parked = ps.addCar(type);
        if (parked)
            System.out.println("Car parked successfully");
        else
            System.out.println("Parking full for this car type");

    }
}
