package RailwayPlatformAllocationSystem;

//represents a railway platform
public class Platform {
   //attribute
    int platformNumber;
    boolean isOccupied;
   //constructor
    public Platform(int platformNumber) {
        this.platformNumber = platformNumber;
        this.isOccupied = false;
    }
}