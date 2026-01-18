package AddressBook;
//main class
public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("-------------  Welcome to Address Book Program  -------------");

        AddressBook addressBook = new AddressBook();
        addressBook.addContact();    // UC-2
        addressBook.editContact();  // UC-3
        addressBook.deleteContact(); //UC -4
        addressBook.displayContact();
    }
}

