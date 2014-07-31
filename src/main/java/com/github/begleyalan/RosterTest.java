package com.github.begleyalan;

import java.util.List;

/**
 * Created by abegley on 30/07/2014.
 */
public class RosterTest {

    interface CheckPerson {
        boolean test(Person person);
    }

    //Approach 1: Create Methods that Search for Persons that Match One characteristic
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person person: roster){
            if(person.getAge() >= age){
                person.printPerson();
            }
        }
    }

    //Approach 2: Create more generalized search methods
}
