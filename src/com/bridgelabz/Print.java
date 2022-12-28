package com.bridgelabz;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Print extends Dictionary{
    /**
     *  created print method to print different types of details
     */
    public void print() {
        /*
         *	using isEmpty method check AddressBookList is Empty or not. If empty return from method
         *	Giving option to print =>
         *  Specific Contact Details, Specific AddressBook Details, Specific City Contacts.
         *  Specific State Contacts, All Contacts Details, AddressBook List
         *  then calling respective methods to get required result
         */
        if (addressBookList.isEmpty()) {
            System.out.println("\n AddressBook List is Empty");
            return;
        }
        System.out.println("\n 1. Specific Contact Details \n 2. Specific AddressBook Details"
                + " \n 3. Specific City Contacts \n 4. Specific State Contacts"
                + " \n 5. All Contacts Details \n 6. AddressBook List");
        System.out.print(" Enter option : ");
        int option = scan.nextInt();
        if (option == 1) {
            printSpecificContact();
        } else if (option == 2) {
            printSpecificAddressBookContacts();
        } else if (option == 3) {
            printSpecificCityContacts();
        } else if (option == 4) {
            printSpecificStateContacts();
        } else if (option == 5) {
            printAllContacts();
        } else if (option == 6) {
            printAddressBookList();
        } else {
            System.out.println("\n Invalid option");
        }
    }
    /**
     *	created printSpecificContact method to print contact details of specific contact
     */
    public void printSpecificContact() {
        /*
         *  taking user input for first & last name
         *  then used values method on addressBookList to get all contactLists in it
         *  then used stream on it, then used flatMap(Collection::stream) to get stream of each contact
         *  ( :: method references is special type of lambda expression "c -> c.stream()" )
         *  then filter contact which match name entered and used toList to store it as list in result
         */
        System.out.print("\n Enter First Name : ");
        String firstName = scan.next();
        System.out.print(" Enter Last Name  : ");
        String lastName = scan.next();
        List<Contact> result = addressBookList.values().stream()
                .flatMap(Collection::stream)
                .filter(c -> c.getFirstName().equals(firstName) && c.getLastName().equals(lastName))
                .toList();
        System.out.println("\n " + result);
    }
    /**
     *	created printSpecificAddressBookContacts method to print contact details of specific addressBook
     */
    public void printSpecificAddressBookContacts() {
        /*
         *  taking user input for AddressBook name
         *  then used keySet method on addressBookList to get all addressBooks in it and applied stream
         *  then filter addressBook which match addressBook entered, then used map & .get to get contactList of it
         *  then used toList to store it as list in result
         */
        System.out.print("\n Enter Name of AddressBook : ");
        String name = scan.next();
        List<ArrayList<Contact>> result = addressBookList.keySet().stream()
                .filter(addressBook -> addressBook.equals(name))
                .map(addressBook -> addressBookList.get(addressBook))
                .toList();
        System.out.println("\n " + result);
    }
    /**
     *	created printSpecificCityContacts method to print contact details of specific city
     */
    public void printSpecificCityContacts() {
        /*
         *  taking user input for city name
         *  then used values method on addressBookList to get all contactLists in it
         *  then used stream on it, then used flatMap(Collection::stream) to get stream of each contact
         *  ( :: method references is special type of lambda expression "c -> c.stream()" )
         *  then filter contact which match city entered and used toList to store it as list in result
         *  printing count of contact using .size method
         */
        System.out.print("\n Enter Name of City : ");
        String city = scan.next();
        List<Contact> result = addressBookList.values().stream()
                .flatMap(Collection::stream).filter(c -> c.getCity().equals(city))
                .toList();
        System.out.println("\n Total no. of contacts in city '" + city + "' = " + result.size());
        System.out.println("\n " + result);
    }
    /**
     *	created printSpecificStateContacts method to print contact details of specific state
     */
    public void printSpecificStateContacts() {
        /*
         *  taking user input for city name
         *  then used values method on addressBookList to get all contactLists in it
         *  then used stream on it, then used flatMap(Collection::stream) to get stream of each contact
         *  ( :: method references is special type of lambda expression "c -> c.stream()" )
         *  then filter contact which match state entered and used toList to store it as list in result
         *  printing count of contact using .size method
         */
        System.out.print("\n Enter Name of State : ");
        String state = scan.next();
        List<Contact> result = addressBookList.values().stream()
                .flatMap(Collection::stream).filter(c -> c.getState().equals(state))
                .toList();
        System.out.println("\n Total no. of contacts in state '" + state + "' = " + result.size());
        System.out.println("\n " + result);
    }
    /**
     *	created printAllContacts method to print all contact details
     */
    public void printAllContacts() {
        /*
         *  used for loop to iterate addressBookList then again used for loop to iterate each contactList
         */
        for (Map.Entry<String, ArrayList<Contact>> entry : addressBookList.entrySet()){
            System.out.println("\n *************** " + entry.getKey() + " ***************");
            for (Contact contact : entry.getValue()) {
                System.out.println(contact);
            }
        }
//        List<ArrayList<Contact>> result = addressBookList.values().stream().toList();
//        System.out.println("\n " + result);
    }
    /**
     *	created printAddressBookList method to print list of addressBooks
     */
    public void printAddressBookList() {
        /*
         *  used .keySet method to get all addressBooks, then used toString to get string representation of it
         */
        String result = addressBookList.keySet().toString();
        System.out.println("\n " + result);
    }
}