package com.mediga.streams;

import com.mediga.lamda.javafunctionalinterfaces.Person;

import java.util.stream.Stream;

public class FilterOperations {
    public static void main(String[] args) {
        Person.persons()
                .stream()
                .filter(Person::isMale)
                .filter(p -> p.getIncome() > 5000)
                .map(p -> p.getFirstName())
                .forEach(System.out::println);

        System.out.println();

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .dropWhile(n -> n < 5)
                .forEach(System.out::println);

        System.out.println();

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .takeWhile(n -> n < 5)
                .forEach(System.out::println);
    }
}
