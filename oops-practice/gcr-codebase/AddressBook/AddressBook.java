package AddressBook;
import java.util.*;

// UC-2: Add new Contact using Console + OOP
public class AddressBook {

// UC-5: Ability to add multiple person to Address Book using Collection Class
		// private ArrayList<Contact> contactList = new ArrayList<Contact>();
// UC-6: Multiple Address Books with unique name using Dictionary
        private HashMap<String, ArrayList<Contact>> addressBookMap = new HashMap<String, ArrayList<Contact>>();
	public boolean addAddressBook(String addressBookName) {
		if (addressBookMap.containsKey(addressBookName)) {
			return false;
		}
		addressBookMap.put(addressBookName, new ArrayList<Contact>());
		return true;
	}

	public Set<String> getAllAddressBookNames() {
		return addressBookMap.keySet();
	}
	    // UC-5 + UC-6: Add contact to selected Address Book
	    public boolean addContact(String addressBookName, Contact contactPerson) {
			ArrayList<Contact> contactList = addressBookMap.get(addressBookName);
		if(contactList==null){
			return false;
		}
		contactList.add(contactPerson);
		return true;
	}
    //UC-5 : return all contacts
	public ArrayList<Contact> getAllContacts(String addressBookName) {
		ArrayList<Contact> contactList= addressBookMap.get(addressBookName);
		if(contactList ==null){
			return new ArrayList<Contact>();
		}
		return contactList;
	}

	//find contact by first name
	public Contact findContactByName(String addressBookName, String firstName) {
		ArrayList<Contact> contactList = addressBookMap.get(addressBookName);

		if (contactList == null) {
			return null;
		}
		for (Contact contact : contactList) {
			if (contact.getFirstName().equalsIgnoreCase(firstName)) {
				return contact;
			}
		}
		return null;
	}
//UC-3: Edit Existing Contact Details by Name using Console (using setters)
		public boolean editContact(String addressBookName, String firstName, String address, String city, String state,
			String zipCode, String phoneNumber, String email) {
				Contact contactPerson = findContactByName(addressBookName, firstName);
			if (contactPerson == null) {
				return false;
			}
			contactPerson.setAddress(address);
			contactPerson.setCity(city);
			contactPerson.setState(state);
			contactPerson.setZipCode(zipCode);
			contactPerson.setPhoneNumber(phoneNumber);
			contactPerson.setEmail(email);

		return true;
	}
//UC-4: Delete a person using person's name - Use Console to delete a person
		public boolean deleteContact(String addressBookName, String firstName) {
			ArrayList<Contact> contactList = addressBookMap.get(addressBookName);
		if (contactList == null) {
			return false;
		}
			for (int i = 0; i < contactList.size(); i++) {
				if (contactList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
					contactList.remove(i);
					return true;
				}
			}
			return false;
		}
	}
			


