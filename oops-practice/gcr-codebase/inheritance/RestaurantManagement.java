package inheritance;
//Hybrid Inheritance (Simulating Multiple Inheritance)
//Sample Problem 1: Restaurant Management System with Hybrid Inheritance

interface Worker { //interface
    void performDuties();
}

class Person {//superclass
    String name;
    int id;

    Person(String name,int id){
        this.name=name;
        this.id=id;
    }

    void showDetails(){ //common method
        System.out.println("Name : "+name);
        System.out.println("ID : "+id);
    }
}
//subclass
class Chef extends Person implements Worker {
    Chef(String n,int i){ 
    	super(n,i); 
    	}

    public void performDuties() {
        System.out.println(name+" cooks food");
    }
}

class Waiter extends Person implements Worker {
    Waiter(String n,int i){ 
    	super(n,i); 
    	}

    public void performDuties() {
        System.out.println(name+" serves customers");
    }
}

public class RestaurantManagement {
    public static void main(String[] args) {

        Chef chef = new Chef("David",1);
        Waiter waiter = new Waiter("Samren",2);

        //Chef
        chef.performDuties();
        chef.showDetails();
        System.out.println("------------------------");

        //Waiter
        waiter.performDuties();
        waiter.showDetails();
    }
}
