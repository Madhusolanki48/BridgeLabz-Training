package reflection;

import java.lang.reflect.Method;

class Calculator{
    private int multiply(int a,int b){
        return a*b;
    }
}

public class InvokePrivateMethod {
	public static void main(String[] args) throws Exception{
		//create object of Calculator
        Calculator calculator = new Calculator();
        
        //get Class object
        Class<?> clazz = calculator.getClass();
        
        //get private method
        Method method = clazz.getDeclaredMethod("multiply", int.class, int.class);
        
        //make private method accessible
        method.setAccessible(true);
        
        //invoke method
        Object result = method.invoke(calculator, 4, 5);
        
        //display result
        System.out.println("Result: " + result);
	}

}
