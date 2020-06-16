package com.mediga.streams;

import com.mediga.lamda.javafunctionalinterfaces.Person;

import java.util.List;
import java.util.stream.Collectors;

public class CollectJoiningTest {
    public static void main(String[] args) {
        List<Person> persons = Person.persons();

        String names = persons.stream()
                .map(Person::getFirstName)
                .collect(Collectors.joining());

        String delimitedNames = persons.stream()
                .map(Person::getFirstName)
                .collect(Collectors.joining(", "));

        String prefixSufixNames = persons.stream()
                .map(Person::getFirstName)
                .collect(Collectors.joining(", ", "Hello ", ". Goodbye"));

        System.out.println(names);
        System.out.println(delimitedNames);
        System.out.println(prefixSufixNames);
    }
}
