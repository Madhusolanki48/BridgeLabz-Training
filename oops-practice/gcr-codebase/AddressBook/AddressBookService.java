package AddressBook;
import java.util.*;

public class AddressBookService {
    private AddressBook addressBook = new AddressBook();
    // UC-6 : Add Address Book
    public boolean addAddressBook(String addressBookName){
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
}
