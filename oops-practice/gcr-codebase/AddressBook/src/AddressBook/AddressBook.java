package AddressBook;

import java.util.*;

// UC-2: Add new Contact using Console + OOP
public class AddressBook {

	// UC-5: Ability to add multiple person to Address Book using Collection Class
	// private ArrayList<Contact> contactList = new ArrayList<Contact>();
	// UC-6: Multiple Address Books with unique name using Dictionary
	private HashMap<String, ArrayList<Contact>> addressBookMap = new HashMap<String, ArrayList<Contact>>();
	// UC-9: Dictionary of City -> Persons and State -> Persons
	private HashMap<String, ArrayList<Contact>> cityMap = new HashMap<String, ArrayList<Contact>>();
	private HashMap<String, ArrayList<Contact>> stateMap = new HashMap<String, ArrayList<Contact>>();

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
		if (contactList == null) {
			return false;
		}
		// UC-7 Duplicate Check
		if (contactList.contains(contactPerson)) {
			return false;
		}
		contactList.add(contactPerson);
		// UC-9: Store in City/State dictionary
		updateCityStateMap(contactPerson);
		return true;
	}

	// UC-9: Update City and State Dictionaries
	private void updateCityStateMap(Contact contactPerson) {
		String city = contactPerson.getCity();
		String state = contactPerson.getState();
		if (!cityMap.containsKey(city)) {
			cityMap.put(city, new ArrayList<Contact>());
		}
		cityMap.get(city).add(contactPerson);
		if (!stateMap.containsKey(state)) {
			stateMap.put(state, new ArrayList<Contact>());
		}
		stateMap.get(state).add(contactPerson);
	}

	// UC-5 : return all contacts
	public ArrayList<Contact> getAllContacts(String addressBookName) {
		ArrayList<Contact> contactList = addressBookMap.get(addressBookName);
		if (contactList == null) {
			return new ArrayList<Contact>();
		}
		return contactList;
	}

	// find contact by first name
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

	// UC-3: Edit Existing Contact Details by Name using Console (using setters)
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

	// UC-4: Delete a person using person's name - Use Console to delete a person
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

	// UC-8: Search Person in a City across multiple Address Books
	public ArrayList<Contact> searchPersonByCity(String city) {
		ArrayList<Contact> result = new ArrayList<Contact>();
		for (String bookName : addressBookMap.keySet()) {
			ArrayList<Contact> contactList = addressBookMap.get(bookName);
			for (Contact contact : contactList) {
				if (contact.getCity().equalsIgnoreCase(city)) {
					result.add(contact);
				}
			}
		}
		return result;
	}

	// UC-8: Search Person in a State across multiple Address Books
	public ArrayList<Contact> searchPersonByState(String state) {
		ArrayList<Contact> result = new ArrayList<Contact>();
		for (String bookName : addressBookMap.keySet()) {
			ArrayList<Contact> contactList = addressBookMap.get(bookName);
			for (Contact contact : contactList) {
				if (contact.getState().equalsIgnoreCase(state)) {
					result.add(contact);
				}
			}
		}
		return result;
	}

	// UC-9: View Persons by City
	public HashMap<String, ArrayList<Contact>> viewPersonsByCity() {
		return cityMap;
	}

	// UC-9: View Persons by State
	public HashMap<String, ArrayList<Contact>> viewPersonsByState() {
		return stateMap;
	}

	// UC-10: Count Persons by City
	public HashMap<String, Integer> countByCity() {
		HashMap<String, Integer> cityCountMap = new HashMap<String, Integer>();

		for (String city : cityMap.keySet()) {
			cityCountMap.put(city, cityMap.get(city).size());
		}
		return cityCountMap;
	}

	// UC-10: Count Persons by State
	public HashMap<String, Integer> countByState() {
		HashMap<String, Integer> stateCountMap = new HashMap<String, Integer>();

		for (String state : stateMap.keySet()) {
			stateCountMap.put(state, stateMap.get(state).size());
		}
		return stateCountMap;
	}
	// UC-11: sort contacts alphabetically by person's name
	public ArrayList<Contact> sortContactsByName(String addressBookName) {
	    ArrayList<Contact> contactList = addressBookMap.get(addressBookName);

	    if (contactList == null) {
	        return new ArrayList<Contact>();
	    }

	    //collection library for sorting
	    Collections.sort(contactList, new Comparator<Contact>() {
	        @Override
	        public int compare(Contact c1, Contact c2) {
	            return c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
	        }
	    });

	    return contactList;
	}

}