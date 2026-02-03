package reflection;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

//custom Inject Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}

//dependency class
class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

// class requiring dependency injection
class Car {

    @Inject
    private Engine engine;

    public void drive() {
        engine.start();
        System.out.println("Car is running");
    }
}

//simple DI Container
class SimpleDIContainer {

    public static void injectDependencies(Object obj) throws Exception {

        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {

            if (field.isAnnotationPresent(Inject.class)) {

                Class<?> fieldType = field.getType();
                Object dependency = fieldType.getDeclaredConstructor().newInstance();

                field.setAccessible(true);
                field.set(obj, dependency);
            }
        }
    }
}

public class DependencyInjectionUsingReflection {
    public static void main(String[] args) throws Exception {

        Car car = new Car();
        SimpleDIContainer.injectDependencies(car);
        car.drive();
    }
}
