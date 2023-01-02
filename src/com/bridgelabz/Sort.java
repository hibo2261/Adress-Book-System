package com.bridgelabz;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;


public class Sort extends Dictionary {
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
}