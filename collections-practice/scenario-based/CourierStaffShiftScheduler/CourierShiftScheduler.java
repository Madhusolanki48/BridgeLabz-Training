package CourierStaffShiftScheduler;

public class CourierShiftScheduler {
    public static void main(String[] args) {

        ShiftScheduler scheduler = new ShiftScheduler();

        Employee e1 = new Employee(1, "John");
        Employee e2 = new Employee(2, "Emma");

        scheduler.addEmployee(e1);
        scheduler.addEmployee(e2);

        try {
            scheduler.assignShift("Morning", e1);
            scheduler.assignShift("Morning", e1); // duplicate
        } catch (ShiftAlreadyAssignedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            scheduler.assignShift("Evening", e2);
        } catch (ShiftAlreadyAssignedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scheduler.displayShifts();
    }
}

