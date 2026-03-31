package annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

//define the custom annotation
@Retention(RetentionPolicy.RUNTIME) //for runtime access
@Target(ElementType.METHOD)         //can be applied to methods
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM"; //default value
}

//class using the annotation
class ProjectModule {

    @Todo(task = "Implement login feature", assignedTo = "Alice", priority = "HIGH")
    public void login() {
        System.out.println("Login feature in progress...");
    }

    @Todo(task = "Add search functionality", assignedTo = "Bob")
    public void search() {
        System.out.println("Search feature in progress...");
    }

    public void logout() {
        System.out.println("Logout feature completed.");
    }
}

//main class to retrieve annotated methods
public class TodoAnnotationDemo {
    public static void main(String[] args) throws Exception {

        ProjectModule module = new ProjectModule();

        //get class object
        Class<?> clazz = module.getClass();

        //get all methods
        Method[] methods = clazz.getDeclaredMethods();

        System.out.println("Pending Tasks:");

        for (Method method : methods) {

            //check if method has @Todo annotation
            if (method.isAnnotationPresent(Todo.class)) {

                //retrieve annotation
                Todo todo = method.getAnnotation(Todo.class);

                //print task details
                System.out.println("Method: " + method.getName());
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("------------------------");
            }
        }
    }
}
