package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

//define the custom annotation
@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

//class using the annotation
class TaskProcessor {

    @ImportantMethod(level = "CRITICAL")
    public void processPayment() {
        System.out.println("Processing payment...");
    }

    @ImportantMethod // uses default level "HIGH"
    public void generateReport() {
        System.out.println("Generating report...");
    }

    public void logActivity() {
        System.out.println("Logging activity...");
    }
}

//main class to retrieve annotated methods
public class ImportantMethodAnnotationDemo {
    public static void main(String[] args) throws Exception {

        TaskProcessor processor = new TaskProcessor();

        //get class object
        Class<?> clazz = processor.getClass();

        //get all methods
        Method[] methods = clazz.getDeclaredMethods();

        System.out.println("Annotated Important Methods:");

        for (Method method : methods) {

            //check if method has @ImportantMethod
            if (method.isAnnotationPresent(ImportantMethod.class)) {

                //retrieve annotation
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);

                //print method name and level
                System.out.println("Method: " + method.getName() +
                                   ", Level: " + annotation.level());
            }
        }

        System.out.println("\nCalling annotated methods:");

        //call the annotated methods
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                method.invoke(processor);
            }
        }
    }
}
