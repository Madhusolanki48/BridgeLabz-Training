package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

//define custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)  
@interface TaskInfo {
    String priority();
    String assignedTo();
}

//class using the annotation
class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Bhumika")
    public void completeTask() {
        System.out.println("Task completed!");
    }
}

//main class to retrieve annotation using Reflection
public class CustomAnnotationDemo {
    public static void main(String[] args) throws Exception {

        TaskManager taskManager = new TaskManager();

        //get Class object
        Class<?> clazz = taskManager.getClass();

        //get all methods
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {

            //check if annotation is present
            if (method.isAnnotationPresent(TaskInfo.class)) {

                //retrieve annotation
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

                //display annotation details
                System.out.println("Method: " + method.getName());
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }
        }

        //call the annotated method
        taskManager.completeTask();
    }
}
