package this_static_final;
//Program 3: Employee Management System
public class Employee {
    //static variable shared by all employees
    private static String companyName = "Tech Solutions Inc.";
    private static int totalEmployees = 0;
    //final variable
    private final int id;
    //instance variables
    private String name;
    private String designation;
    //constructor using 'this'
    public Employee(int id, String name, String designation) {
        this.id = id;               // final variable assigned once
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }
    //static method
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
    //display employee details using instanceof
    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        }
    }
    //main method
    public static void main(String[] args) {
        Employee emp1=new Employee(101,"Thamarai","Software Engineer");
        Employee emp2=new Employee(102,"Rohan","Project Manager");
        //display total employees
        Employee.displayTotalEmployees();
        //display employee details
        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();
    }
}
