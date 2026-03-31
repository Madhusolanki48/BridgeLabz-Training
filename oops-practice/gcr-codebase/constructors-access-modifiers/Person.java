package constructors_access_modifiers;

public class Person {
	//attributes
    private String name;
    private int age;
   
    //parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //copy constructor
    Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    } 
    //method to display details
  	void display() {
  		System.out.println("Name : "+name);
  		System.out.println("Age : "+age);
  		System.out.println("-------------------------");
  	}
  	public static void main(String[] args) {
  		Person person1 = new Person("Maxwell", 28);
        Person person2 = new Person(person1);
        person1.display();
  		person2.display();
  	}
}
