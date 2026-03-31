package class_and_object;
// Class to store and display employee details
class Employee {
    //attributes 
    private String name;
    private int id;
    private double salary;

    //constructor to initialize attributes
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    //method to display employee details
    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee Salary: " + salary);
    }
}

public class DisplayEmployeeDetails  {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Rohan", 1, 500000);
        emp1.displayDetails();
    }
}
