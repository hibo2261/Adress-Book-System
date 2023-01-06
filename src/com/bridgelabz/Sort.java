package com.bridgelabz;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;


public class Sort extends Dictionary {

    public void sort() {
        /*
         *	using isEmpty method check AddressBookList is Empty or not. If empty return from method
         *	Giving option to sort contacts by =>
         *	first name, city, state, pin code
         *  then calling respective methods to get required result
         */
        if (addressBookList.isEmpty()) {
            System.out.println("\n AddressBook List is Empty");
            return;
        }
        System.out.println("\n 1. Sort By Name \n 2. Sort By City"
                + " \n 3. Sort By State \n 4. Sort By Zip");
        System.out.print(" Enter option : ");
        int option = scan.nextInt();
        if (option == 1) {
            sortAlphabeticallyByName();
        } else if (option == 2) {
            sortByCity();
        } else if (option == 3) {
            sortByState();
        } else if (option == 4) {
            sortByZip();
        } else {
            System.out.println("\n Invalid option");
        }
    }
    /**
     *	created sortAlphabeticallyByName method to sort contacts alphabetically by name
     */
    public void sortAlphabeticallyByName() {
        /*
         *  used values method on addressBookList to get all contactLists in it
         *  then used stream on it, then used flatMap(Collection::stream) to get stream of each contact
         *  ( :: method references is special type of lambda expression "c -> c.stream()" )
         *  then sorted contact alphabetically by first name and used toList to store it as list in result
         */
        List<Contact> result = addressBookList.values().stream().flatMap(Collection::stream)
                .sorted(Comparator.comparing(Contact :: getFirstName)).toList();
        System.out.println(result);
    }
    /**
     *	created sortByCity method to sort contacts by city
     */
    public void sortByCity() {
        /*
         *  used values method on addressBookList to get all contactLists in it
         *  then used stream on it, then used flatMap(Collection::stream) to get stream of each contact
         *  ( :: method references is special type of lambda expression "c -> c.stream()" )
         *  then sorted contact by city and used toList to store it as list in result
         */
        List<Contact> result = addressBookList.values().stream().flatMap(Collection::stream)
                .sorted(Comparator.comparing(Contact :: getCity)).toList();
        System.out.println(result);
    }
    /**
     *	created sortByState method to sort contacts by state
     */
    public void sortByState() {
        /*
         *  used values method on addressBookList to get all contactLists in it
         *  then used stream on it, then used flatMap(Collection::stream) to get stream of each contact
         *  ( :: method references is special type of lambda expression "c -> c.stream()" )
         *  then sorted contact by state and used toList to store it as list in result
         */
        List<Contact> result = addressBookList.values().stream().flatMap(Collection::stream)
                .sorted(Comparator.comparing(Contact :: getState)).toList();
        System.out.println(result);
    }
    /**
     *	created sortByZip method to sort contacts by pin code
     */
    public void sortByZip() {
        /*
         *  used values method on addressBookList to get all contactLists in it
         *  then used stream on it, then used flatMap(Collection::stream) to get stream of each contact
         *  ( :: method references is special type of lambda expression "c -> c.stream()" )
         *  then sorted contact by pin code and used toList to store it as list in result
         */
        List<Contact> result = addressBookList.values().stream().flatMap(Collection::stream)
                .sorted(Comparator.comparing(Contact :: getZipCode)).toList();
        System.out.println(result);
    }
}