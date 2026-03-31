package reflection;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
class MathOperations {
	//method to add
    public int add(int a, int b) {
        return a+b;
    }
    //method to subtract
    public int subtract(int a, int b) {
        return a-b;
    }
    //method to multiply
    public int multiply(int a, int b) {
        return a*b;
    }
}

public class DynamicMethodInvocation {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter method name (add / subtract / multiply): ");
        String methodName = sc.nextLine();
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        
        //load class dynamically
        Class<?> clazz = Class.forName("reflections.MathOperations");
        
        //create object dynamically
        Object obj = clazz.getDeclaredConstructor().newInstance();
        
        //get method based on user input
        Method method = clazz.getMethod(methodName, int.class, int.class);
        
        //invoke method dynamically
        Object result = method.invoke(obj, a, b);
        System.out.println("Result: " + result);
        sc.close();
	}

}
