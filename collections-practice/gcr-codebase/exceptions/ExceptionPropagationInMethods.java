package exceptions;

public class ExceptionPropagationInMethods {
	public static void method1() {
		int x = 10 / 0;  //throws Arithmetic Exception
	}
	public static void method2() {
		method1();   //exception propagates here
	}
	public static void main(String[] args) {
		try {
			method2();
		}catch(ArithmeticException e) {
			System.out.println("Handled exception in main");
		}
		
	}

}
