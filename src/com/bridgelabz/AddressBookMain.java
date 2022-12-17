package com.bridgelabz;

public class AddressBookMain {

    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();			// 	created object of AddressBook class

        System.out.println(" Welcome to Address Book Program");

        int option;		// variable to store value of console options

        /*
         *		used do-while loop and switch-case to make console for activities like
         *		Add contact, Edit Contact, Display contact, Exit
         */

        do {
            System.out.println("\n *** Available Options *** ");
            System.out.println(" 1. Add Contact \n 2. Edit Contact \n 3. Display Contact \n 4. Exit");
            System.out.print(" Enter option to perform activity : ");
            option = addressBook.scan.nextInt();

            switch (option) {

                case 1 -> addressBook.addContact();

                case 2 -> addressBook.editContact();

                case 3 -> addressBook.displayContact();

                case 4 -> System.out.println("\n Exited Successfully");

                default -> System.out.print(" Option not Available \n");

            }

        } while(option != 4);

    }
}