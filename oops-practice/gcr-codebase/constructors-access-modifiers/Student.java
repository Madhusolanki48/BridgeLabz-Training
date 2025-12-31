package constructors_access_modifiers;
//Access Modifiers
//Problem 1: University Management System
public class Student {
	//attributes
    public int rollNumber;     // public
    protected String name;     // protected
    private double cgpa;       // private

    //public method to modify private cgpa
    public void setCGPA(double cgpa) {
        this.cgpa = cgpa;
    }

    //public method to access private cgpa
    public double getCGPA() {
        return cgpa;
    }

    //instance method to display student details
    void display() {
        System.out.println("Roll No: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + cgpa);
        System.out.println("----------------------------------");
    }
}

//subclass demonstrates use of protected member
class PostgraduateStudent extends Student {
    //accessing protected variable 'name'
    void showName() {
        System.out.println("Protected Name Access: " + name);
    }
    
    public static void main(String[] args) {
        PostgraduateStudent s = new PostgraduateStudent();

        s.rollNumber = 8;  
        s.name = "Sam";     
        s.setCGPA(9.2);       //modifying private via setter method

        s.display();
        s.showName();
    }
}
