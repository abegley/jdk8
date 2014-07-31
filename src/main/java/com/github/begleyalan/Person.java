package com.github.begleyalan;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abegley on 30/07/2014.
 */
public class Person {
    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name=name;
        this.birthday=birthday;
        this.gender=gender;
        this.emailAddress=emailAddress;
    }

    public enum Sex {
        MALE, FEMALE
    }

    public int getAge(){
        return birthday
               .until(IsoChronology.INSTANCE.dateNow())
               .getYears();
    }

    public void printPerson(){
        System.out.println(name + ", " + this.getAge());
    }

    public Sex getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public static int compareByAge(Person person1, Person person2){
        return person1.birthday.compareTo(person2.birthday);
    }

    public static List<Person> createRoster() {
        List<Person> roster = new ArrayList();
        roster.add(
                    new Person(
                            "Fred",
                            IsoChronology.INSTANCE.date(1980, 6, 20),
                            Sex.MALE,
                            "fred@example.com"
                    ));
        roster.add(
                    new Person(
                            "Jane",
                            IsoChronology.INSTANCE.date(1990, 7, 15),
                            Sex.FEMALE,
                            "jane@example.com"
                    ));
        roster.add(
                    new Person(
                            "George",
                            IsoChronology.INSTANCE.date(1991, 8, 13),
                            Sex.MALE,
                            "george@example.com"
                    ));
        roster.add(
                    new Person(
                            "Bob",
                            IsoChronology.INSTANCE.date(2000, 9, 12),
                            Sex.MALE,
                            "bob@example.com"
                    ));
        return roster;

    }

    private String name;
    private LocalDate birthday;
    private Sex gender;
    private String emailAddress;

}
