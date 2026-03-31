package reflection;
import java.lang.reflect.Field;
class Configuration {

    //private static field
    private static String API_KEY = "OLD_KEY";
    public static void display() {
        System.out.println("API_KEY: " + API_KEY);
    }
}

public class AccessAndModifyStaticField {
    public static void main(String[] args) throws Exception {
        //before modification
        Configuration.display();
        
        //get Class object
        Class<?> clazz = Configuration.class;
        
        //get private static field
        Field field = clazz.getDeclaredField("API_KEY");
        
        //allow access to private field
        field.setAccessible(true);
        
        //modify static field (null because it's static)
        field.set(null, "NEW_SECRET_KEY");
        
        //after modification
        Configuration.display();
    }
}
