package scenario_based;
import java.util.*;

class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String s) {
        super(s);
    }
}

class Contact {
    //attributes
    private String name;
    private String phoneNumber;

    //constructor
    Contact(String name,String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //getters
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void getDetails() {
        System.out.println("Name         : " + name);
        System.out.println("Phone Number : " + phoneNumber);
        System.out.println("------------------------------------------");
    }
}

class Phone {
    static List<Contact> list = new ArrayList<>();
    //method to add contact 
    public static void addContact(String name,String phoneNumber)
            throws InvalidPhoneNumberException {

        if (!phoneNumber.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException(   //throws exception when phone number is not of 10 digits
                "Invalid Phone Number - must be exactly 10 digits."
            );
        }

        //prevent duplicate 
        for (Contact contact : list) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("This phone number already exists in contact list!");
                return;
            }
        }

        Contact contact = new Contact(name, phoneNumber);
        list.add(contact);
        System.out.println("Contact added successfully.");
        System.out.println("-----------------------------------------");
    }

    public static void deleteContact(String phoneNumber) {
        boolean removed = false;

        Iterator<Contact> it = list.iterator();
        while (it.hasNext()) {
            Contact c = it.next();
            if (c.getPhoneNumber().equals(phoneNumber)) {
                it.remove();
                removed = true;
            }
        }

        System.out.println(removed ? "Contact deleted successfully!": "Contact not found in list!");
        System.out.println("-----------------------------------------");
    }
    //method to search contact in the contact list
    public static void searchContact(String name) {
        boolean found = false;
        for(Contact contact : list) {
            if(contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact Found!");
                contact.getDetails();
                found = true;
            }
        }
        if (!found)
            System.out.println("This contact does not exist in the Contact List!");
    }
    public static void viewContacts() {
        if (list.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (Contact c : list) {
                c.getDetails();
            }
        }
    }
}

public class PhoneContactOrganizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------  Welcome to Phone Contact Organizer  ------");
        //user input
        while (true) {
            System.out.println("\n1- Add Contact");
            System.out.println("2- Delete Contact");
            System.out.println("3- Search Contact");
            System.out.println("4- View All Contacts");
            System.out.println("5- Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            try {
                switch (choice) {
                    case 1:  //to add a number
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Phone Number: ");
                        String phone = sc.nextLine();
                        Phone.addContact(name, phone);
                        break;
                    case 2:  //to delete a number
                        System.out.print("Enter phone number to delete: ");
                        Phone.deleteContact(sc.nextLine());
                        break;
                    case 3:  //to search a contact
                        System.out.print("Enter name to search: ");
                        Phone.searchContact(sc.nextLine());
                        break;

                    case 4:  //to view contact list
                        Phone.viewContacts();
                        break;

                    case 5:
                        System.out.println("Exiting... Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
            catch (InvalidPhoneNumberException e) {
                System.out.println("Error" + e.getMessage());
                System.out.println("-----------------------------------------");
            }
        }
    }
}
