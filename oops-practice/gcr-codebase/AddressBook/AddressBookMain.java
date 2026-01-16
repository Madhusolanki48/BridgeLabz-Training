package AddressBook;
//main class
public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("-------------  Welcome to Address Book Program  -------------");

        AddressBook addressBook = new AddressBook();
        addressBook.addContact();
        addressBook.displayContact();
    }
}

