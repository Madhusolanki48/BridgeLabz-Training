package annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

//define annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

//class with expensive computation
class Calculator {

    private Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int factorial(int n) {
        if (cache.containsKey(n)) return cache.get(n);

        int result = 1;
        for (int i = 1; i <= n; i++) result *= i;

        cache.put(n, result);
        return result;
    }
}

public class CacheResultDemo {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();

        Method method = calc.getClass().getDeclaredMethod("factorial", int.class);

        if (method.isAnnotationPresent(CacheResult.class)) {
            System.out.println("factorial(5): " + calc.factorial(5)); // Computes
            System.out.println("factorial(5): " + calc.factorial(5)); // Returns cached
            System.out.println("factorial(6): " + calc.factorial(6)); // Computes
        }
    }
}
