package CabBookingManagementSystem;
import java.util.ArrayList;
import java.util.List;

public class RideService {

    private List<User> users = new ArrayList<>();
    private List<Driver> drivers = new ArrayList<>();
    //CRUD operations for User
    //create user
    public void addUser(User u) {
        users.add(u);
    }
    //update user
    public void updateUser(int id, String newName) {
        for (User u : users) {
            if (u.getId() == id) {
                u.setName(newName);
                return;
            }
        }
        System.out.println("User not found.");
    }
    //delete user
    public void deleteUser(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(i);
                return;
            }
        }
        System.out.println("User not found.");
    }
    //show users
    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }
        for (User u : users) {
            System.out.println(u);
        }
    }
    //get users
    public User getUser(int id) {
        for (User u : users) {
            if (u.getId() == id)
                return u;
        }
        return null;
    }

    //CRUD operations for Driver
    public void addDriver(Driver d) {
        drivers.add(d);
    }
    //update driver
    public void updateDriver(int id, String newName) {
        for (Driver d : drivers) {
            if (d.getId() == id) {
                d.setName(newName);
                return;
            }
        }
        System.out.println("Driver not found.");
    }
    //delete driver
    public void deleteDriver(int id) {
        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).getId() == id) {
                drivers.remove(i);
                return;
            }
        }
        System.out.println("Driver not found.");
    }
    //show drivers
    public void listDrivers() {
        if (drivers.isEmpty()) {
            System.out.println("No drivers found.");
            return;
        }
        for (Driver d : drivers) {
            System.out.println(d);
        }
    }
    //get driver
    public Driver getDriver(int id) {
        for (Driver d : drivers) {
            if (d.getId() == id)
                return d;
        }
        return null;
    }

    //Ride Booking
    public Ride bookRide(int userId, double distance, boolean isPeak)
            throws NoDriverAvailableException {

        //find user
        User user = getUser(userId);
        if (user == null) {
            System.out.println("User not found.");
            return null;
        }

        //first available driver
        Driver assignedDriver = null;

        for (Driver d : drivers) {
            if (d.isAvailable()) {
                assignedDriver = d;
                break;
            }
        }

        if (assignedDriver == null) {
            throw new NoDriverAvailableException("No driver available!");
        }

        assignedDriver.setAvailable(false); // driver accepts ride

        FareCalculator calculate;
        if (isPeak) {
        	calculate = new PeakFareCalculator();
        } else {
        	calculate = new NormalFareCalculator();
        }

        Ride ride = new Ride(user, assignedDriver, distance, calculate);
        user.addRide(ride);

        System.out.println("\nRide Assigned Successfully!");
        System.out.println("Driver: " + assignedDriver.getName());
        System.out.println("Distance: " + distance + " km");
        System.out.println("Fare: " + ride.getFare());

        return ride;
    }
}
