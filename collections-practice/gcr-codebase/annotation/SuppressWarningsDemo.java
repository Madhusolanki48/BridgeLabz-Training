package annotation;
import java.util.ArrayList;

public class SuppressWarningsDemo {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        //creating ArrayList without generics (raw type)
        ArrayList list = new ArrayList();

        //adding elements
        list.add("Bhumika");
        list.add(20);
        list.add(3.14);

        //retrieving elements (unchecked cast warning suppressed)
        String name = (String) list.get(0);
        int age = (Integer) list.get(1);
        double pi = (Double) list.get(2);

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Pi: " + pi);
    }
}
