package com.bridgelabz;

import java.util.Scanner;		// imported Scanner class

public class AddressBook {

    Scanner scan = new Scanner(System.in);		//	created object of Scanner class
    Contact contact = new Contact();			//	created object of Contact class

    //	created addContact method to store details of new contact

    public void addContact() {

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

    }

    //	created displayContact method to display details of contact

    public void displayContact() {

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