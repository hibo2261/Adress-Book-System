package com.bridgelabz;

public class Main {
    /**
     *	created main method to run program
     */
    public static void main(String[] args) {
        /*
         *  printing welcome message
         *  created object of class Dictionary & class Print
         *	used do-while loop and switch-case to make console for activities like
         *	Add AddressBook, Add Contact, Edit Contact, Delete, Print, Exit
         */
        System.out.println(" Welcome to Address Book Program");
        Dictionary dictionary = new Dictionary();
        Print print = new Print();
        int option;		// variable to store value of console options
        do {
            System.out.println("\n *** Available Options *** ");
            System.out.println(" 1. Add AddressBook \n 2. Add Contact \n 3. Edit Contact" +
                    " \n 4. Delete \n 5. Print \n 6. Exit");
            System.out.print(" Enter option to perform activity : ");
            option = dictionary.scan.nextInt();
            switch (option) {
                case 1 -> dictionary.addAddressBook();
                case 2 -> dictionary.addContact();
                case 3 -> dictionary.editContact();
                case 4 -> dictionary.delete();
                case 5 -> print.print();
                case 6 -> System.out.println("\n Exited Successfully");
                default -> System.out.print("\n Option not Available \n");
            }
        } while(option != 6);
    }
}