package AddressBook;
import java.util.*;

// UC-2: Add new Contact using Console + OOP
public class AddressBook {
	
// UC-5: Ability to add multiple person to Address Book using Collection Class
		private ArrayList<Contact> contactList = new ArrayList<Contact>();
	    public void addContact(Contact contactPerson) {
		contactList.add(contactPerson);
	}
    // return all contacts
	public ArrayList<Contact> getAllContacts() {
		return contactList;
	}

	//find contact by first name
	public Contact findContactByName(String firstName) {
		for (Contact contact : contactList) {
			if (contact.getFirstName().equalsIgnoreCase(firstName)) {
				return contact;
			}
		}
		return null;
	}
//UC-3: Edit Existing Contact Details by Name using Console (using setters)
		public boolean editContact(String firstName, String address, String city, String state,
			String zipCode, String phoneNumber, String email) {
				Contact contactPerson = findContactByName(firstName);
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
		public boolean deleteContact(String firstName) {
			for (int i = 0; i < contactList.size(); i++) {
				if (contactList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
					contactList.remove(i);
					return true;
				}
			}
			return false;
		}
	}
			


