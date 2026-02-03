package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

//define field-level annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

//user class with annotated field
class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        this.username = username;
        validate();
    }

    private void validate() {
        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(MaxLength.class)) {
                    field.setAccessible(true);
                    String value = (String) field.get(this);
                    int max = field.getAnnotation(MaxLength.class).value();
                    if (value.length() > max) {
                        throw new IllegalArgumentException(
                            field.getName() + " exceeds max length of " + max
                        );
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

public class MaxLengthValidationDemo {
    public static void main(String[] args) {
        User validUser = new User("Alice"); // OK
        System.out.println("Username: " + validUser.getUsername());

        User invalidUser = new User("VeryLongUsername"); // Throws IllegalArgumentException
    }
}
