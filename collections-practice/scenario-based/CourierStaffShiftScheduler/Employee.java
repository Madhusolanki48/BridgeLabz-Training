package CourierStaffShiftScheduler;

//employee entity
public class Employee {
    //attributes
    int empId;
    String name;
    //constructor
    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    //to prevent duplicate assignment
    @Override
    public boolean equals(Object obj) {
        Employee e = (Employee) obj;
        return this.empId == e.empId;
    }

    @Override
    public int hashCode() {
        return empId;
    }
}
