package json;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

class Student {
    String name;
    int age;
    //constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListToJsonArray {
    public static void main(String[] args) {
        //create list of objects
        List<Student> list = new ArrayList<>();
        list.add(new Student("Amiley", 24));
        list.add(new Student("Ronald", 28));

        //convert list to JSON array
        Gson gson = new Gson();
        String jsonArray = gson.toJson(list);

        //print JSON array
        System.out.println(jsonArray);
    }
}
