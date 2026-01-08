package linkedlist;
//Using Singly Linked List
class Node{
	Student data;
	Node next;
	Node(Student data){
		this.data=data;
		this.next=null;
	}
}
class Student{
	int rollNumber;
	String name;
	int age;
	char grade;
	Student(int rollNumber,String name,int age,char grade){
		this.rollNumber=rollNumber;
		this.name=name;
		this.age=age;
		this.grade=grade;
	}
}

public class StudentRecordManagement {
    static Node head;
    //add a new student record at the beginning
    static void insertAtBeginning(Student student) {
    	Node newNode = new Node(student);
        newNode.next = head;
        head = newNode;
        }
    //add a new student record at a specific position
    static void insertAtPosition(Student student, int position) {
        if (position <= 1 || head == null) {
            insertAtBeginning(student);
            return;
        }

        Node newNode = new Node(student);
        Node temp = head;

        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        }
    //add a new student record at the end
    static void insertNode(Student student){
		Node newNode=new Node(student);
		if(head==null) {
			head=newNode;
			return;
		}
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=newNode;
	}
    //deletes a student record based on roll number.
	static void deleteNode(int rollNumber) {
		if(head!=null && head.data.rollNumber==rollNumber) {
			head=head.next;
			return;
		}
		Node temp1=head;
		Node temp2=head;
		while(temp1!=null && temp1.data.rollNumber!=rollNumber) {
			temp2=temp1;
			temp1=temp1.next;
		}
		if(temp1!=null) {
			temp2.next=temp1.next;
		}
		else {
			System.out.println("Student not found");
		}
	}
	//search for a student record by roll number.
	static void searchNode(int rollNumber) {
		Node temp=head;
		while(temp!=null && temp.data.rollNumber!=rollNumber) {
			temp=temp.next;
		}
		if(temp!=null) {
			System.out.println("Node found ");
			System.out.println("Student roll no. : "+temp.data.rollNumber);
			System.out.println("Student name : "+temp.data.name);
			System.out.println("Student age : "+temp.data.age);
			System.out.println("Student grade : "+temp.data.grade);
			System.out.println("------------------------------------------");
		}
		else {
			System.out.println("Node not founded");
		}
	}
	//display all student records
	static void display() {
		Node temp=head;
		System.out.println("---------- Displaying Students -----------");
		while(temp!=null) {
			System.out.println("Student's Roll No. : "+temp.data.rollNumber);
			System.out.println("Student's Name     : "+temp.data.name);
			System.out.println("Student's Age      : "+temp.data.age);
			System.out.println("Student's grade    : "+temp.data.grade);
			System.out.println("------------------------------------------");
			temp=temp.next;
		}
	}
	//update a student's grade based on their roll number
    static void updateGrades(int rollNumber,char grade) {
		Node temp=head;
		while(temp!=null && temp.data.rollNumber!=rollNumber) {
			temp=temp.next;
		}
		if(temp!=null) {
			temp.data.grade=grade;
			System.out.println("Grades updated");
		}
		else {
			System.out.println("No Student was found with this Roll Number! So Grades could not be Updated");
		}
			
	}
	public static void main(String[] args) {
		Student student1=new Student(1,"Merin",22,'A');
		Student student2=new Student(2,"Peter",18,'A');
		Student student3=new Student(3,"Shiren",17,'A');
		Student student4=new Student(4,"Divyan",18,'A');
	    Student student5=new Student(5,"Krish",19,'B');
		//insert node
		insertNode(student1);
		insertNode(student2);
		insertNode(student3);
		insertNode(student4);
		insertNode(student5);
		//display all nodes of a linkedlist
		display();
        //delete a student by rollNumber
		deleteNode(2);
		display();
		deleteNode(8);
		display();
		//searching nodes
		searchNode(1);
		searchNode(6);
		//update grades based on roll_Numbers
		updateGrades(5,'C');
		display();
	}
}