package com.bridgelabz;

import java.util.ArrayList;
import java.util.Map;

public class Print extends Dictionary {

    /**
     *	created print method to print different types of details
     */
    public void print() {
        /*
         *	using isEmpty method check AddressBookList is Empty or not. If empty return from method
         *	Giving option to print => All contacts or contacts of specific AddressBook or specific contact or AddressBook List
         *	[ For Specific Contact details ] =>
         *		call displayContact method pass value returned by searchContact method
         *	[ For Specific AddressBook details ] =>
         *		calling printAddressBookContacts method
         *	[ For All contact details ] =>
         *		calling printAllContacts method
         *	[ For AddressBook List ] =>
         *		calling printAddressBookList method
         */
        if (addressBookList.isEmpty() == true) {
            System.out.println("\n AddressBook List is Empty");
            return;
        }

        System.out.println("\n 1. Specific Contact Details \n 2. Specific AddressBook Details "
                + "\n 3. All Contacts Details \n 4. AddressBook List");
        System.out.print(" Enter optoin : ");
        int option = scan.nextInt();

        if (option == 1) {

            System.out.print("\n Enter First Name : ");
            String firstName = scan.next();
            System.out.print(" Enter Last Name : ");
            String lastName = scan.next();

            displayContact(searchContact(firstName, lastName));

        } else if (option == 2) {

            printAddressBookContacts();

        } else if (option == 3) {

            printAllContacts();

        } else if (option == 4) {

            printAddressBookList();

        } else {

            System.out.println("\n Invalid option");
        }
    }

    /**
     *	created printAddressBookContacts method to print contact details of AddressBook
     */
    public void printAddressBookContacts() {
        /*
         *	take AddressBook name, if it is not available print "Address Book not Available"
         *	if Available then using for loop print all contact details from it
         */
        System.out.print("\n Enter Name of AddressBook : ");
        String name = scan.next();

        if (!addressBookList.containsKey(name)) {
            System.out.println("\n Address Book not Available");

        } else {
            System.out.println("\n **** " + name + " ****");
            contactList = addressBookList.get(name);

            for(int i = 0; i < contactList.size(); i++) {
                System.out.println("\n *** Contact - " + (i+1) +" ***");
                displayContact(contactList.get(i));
            }
        }

    }

    /**
     *	created printAllContacts method to print all contact details
     */
    public void printAllContacts() {
        /*
         *	Iterate all addressBookList (HashMap), take contactList (ArrayList) one by one
         *	and print all contact details from it
         */
        int j = 0;
        for(Map.Entry<String, ArrayList<Contact>> temp : addressBookList.entrySet()){
            j++;
            System.out.println("\n ***** [" + j +"] " + temp.getKey() + " *****");
            contactList = temp.getValue();
            for(int i = 0; i < contactList.size(); i++) {
                System.out.println("\n *** Contact - " + (i+1) +" ***");
                displayContact(contactList.get(i));
            }
        }
    }

    /**
     *	created printAddressBookList method to print AddressBook List
     */
    public void printAddressBookList() {
        /*
         *	Iterate addressBookList and print addressBook name one by one
         */
        int i = 0;
        System.out.println("\n **** AddressBook List **** \n");
        for(Map.Entry<String, ArrayList<Contact>> temp  : addressBookList.entrySet()){
            i++;
            System.out.println(" ("+ i +") "+ temp.getKey());
        }
    }
}