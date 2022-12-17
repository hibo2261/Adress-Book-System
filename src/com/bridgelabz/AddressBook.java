package com.bridgelabz;

import java.util.ArrayList;     //imported ArrayList class
import java.util.Scanner;		// imported Scanner class

public class AddressBook {

    ArrayList<Contact> contactList = new ArrayList<>();	//	created object of ArrayList class

    Scanner scan = new Scanner(System.in);				//	created object of Scanner class

    //	created addContact method to store details of new contact

    public void addContact() {

        Contact contact = new Contact();		//	created object of Contact class

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

        contactList.add(contact);		// adding new contact to contactList

        System.out.println("\n Contact Added Successfully");
    }

    //	created displayContact method to display details of contact

    public void displayContact() {

        for(int i = 0; i < contactList.size(); i++) {

            System.out.println("\n *** Contact - " + (i+1) +" ***");

            Contact contact = contactList.get(i);

            System.out.println( "\n First Name : " + contact.getFirstName()
                    + "\n Last Name  : " + contact.getLastName()
                    + "\n Address    : " + contact.getAddress()
                    + "\n City Name  : " + contact.getCity()
                    + "\n State Name : " + contact.getState()
                    + "\n Zip Code   : " + contact.getZipCode()
                    + "\n Phone No.  : " + contact.getPhoneNumber()
                    + "\n Email Id   : " + contact.getEmailId() );
        }
    }

    //	created editContact method to edit details of contact

    public void editContact() {

        System.out.print("\n Enter First Name of Contact you want Edit : ");
        String firstName = scan.next();		//	variable to store first name of contact we want to edit
        boolean isAvailable = false;

        for(Contact contact : contactList) {

            if(contact.getFirstName().equalsIgnoreCase(firstName)) {		// matching firstName of contact (Ignoring upper/lower case)
                isAvailable = true;

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

                System.out.println("\n Contact Updated Successfully");
            }
        }

        if (!isAvailable) {
            System.out.println("\n Contact not found!");
        }

    }

    //	created deleteContact method to delete contact

    public void deleteContact() {

        System.out.print("\n Enter First Name of Contact you want Delete : ");
        String firstName = scan.next();		//	variable to store first name of contact we want to delete
        boolean isAvailable = false;

        for(Contact contact : contactList) {

            if(contact.getFirstName().equalsIgnoreCase(firstName)) {	// matching firstName of contact (Ignoring upper/lower case)
                isAvailable = true;
                contactList.remove(contact);
                System.out.println("\n Contact Deleted Successfully");
                break;
            }
        }

        if(!isAvailable) {
            System.out.println("\n Contact not found!");

        }

    }

}