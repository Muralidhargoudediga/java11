package com.mediga.streams;

import com.mediga.lamda.javafunctionalinterfaces.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CollectorsTest {
    public static void main(String[] args) {
        List<String> names = Person.persons()
                                    .stream()
                                    .map(p -> p.getFirstName())
                                    .collect(/*Supplier of mutable container */ArrayList::new,
                                            /*accumulator */(list, name) -> list.add(name),
                                            /*combiner - in case of parallel streams*/(list1, list2) -> list1.addAll(list2));
        System.out.println(names);

        //Using Collector Interface as the param to collect() overloaded method. Collectors class provides implementations for Collector interface
        names = Person.persons()
                        .stream()
                        .map(p -> p.getFirstName())
                        .collect(Collectors.toList());

        System.out.println(names);

        Set<String> uniqueNames = Person.persons()
                                            .stream()
                                            .map(p -> p.getFirstName())
                                            .collect(Collectors.toSet());

        System.out.println(uniqueNames);

        Set<String> uniqueSortedNames = Person.persons()
                                                .stream()
                                                .map(p -> p.getFirstName())
                                                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println(uniqueSortedNames);

        List<String> sortedNames = Person.persons()
                                        .stream()
                                        .map(Person::getFirstName)
                                        .sorted()
                                        .collect(Collectors.toList());

        System.out.println(sortedNames);

    }
}
