package com.bridgelabz;

public class Main {

    /**
     *	created main method to run program
     */
    public static void main(String[] args) {
        /*
         *		used do-while loop and switch-case to make console for activities like
         *		Add Contact, Edit Contact, Add Address Book, Print, Delete, Search By City or State, Exit
         */
        Dictionary dictionary = new Dictionary();	// created object of class Dictionary
        Print print = new Print();

        System.out.println(" Welcome to Address Book Program");

        int option;		// variable to store value of console options

        do {
            System.out.println("\n *** Available Options *** ");
            System.out.println(" 1. Add Contact \n 2. Edit Contact \n 3. Add Address Book "
                    + "\n 4. Print \n 5. Delete \n 6. Search By City or State \n 7. Exit");
            System.out.print(" Enter option to perform activity : ");
            option = dictionary.scan.nextInt();

            switch (option) {

                case 1 -> dictionary.addContact();

                case 2 -> dictionary.editContact();

                case 3 -> dictionary.addAddressBook();

                case 4 -> print.print();

                case 5 -> dictionary.delete();

                case 6 -> dictionary.searchBCityOrState();

                case 7 -> System.out.println("\n Exited Successfully");

                default -> System.out.print("\n Option not Available \n");

            }

        } while(option != 7);

    }

}