package com.github.begleyalan;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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

    public static void printPersonsWithinAgeRange (List<Person> roster, int low, int high){
        for(Person person: roster){
            if (low <= person.getAge() && person.getAge() < high) {
                person.printPerson();
            }
        }
    }

    //Approach 3: Specify search criteria code in a local class
    //Approach 4: Specify search criteria code in an anonymous class
    //Approach 5: Specify search criteria code with a lambda expression

    public static void printPersons(List<Person> roster, CheckPerson tester){
        for(Person person: roster){
            if(tester.test(person)){
                person.printPerson();
            }
        }
    }

    //Approach 6:  Use standard functional interfaces with Lambda expressions
    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester){
        for (Person person: roster){
            if(tester.test(person)){
                person.printPerson();
            }
        }
    }

    //Approach 7:  Use Lambda expressions throughout your application
    public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block){
        for(Person person : roster){
            if(tester.test(person)){
                block.accept(person);
            }
        }
    }

    //Approach 7: second example
    public static void processPersonsWithFunctions(List<Person> roster,
                                                   Predicate<Person> tester,
                                                   Function<Person, String> mapper,
                                                   Consumer<String> block){
        for(Person person: roster){
            if(tester.test(person)){
                String data = mapper.apply(person);
                block.accept(data);
            }
        }
    }

    //Approach 8: Use generics more extensively
    public static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block){
        for(X p : source){
            if(tester.test(p)){
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static void main(String... args){
        List<Person> roster = Person.createRoster();

        for(Person person: roster){
            person.printPerson();
        }

        //Approach 1: Create Methods that search for Persons that match one characteristic
        System.out.println("Persons older than 20:");
        printPersonsOlderThan(roster, 20);
        System.out.println();

        //Approach 2:  Create more generalized search methods
        System.out.println("Persons between the ages of 14 and 30");
        printPersonsWithinAgeRange(roster, 14, 30);
        System.out.println();

        //Approach 3:  Specify search criteria code in a local class
        System.out.println("Persons who are eligible for Selective service:");

        class CheckPersonEligibleForSelectiveService implements CheckPerson {
            @Override
            public boolean test(Person person) {
                return person.getGender() == Person.Sex.MALE
                        && person.getAge() >= 18
                        && person.getAge() >= 25;
            }
        }

        printPersons(roster, new CheckPersonEligibleForSelectiveService());

        System.out.println();

        //Approach 4:  Specify search criteria Code in an Anonymous Code
        System.out.println("Persons who are eligible for Selective Service " + "(anonymous class):");

        printPersons(roster, new CheckPerson() {
            @Override
            public boolean test(Person person) {
                return person.getGender() == Person.Sex.MALE
                        && person.getAge() >= 18
                        && person.getAge() <= 25;
            }
        });

        System.out.println();

        //Approach 5:  Specify search criteria code with a Lambda expression
        System.out.println("Persons who are eligible for Selective service " + "(lambda expression):");

        printPersons(roster, (Person person) -> person.getGender() == Person.Sex.MALE
                && person.getAge() >= 18
                && person.getAge() <= 25);

        System.out.println();

        //Approach 6: Use Standard Functional interfaces with lambda expressions
        System.out.println("Persons who are eligible for selective service " + "(with Predicate paramter):");

        printPersonsWithPredicate(roster, p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25);

        System.out.println();

        //Approach 7: Use Lambda expressions throughout your application
        System.out.println("Persons who are eligible for selective service " + "(with predicate and consumer parameters)");

        processPersons(roster, p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 28
                        && p.getAge() <= 25,
                p -> p.printPerson());

        System.out.println();

        //Approach 7: second example
        System.out.println("Persons who are eligible for selective service " + "(with Predicate, Function and Consumer parameters)");

        processPersonsWithFunctions(roster, p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email));

        System.out.println();

        //Approach 8: Use Generics more extensively
        System.out.println("Persons who are eligible for selective service " +"(generic version):");
        processElements(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email));
    }
}
