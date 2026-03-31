package reflection;
import java.util.*;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
class DemoClass{
	private int id;
	private String name;
	public DemoClass(int id,String name) {
		this.id=id;
		this.name=name;
	}
	void display() {
		System.out.println("ID : "+id +" Name : "+name);
	}
}
public class GetClassInformation {
	public static void main(String[] args) throws ClassNotFoundException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter class name : ");
		String className=sc.nextLine();
		
		//load class using reflection
		Class<?> cls=Class.forName(className);
		System.out.println("\nClass Name: "+cls.getName());
		
		//display fields
		System.out.println("Fields:");
		for(Field f:cls.getDeclaredFields()) {
			System.out.println(f);
		}
		
		//display constructor
		System.out.println("Constructors:");
		for(Constructor<?> c:cls.getDeclaredConstructors()) {
			System.out.println(c);
		}
		
		//display methods
		System.out.println("Methods:");
		for(Method m:cls.getDeclaredMethods()) {
			System.out.println(m);
		}	
	}
}
