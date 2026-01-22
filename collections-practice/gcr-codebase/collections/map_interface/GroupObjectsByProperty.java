package map_interface;
import java.util.*;

class Employee {
	//attributes
    private String name;
    private String department;
    //constructor
    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    //getter method
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupObjectsByProperty {
	//group employees by department
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> grouped = new HashMap<>();

        for (Employee emp : employees) {
            grouped.putIfAbsent(emp.getDepartment(), new ArrayList<>());
            grouped.get(emp.getDepartment()).add(emp);
        }

        return grouped;
    }
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Maxwell", "IT"),
                new Employee("Boblin", "IT"),
                new Employee("Carol", "HR"));

        Map<String, List<Employee>> result = groupByDepartment(employees);
        //print grouped result
        for (Map.Entry<String, List<Employee>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
