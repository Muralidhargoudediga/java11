package com.mediga.lamda.javafunctionalinterfaces;

import java.util.List;

import static com.mediga.lamda.javafunctionalinterfaces.Gender.MALE;

//Here you are using FUnctionalUtil library class and passing lamda expressions
public class FunctionUtilTest {
    public static void main(String[] args) {
        List<Person> persons = Person.getPersons();

        System.out.println("Original list of persons:");
        FunctionUtil.forEach( persons, p -> System.out.println(p));

        System.out.println("Only males:");
        List<Person> maleList = FunctionUtil.filter(persons, p -> p.getGender() == MALE);
        FunctionUtil.forEach(maleList, p -> System.out.println(p));

        System.out.println("\nPersons mapped to year of their birth:");
        FunctionUtil.forEach(FunctionUtil.map(persons, p -> p.getDob().getYear()), p -> System.out.println(p));

        // Apply an action to each person in the list. Add one year to each male's dob
        FunctionUtil.forEach(maleList, p -> p.setDob(p.getDob().plusYears(1)));

        System.out.println("\nMales only after adding 1 year to DOB:");
        FunctionUtil.forEach(maleList, System.out::println);
    }
}
