package reflection;
import java.lang.reflect.Field;
class Person{
	private int age;
}
public class AccessPrivateField {
	public static void main(String[] args) throws Exception {
		Person p=new Person();
		Class<?> cls=p.getClass();
		
		//access private field
		Field field=cls.getDeclaredField("age");
		field.setAccessible(true);
		field.set(p,21);
		
        //retrieve value
        int value = (int) field.get(p);
        System.out.println("Age: " + value);
	}
}
