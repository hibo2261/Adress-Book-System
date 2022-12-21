package com.bridgelabz;

import java.util.ArrayList;     //imported ArrayList class
import java.util.Scanner;		// imported Scanner class

public class AddressBook {

    ArrayList<Contact> contactList = new ArrayList<>();	//	created object of ArrayList class

    Scanner scan = new Scanner(System.in);				//	created object of Scanner class

    /**
     *  created addDetails method to store details of new contact
     */
    public void addDetails(ArrayList<Contact> contactList) {
        /*
         *	created object of Contact class then
         *	storing details of contact in it.
         *	at last adding new contact to contactList
         */
        Contact contact = new Contact();

        System.out.print("\n Enter First Name : ");
        contact.setFirstName(scan.next());

        System.out.print(" Enter Last Name  : ");
        contact.setLastName(scan.next());

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
                System.out.println(" 1. First Name  \n 2. Last Name \n 3. Address \n 4. City \n 5. State "
                        + "\n 6. Zip code \n 7. Phone No. \n 8. Email Id \n 9. Exit");
                System.out.print(" Enter option : ");
                option = scan.nextInt();

                switch (option) {

                    case 1 -> {
                        System.out.print("\n Enter First Name : ");
                        contact.setFirstName(scan.next());
                    } case 2 -> {
                        System.out.print(" Enter Last Name  : ");
                        contact.setLastName(scan.next());
                    } case 3 -> {
                        System.out.print(" Enter Address    : ");
                        contact.setAddress(scan.next());
                    } case 4 -> {
                        System.out.print(" Enter City Name  : ");
                        contact.setCity(scan.next());
                    } case 5 -> {
                        System.out.print(" Enter State Name : ");
                        contact.setState(scan.next());
                    } case 6 -> {
                        System.out.print(" Enter Zip code   : ");
                        contact.setZipCode(scan.next());
                    } case 7 -> {
                        System.out.print(" Enter Phone No.  : ");
                        contact.setPhoneNumber(scan.next());
                    } case 8 -> {
                        System.out.print(" Enter Email Id   : ");
                        contact.setEmailId(scan.next());

                    } default -> System.out.println("\n Invalid Option");
                }
            }while(option != 9);
            System.out.println("\n Contact Edited Successfully");
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

}