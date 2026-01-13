package HospitalManagementSystem;

//parent class
public class Person {
	//attributes
	private int id;
	private String name;

	//constructor
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	//getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
