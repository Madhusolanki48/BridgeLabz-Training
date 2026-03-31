package reflection;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//interface
interface Greeting {
    void sayHello(String name);
}

//real implementation
class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

//invocation Handler, Logging Proxy
class LoggingInvocationHandler implements InvocationHandler {

    private Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //log before method execution
        System.out.println("Invoking method: " + method.getName());

        //call actual method
        return method.invoke(target, args);
    }
}

public class CustomLoggingProxyUsingReflection {
    public static void main(String[] args) {

        //create real object
        Greeting greeting = new GreetingImpl();

        //create proxy instance
        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class<?>[]{Greeting.class},
                new LoggingInvocationHandler(greeting)
        );

        //call method via proxy
        proxy.sayHello("Bhumika");
    }
}
