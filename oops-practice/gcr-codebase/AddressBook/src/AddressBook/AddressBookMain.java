package AddressBook;

import java.util.*;

//main class
public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("-------------  Welcome to Address Book Program  -------------");
        Scanner sc = new Scanner(System.in);
        AddressBookService service = new AddressBookService();
        String currentAddressBook = null;
        int choice = 0;
        do {
            System.out.println("\n---------- Address Book Home Page ----------");
            System.out.println("Current AddressBook: " + (currentAddressBook == null ? "None" : currentAddressBook));
            System.out.println("1. Create New Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Add Contact");
            System.out.println("4. Edit Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Display Contacts");
            System.out.println("7. Search Person by City");
            System.out.println("8. Search Person by State");
            System.out.println("9. View Persons by City");
            System.out.println("10. View Persons by State");
            System.out.println("11. Count Persons by City");
            System.out.println("12. Count Persons by State");
            System.out.println("13. Sort Contacts By Name");
            System.out.println("14. Sort Contacts by City");
            System.out.println("15. Sort Contacts by State");
            System.out.println("16. Sort Contacts by Zip");
            System.out.println("17. Write Address Book to File");
            System.out.println("18. Read Address Book from File");
            System.out.println("19. Write Address Book to CSV");
            System.out.println("20. Read Address Book from CSV");
            System.out.println("21. Exit");

            System.out.print("Enter your choice: ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number (1-13).");
                sc.nextLine();
                continue;
            }
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
                    System.out.println("--------------------------------------------");
                    break;

                case 2:
                    Set<String> books = service.getAllAddressBookNames();
                    if (books.size() == 0) {
                        System.out.println("No Address Book available! Create one first.");
                        System.out.println("--------------------------------------------");
                        break;
                    }
                    System.out.println("Available Address Books: " + books);
                    System.out.print("Enter Address Book Name to Select: ");
                    String selectBook = sc.nextLine();
                    if (service.getAllAddressBookNames().contains(selectBook)) {
                        currentAddressBook = selectBook;
                        System.out.println("Selected Address Book: " + currentAddressBook);
                    } else {
                        System.out.println("Address Book not found!");
                    }
                    System.out.println("--------------------------------------------");
                    break;

                case 3:
                    if (currentAddressBook == null) {
                        System.out.println("Please select an Address Book first!");
                        System.out.println("--------------------------------------------");
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

                    Contact contact = new Contact(firstName, lastName, address, city, state, zipCode, phoneNumber,
                            email);
                    boolean added = service.addContact(currentAddressBook, contact);
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
                        System.out.println("--------------------------------------------");
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
                    boolean edited = service.editContact(currentAddressBook, editName, newAddress, newCity, newState,
                            newZip, newPhone, newEmail);
                    if (edited) {
                        System.out.println("Contact Updated Successfully!");
                    } else {
                        System.out.println("Name not found!");
                    }
                    System.out.println("--------------------------------------------");
                    break;

                case 5:
                    if (currentAddressBook == null) {
                        System.out.println("Please select an Address Book first!");
                        System.out.println("--------------------------------------------");
                        break;
                    }
                    System.out.print("Enter First Name to Delete: ");
                    String deleteName = sc.nextLine();
                    System.out.print("Are you sure you want to delete this contact? (Y/N): ");
                    char confirm = sc.nextLine().charAt(0);

                    if (confirm == 'Y' || confirm == 'y') {
                        boolean deleted = service.deleteContact(currentAddressBook, deleteName);
                        if (deleted) {
                            System.out.println("Contact Deleted Successfully!");
                        } else {
                            System.out.println("Name not found!");
                        }
                    } else {
                        System.out.println("Delete cancelled!");
                    }
                    System.out.println("--------------------------------------------");
                    break;
                case 6:
                    if (currentAddressBook == null) {
                        System.out.println("Please select an Address Book first!");
                        System.out.println("--------------------------------------------");
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
                    System.out.print("Enter City to Search: ");
                    String searchCity = sc.nextLine();

                    ArrayList<Contact> cityResult = service.searchPersonByCity(searchCity);
                    System.out.println("\n------ Search Result By City: " + searchCity + " ------");

                    if (cityResult.size() > 0) {
                        System.out.println("\nPersons Found in City: " + searchCity);
                        for (Contact c : cityResult) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("No person found in this city!");
                    }
                    break;

                case 8:
                    System.out.print("Enter State to Search: ");
                    String searchState = sc.nextLine();

                    ArrayList<Contact> stateResult = service.searchPersonByState(searchState);
                    System.out.println("\n------ Search Result By State: " + searchState + " ------");

                    if (stateResult.size() > 0) {
                        System.out.println("\nPersons Found in State: " + searchState);
                        for (Contact c : stateResult) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("No person found in this state!");
                    }
                    break;
                case 9:
                    HashMap<String, ArrayList<Contact>> cityMap = service.viewPersonsByCity();

                    if (cityMap.size() == 0) {
                        System.out.println("No person found!");
                        System.out.println("--------------------------------------------");
                        break;
                    }

                    System.out.println("\n------ Persons Grouped By City ------");
                    for (String cityName : cityMap.keySet()) {
                        System.out.println("\nCity: " + cityName);
                        for (Contact c : cityMap.get(cityName)) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 10:
                    HashMap<String, ArrayList<Contact>> stateMap = service.viewPersonsByState();

                    if (stateMap.size() == 0) {
                        System.out.println("No person found!");
                        System.out.println("--------------------------------------------");
                        break;
                    }

                    System.out.println("\n------ Persons Grouped By State ------");
                    for (String stateName : stateMap.keySet()) {
                        System.out.println("\nState: " + stateName);
                        for (Contact c : stateMap.get(stateName)) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 11:
                    HashMap<String, Integer> cityCount = service.countByCity();

                    if (cityCount.size() == 0) {
                        System.out.println("No person found!");
                        System.out.println("--------------------------------------------");
                        break;
                    }

                    System.out.println("\n------ Count of Persons By City ------");
                    for (String cityName : cityCount.keySet()) {
                        System.out.println(cityName + " : " + cityCount.get(cityName));
                    }
                    System.out.println("--------------------------------------------");
                    break;

                case 12:
                    HashMap<String, Integer> stateCount = service.countByState();

                    if (stateCount.size() == 0) {
                        System.out.println("No person found!");
                        System.out.println("--------------------------------------------");
                        break;
                    }

                    System.out.println("\n------ Count of Persons By State ------");
                    for (String stateName : stateCount.keySet()) {
                        System.out.println(stateName + " : " + stateCount.get(stateName));
                    }
                    System.out.println("--------------------------------------------");
                    break;
                case 13:
                    if (currentAddressBook == null) {
                        System.out.println("Please select an Address Book first!");
                        System.out.println("--------------------------------------------");
                        break;
                    }

                    ArrayList<Contact> sortedList = service.sortContactsByName(currentAddressBook);

                    if (sortedList.size() == 0) {
                        System.out.println("No contact found!");
                        break;
                    }

                    System.out.println("\n------ Contacts Sorted By Name ------");
                    for (Contact c : sortedList) {
                        System.out.println(c);
                    }
                    System.out.println("--------------------------------------------");
                    break;
                case 14:
                    if (currentAddressBook == null) {
                        System.out.println("Please select an Address Book first!");
                        break;
                    }

                    ArrayList<Contact> citySorted = service.sortContactsByCity(currentAddressBook);

                    System.out.println("\n------ Contacts Sorted By City ------");
                    for (Contact c : citySorted) {
                        System.out.println(c);
                    }
                    break;
                case 15:
                    if (currentAddressBook == null) {
                        System.out.println("Please select an Address Book first!");
                        break;
                    }

                    ArrayList<Contact> stateSorted = service.sortContactsByState(currentAddressBook);

                    System.out.println("\n------ Contacts Sorted By State ------");
                    for (Contact c : stateSorted) {
                        System.out.println(c);
                    }
                    break;
                case 16:
                    if (currentAddressBook == null) {
                        System.out.println("Please select an Address Book first!");
                        break;
                    }

                    ArrayList<Contact> zipSorted = service.sortContactsByZip(currentAddressBook);

                    System.out.println("\n------ Contacts Sorted By Zip ------");
                    for (Contact c : zipSorted) {
                        System.out.println(c);
                    }
                    break;
                case 17:
                    if (currentAddressBook == null) {
                        System.out.println("Please select an Address Book first!");
                        break;
                    }

                    service.writeToFile(currentAddressBook, "addressbook.txt");
                    break;
                case 18:
                    if (currentAddressBook == null) {
                        System.out.println("Please select an Address Book first!");
                        break;
                    }

                    service.readFromFile(currentAddressBook, "addressbook.txt");
                    break;
                case 19:
                    if (currentAddressBook == null) {
                        System.out.println("Please select an Address Book first!");
                        break;
                    }

                    service.writeToCSV(currentAddressBook, "addressbook.csv");
                    break;
                case 20:
                    if (currentAddressBook == null) {
                        System.out.println("Please select an Address Book first!");
                        break;
                    }

                    service.readFromCSV(currentAddressBook, "addressbook.csv");
                    break;

                case 21:
                    System.out.println("Exiting Program...");
                    System.out.println("--------------------------------------------");
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please enter number between 1 and 21.");
                    System.out.println("--------------------------------------------");
            }
            if (choice != 21) {
                System.out.print("\nPress Enter to continue...");
                sc.nextLine();
            }

        } while (choice != 21);
        System.out.println("Thank you for using Address Book!");
        System.out.println("--------------------------------------------");
    }
}
