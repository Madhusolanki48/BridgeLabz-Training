package AddressBook;
import java.util.*;
//main class
public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("-------------  Welcome to Address Book Program  -------------");
        Scanner sc = new Scanner(System.in);
        AddressBookService service = new AddressBookService();
        String currentAddressBook = null;
        int choice;
        do {
            System.out.println("\n---------- Address Book Home Page ----------");
            System.out.println("Current AddressBook: " + (currentAddressBook == null ? "None" : currentAddressBook));
            System.out.println("1. Create New Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Add Contact");
            System.out.println("4. Edit Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Display Contacts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // UC-6: Multiple Address Books System
                case 1:
                    System.out.print("Enter Address Book Name: ");
                    String bookName = sc.nextLine();
                    boolean created = service.addAddressBook(bookName);
                    if (created) {
                        System.out.println("Address Book Created Successfully!");
                    } else {
                        System.out.println("Address Book already exists!");
                    }
                    break;

                case 2:
                    System.out.println("Available Address Books: " + service.getAllAddressBookNames());
                    System.out.print("Enter Address Book Name to Select: ");
                    String selectBook = sc.nextLine();
                    if (service.getAllAddressBookNames().contains(selectBook)) {
                        currentAddressBook = selectBook;
                        System.out.println("Selected Address Book: " + currentAddressBook);
                    } else {
                        System.out.println("Address Book not found!");
                    }
                    break;

                case 3:
                    if (currentAddressBook == null) {
                        System.out.println("Please select an Address Book first!");
                        break;
                    }
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

                    Contact contact = new Contact(firstName, lastName, address, city, state, zipCode, phoneNumber,email);
                    boolean added=service.addContact(currentAddressBook, contact);
                    if (added) {
                        System.out.println("Contact Added Successfully!");
                    } else {
                        System.out.println("Duplicate Contact! Person already exists in this Address Book!");
                    }
                    System.out.println("--------------------------------------------");
                    break;

                case 4:
                    if (currentAddressBook == null) {
                        System.out.println("Please select an Address Book first!");
                        break;
                    }
                    System.out.print("Enter First Name to Edit: ");
                    String editName = sc.nextLine();
                    System.out.print("Enter New Address: ");
                    String newAddress = sc.nextLine();
                    System.out.print("Enter New City: ");
                    String newCity = sc.nextLine();
                    System.out.print("Enter New State: ");
                    String newState = sc.nextLine();
                    System.out.print("Enter New Zip Code: ");
                    String newZip = sc.nextLine();
                    System.out.print("Enter New Phone Number: ");
                    String newPhone = sc.nextLine();
                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();
                    boolean edited = service.editContact(currentAddressBook, editName, newAddress, newCity, newState, newZip, newPhone,newEmail);
                    if (edited) {
                        System.out.println("Contact Updated Successfully!");
                        System.out.println("--------------------------------------------");
                    } else {
                        System.out.println("Name not found!");
                    }
                    break;

                case 5:
                    if (currentAddressBook == null) {
                        System.out.println("Please select an Address Book first!");
                        break;
                    }
                    System.out.print("Enter First Name to Delete: ");
                    String deleteName = sc.nextLine();
                    boolean deleted = service.deleteContact(currentAddressBook, deleteName);
                    if (deleted) {
                        System.out.println("Contact Deleted Successfully!");
                        System.out.println("--------------------------------------------");
                    } else {
                        System.out.println("Name not found!");
                    }
                    break;
                case 6:
                    if (currentAddressBook == null) {
                        System.out.println("Please select an Address Book first!");
                        break;
                    }
                    System.out.println("Contacts in Address Book: " + currentAddressBook);
                    System.out.println("--------------------------------------------");
                    ArrayList<Contact> list = service.getAllContacts(currentAddressBook);
                    if (list.size() > 0) {
                        for (Contact c : list) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("No contact found!");
                        System.out.println("--------------------------------------------");
                    }
                    break;
                case 7:
                    System.out.println("Exiting Program...");
                    System.out.println("--------------------------------------------");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            if (choice != 7) {
                System.out.print("\nPress Enter to continue...");
                sc.nextLine();
            }

        } while (choice != 7);
        System.out.println("Thank you for using Address Book!");
        System.out.println("--------------------------------------------");
    }
}
