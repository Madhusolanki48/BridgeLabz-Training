package reflection;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

//sample class, different name
class Employee {
    private int empId;
    private String empName;
    private double salary;

    public void display() {
        System.out.println(
            "Employee ID: " + empId +
            ", Name: " + empName +
            ", Salary: " + salary
        );
    }
}

public class CustomObjectMapperDemo {

    //generic method to map Map -> Object
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties)
            throws Exception {

        //create object dynamically
        T obj = clazz.getDeclaredConstructor().newInstance();

        //set fields using reflection
        for (Map.Entry<String, Object> entry : properties.entrySet()) {

            Field field = clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);   // access private field
            field.set(obj, entry.getValue());
        }

        return obj;
    }

    public static void main(String[] args) throws Exception {

        //map containing field names and values
        Map<String, Object> data = new HashMap<>();
        data.put("empId", 501);
        data.put("empName", "Aarav");
        data.put("salary", 55000.75);

        //convert Map to Employee object
        Employee employee = toObject(Employee.class, data);

        //display object data
        employee.display();
    }
}
