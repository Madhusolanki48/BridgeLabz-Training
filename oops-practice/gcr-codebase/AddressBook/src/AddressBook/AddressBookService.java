package AddressBook;

import java.util.*;

public class AddressBookService {
    private AddressBook addressBook = new AddressBook();

    // UC-6 : Add Address Book
    public boolean addAddressBook(String addressBookName) {
        return addressBook.addAddressBook(addressBookName);
    }

    public Set<String> getAllAddressBookNames() {
        return addressBook.getAllAddressBookNames();
    }

    // UC-5 + UC-6 : add contact
    public boolean addContact(String addressBookName, Contact contact) {
        return addressBook.addContact(addressBookName, contact);
    }

    public ArrayList<Contact> getAllContacts(String addressBookName) {
        return addressBook.getAllContacts(addressBookName);
    }

    // UC-3 : edit contact
    public boolean editContact(String addressBookName, String firstName, String address, String city, String state,
            String zipCode, String phoneNumber, String email) {
        return addressBook.editContact(addressBookName, firstName, address, city, state, zipCode, phoneNumber, email);
    }

    // UC-4 : delete contact
    public boolean deleteContact(String addressBookName, String firstName) {
        return addressBook.deleteContact(addressBookName, firstName);
    }

    // UC-8: Search Person by City across multiple Address Books
    public ArrayList<Contact> searchPersonByCity(String city) {
        return addressBook.searchPersonByCity(city);
    }

    // UC-8: Search Person by State across multiple Address Books
    public ArrayList<Contact> searchPersonByState(String state) {
        return addressBook.searchPersonByState(state);
    }

    // UC-9: View Persons grouped by City
    public HashMap<String, ArrayList<Contact>> viewPersonsByCity() {
        return addressBook.viewPersonsByCity();
    }

    // UC-9: View Persons grouped by State
    public HashMap<String, ArrayList<Contact>> viewPersonsByState() {
        return addressBook.viewPersonsByState();
    }

    // UC-10: Count Persons by City
    public HashMap<String, Integer> countByCity() {
        return addressBook.countByCity();
    }

    // UC-10: Count Persons by State
    public HashMap<String, Integer> countByState() {
        return addressBook.countByState();
    }
    // UC-11: Sort contacts by name
    public ArrayList<Contact> sortContactsByName(String addressBookName) {
        return addressBook.sortContactsByName(addressBookName);
    }
    // UC-12: Sort by City
    public ArrayList<Contact> sortContactsByCity(String addressBookName) {
        return addressBook.sortContactsByCity(addressBookName);
    }

    // UC-12: Sort by State
    public ArrayList<Contact> sortContactsByState(String addressBookName) {
        return addressBook.sortContactsByState(addressBookName);
    }

    // UC-12: Sort by Zip
    public ArrayList<Contact> sortContactsByZip(String addressBookName) {
        return addressBook.sortContactsByZip(addressBookName);
    }
    // UC-13: Write to file
    public void writeToFile(String addressBookName, String fileName) {
        addressBook.writeToFile(addressBookName, fileName);
    }

    // UC-13: Read from file
    public void readFromFile(String addressBookName, String fileName) {
        addressBook.readFromFile(addressBookName, fileName);
    }
    // UC-14: Write CSV
    public void writeToCSV(String addressBookName, String fileName) {
        addressBook.writeToCSV(addressBookName, fileName);
    }

    // UC-14: Read CSV
    public void readFromCSV(String addressBookName, String fileName) {
        addressBook.readFromCSV(addressBookName, fileName);
    }

}
