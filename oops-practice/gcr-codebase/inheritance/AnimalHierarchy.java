package inheritance;
class Animal{   //superclass
	//attributes
	String name;
	int age;
	void makeSound() {  //method
		System.out.println("Animal make a sound");
	}
	
}
//subclasses Dog, Cat,Bird
class Dog extends Animal{
	void makeSound(){
		System.out.println("Dog barks!");
	}
}
class Cat extends Animal{
	void makeSound() {
		System.out.println("Cat meows!");
	}
}
class Bird extends Animal{
	void makeSound() {
		System.out.println("Bird Chirps!");
	}
}
public class AnimalHierarchy {
	public static void main(String[] args) {
		Animal animal1=new Animal();
		Dog dog=new Dog();
		Cat cat=new Cat();
		Bird bird=new Bird();
		animal1.makeSound();
		dog.makeSound();
		cat.makeSound();
		bird.makeSound();
	}
}