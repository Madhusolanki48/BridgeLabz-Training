package reflection;
import java.lang.reflect.Method;
//sample class whose methods will be timed
class Task {

    public void fastTask() {
        for (int i = 0; i < 1_000; i++) {
            Math.sqrt(i);
        }
    }

    public void slowTask() {
        for (int i = 0; i < 5_000_000; i++) {
            Math.sqrt(i);
        }
    }
}

//utility class to measure execution time using Reflection
class MethodTimer {

    public static void measureExecutionTime(Object obj) throws Exception {

        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {

            //skip main or methods with parameters
            if (method.getParameterCount() > 0) {
                continue;
            }

            method.setAccessible(true);

            long startTime = System.nanoTime();

            //invoke method dynamically
            method.invoke(obj);

            long endTime = System.nanoTime();

            long duration = endTime - startTime;

            System.out.println(
                "Method: " + method.getName() +
                " | Execution Time: " + duration + " ns"
            );
        }
    }
}

//main class
public class MethodExecutionTiming {
    public static void main(String[] args) throws Exception {

        Task task = new Task();

        //measure execution time of all methods dynamically
        MethodTimer.measureExecutionTime(task);
    }
}
