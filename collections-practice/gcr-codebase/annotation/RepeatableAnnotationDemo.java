package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.reflect.Method;

//container annotation (required for repeatable)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

//repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

//class using repeatable annotation
class Software {

    @BugReport(description = "NullPointerException on startup")
    @BugReport(description = "UI layout breaks on resize")
    public void runApp() {
        System.out.println("Running the app...");
    }
}

//main class to retrieve repeatable annotations
public class RepeatableAnnotationDemo {
    public static void main(String[] args) throws Exception {

        Software software = new Software();

        //get class object
        Class<?> clazz = software.getClass();

        //get the method
        Method method = clazz.getDeclaredMethod("runApp");

        //retrieve all BugReport annotations
        BugReport[] reports = method.getAnnotationsByType(BugReport.class);

        System.out.println("Bug Reports for method: " + method.getName());
        for (BugReport report : reports) {
            System.out.println("- " + report.description());
        }

        //call the method
        software.runApp();
    }
}
