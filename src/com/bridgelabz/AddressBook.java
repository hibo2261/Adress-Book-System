package com.bridgelabz;

import java.util.ArrayList;     //imported ArrayList class
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;		// imported Scanner class

public class AddressBook {

    ArrayList<Contact> contactList;			//	created object of ArrayList class
    static HashMap<String, ArrayList<Contact>> addressBookList = new HashMap<>();		// created object of HashMap class
    static HashMap<String, ArrayList<Contact>> cityList = new HashMap<>();
    static HashMap<String, ArrayList<Contact>> stateList = new HashMap<>();

    Scanner scan = new Scanner(System.in);				//	created object of Scanner class

    /**
     *  created addDetails method to store details of new contact
     */
    public void addDetails(String firstName, String lastName, ArrayList<Contact> contactList) {
        /*
         *	created object of Contact class then
         *	storing details of contact in it.
         *	adding new contact to contactList
         */
        Contact contact = new Contact();

        contact.setFirstName(firstName);

        contact.setLastName(lastName);

        System.out.print(" Enter Address    : ");
        contact.setAddress(scan.next());

        System.out.print(" Enter City Name  : ");
        contact.setCity(scan.next());

        System.out.print(" Enter State Name : ");
        contact.setState(scan.next());

        System.out.print(" Enter Zip code   : ");
        contact.setZipCode(scan.next());

        System.out.print(" Enter Phone No.  : ");
        contact.setPhoneNumber(scan.next());

        System.out.print(" Enter Email Id   : ");
        contact.setEmailId(scan.next());

        contactList.add(contact);

        /*
         *	checking city already available or not in cityList
         *	if available then add contact to city of cityList
         *	else add city in cityList then add contact in it
         */
        if (!cityList.containsKey(contact.getCity())) {
            contactList =  new ArrayList<>();
            cityList.put(contact.getCity(), contactList);
            contactList.add(contact);
        } else {
            contactList = cityList.get(contact.getCity());
            contactList.add(contact);
        }
        /*
         *	checking state already available or not in stateList
         *	if available then add contact to state of stateList
         *	else add state in stateList then add contact in it
         */
        if (!stateList.containsKey(contact.getState())) {
            contactList =  new ArrayList<>();
            stateList.put(contact.getState(), contactList);
            contactList.add(contact);
        } else {
            contactList = stateList.get(contact.getState());
            contactList.add(contact);
        }

        System.out.println("\n Contact Added Successfully");
    }

    /**
     *	created displayContact method to display details of contact & passing contact as parameter
     */
    public void displayContact(Contact contact) {
        /*
         * 	if parameter contact is not null
         *  then print data / details of contact.
         *  else print "Contact Not Found"
         */
        if (contact != null) {
            System.out.println( "\n First Name : " + contact.getFirstName()
                    + "\n Last Name  : " + contact.getLastName()
                    + "\n Address    : " + contact.getAddress()
                    + "\n City Name  : " + contact.getCity()
                    + "\n State Name : " + contact.getState()
                    + "\n Zip Code   : " + contact.getZipCode()
                    + "\n Phone No.  : " + contact.getPhoneNumber()
                    + "\n Email Id   : " + contact.getEmailId() );
        } else {
            System.out.println("\n Contact Not Found");
        }
    }

    /**
     *	created editDetails method to edit details of contact & passing contact as parameter
     */
    public void editDetails(Contact contact) {
        /*
         *	If parameter contact is not null then run do-while loop till exit option entered
         *	In loop using switch case we give separate options to edit different contact details
         *	If contact parameter is null print "Contact Not Found"
         */
        if (contact != null) {
            int option;
            do {
                System.out.println("\n *** Available Options to Change *** ");
                System.out.println(" 1. Name \n 2. Address \n 3. City \n 4. State "
                        + "\n 5. Zip code \n 6. Phone No. \n 7. Email Id \n 8. Exit");
                System.out.print(" Enter option : ");
                option = scan.nextInt();

                switch (option) {

                    case 1 -> {
                        System.out.print("\n Enter First Name : ");
                        String firstName = scan.next();
                        System.out.print(" Enter Last Name : ");
                        String lastName = scan.next();
                        if(searchContact(firstName, lastName) == null) {
                            contact.setFirstName(firstName);
                            contact.setLastName(lastName);
                        } else {
                            System.out.println("\n Contact Already Available");
                        }

                    } case 2 -> {
                        System.out.print("\n Enter Address    : ");
                        contact.setAddress(scan.next());
                    } case 3 -> {
                        System.out.print("\n Enter City Name  : ");
                        contact.setCity(scan.next());
                    } case 4 -> {
                        System.out.print("\n Enter State Name : ");
                        contact.setState(scan.next());
                    } case 5 -> {
                        System.out.print("\n Enter Zip code   : ");
                        contact.setZipCode(scan.next());
                    } case 6 -> {
                        System.out.print("\n Enter Phone No.  : ");
                        contact.setPhoneNumber(scan.next());
                    } case 7 -> {
                        System.out.print("\n Enter Email Id   : ");
                        contact.setEmailId(scan.next());
                    } case 8 -> {
                        System.out.println("\n Contact Edited Successfully");
                    } default -> System.out.println("\n Invalid Option");
                }
            }while(option != 8);

        } else {
            System.out.println("\n Contact Not Found");
        }
    }

    /**
     *	created deleteContact method to delete contact &  & passing contact as parameter
     */
    public void deleteContact(Contact contact) {
        /*
         * 	if parameter contact is not null
         *  then delete contact from contactList.
         *  else print "Contact Not Found"
         */
        if (contact != null) {
            contactList.remove(contact);
            System.out.println("\n Contact Deleted Successfully");
        } else {
            System.out.println("\n Contact not found!");
        }
    }

    /**
     *	created searchContact method to search contact by name
     */
    public Contact searchContact(String firstName, String lastName) {
        /*
         *	taking user input of first name of contact
         *	Iterating addressBookList (HashMap) and one by one taking contactList (ArrrayList)
         *	and for each contact of contactList matching firstName of contact
         *	if it matches then return contact else return null
         */

        for(Map.Entry<String, ArrayList<Contact>> temp : addressBookList.entrySet()){
            contactList = temp.getValue();

            for(Contact contact : contactList) {

                if(contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)) {
                    return contact;
                }
            }
        }
        return null;
    }
}