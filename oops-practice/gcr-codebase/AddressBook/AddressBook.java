package AddressBook;
import java.util.*;

// UC-2: Add new Contact using Console + OOP
public class AddressBook {
	    private Contact contactPerson;
		Scanner sc = new Scanner(System.in);
	    public void addContact() {
	    	//user input
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
//UC-3: Edit Existing Contact Details by Name using Console (using setters)
		public void editContact() {
			if (contactPerson == null) {
            System.out.println("No contact found to edit!");
            return;
        }

        System.out.print("\nEnter First Name to Edit: ");
        String name = sc.nextLine();
        if (contactPerson.getFirstName().equalsIgnoreCase(name)) {

            System.out.println("Contact Found! Enter new details:");

            System.out.print("Enter New Address: ");
            contactPerson.setAddress(sc.nextLine());

            System.out.print("Enter New City: ");
            contactPerson.setCity(sc.nextLine());

            System.out.print("Enter New State: ");
            contactPerson.setState(sc.nextLine());

            System.out.print("Enter New Zip Code: ");
            contactPerson.setZipCode(sc.nextLine());

            System.out.print("Enter New Phone Number: ");
            contactPerson.setPhoneNumber(sc.nextLine());

            System.out.print("Enter New Email: ");
            contactPerson.setEmail(sc.nextLine());

            System.out.println("Contact Updated Successfully!");

        } else {
            System.out.println("Name not found!");
        }
    }

	    public void displayContact() {
	        if (contactPerson != null) {
	            System.out.println(contactPerson);
	        } else {
	            System.out.println("No contact found!");
	        }
	    }
	}


