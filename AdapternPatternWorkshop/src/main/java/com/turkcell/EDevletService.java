package com.turkcell;

import java.util.ArrayList;
import java.util.List;

public class EDevletService {

    private static List<Person> personList = new ArrayList<>();

    public EDevletService (){
        personList.add(new Person("Ümit", "Sayın", 1998, "11111111111"));
    }

    public boolean verify(String firstName, String lastName, int birthYear, String nationalityID) {
        for (Person person : personList) {
            if (person.getFirstName().equals(firstName) &&
                person.getLastName().equals(lastName) &&
                person.getBirthYear() == birthYear &&
                person.getNationalityID().equals(nationalityID)) {
                return true;
            }
        }
        return false;
    }
}
