package com.bridgelabz;

import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class AddressBookManager {
	 AddressBookFileIOService addressBookFileIOService = new AddressBookFileIOService();
	    HashMap<String, LinkedList> addressBookMap = new HashMap<String, LinkedList>();
	    Scanner scanner = new Scanner(System.in);


	    public void createAddressBook() {
	        System.out.println("Enter the name of a AddressBook: ");
	        String addressBookName = scanner.next();
	        if (addressBookMap.containsKey(addressBookName))
	            System.out.println("AddressBook is already present");
	        else
	            addressBookMap.put(addressBookName, new LinkedList<Contact>());
	        System.out.println(addressBookMap.keySet());
	    }

	    //@addContact verifies the addressBookName entered by the user. if not matches it will show exception.
	    public boolean checkAddressBookandaddContact(String addressBookName, Contact obj) {
	        if (addressBookMap.containsKey(addressBookName) == false) {
	            throw new RuntimeException("AddressBook not present");
	        }
	        System.out.println(obj + "AddressBook name: " + addressBookName);
	        addressBookMap.get(addressBookName).add(obj);
	        return true;
	    }
	    //@editContact verifies the addressBookName entered by the user. if not matches it will show exception.

	    public boolean editContact(String addressBookName, Contact obj) {
	        if (addressBookMap.containsKey(addressBookName) == false) {
	            throw new RuntimeException("AddressBook not present");
	        }
	        System.out.println(obj + "AddressBook name: " + addressBookName);
	        addressBookMap.get(addressBookName).add(obj);
	        return true;
	    }

	    public List getContactByAddressBook(String addressBookName) {
	        List contacts = addressBookMap.get(addressBookName);
	        contacts.forEach(contact -> System.out.println(contact));
	        return contacts;
	    }
	    public void writeDataInFile(){
	        addressBookMap.forEach((addressBookName,contacts)->addressBookFileIOService.writeData(contacts,addressBookName));
	    }

}
