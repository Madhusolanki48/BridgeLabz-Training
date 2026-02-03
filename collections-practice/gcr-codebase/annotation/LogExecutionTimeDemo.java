package annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

//define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

//class with methods to test execution time
class PerformanceTest {

    @LogExecutionTime
    public void fastTask() {
        for (int i = 0; i < 1_000; i++) {
            Math.sqrt(i);
        }
    }

    @LogExecutionTime
    public void slowTask() {
        for (int i = 0; i < 5_000_000; i++) {
            Math.sqrt(i);
        }
    }

    public void normalTask() {
        System.out.println("Normal task executed.");
    }
}

//main class to measure execution time via Reflection
public class LogExecutionTimeDemo {
    public static void main(String[] args) throws Exception {

        PerformanceTest test = new PerformanceTest();

        Class<?> clazz = test.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {

            //check if method has @LogExecutionTime
            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long startTime = System.nanoTime();

                //invoke the method dynamically
                method.invoke(test);

                long endTime = System.nanoTime();
                long duration = endTime - startTime;

                System.out.println("Method: " + method.getName() +
                                   " | Execution Time: " + duration + " ns");
                System.out.println("-----------------------------");
            }
        }
    }
}
