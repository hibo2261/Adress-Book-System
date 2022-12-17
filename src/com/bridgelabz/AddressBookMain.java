package com.bridgelabz;

public class AddressBookMain {

    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();			// 	created object of AddressBook class

        System.out.println(" Welcome to Address Book Program");

        int option;		// variable to store value of console options

        /*
         *		used do-while loop and switch-case to make console for activities like
         *		Add contact, Display contact, Edit Contact, Delete Contact, Exit
         */

        do {
            System.out.println("\n *** Available Options *** ");
            System.out.println(" 1. Add Contact \n 2. Display Contact \n 3. Edit Contact \n 4. Delete Contact \n 5. Exit");
            System.out.print(" Enter option to perform activity : ");
            option = addressBook.scan.nextInt();

            switch (option) {

                case 1 -> addressBook.addContact();

                case 2 -> addressBook.displayContact();

                case 3 -> addressBook.editContact();

                case 4 -> addressBook.deleteContact();

                case 5 -> System.out.println("\n Exited Successfully");

                default -> System.out.print(" Option not Available \n");

            }

        } while(option != 5);

    }
}