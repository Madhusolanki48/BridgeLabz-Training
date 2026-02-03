package annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

//define annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

//user class with annotated fields
class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

//utility to convert object to JSON
class JsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                sb.append("\"").append(annotation.name()).append("\":");
                Object value = field.get(obj);
                if (value instanceof String) sb.append("\"").append(value).append("\"");
                else sb.append(value);
                sb.append(",");
            }
        }
        if (sb.charAt(sb.length() - 1) == ',') sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }
}

public class JsonFieldSerializationDemo {
    public static void main(String[] args) throws Exception {
        User user = new User("Alice", 25);
        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}
