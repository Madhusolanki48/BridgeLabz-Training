package CourierStaffShiftScheduler;
import java.util.*;

// service class
public class ShiftScheduler {
	// store all employees
	List<Employee> employees = new ArrayList<>();

	// store shift : list of employees
	Map<String, List<Employee>> shiftMap = new HashMap<>();

	//method to add employee
	public void addEmployee(Employee emp) {
		employees.add(emp);
	}

	//method to assign shift
	public void assignShift(String shiftTime, Employee emp) throws ShiftAlreadyAssignedException {

		shiftMap.putIfAbsent(shiftTime, new ArrayList<>());

		if (shiftMap.get(shiftTime).contains(emp)) {
			throw new ShiftAlreadyAssignedException("Shift already assigned to employee");
		}

		shiftMap.get(shiftTime).add(emp);
	}

	// display shifts
	public void displayShifts() {

	    System.out.println("-----------------------------------");
	    System.out.println("        COURIER SHIFT SCHEDULE     ");
	    System.out.println("-----------------------------------");

	    for (String shift : shiftMap.keySet()) {

	        System.out.println("\nShift Time : " + shift);
	        System.out.println("-----------------------------------");

	        for (Employee emp : shiftMap.get(shift)) {
	            System.out.println("Employee ID   : " + emp.empId);
	            System.out.println("Employee Name : " + emp.name);
	            System.out.println();
	        }
	    }

	    System.out.println("-----------------------------------");
	}

}
