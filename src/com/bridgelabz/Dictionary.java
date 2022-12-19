package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dictionary extends AddressBook {

    HashMap<String, ArrayList<Contact>> addressBookList = new HashMap<>();		// created object of HashMap class

    /**
     *	created searchContact method with return type Contact
     *	to search and check contact is available or not
     */
    public Contact searchContact() {
        /*
         *	taking user input of first name of contact
         *	Iterating addressBookList (HashMap) and one by one taking contactList (ArrrayList)
         *	and for each contact of contactList matching firstName of contact
         *	if it matches then return contact else return null
         */
        System.out.print("\n Enter First Name of Contact : ");
        String firstName = scan.next();

        for(Map.Entry<String, ArrayList<Contact>> temp : addressBookList.entrySet()){
            contactList = temp.getValue();

            for(Contact contact : contactList) {

                if(contact.getFirstName().equalsIgnoreCase(firstName)) {
                    return contact;
                }
            }
        }
        return null;
    }

    /**
     *	created addContact method to add new contact
     */
    public void addContact() {
        /*
         *	taking user input of AddressBook name
         *	using containsKey method of HashMap class to check addressBook is available or not
         *	if addressBook not available then create addressBook and add to addressBookList
         *  then call addDetails method to add contact details
         *	if addressBook available then call addDetails method to add contact details
         */
        System.out.print("\n Enter Name of AddressBook : ");
        String name = scan.next();

        if (!addressBookList.containsKey(name)) {
            contactList =  new ArrayList<>();
            addressBookList.put(name, contactList);
            addDetails(contactList);

        } else {
            contactList = addressBookList.get(name);
            addDetails(contactList);
        }
    }

    /**
     *	created addAddressBook to create new AddressBook and add it to AddressBookList
     */
    public void addAddressBook() {
        /*
         *	taking user input of AddressBook name
         *	using containsKey method of HashMap class to check addressBook is available or not
         *	if addressBook not available then create addressBook and add to addressBookList
         *	else print "Address Book Already Available"
         */
        System.out.print("\n Enter Name of AddressBook : ");
        String name = scan.next();

        if (!addressBookList.containsKey(name)) {
            contactList =  new ArrayList<>(); ;
            addressBookList.put(name, contactList);
            System.out.println("\n AddressBook Added Successfully");
        } else {
            System.out.println("\n Address Book Already Available");
        }
    }


    /**
     *	created delete method to delete Contact or AddressBook
     */
    public void delete() {
        /*
         *	using isEmpty method check AddressBookList is Empty or not. If empty return from method
         *	Giving option to delete => Contact or AddressBook
         *	[ To Delete Contact ] =>
         *		call deleteContact method pass value returned by searchContact method
         *	[ To Delete AddressBook ] =>
         *		taking name of AddressBook, if not available print "AddressBook Not Available"
         *		if available use remove method of HashMap to delete AddressBook
         */
        if (addressBookList.isEmpty() == true) {
            System.out.println("\n AddressBook List is Empty");
            return;
        }

        System.out.println("\n 1. Delete Contact \n 2. Delete AddressBook");
        System.out.print(" Enter option : ");
        int option = scan.nextInt();

        if (option == 1) {

            deleteContact(searchContact());

        } else if (option == 2) {
            System.out.print("\n Enter Name of AddressBook : ");
            String name = scan.next();
            if (!addressBookList.containsKey(name)) {
                System.out.println("\n AddressBook Not Available");
            } else {
                addressBookList.remove(name);
                System.out.println("\n AddressBook Deleted Successfully");
            }
        } else {
            System.out.println("\n Invalid Input");
        }
    }

    /**
     *	created editContact method to edit contact details
     */
    public void editContact() {
        /*
         *	using isEmpty method check AddressBookList is Empty or not. If empty return from method
         *	else call editDetails method pass value returned by searchContact method
         */
        if (addressBookList.isEmpty() == true) {
            System.out.println("\n AddressBook List is Empty");
            return;
        }
        editDetails(searchContact());
    }

}