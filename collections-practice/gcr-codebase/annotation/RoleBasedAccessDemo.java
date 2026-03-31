package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

//define class-level annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

//service class
class AdminService {

    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted successfully!");
    }

    public void viewDashboard() {
        System.out.println("Dashboard viewed!");
    }
}

public class RoleBasedAccessDemo {
    public static void main(String[] args) throws Exception {

        AdminService service = new AdminService();
        String currentRole = "USER"; //change to "ADMIN" to allow access

        for (Method method : service.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed role = method.getAnnotation(RoleAllowed.class);
                if (role.value().equals(currentRole)) {
                    method.invoke(service);
                } else {
                    System.out.println("Access Denied to method: " + method.getName());
                }
            } else {
                //methods without RoleAllowed are accessible
                method.invoke(service);
            }
        }
    }
}
