package reflection;
class Student {
    private String name;
    private int age;
    public Student() {
        this.name = "Unknown";
        this.age = 0;
    }
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
public class DynamicallyCreateObjects {
	public static void main(String[] args) throws Exception {
		 //load class at runtime
        Class<?> clazz = Class.forName("reflections.Student");
        
        //create instance without using new keyword
        Object obj = clazz.getDeclaredConstructor().newInstance();
        
        //type casting
        Student student = (Student) obj;
        
        //call method
        student.display();
	}

}
