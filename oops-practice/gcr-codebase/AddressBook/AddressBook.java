package AddressBook;
import java.util.*;

// UC-2: Add new Contact using Console + OOP
public class AddressBook {
	    private Contact contactPerson;
	    public void addContact() {
	    	//user input
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter First Name: ");
	        String firstName = sc.nextLine();
	        System.out.print("Enter Last Name: ");
	        String lastName = sc.nextLine();
	        System.out.print("Enter Address: ");
	        String address = sc.nextLine();
	        System.out.print("Enter City: ");
	        String city = sc.nextLine();
	        System.out.print("Enter State: ");
	        String state = sc.nextLine();
	        System.out.print("Enter Zip Code: ");
	        String zipCode = sc.nextLine();
	        System.out.print("Enter Phone Number: ");
	        String phoneNumber = sc.nextLine();
	        System.out.print("Enter Email: ");
	        String email = sc.nextLine();

	        contactPerson = new Contact(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
	        System.out.println("Contact Added Successfully!");
	    }

	    public void displayContact() {
	        if (contactPerson != null) {
	            System.out.println(contactPerson);
	        } else {
	            System.out.println("No contact found!");
	        }
	    }
	}


