package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Dictionary extends AddressBook {

    /**
     *	created searchBCityOrState method to search contacts by city or state and print contact details
     */
    public void searchBCityOrState() {
        /*
         *	taking input to search by city or state,
         *	taking city or state depend on option selected
         *	and check if entered city or state is available or not in cityList or stateList
         *	if city or state available iterate that arrayList
         *	and one by one give contacts to displayContact method to print details of contacts
         */
        System.out.println("\n 1. By City \n 2. By State");
        System.out.print(" Enter option : ");
        int option = scan.nextInt();


        switch (option) {
            case 1 -> {
                System.out.print("\n Enter name of City : ");
                String city = scan.next();

                if (!cityList.containsKey(city)) {
                    System.out.println("\n City not Available");

                } else {
                    System.out.println("\n **** " + city + " ****");
                    contactList = cityList.get(city);

                    for(int i = 0; i < contactList.size(); i++) {
                        System.out.println("\n *** Contact - " + (i+1) +" ***");
                        displayContact(contactList.get(i));
                    }
                }
            }

            case 2 -> {
                System.out.print("\n Enter name of State : ");
                String state = scan.next();

                if (!stateList.containsKey(state)) {
                    System.out.println("\n State not Available");

                } else {
                    System.out.println("\n **** " + state + " ****");
                    contactList = stateList.get(state);

                    for(int i = 0; i < contactList.size(); i++) {
                        System.out.println("\n *** Contact - " + (i+1) +" ***");
                        displayContact(contactList.get(i));
                    }
                }
            }
            default -> {

                System.out.println("\n Invalid option selected");
            }
        }
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
        System.out.print("\n Enter First Name : ");
        String firstName = scan.next();
        System.out.print(" Enter Last Name : ");
        String lastName = scan.next();

        if(searchContact(firstName, lastName) != null) {
            System.out.println("\n Contact Already Available");
            return;
        }

        if (!addressBookList.containsKey(name)) {
            contactList =  new ArrayList<>();
            addressBookList.put(name, contactList);
            addDetails(firstName, lastName, contactList);

        } else {
            contactList = addressBookList.get(name);
            addDetails(firstName, lastName, contactList);
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

            System.out.print("\n Enter First Name : ");
            String firstName = scan.next();
            System.out.print(" Enter Last Name : ");
            String lastName = scan.next();

            deleteContact(searchContact(firstName, lastName));

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
        System.out.print("\n Enter First Name : ");
        String firstName = scan.next();
        System.out.print(" Enter Last Name : ");
        String lastName = scan.next();
        editDetails(searchContact(firstName, lastName));
    }

}