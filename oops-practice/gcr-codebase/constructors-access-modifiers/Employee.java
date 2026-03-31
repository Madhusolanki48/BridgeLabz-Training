package constructors_access_modifiers;
//Access Modifiers
//Problem 4: Employee Records
public class Employee {
    //attributes
    public int employeeID;       // public
    protected String department; // protected
    private double salary;       // private
    //public setter for salary
    public void setSalary(double salary) {
        this.salary = salary;
    }
    //public getter for salary
    public double getSalary() {
        return salary;
    }
    //method to display employee details
    public void display() {
        System.out.println("Employee ID : " + employeeID);
        System.out.println("Department  : " + department);
        System.out.println("Salary      : " + salary);
        System.out.println("----------------------------------");
    }
}
//subclass
class Manager extends Employee {
    //demonstrates access to protected member
    void showDepartment() {
        System.out.println("Department (Protected): " + department);
    }
    public static void main(String[] args) {
        Manager manager= new Manager();
        manager.employeeID = 201;         // public access
        manager.department = "HR";        // protected access
        manager.setSalary(75000);         // private via public setter
        manager.display();
        manager.showDepartment();
        // modify salary using public method
        manager.setSalary(85000);
        System.out.println("Updated Salary: " + manager.getSalary());
    }
}