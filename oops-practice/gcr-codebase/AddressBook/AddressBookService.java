package AddressBook;
import java.util.*;

public class AddressBookService {
    private AddressBook addressBook = new AddressBook();
    // UC-2 : add contact
    public void addContact(Contact contact) {
        addressBook.addContact(contact);
    }
    public ArrayList<Contact> getAllContacts() {
        return addressBook.getAllContacts();
    }

    // UC-3 : edit contact
    public boolean editContact(String firstName, String address, String city, String state,
                               String zipCode, String phoneNumber, String email) {

        return addressBook.editContact(firstName, address, city, state, zipCode, phoneNumber, email);
    }

    // UC-4 : delete contact
    public boolean deleteContact(String firstName) {
        return addressBook.deleteContact(firstName);
    }
}
