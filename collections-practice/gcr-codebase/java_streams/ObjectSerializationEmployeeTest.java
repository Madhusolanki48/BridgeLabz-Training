package java_streams;
import java.io.*;
import java.util.*;

//Employee class for serialization
class Employee implements Serializable {
	//attributes
    int id;
    String name;
    String department;
    double salary;
    //constructor
    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class ObjectSerializationEmployeeTest {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();

        // add employee objects
        list.add(new Employee(1, "Amanid", "IT", 50000));
        list.add(new Employee(2, "Nexon", "HR", 45000));

        //serialization
        try (ObjectOutputStream objOutputStream =new ObjectOutputStream(new FileOutputStream("src/emp.txt"))) {
        	objOutputStream.writeObject(list);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //deserialization
        try (ObjectInputStream objInputStream =
                     new ObjectInputStream(new FileInputStream("src/emp.txt"))) {

            List<Employee> empList = (List<Employee>) objInputStream.readObject();

            //display employee details
            for (Employee e : empList) {
                System.out.println(
                        e.id + ". " + e.name + " " + e.department + " " + e.salary
                );
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
