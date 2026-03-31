package inheritance;
//Hierarchical Inheritance
//Sample Problem 2: School System with Different Roles

class Person { //superclass
    String name;
    int age;

    Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    void showDetails(){   //common method
        System.out.println("Name : "+name);
        System.out.println("Age : "+age);
    }
}

class Teacher extends Person {
    String subject;

    Teacher(String n,int a,String s){
        super(n,a);
        this.subject=s;
    }

    void displayRole(){
        System.out.println("Role: Teacher of "+subject);
    }
}

class Student extends Person {
    String grade;

    Student(String n,int a,String g){
        super(n,a);
        this.grade=g;
    }

    void displayRole(){
        System.out.println("Role : Student -Grade : "+grade);
    }
}

class Staff extends Person {
    String department;

    Staff(String n,int a,String d){
        super(n,a);
        this.department=d;
    }

    void displayRole(){
        System.out.println("Role : Staff - "+department);
    }
}

public class SchoolSystem {
    public static void main(String[] args) {

        Teacher t = new Teacher("Maxwell",30,"Maths");
        Student s = new Student("Colin",20,"B.Tech");
        Staff st = new Staff("Samzren",40,"Administration");

        // Teacher
        t.displayRole();
        t.showDetails();
        System.out.println("------------------------------");

        // Student
        s.displayRole();
        s.showDetails();
        System.out.println("------------------------------");

        // Staff
        st.displayRole();
        st.showDetails();
    }
}
